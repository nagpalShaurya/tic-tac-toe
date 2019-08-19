package com.google.firebase.database.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.persistence.TrackedQuery;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.util.JsonMapper;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class SqlPersistenceStorageEngine implements PersistenceStorageEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CHILDREN_NODE_SPLIT_SIZE_THRESHOLD = 16384;
    private static final String CREATE_SERVER_CACHE = "CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);";
    private static final String CREATE_TRACKED_KEYS = "CREATE TABLE trackedKeys (id INTEGER, key TEXT);";
    private static final String CREATE_TRACKED_QUERIES = "CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);";
    private static final String CREATE_WRITES = "CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));";
    private static final String FIRST_PART_KEY = ".part-0000";
    private static final String LOGGER_COMPONENT = "Persistence";
    private static final String PART_KEY_FORMAT = ".part-%04d";
    private static final String PART_KEY_PREFIX = ".part-";
    private static final String PATH_COLUMN_NAME = "path";
    private static final String ROW_ID_COLUMN_NAME = "rowid";
    private static final int ROW_SPLIT_SIZE = 262144;
    private static final String SERVER_CACHE_TABLE = "serverCache";
    private static final String TRACKED_KEYS_ID_COLUMN_NAME = "id";
    private static final String TRACKED_KEYS_KEY_COLUMN_NAME = "key";
    private static final String TRACKED_KEYS_TABLE = "trackedKeys";
    private static final String TRACKED_QUERY_ACTIVE_COLUMN_NAME = "active";
    private static final String TRACKED_QUERY_COMPLETE_COLUMN_NAME = "complete";
    private static final String TRACKED_QUERY_ID_COLUMN_NAME = "id";
    private static final String TRACKED_QUERY_LAST_USE_COLUMN_NAME = "lastUse";
    private static final String TRACKED_QUERY_PARAMS_COLUMN_NAME = "queryParams";
    private static final String TRACKED_QUERY_PATH_COLUMN_NAME = "path";
    private static final String TRACKED_QUERY_TABLE = "trackedQueries";
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    private static final String VALUE_COLUMN_NAME = "value";
    private static final String WRITES_TABLE = "writes";
    private static final String WRITE_ID_COLUMN_NAME = "id";
    private static final String WRITE_NODE_COLUMN_NAME = "node";
    private static final String WRITE_PART_COLUMN_NAME = "part";
    private static final String WRITE_TYPE_COLUMN_NAME = "type";
    private static final String WRITE_TYPE_MERGE = "m";
    private static final String WRITE_TYPE_OVERWRITE = "o";
    private final SQLiteDatabase database;
    private boolean insideTransaction;
    private final LogWrapper logger;
    private long transactionStart = 0;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class PersistentCacheOpenHelper extends SQLiteOpenHelper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int DATABASE_VERSION = 2;

        public PersistentCacheOpenHelper(Context context, String cacheId) {
            super(context, cacheId, null, 2);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
            db.execSQL(SqlPersistenceStorageEngine.CREATE_WRITES);
            db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
            db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion <= 1) {
                dropTable(db, SqlPersistenceStorageEngine.SERVER_CACHE_TABLE);
                db.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
                dropTable(db, SqlPersistenceStorageEngine.TRACKED_QUERY_COMPLETE_COLUMN_NAME);
                db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
                db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("We don't handle upgrading to ");
            sb.append(newVersion);
            throw new AssertionError(sb.toString());
        }

        private void dropTable(SQLiteDatabase db, String table) {
            StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE IF EXISTS ");
            sb.append(table);
            db.execSQL(sb.toString());
        }
    }

    public SqlPersistenceStorageEngine(Context context, com.google.firebase.database.core.Context firebaseContext, String cacheId) {
        try {
            String sanitizedCacheId = URLEncoder.encode(cacheId, "utf-8");
            this.logger = firebaseContext.getLogger(LOGGER_COMPONENT);
            this.database = openDatabase(context, sanitizedCacheId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUserOverwrite(Path path, Node node, long writeId) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        Path path2 = path;
        long j = writeId;
        saveWrite(path2, j, WRITE_TYPE_OVERWRITE, serializeObject(node.getValue(true)));
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void saveUserMerge(Path path, CompoundWrite children, long writeId) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        Path path2 = path;
        long j = writeId;
        saveWrite(path2, j, WRITE_TYPE_MERGE, serializeObject(children.getValue(true)));
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void removeUserWrite(long writeId) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        int count = this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(writeId)});
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(count), Long.valueOf(writeId), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public List<UserWriteRecord> loadUserWrites() {
        byte[] serialized;
        UserWriteRecord record;
        int i = 0;
        int i2 = 1;
        int i3 = 3;
        int i4 = 4;
        String[] columns = {"id", "path", "type", WRITE_PART_COLUMN_NAME, WRITE_NODE_COLUMN_NAME};
        long start = System.currentTimeMillis();
        Cursor cursor = this.database.query(WRITES_TABLE, columns, null, null, null, null, "id, part");
        List<UserWriteRecord> writes = new ArrayList<>();
        while (cursor.moveToNext()) {
            try {
                long writeId = cursor.getLong(i);
                Path path = new Path(cursor.getString(i2));
                String type = cursor.getString(2);
                if (cursor.isNull(i3)) {
                    serialized = cursor.getBlob(i4);
                } else {
                    List<byte[]> parts = new ArrayList<>();
                    while (true) {
                        parts.add(cursor.getBlob(i4));
                        if (!cursor.moveToNext()) {
                            break;
                        } else if (cursor.getLong(i) != writeId) {
                            break;
                        }
                    }
                    cursor.moveToPrevious();
                    serialized = joinBytes(parts);
                }
                Object writeValue = JsonMapper.parseJsonValue(new String(serialized, UTF8_CHARSET));
                if (WRITE_TYPE_OVERWRITE.equals(type)) {
                    record = new UserWriteRecord(writeId, path, NodeUtilities.NodeFromJSON(writeValue), true);
                } else if (WRITE_TYPE_MERGE.equals(type)) {
                    record = new UserWriteRecord(writeId, path, CompoundWrite.fromValue((Map) writeValue));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Got invalid write type: ");
                    sb.append(type);
                    throw new IllegalStateException(sb.toString());
                }
                writes.add(record);
                i = 0;
                i2 = 1;
                i3 = 3;
                i4 = 4;
            } catch (IOException e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(writes.size()), Long.valueOf(duration)}), new Object[0]);
        }
        cursor.close();
        return writes;
    }

    private void saveWrite(Path path, long writeId, String type, byte[] serializedWrite) {
        String str = type;
        byte[] bArr = serializedWrite;
        verifyInsideTransaction();
        SQLiteDatabase sQLiteDatabase = this.database;
        String[] strArr = {String.valueOf(writeId)};
        String str2 = WRITES_TABLE;
        sQLiteDatabase.delete(str2, "id = ?", strArr);
        int length = bArr.length;
        String str3 = WRITE_NODE_COLUMN_NAME;
        String str4 = WRITE_PART_COLUMN_NAME;
        String str5 = "type";
        String str6 = "path";
        String str7 = "id";
        if (length >= 262144) {
            List<byte[]> parts = splitBytes(bArr, 262144);
            for (int i = 0; i < parts.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(str7, Long.valueOf(writeId));
                values.put(str6, pathToKey(path));
                values.put(str5, str);
                values.put(str4, Integer.valueOf(i));
                values.put(str3, (byte[]) parts.get(i));
                this.database.insertWithOnConflict(str2, null, values, 5);
            }
            return;
        }
        ContentValues values2 = new ContentValues();
        values2.put(str7, Long.valueOf(writeId));
        values2.put(str6, pathToKey(path));
        values2.put(str5, str);
        values2.put(str4, null);
        values2.put(str3, bArr);
        this.database.insertWithOnConflict(str2, null, values2, 5);
    }

    public Node serverCache(Path path) {
        return loadNested(path);
    }

    public void overwriteServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, false);
    }

    public void mergeIntoServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, true);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.firebase.database.snapshot.Node, code=com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, for r13v0, types: [com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, com.google.firebase.database.snapshot.Node] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateServerCache(com.google.firebase.database.core.Path r12, com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode> r13, boolean r14) {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = "serverCache"
            if (r14 != 0) goto L_0x0011
            int r2 = r11.removeNested(r2, r12)
            int r3 = r11.saveNested(r12, r13)
            goto L_0x0044
        L_0x0011:
            r3 = 0
            r4 = 0
            java.util.Iterator r5 = r13.iterator()
        L_0x0017:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0042
            java.lang.Object r6 = r5.next()
            com.google.firebase.database.snapshot.NamedNode r6 = (com.google.firebase.database.snapshot.NamedNode) r6
            com.google.firebase.database.snapshot.ChildKey r7 = r6.getName()
            com.google.firebase.database.core.Path r7 = r12.child(r7)
            int r7 = r11.removeNested(r2, r7)
            int r3 = r3 + r7
            com.google.firebase.database.snapshot.ChildKey r7 = r6.getName()
            com.google.firebase.database.core.Path r7 = r12.child(r7)
            com.google.firebase.database.snapshot.Node r8 = r6.getNode()
            int r7 = r11.saveNested(r7, r8)
            int r4 = r4 + r7
            goto L_0x0017
        L_0x0042:
            r2 = r3
            r3 = r4
        L_0x0044:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            com.google.firebase.database.logging.LogWrapper r6 = r11.logger
            boolean r6 = r6.logsDebug()
            if (r6 == 0) goto L_0x007d
            com.google.firebase.database.logging.LogWrapper r6 = r11.logger
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r9 = 0
            r7[r9] = r8
            r8 = 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            r7[r8] = r10
            r8 = 2
            java.lang.String r10 = r12.toString()
            r7[r8] = r10
            r8 = 3
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            r7[r8] = r10
            java.lang.String r8 = "Persisted a total of %d rows and deleted %d rows for a set at %s in %dms"
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r6.debug(r7, r8)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.android.SqlPersistenceStorageEngine.updateServerCache(com.google.firebase.database.core.Path, com.google.firebase.database.snapshot.Node, boolean):void");
    }

    public void mergeIntoServerCache(Path path, CompoundWrite children) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        int savedRows = 0;
        int removedRows = 0;
        Iterator it = children.iterator();
        while (it.hasNext()) {
            Entry<Path, Node> entry = (Entry) it.next();
            removedRows += removeNested(SERVER_CACHE_TABLE, path.child((Path) entry.getKey()));
            savedRows += saveNested(path.child((Path) entry.getKey()), (Node) entry.getValue());
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(savedRows), Integer.valueOf(removedRows), path.toString(), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public long serverCacheEstimatedSizeInBytes() {
        Cursor cursor = this.database.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{"value", "path", SERVER_CACHE_TABLE}), null);
        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            cursor.close();
        }
    }

    public void saveTrackedQuery(TrackedQuery trackedQuery) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put("id", Long.valueOf(trackedQuery.f45id));
        values.put("path", pathToKey(trackedQuery.querySpec.getPath()));
        values.put(TRACKED_QUERY_PARAMS_COLUMN_NAME, trackedQuery.querySpec.getParams().toJSON());
        values.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(trackedQuery.lastUse));
        values.put(TRACKED_QUERY_COMPLETE_COLUMN_NAME, Boolean.valueOf(trackedQuery.complete));
        values.put(TRACKED_QUERY_ACTIVE_COLUMN_NAME, Boolean.valueOf(trackedQuery.active));
        this.database.insertWithOnConflict(TRACKED_QUERY_TABLE, null, values, 5);
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void deleteTrackedQuery(long trackedQueryId) {
        verifyInsideTransaction();
        String trackedQueryIdStr = String.valueOf(trackedQueryId);
        String[] strArr = {trackedQueryIdStr};
        this.database.delete(TRACKED_QUERY_TABLE, "id = ?", strArr);
        String[] strArr2 = {trackedQueryIdStr};
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", strArr2);
    }

    public List<TrackedQuery> loadTrackedQueries() {
        String[] columns = {"id", "path", TRACKED_QUERY_PARAMS_COLUMN_NAME, TRACKED_QUERY_LAST_USE_COLUMN_NAME, TRACKED_QUERY_COMPLETE_COLUMN_NAME, TRACKED_QUERY_ACTIVE_COLUMN_NAME};
        long start = System.currentTimeMillis();
        Cursor cursor = this.database.query(TRACKED_QUERY_TABLE, columns, null, null, null, null, "id");
        List<TrackedQuery> queries = new ArrayList<>();
        while (cursor.moveToNext()) {
            try {
                TrackedQuery trackedQuery = new TrackedQuery(cursor.getLong(0), QuerySpec.fromPathAndQueryObject(new Path(cursor.getString(1)), JsonMapper.parseJson(cursor.getString(2))), cursor.getLong(3), cursor.getInt(4) != 0, cursor.getInt(5) != 0);
                queries.add(trackedQuery);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(queries.size()), Long.valueOf(duration)}), new Object[0]);
        }
        cursor.close();
        return queries;
    }

    public void resetPreviouslyActiveTrackedQueries(long lastUse) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put(TRACKED_QUERY_ACTIVE_COLUMN_NAME, Boolean.valueOf(false));
        values.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(lastUse));
        this.database.updateWithOnConflict(TRACKED_QUERY_TABLE, values, "active = 1", new String[0], 5);
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void saveTrackedQueryKeys(long trackedQueryId, Set<ChildKey> keys) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        String trackedQueryIdStr = String.valueOf(trackedQueryId);
        SQLiteDatabase sQLiteDatabase = this.database;
        String[] strArr = {trackedQueryIdStr};
        String str = TRACKED_KEYS_TABLE;
        sQLiteDatabase.delete(str, "id = ?", strArr);
        for (ChildKey addedKey : keys) {
            ContentValues values = new ContentValues();
            values.put("id", Long.valueOf(trackedQueryId));
            values.put(TRACKED_KEYS_KEY_COLUMN_NAME, addedKey.asString());
            this.database.insertWithOnConflict(str, null, values, 5);
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(keys.size()), Long.valueOf(trackedQueryId), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void updateTrackedQueryKeys(long trackedQueryId, Set<ChildKey> added, Set<ChildKey> removed) {
        String str;
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        String whereClause = "id = ? AND key = ?";
        String trackedQueryIdStr = String.valueOf(trackedQueryId);
        Iterator it = removed.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str = TRACKED_KEYS_TABLE;
            if (!hasNext) {
                break;
            }
            ChildKey removedKey = (ChildKey) it.next();
            this.database.delete(str, whereClause, new String[]{trackedQueryIdStr, removedKey.asString()});
        }
        for (ChildKey addedKey : added) {
            ContentValues values = new ContentValues();
            values.put("id", Long.valueOf(trackedQueryId));
            values.put(TRACKED_KEYS_KEY_COLUMN_NAME, addedKey.asString());
            this.database.insertWithOnConflict(str, null, values, 5);
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(added.size()), Integer.valueOf(removed.size()), Long.valueOf(trackedQueryId), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public Set<ChildKey> loadTrackedQueryKeys(long trackedQueryId) {
        return loadTrackedQueryKeys(Collections.singleton(Long.valueOf(trackedQueryId)));
    }

    public Set<ChildKey> loadTrackedQueryKeys(Set<Long> trackedQueryIds) {
        String[] columns = {TRACKED_KEYS_KEY_COLUMN_NAME};
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("id IN (");
        sb.append(commaSeparatedList(trackedQueryIds));
        sb.append(")");
        Cursor cursor = this.database.query(true, TRACKED_KEYS_TABLE, columns, sb.toString(), null, null, null, null, null);
        Set<ChildKey> keys = new HashSet<>();
        while (cursor.moveToNext()) {
            try {
                keys.add(ChildKey.fromString(cursor.getString(0)));
            } finally {
                cursor.close();
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(keys.size()), trackedQueryIds.toString(), Long.valueOf(duration)}), new Object[0]);
        }
        return keys;
    }

    public void pruneCache(Path root, PruneForest pruneForest) {
        Path path = root;
        PruneForest pruneForest2 = pruneForest;
        if (pruneForest.prunesAnything()) {
            verifyInsideTransaction();
            long start = System.currentTimeMillis();
            int i = 1;
            Cursor cursor = loadNestedQuery(path, new String[]{ROW_ID_COLUMN_NAME, "path"});
            ImmutableTree<Long> rowIdsToPrune = new ImmutableTree<>(null);
            ImmutableTree immutableTree = new ImmutableTree(null);
            while (cursor.moveToNext()) {
                long rowId = cursor.getLong(0);
                Path rowPath = new Path(cursor.getString(i));
                String str = "We are pruning at ";
                if (!path.contains(rowPath)) {
                    LogWrapper logWrapper = this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(path);
                    sb.append(" but we have data stored higher up at ");
                    sb.append(rowPath);
                    sb.append(". Ignoring.");
                    logWrapper.warn(sb.toString());
                } else {
                    Path relativePath = Path.getRelative(path, rowPath);
                    if (pruneForest2.shouldPruneUnkeptDescendants(relativePath)) {
                        rowIdsToPrune = rowIdsToPrune.set(relativePath, Long.valueOf(rowId));
                    } else if (pruneForest2.shouldKeep(relativePath)) {
                        immutableTree = immutableTree.set(relativePath, Long.valueOf(rowId));
                    } else {
                        LogWrapper logWrapper2 = this.logger;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(path);
                        sb2.append(" and have data at ");
                        sb2.append(rowPath);
                        sb2.append(" that isn't marked for pruning or keeping. Ignoring.");
                        logWrapper2.warn(sb2.toString());
                    }
                }
                i = 1;
            }
            int prunedCount = 0;
            int resavedCount = 0;
            if (!rowIdsToPrune.isEmpty()) {
                List<Pair<Path, Node>> rowsToResave = new ArrayList<>();
                ImmutableTree<Long> rowIdsToPrune2 = rowIdsToPrune;
                pruneTreeRecursive(root, Path.getEmptyPath(), rowIdsToPrune, immutableTree, pruneForest, rowsToResave);
                Collection<Long> rowIdsToDelete = rowIdsToPrune2.values();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("rowid IN (");
                sb3.append(commaSeparatedList(rowIdsToDelete));
                sb3.append(")");
                this.database.delete(SERVER_CACHE_TABLE, sb3.toString(), null);
                for (Pair<Path, Node> node : rowsToResave) {
                    saveNested(path.child((Path) node.getFirst()), (Node) node.getSecond());
                }
                prunedCount = rowIdsToDelete.size();
                resavedCount = rowsToResave.size();
            } else {
                ImmutableTree immutableTree2 = immutableTree;
                ImmutableTree immutableTree3 = rowIdsToPrune;
            }
            long duration = System.currentTimeMillis() - start;
            if (this.logger.logsDebug()) {
                this.logger.debug(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(prunedCount), Integer.valueOf(resavedCount), Long.valueOf(duration)}), new Object[0]);
            }
        }
    }

    private void pruneTreeRecursive(Path pruneRoot, Path relativePath, ImmutableTree<Long> rowIdsToPrune, ImmutableTree<Long> rowIdsToKeep, PruneForest pruneForest, List<Pair<Path, Node>> rowsToResaveAccumulator) {
        final ImmutableTree<Long> immutableTree = rowIdsToKeep;
        PruneForest pruneForest2 = pruneForest;
        if (rowIdsToPrune.getValue() != null) {
            int nodesToResave = ((Integer) pruneForest2.foldKeptNodes(Integer.valueOf(0), new TreeVisitor<Void, Integer>() {
                public Integer onNodeValue(Path keepPath, Void ignore, Integer nodesToResave) {
                    return Integer.valueOf(immutableTree.get(keepPath) == null ? nodesToResave.intValue() + 1 : nodesToResave.intValue());
                }
            })).intValue();
            if (nodesToResave > 0) {
                Path absolutePath = pruneRoot.child(relativePath);
                if (this.logger.logsDebug()) {
                    this.logger.debug(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(nodesToResave), absolutePath}), new Object[0]);
                }
                final ImmutableTree<Long> immutableTree2 = rowIdsToKeep;
                final List<Pair<Path, Node>> list = rowsToResaveAccumulator;
                final Path path = relativePath;
                final Node loadNested = loadNested(absolutePath);
                C04052 r0 = new TreeVisitor<Void, Void>() {
                    public Void onNodeValue(Path keepPath, Void ignore, Void ignore2) {
                        if (immutableTree2.get(keepPath) == null) {
                            list.add(new Pair(path.child(keepPath), loadNested.getChild(keepPath)));
                        }
                        return null;
                    }
                };
                pruneForest2.foldKeptNodes(null, r0);
            }
            Path path2 = relativePath;
            return;
        }
        Iterator it = rowIdsToPrune.getChildren().iterator();
        while (it.hasNext()) {
            Entry<ChildKey, ImmutableTree<Long>> entry = (Entry) it.next();
            ChildKey childKey = (ChildKey) entry.getKey();
            Path path3 = pruneRoot;
            pruneTreeRecursive(path3, relativePath.child(childKey), (ImmutableTree) entry.getValue(), immutableTree.getChild(childKey), pruneForest2.child((ChildKey) entry.getKey()), rowsToResaveAccumulator);
        }
        Path path4 = relativePath;
    }

    public void removeAllUserWrites() {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        int count = this.database.delete(WRITES_TABLE, null, null);
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(count), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void purgeCache() {
        verifyInsideTransaction();
        this.database.delete(SERVER_CACHE_TABLE, null, null);
        this.database.delete(WRITES_TABLE, null, null);
        this.database.delete(TRACKED_QUERY_TABLE, null, null);
        this.database.delete(TRACKED_KEYS_TABLE, null, null);
    }

    public void beginTransaction() {
        Utilities.hardAssert(!this.insideTransaction, "runInTransaction called when an existing transaction is already in progress.");
        if (this.logger.logsDebug()) {
            this.logger.debug("Starting transaction.", new Object[0]);
        }
        this.database.beginTransaction();
        this.insideTransaction = true;
        this.transactionStart = System.currentTimeMillis();
    }

    public void endTransaction() {
        this.database.endTransaction();
        this.insideTransaction = false;
        long elapsed = System.currentTimeMillis() - this.transactionStart;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(elapsed)}), new Object[0]);
        }
    }

    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    public void close() {
        this.database.close();
    }

    private SQLiteDatabase openDatabase(Context context, String cacheId) {
        try {
            SQLiteDatabase database2 = new PersistentCacheOpenHelper(context, cacheId).getWritableDatabase();
            database2.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            database2.beginTransaction();
            database2.endTransaction();
            return database2;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private void verifyInsideTransaction() {
        Utilities.hardAssert(this.insideTransaction, "Transaction expected to already be in progress.");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.firebase.database.snapshot.Node, code=com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, for r10v0, types: [com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, com.google.firebase.database.snapshot.Node] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int saveNested(com.google.firebase.database.core.Path r9, com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode> r10) {
        /*
            r8 = this;
            long r0 = com.google.firebase.database.core.utilities.NodeSizeEstimator.estimateSerializedNodeSize(r10)
            boolean r2 = r10 instanceof com.google.firebase.database.snapshot.ChildrenNode
            r3 = 1
            if (r2 == 0) goto L_0x0080
            r4 = 16384(0x4000, double:8.0948E-320)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0080
            com.google.firebase.database.logging.LogWrapper r2 = r8.logger
            boolean r2 = r2.logsDebug()
            if (r2 == 0) goto L_0x0039
            com.google.firebase.database.logging.LogWrapper r2 = r8.logger
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r9
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            r4[r3] = r6
            r6 = 2
            r7 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4[r6] = r7
            java.lang.String r6 = "Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up."
            java.lang.String r4 = java.lang.String.format(r6, r4)
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r2.debug(r4, r5)
        L_0x0039:
            r2 = 0
            java.util.Iterator r4 = r10.iterator()
        L_0x003e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x005c
            java.lang.Object r5 = r4.next()
            com.google.firebase.database.snapshot.NamedNode r5 = (com.google.firebase.database.snapshot.NamedNode) r5
            com.google.firebase.database.snapshot.ChildKey r6 = r5.getName()
            com.google.firebase.database.core.Path r6 = r9.child(r6)
            com.google.firebase.database.snapshot.Node r7 = r5.getNode()
            int r6 = r8.saveNested(r6, r7)
            int r2 = r2 + r6
            goto L_0x003e
        L_0x005c:
            com.google.firebase.database.snapshot.Node r4 = r10.getPriority()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0077
            com.google.firebase.database.snapshot.ChildKey r4 = com.google.firebase.database.snapshot.ChildKey.getPriorityKey()
            com.google.firebase.database.core.Path r4 = r9.child(r4)
            com.google.firebase.database.snapshot.Node r5 = r10.getPriority()
            r8.saveNode(r4, r5)
            int r2 = r2 + 1
        L_0x0077:
            com.google.firebase.database.snapshot.EmptyNode r4 = com.google.firebase.database.snapshot.EmptyNode.Empty()
            r8.saveNode(r9, r4)
            int r2 = r2 + r3
            return r2
        L_0x0080:
            r8.saveNode(r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.android.SqlPersistenceStorageEngine.saveNested(com.google.firebase.database.core.Path, com.google.firebase.database.snapshot.Node):int");
    }

    private String partKey(Path path, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(pathToKey(path));
        sb.append(String.format(PART_KEY_FORMAT, new Object[]{Integer.valueOf(i)}));
        return sb.toString();
    }

    private void saveNode(Path path, Node node) {
        byte[] serialized = serializeObject(node.getValue(true));
        int length = serialized.length;
        String str = SERVER_CACHE_TABLE;
        String str2 = "value";
        String str3 = "path";
        if (length >= 262144) {
            List<byte[]> parts = splitBytes(serialized, 262144);
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper = this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Saving huge leaf node with ");
                sb.append(parts.size());
                sb.append(" parts.");
                logWrapper.debug(sb.toString(), new Object[0]);
            }
            for (int i = 0; i < parts.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(str3, partKey(path, i));
                values.put(str2, (byte[]) parts.get(i));
                this.database.insertWithOnConflict(str, null, values, 5);
            }
            return;
        }
        ContentValues values2 = new ContentValues();
        values2.put(str3, pathToKey(path));
        values2.put(str2, serialized);
        this.database.insertWithOnConflict(str, null, values2, 5);
    }

    private Node loadNested(Path path) {
        Cursor cursor;
        Cursor cursor2;
        long loadingStart;
        Path savedPath;
        Node savedNode;
        ArrayList arrayList;
        HashMap hashMap;
        Path savedPath2;
        Path path2 = path;
        List<String> arrayList2 = new ArrayList<>();
        List<byte[]> payloads = new ArrayList<>();
        long queryStart = System.currentTimeMillis();
        Cursor cursor3 = loadNestedQuery(path2, new String[]{"path", "value"});
        long queryDuration = System.currentTimeMillis() - queryStart;
        long loadingStart2 = System.currentTimeMillis();
        while (cursor3.moveToNext()) {
            try {
                try {
                    arrayList2.add(cursor3.getString(0));
                    payloads.add(cursor3.getBlob(1));
                } catch (Throwable th) {
                    th = th;
                    ArrayList arrayList3 = arrayList2;
                    cursor = cursor3;
                    long j = loadingStart2;
                }
            } catch (Throwable th2) {
                th = th2;
                ArrayList arrayList4 = arrayList2;
                cursor = cursor3;
                long j2 = loadingStart2;
                cursor.close();
                throw th;
            }
        }
        cursor3.close();
        long loadingDuration = System.currentTimeMillis() - loadingStart2;
        long serializingStart = System.currentTimeMillis();
        Node node = EmptyNode.Empty();
        boolean sawDescendant = false;
        Map<Path, Node> hashMap2 = new HashMap<>();
        Node node2 = node;
        int i = 0;
        while (i < payloads.size()) {
            String str = (String) arrayList2.get(i);
            String str2 = FIRST_PART_KEY;
            if (str.endsWith(str2)) {
                String pathString = (String) arrayList2.get(i);
                loadingStart = loadingStart2;
                Path savedPath3 = new Path(pathString.substring(0, pathString.length() - str2.length()));
                int splitNodeRunLength = splitNodeRunLength(savedPath3, arrayList2, i);
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    savedPath2 = savedPath3;
                    StringBuilder sb = new StringBuilder();
                    String str3 = pathString;
                    sb.append("Loading split node with ");
                    sb.append(splitNodeRunLength);
                    sb.append(" parts.");
                    cursor2 = cursor3;
                    logWrapper.debug(sb.toString(), new Object[0]);
                } else {
                    cursor2 = cursor3;
                    savedPath2 = savedPath3;
                    String str4 = pathString;
                }
                savedNode = deserializeNode(joinBytes(payloads.subList(i, i + splitNodeRunLength)));
                i = (i + splitNodeRunLength) - 1;
                savedPath = savedPath2;
            } else {
                cursor2 = cursor3;
                loadingStart = loadingStart2;
                savedNode = deserializeNode((byte[]) payloads.get(i));
                savedPath = new Path((String) arrayList2.get(i));
            }
            if (savedPath.getBack() == null || !savedPath.getBack().isPriorityChildName()) {
                hashMap = hashMap2;
                if (savedPath.contains(path2)) {
                    Utilities.hardAssert(!sawDescendant, "Descendants of path must come after ancestors.");
                    arrayList = arrayList2;
                    node2 = savedNode.getChild(Path.getRelative(savedPath, path2));
                } else if (path2.contains(savedPath)) {
                    arrayList = arrayList2;
                    node2 = node2.updateChild(Path.getRelative(path2, savedPath), savedNode);
                    sawDescendant = true;
                } else {
                    List<String> pathStrings = arrayList2;
                    Node node3 = node2;
                    int i2 = i;
                    throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{savedPath, path2}));
                }
            } else {
                hashMap = hashMap2;
                hashMap.put(savedPath, savedNode);
                arrayList = arrayList2;
            }
            i++;
            arrayList2 = arrayList;
            loadingStart2 = loadingStart;
            cursor3 = cursor2;
            hashMap2 = hashMap;
        }
        long j3 = loadingStart2;
        Map<Path, Node> priorities = hashMap2;
        ArrayList arrayList5 = arrayList2;
        Node node4 = node2;
        for (Entry<Path, Node> entry : priorities.entrySet()) {
            node4 = node4.updateChild(Path.getRelative(path2, (Path) entry.getKey()), (Node) entry.getValue());
        }
        long serializeDuration = System.currentTimeMillis() - serializingStart;
        long duration = System.currentTimeMillis() - queryStart;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(payloads.size()), Integer.valueOf(NodeSizeEstimator.nodeCount(node4)), path2, Long.valueOf(duration), Long.valueOf(queryDuration), Long.valueOf(loadingDuration), Long.valueOf(serializeDuration)}), new Object[0]);
        }
        return node4;
    }

    private int splitNodeRunLength(Path path, List<String> pathStrings, int startPosition) {
        int endPosition = startPosition + 1;
        String pathPrefix = pathToKey(path);
        if (((String) pathStrings.get(startPosition)).startsWith(pathPrefix)) {
            while (endPosition < pathStrings.size() && ((String) pathStrings.get(endPosition)).equals(partKey(path, endPosition - startPosition))) {
                endPosition++;
            }
            if (endPosition < pathStrings.size()) {
                String str = (String) pathStrings.get(endPosition);
                StringBuilder sb = new StringBuilder();
                sb.append(pathPrefix);
                sb.append(PART_KEY_PREFIX);
                if (str.startsWith(sb.toString())) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return endPosition - startPosition;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private Cursor loadNestedQuery(Path path, String[] columns) {
        String pathPrefixStart = pathToKey(path);
        String pathPrefixEnd = pathPrefixStartToPrefixEnd(pathPrefixStart);
        String[] arguments = new String[(path.size() + 3)];
        String whereClause = buildAncestorWhereClause(path, arguments);
        StringBuilder sb = new StringBuilder();
        sb.append(whereClause);
        sb.append(" OR (path > ? AND path < ?)");
        String whereClause2 = sb.toString();
        arguments[path.size() + 1] = pathPrefixStart;
        arguments[path.size() + 2] = pathPrefixEnd;
        return this.database.query(SERVER_CACHE_TABLE, columns, whereClause2, arguments, null, null, "path");
    }

    private static String pathToKey(Path path) {
        String str = "/";
        if (path.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(path.toString());
        sb.append(str);
        return sb.toString();
    }

    private static String pathPrefixStartToPrefixEnd(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix.substring(0, prefix.length() - 1));
        sb.append('0');
        return sb.toString();
    }

    private static String buildAncestorWhereClause(Path path, String[] arguments) {
        int count = 0;
        StringBuilder whereClause = new StringBuilder("(");
        while (true) {
            String str = "path";
            if (!path.isEmpty()) {
                whereClause.append(str);
                whereClause.append(" = ? OR ");
                arguments[count] = pathToKey(path);
                path = path.getParent();
                count++;
            } else {
                whereClause.append(str);
                whereClause.append(" = ?)");
                arguments[count] = pathToKey(Path.getEmptyPath());
                return whereClause.toString();
            }
        }
    }

    private int removeNested(String table, Path path) {
        String pathPrefixStart = pathToKey(path);
        String pathPrefixEnd = pathPrefixStartToPrefixEnd(pathPrefixStart);
        return this.database.delete(table, "path >= ? AND path < ?", new String[]{pathPrefixStart, pathPrefixEnd});
    }

    private static List<byte[]> splitBytes(byte[] bytes, int size) {
        int parts = ((bytes.length - 1) / size) + 1;
        List<byte[]> partList = new ArrayList<>(parts);
        for (int i = 0; i < parts; i++) {
            int length = Math.min(size, bytes.length - (i * size));
            byte[] part = new byte[length];
            System.arraycopy(bytes, i * size, part, 0, length);
            partList.add(part);
        }
        return partList;
    }

    private byte[] joinBytes(List<byte[]> payloads) {
        int totalSize = 0;
        for (byte[] payload : payloads) {
            totalSize += payload.length;
        }
        byte[] buffer = new byte[totalSize];
        int currentBytePosition = 0;
        for (byte[] payload2 : payloads) {
            System.arraycopy(payload2, 0, buffer, currentBytePosition, payload2.length);
            currentBytePosition += payload2.length;
        }
        return buffer;
    }

    private byte[] serializeObject(Object object) {
        try {
            return JsonMapper.serializeJsonValue(object).getBytes(UTF8_CHARSET);
        } catch (IOException e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private Node deserializeNode(byte[] value) {
        try {
            return NodeUtilities.NodeFromJSON(JsonMapper.parseJsonValue(new String(value, UTF8_CHARSET)));
        } catch (IOException e) {
            String stringValue = new String(value, UTF8_CHARSET);
            StringBuilder sb = new StringBuilder();
            sb.append("Could not deserialize node: ");
            sb.append(stringValue);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private String commaSeparatedList(Collection<Long> items) {
        StringBuilder list = new StringBuilder();
        boolean first = true;
        for (Long longValue : items) {
            long item = longValue.longValue();
            if (!first) {
                list.append(",");
            }
            first = false;
            list.append(item);
        }
        return list.toString();
    }
}

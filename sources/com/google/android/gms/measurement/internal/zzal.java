package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzal extends zzf {
    private final zzam zzalq = new zzam(this, getContext(), "google_app_measurement_local.db");
    private boolean zzalr;

    zzal(zzbt zzbt) {
        super(zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzgb();
        zzaf();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzgo().zzjl().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgo().zzjd().zzg("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r13v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r10v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r13v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r10v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r0 = e;
        r8 = r8;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        r8 = 0;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e7, code lost:
        if (r8.inTransaction() != false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e9, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00fc, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0101, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0105, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0106, code lost:
        r10 = r8;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0113, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0118, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0141, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0146, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1, types: [boolean, int]
      assigns: []
      uses: [?[int, short, byte, char], int, boolean]
      mth insns count: 167
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0137 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0137 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0137 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d1 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:9:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e3 A[SYNTHETIC, Splitter:B:57:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0146  */
    /* JADX WARNING: Unknown variable types count: 19 */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "Error writing entry to local database"
            r17.zzgb()
            r17.zzaf()
            boolean r0 = r1.zzalr
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.String r5 = "type"
            r4.put(r5, r0)
            java.lang.String r0 = "entry"
            r5 = r19
            r4.put(r0, r5)
            r5 = 5
            r6 = 0
            r7 = 5
        L_0x0029:
            if (r6 >= r5) goto L_0x014a
            r8 = 0
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r17.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x011c, SQLiteDatabaseLockedException -> 0x0108, SQLiteException -> 0x00de, all -> 0x00d8 }
            if (r10 != 0) goto L_0x0044
            r1.zzalr = r9     // Catch:{ SQLiteFullException -> 0x0041, SQLiteDatabaseLockedException -> 0x00d1, SQLiteException -> 0x003d }
            if (r10 == 0) goto L_0x003c
            r10.close()
        L_0x003c:
            return r3
        L_0x003d:
            r0 = move-exception
            r13 = r8
            goto L_0x00cf
        L_0x0041:
            r0 = move-exception
            goto L_0x011f
        L_0x0044:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00d5, SQLiteDatabaseLockedException -> 0x00d1, SQLiteException -> 0x00cc, all -> 0x00c7 }
            r11 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r13 = r10.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00d5, SQLiteDatabaseLockedException -> 0x00d1, SQLiteException -> 0x00cc, all -> 0x00c7 }
            if (r13 == 0) goto L_0x0068
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            if (r0 == 0) goto L_0x0068
            long r11 = r13.getLong(r3)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            goto L_0x0068
        L_0x005c:
            r0 = move-exception
            goto L_0x013f
        L_0x005f:
            r0 = move-exception
            goto L_0x00cf
        L_0x0062:
            r0 = move-exception
            goto L_0x00c5
        L_0x0064:
            r0 = move-exception
            r8 = r13
            goto L_0x011f
        L_0x0068:
            java.lang.String r0 = "messages"
            r14 = 100000(0x186a0, double:4.94066E-319)
            int r16 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzap r16 = r17.zzgo()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            com.google.android.gms.measurement.internal.zzar r5 = r16.zzjd()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.String r8 = "Data loss, local db full"
            r5.zzbx(r8)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            long r14 = r14 - r11
            r11 = 1
            long r14 = r14 + r11
            java.lang.String r5 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r8 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.String r11 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            r8[r3] = r11     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            int r5 = r10.delete(r0, r5, r8)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            long r11 = (long) r5     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzap r5 = r17.zzgo()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjd()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.String r8 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            r5.zzd(r8, r3, r9, r11)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
        L_0x00af:
            r3 = 0
            r10.insertOrThrow(r0, r3, r4)     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x0064, SQLiteDatabaseLockedException -> 0x0062, SQLiteException -> 0x005f, all -> 0x005c }
            if (r13 == 0) goto L_0x00be
            r13.close()
        L_0x00be:
            if (r10 == 0) goto L_0x00c3
            r10.close()
        L_0x00c3:
            r2 = 1
            return r2
        L_0x00c5:
            r8 = r13
            goto L_0x010b
        L_0x00c7:
            r0 = move-exception
            r3 = r8
            r13 = r3
            goto L_0x013f
        L_0x00cc:
            r0 = move-exception
            r3 = r8
            r13 = r3
        L_0x00cf:
            r8 = r10
            goto L_0x00e1
        L_0x00d1:
            r0 = move-exception
            r3 = r8
            r8 = r3
            goto L_0x010b
        L_0x00d5:
            r0 = move-exception
            r3 = r8
            goto L_0x011f
        L_0x00d8:
            r0 = move-exception
            r3 = r8
            r10 = r3
            r13 = r10
            goto L_0x013f
        L_0x00de:
            r0 = move-exception
            r3 = r8
            r13 = r8
        L_0x00e1:
            if (r8 == 0) goto L_0x00ec
            boolean r3 = r8.inTransaction()     // Catch:{ all -> 0x0105 }
            if (r3 == 0) goto L_0x00ec
            r8.endTransaction()     // Catch:{ all -> 0x0105 }
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzap r3 = r17.zzgo()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ all -> 0x0105 }
            r3.zzg(r2, r0)     // Catch:{ all -> 0x0105 }
            r3 = 1
            r1.zzalr = r3     // Catch:{ all -> 0x0105 }
            if (r13 == 0) goto L_0x00ff
            r13.close()
        L_0x00ff:
            if (r8 == 0) goto L_0x0137
            r8.close()
            goto L_0x0137
        L_0x0105:
            r0 = move-exception
            r10 = r8
            goto L_0x013f
        L_0x0108:
            r0 = move-exception
            r3 = r8
            r10 = r8
        L_0x010b:
            long r11 = (long) r7
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x013d }
            int r7 = r7 + 20
            if (r8 == 0) goto L_0x0116
            r8.close()
        L_0x0116:
            if (r10 == 0) goto L_0x0137
            r10.close()
            goto L_0x0137
        L_0x011c:
            r0 = move-exception
            r3 = r8
            r10 = r8
        L_0x011f:
            com.google.android.gms.measurement.internal.zzap r3 = r17.zzgo()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ all -> 0x013d }
            r3.zzg(r2, r0)     // Catch:{ all -> 0x013d }
            r3 = 1
            r1.zzalr = r3     // Catch:{ all -> 0x013d }
            if (r8 == 0) goto L_0x0132
            r8.close()
        L_0x0132:
            if (r10 == 0) goto L_0x0137
            r10.close()
        L_0x0137:
            int r6 = r6 + 1
            r3 = 0
            r5 = 5
            goto L_0x0029
        L_0x013d:
            r0 = move-exception
            r13 = r8
        L_0x013f:
            if (r13 == 0) goto L_0x0144
            r13.close()
        L_0x0144:
            if (r10 == 0) goto L_0x0149
            r10.close()
        L_0x0149:
            throw r0
        L_0x014a:
            com.google.android.gms.measurement.internal.zzap r0 = r17.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjg()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zzbx(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzad zzad) {
        Parcel obtain = Parcel.obtain();
        zzad.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzgo().zzjg().zzbx("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzfh zzfh) {
        Parcel obtain = Parcel.obtain();
        zzfh.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzgo().zzjg().zzbx("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzc(zzl zzl) {
        zzgm();
        byte[] zza = zzfk.zza((Parcelable) zzl);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzgo().zzjg().zzbx("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0194, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01a9, code lost:
        if (r3.inTransaction() != false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ab, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01bd, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01c2, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01c6, code lost:
        r0 = th;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01d3, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01d8, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r10 = r3;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r0 = e;
        r3 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0193 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:12:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a5 A[SYNTHETIC, Splitter:B:119:0x01a5] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01fa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01fa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01fa A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 13 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzr(int r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = "Error reading entries from local database"
            r20.zzaf()
            r20.zzgb()
            boolean r0 = r1.zzalr
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            android.content.Context r0 = r20.getContext()
            java.lang.String r5 = "google_app_measurement_local.db"
            java.io.File r0 = r0.getDatabasePath(r5)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0028
            return r4
        L_0x0028:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x002d:
            if (r7 >= r5) goto L_0x020e
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r20.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x01e0, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x01a0, all -> 0x019c }
            if (r15 != 0) goto L_0x0048
            r1.zzalr = r9     // Catch:{ SQLiteFullException -> 0x0045, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0040 }
            if (r15 == 0) goto L_0x003f
            r15.close()
        L_0x003f:
            return r3
        L_0x0040:
            r0 = move-exception
            r10 = r3
            r3 = r15
            goto L_0x01a3
        L_0x0045:
            r0 = move-exception
            goto L_0x01e3
        L_0x0048:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018d }
            java.lang.String r11 = "messages"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018d }
            java.lang.String r0 = "rowid"
            r12[r6] = r0     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018d }
            java.lang.String r0 = "type"
            r12[r9] = r0     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018d }
            java.lang.String r0 = "entry"
            r14 = 2
            r12[r14] = r0     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018d }
            r13 = 0
            r0 = 0
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid asc"
            r10 = 100
            java.lang.String r19 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018d }
            r10 = r15
            r5 = 2
            r14 = r0
            r3 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0186, all -> 0x0184 }
            r11 = -1
        L_0x007d:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            if (r0 == 0) goto L_0x0144
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            byte[] r13 = r10.getBlob(r5)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            if (r0 != 0) goto L_0x00c6
            android.os.Parcel r14 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00b0 }
            r14.unmarshall(r13, r6, r0)     // Catch:{ ParseException -> 0x00b0 }
            r14.setDataPosition(r6)     // Catch:{ ParseException -> 0x00b0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r0 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ ParseException -> 0x00b0 }
            java.lang.Object r0 = r0.createFromParcel(r14)     // Catch:{ ParseException -> 0x00b0 }
            com.google.android.gms.measurement.internal.zzad r0 = (com.google.android.gms.measurement.internal.zzad) r0     // Catch:{ ParseException -> 0x00b0 }
            r14.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            if (r0 == 0) goto L_0x00ad
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x00ad:
            goto L_0x007d
        L_0x00ae:
            r0 = move-exception
            goto L_0x00c2
        L_0x00b0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzap r0 = r20.zzgo()     // Catch:{ all -> 0x00ae }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x00ae }
            java.lang.String r13 = "Failed to load event from local database"
            r0.zzbx(r13)     // Catch:{ all -> 0x00ae }
            r14.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            goto L_0x007d
        L_0x00c2:
            r14.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            throw r0     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x00c6:
            java.lang.String r14 = "Failed to load user property from local database"
            if (r0 != r9) goto L_0x00fe
            android.os.Parcel r15 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00e4 }
            r15.unmarshall(r13, r6, r0)     // Catch:{ ParseException -> 0x00e4 }
            r15.setDataPosition(r6)     // Catch:{ ParseException -> 0x00e4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzfh> r0 = com.google.android.gms.measurement.internal.zzfh.CREATOR     // Catch:{ ParseException -> 0x00e4 }
            java.lang.Object r0 = r0.createFromParcel(r15)     // Catch:{ ParseException -> 0x00e4 }
            com.google.android.gms.measurement.internal.zzfh r0 = (com.google.android.gms.measurement.internal.zzfh) r0     // Catch:{ ParseException -> 0x00e4 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            goto L_0x00f4
        L_0x00e2:
            r0 = move-exception
            goto L_0x00fa
        L_0x00e4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzap r0 = r20.zzgo()     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x00e2 }
            r0.zzbx(r14)     // Catch:{ all -> 0x00e2 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            r0 = 0
        L_0x00f4:
            if (r0 == 0) goto L_0x00f9
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x00f9:
            goto L_0x007d
        L_0x00fa:
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            throw r0     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x00fe:
            if (r0 != r5) goto L_0x0135
            android.os.Parcel r15 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x011a }
            r15.unmarshall(r13, r6, r0)     // Catch:{ ParseException -> 0x011a }
            r15.setDataPosition(r6)     // Catch:{ ParseException -> 0x011a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzl> r0 = com.google.android.gms.measurement.internal.zzl.CREATOR     // Catch:{ ParseException -> 0x011a }
            java.lang.Object r0 = r0.createFromParcel(r15)     // Catch:{ ParseException -> 0x011a }
            com.google.android.gms.measurement.internal.zzl r0 = (com.google.android.gms.measurement.internal.zzl) r0     // Catch:{ ParseException -> 0x011a }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            goto L_0x012a
        L_0x0118:
            r0 = move-exception
            goto L_0x0131
        L_0x011a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzap r0 = r20.zzgo()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x0118 }
            r0.zzbx(r14)     // Catch:{ all -> 0x0118 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            r0 = 0
        L_0x012a:
            if (r0 == 0) goto L_0x012f
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x012f:
            goto L_0x007d
        L_0x0131:
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            throw r0     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x0135:
            com.google.android.gms.measurement.internal.zzap r0 = r20.zzgo()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            java.lang.String r13 = "Unknown record type in local database"
            r0.zzbx(r13)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            goto L_0x007d
        L_0x0144:
            java.lang.String r0 = "messages"
            java.lang.String r5 = "rowid <= ?"
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            java.lang.String r11 = java.lang.Long.toString(r11)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            r13[r6] = r11     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            int r0 = r3.delete(r0, r5, r13)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            int r5 = r4.size()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            if (r0 >= r5) goto L_0x0167
            com.google.android.gms.measurement.internal.zzap r0 = r20.zzgo()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            java.lang.String r5 = "Fewer entries removed from local database than expected"
            r0.zzbx(r5)     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
        L_0x0167:
            r3.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            r3.endTransaction()     // Catch:{ SQLiteFullException -> 0x017f, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x0179 }
            if (r10 == 0) goto L_0x0173
            r10.close()
        L_0x0173:
            if (r3 == 0) goto L_0x0178
            r3.close()
        L_0x0178:
            return r4
        L_0x0179:
            r0 = move-exception
            goto L_0x01a3
        L_0x017b:
            r0 = move-exception
            r5 = r3
            r3 = r10
            goto L_0x01cb
        L_0x017f:
            r0 = move-exception
            r15 = r3
            r3 = r10
            goto L_0x01e3
        L_0x0184:
            r0 = move-exception
            goto L_0x019e
        L_0x0186:
            r0 = move-exception
            goto L_0x01a2
        L_0x0188:
            r0 = move-exception
            goto L_0x0195
        L_0x018a:
            r0 = move-exception
            r15 = r3
            goto L_0x019a
        L_0x018d:
            r0 = move-exception
            r3 = r15
            goto L_0x019e
        L_0x0190:
            r0 = move-exception
            r3 = r15
            goto L_0x01a2
        L_0x0193:
            r0 = move-exception
            r3 = r15
        L_0x0195:
            r5 = r3
            r3 = 0
            goto L_0x01cb
        L_0x0198:
            r0 = move-exception
            r3 = r15
        L_0x019a:
            r3 = 0
            goto L_0x01e3
        L_0x019c:
            r0 = move-exception
            r3 = 0
        L_0x019e:
            r10 = 0
            goto L_0x0203
        L_0x01a0:
            r0 = move-exception
            r3 = 0
        L_0x01a2:
            r10 = 0
        L_0x01a3:
            if (r3 == 0) goto L_0x01ae
            boolean r5 = r3.inTransaction()     // Catch:{ all -> 0x01c6 }
            if (r5 == 0) goto L_0x01ae
            r3.endTransaction()     // Catch:{ all -> 0x01c6 }
        L_0x01ae:
            com.google.android.gms.measurement.internal.zzap r5 = r20.zzgo()     // Catch:{ all -> 0x01c6 }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjd()     // Catch:{ all -> 0x01c6 }
            r5.zzg(r2, r0)     // Catch:{ all -> 0x01c6 }
            r1.zzalr = r9     // Catch:{ all -> 0x01c6 }
            if (r10 == 0) goto L_0x01c0
            r10.close()
        L_0x01c0:
            if (r3 == 0) goto L_0x01fa
            r3.close()
            goto L_0x01fa
        L_0x01c6:
            r0 = move-exception
            goto L_0x0203
        L_0x01c8:
            r0 = move-exception
            r3 = 0
            r5 = 0
        L_0x01cb:
            long r9 = (long) r8
            android.os.SystemClock.sleep(r9)     // Catch:{ all -> 0x01dc }
            int r8 = r8 + 20
            if (r3 == 0) goto L_0x01d6
            r3.close()
        L_0x01d6:
            if (r5 == 0) goto L_0x01fa
            r5.close()
            goto L_0x01fa
        L_0x01dc:
            r0 = move-exception
            r10 = r3
            r3 = r5
            goto L_0x0203
        L_0x01e0:
            r0 = move-exception
            r3 = 0
            r15 = 0
        L_0x01e3:
            com.google.android.gms.measurement.internal.zzap r5 = r20.zzgo()     // Catch:{ all -> 0x0200 }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjd()     // Catch:{ all -> 0x0200 }
            r5.zzg(r2, r0)     // Catch:{ all -> 0x0200 }
            r1.zzalr = r9     // Catch:{ all -> 0x0200 }
            if (r3 == 0) goto L_0x01f5
            r3.close()
        L_0x01f5:
            if (r15 == 0) goto L_0x01fa
            r15.close()
        L_0x01fa:
            int r7 = r7 + 1
            r3 = 0
            r5 = 5
            goto L_0x002d
        L_0x0200:
            r0 = move-exception
            r10 = r3
            r3 = r15
        L_0x0203:
            if (r10 == 0) goto L_0x0208
            r10.close()
        L_0x0208:
            if (r3 == 0) goto L_0x020d
            r3.close()
        L_0x020d:
            throw r0
        L_0x020e:
            com.google.android.gms.measurement.internal.zzap r0 = r20.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjg()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zzbx(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzr(int):java.util.List");
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzalr) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzalq.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzalr = true;
        return null;
    }

    public final /* bridge */ /* synthetic */ void zzga() {
        super.zzga();
    }

    public final /* bridge */ /* synthetic */ void zzgb() {
        super.zzgb();
    }

    public final /* bridge */ /* synthetic */ void zzgc() {
        super.zzgc();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zza zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzcs zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzaj zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzdr zzgg() {
        return super.zzgg();
    }

    public final /* bridge */ /* synthetic */ zzdo zzgh() {
        return super.zzgh();
    }

    public final /* bridge */ /* synthetic */ zzal zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzeq zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzx zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzan zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzfk zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzbo zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzap zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzba zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ zzn zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzk zzgr() {
        return super.zzgr();
    }
}

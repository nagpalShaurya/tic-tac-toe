package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzyx;
import com.google.android.gms.internal.measurement.zzyy;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzq extends zzez {
    /* access modifiers changed from: private */
    public static final String[] zzahi = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzahj = {Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzahk = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzahl = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzahm = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzahn = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzt zzaho = new zzt(this, getContext(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzev zzahp = new zzev(zzbx());

    zzq(zzfa zzfa) {
        super(zzfa);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    @WorkerThread
    public final void beginTransaction() {
        zzcl();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzcl();
        getWritableDatabase().setTransactionSuccessful();
    }

    @WorkerThread
    public final void endTransaction() {
        zzcl();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        zzaf();
        try {
            return this.zzaho.getWritableDatabase();
        } catch (SQLiteException e) {
            zzgo().zzjg().zzg("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0136  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzz zzg(java.lang.String r23, java.lang.String r24) {
        /*
            r22 = this;
            r15 = r24
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r22.zzaf()
            r22.zzcl()
            r16 = 0
            android.database.sqlite.SQLiteDatabase r1 = r22.getWritableDatabase()     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r2 = "events"
            r0 = 8
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "lifetime_count"
            r9 = 0
            r3[r9] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "current_bundle_count"
            r10 = 1
            r3[r10] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "last_fire_timestamp"
            r11 = 2
            r3[r11] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "last_bundled_timestamp"
            r12 = 3
            r3[r12] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "last_bundled_day"
            r13 = 4
            r3[r13] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "last_sampled_complex_event_id"
            r14 = 5
            r3[r14] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "last_sampling_rate"
            r8 = 6
            r3[r8] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r0 = "last_exempt_from_sampling"
            r7 = 7
            r3[r7] = r0     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            java.lang.String r4 = "app_id=? and name=?"
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            r5[r9] = r23     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            r6 = 0
            r0 = 0
            r17 = 0
            r7 = r0
            r0 = 6
            r8 = r17
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x010f, all -> 0x010b }
            boolean r1 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            if (r1 != 0) goto L_0x0063
            if (r8 == 0) goto L_0x0062
            r8.close()
        L_0x0062:
            return r16
        L_0x0063:
            long r4 = r8.getLong(r9)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            long r6 = r8.getLong(r10)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            long r19 = r8.getLong(r11)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            boolean r1 = r8.isNull(r12)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            if (r1 == 0) goto L_0x0078
            r1 = 0
            goto L_0x007c
        L_0x0078:
            long r1 = r8.getLong(r12)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
        L_0x007c:
            r11 = r1
            boolean r1 = r8.isNull(r13)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            if (r1 == 0) goto L_0x0086
            r13 = r16
            goto L_0x008f
        L_0x0086:
            long r1 = r8.getLong(r13)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            r13 = r1
        L_0x008f:
            boolean r1 = r8.isNull(r14)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            if (r1 == 0) goto L_0x0098
            r14 = r16
            goto L_0x00a1
        L_0x0098:
            long r1 = r8.getLong(r14)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            r14 = r1
        L_0x00a1:
            boolean r1 = r8.isNull(r0)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            if (r1 == 0) goto L_0x00aa
            r0 = r16
            goto L_0x00b2
        L_0x00aa:
            long r0 = r8.getLong(r0)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
        L_0x00b2:
            r1 = 7
            boolean r2 = r8.isNull(r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            if (r2 != 0) goto L_0x00cc
            long r1 = r8.getLong(r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            r17 = 1
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 != 0) goto L_0x00c5
            r9 = 1
        L_0x00c5:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            r17 = r1
            goto L_0x00ce
        L_0x00cc:
            r17 = r16
        L_0x00ce:
            com.google.android.gms.measurement.internal.zzz r18 = new com.google.android.gms.measurement.internal.zzz     // Catch:{ SQLiteException -> 0x0107, all -> 0x0103 }
            r1 = r18
            r2 = r23
            r3 = r24
            r21 = r8
            r8 = r19
            r10 = r11
            r12 = r13
            r13 = r14
            r14 = r0
            r15 = r17
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r13, r14, r15)     // Catch:{ SQLiteException -> 0x0101 }
            boolean r0 = r21.moveToNext()     // Catch:{ SQLiteException -> 0x0101 }
            if (r0 == 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzap r0 = r22.zzgo()     // Catch:{ SQLiteException -> 0x0101 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ SQLiteException -> 0x0101 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzap.zzbv(r23)     // Catch:{ SQLiteException -> 0x0101 }
            r0.zzg(r1, r2)     // Catch:{ SQLiteException -> 0x0101 }
        L_0x00fa:
            if (r21 == 0) goto L_0x0100
            r21.close()
        L_0x0100:
            return r18
        L_0x0101:
            r0 = move-exception
            goto L_0x0112
        L_0x0103:
            r0 = move-exception
            r21 = r8
            goto L_0x0134
        L_0x0107:
            r0 = move-exception
            r21 = r8
            goto L_0x0112
        L_0x010b:
            r0 = move-exception
            r21 = r16
            goto L_0x0134
        L_0x010f:
            r0 = move-exception
            r21 = r16
        L_0x0112:
            com.google.android.gms.measurement.internal.zzap r1 = r22.zzgo()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r23)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.measurement.internal.zzan r4 = r22.zzgl()     // Catch:{ all -> 0x0133 }
            r5 = r24
            java.lang.String r4 = r4.zzbs(r5)     // Catch:{ all -> 0x0133 }
            r1.zzd(r2, r3, r4, r0)     // Catch:{ all -> 0x0133 }
            if (r21 == 0) goto L_0x0132
            r21.close()
        L_0x0132:
            return r16
        L_0x0133:
            r0 = move-exception
        L_0x0134:
            if (r21 == 0) goto L_0x0139
            r21.close()
        L_0x0139:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzg(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzz");
    }

    @WorkerThread
    public final void zza(zzz zzz) {
        Long l;
        Preconditions.checkNotNull(zzz);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzz.zztt);
        contentValues.put("name", zzz.name);
        contentValues.put("lifetime_count", Long.valueOf(zzz.zzaie));
        contentValues.put("current_bundle_count", Long.valueOf(zzz.zzaif));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzz.zzaig));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzz.zzaih));
        contentValues.put("last_bundled_day", zzz.zzaii);
        contentValues.put("last_sampled_complex_event_id", zzz.zzaij);
        contentValues.put("last_sampling_rate", zzz.zzaik);
        if (zzz.zzail == null || !zzz.zzail.booleanValue()) {
            l = null;
        } else {
            l = Long.valueOf(1);
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzgo().zzjd().zzg("Failed to insert/update event aggregates (got -1). appId", zzap.zzbv(zzz.zztt));
            }
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Error storing event aggregates. appId", zzap.zzbv(zzz.zztt), e);
        }
    }

    @WorkerThread
    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            zzgo().zzjl().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzgo().zzjd().zzd("Error deleting user attribute. appId", zzap.zzbv(str), zzgl().zzbu(str2), e);
        }
    }

    @WorkerThread
    public final boolean zza(zzfj zzfj) {
        Preconditions.checkNotNull(zzfj);
        zzaf();
        zzcl();
        if (zzi(zzfj.zztt, zzfj.name) == null) {
            if (zzfk.zzcq(zzfj.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzfj.zztt}) >= 25) {
                    return false;
                }
            } else {
                long zza = zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzfj.zztt, zzfj.origin});
                if (zzgq().zze(zzfj.zztt, zzaf.zzalj)) {
                    if (!"_ap".equals(zzfj.name) && zza >= 25) {
                        return false;
                    }
                } else if (zza >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfj.zztt);
        contentValues.put(Param.ORIGIN, zzfj.origin);
        contentValues.put("name", zzfj.name);
        contentValues.put("set_timestamp", Long.valueOf(zzfj.zzaue));
        zza(contentValues, Param.VALUE, zzfj.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzgo().zzjd().zzg("Failed to insert/update user property (got -1). appId", zzap.zzbv(zzfj.zztt));
            }
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Error storing user property. appId", zzap.zzbv(zzfj.zztt), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzfj zzi(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzaf()
            r18.zzcl()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.getWritableDatabase()     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x008a, all -> 0x0085 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            if (r0 != 0) goto L_0x0045
            if (r10 == 0) goto L_0x0044
            r10.close()
        L_0x0044:
            return r9
        L_0x0045:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzfj r0 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ SQLiteException -> 0x007b }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x007b }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x007b }
            if (r1 == 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzap r1 = r18.zzgo()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r19)     // Catch:{ SQLiteException -> 0x007b }
            r1.zzg(r2, r3)     // Catch:{ SQLiteException -> 0x007b }
        L_0x0074:
            if (r10 == 0) goto L_0x007a
            r10.close()
        L_0x007a:
            return r0
        L_0x007b:
            r0 = move-exception
            goto L_0x008e
        L_0x007d:
            r0 = move-exception
            r11 = r18
            goto L_0x00ae
        L_0x0081:
            r0 = move-exception
            r11 = r18
            goto L_0x008e
        L_0x0085:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto L_0x00ae
        L_0x008a:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x008e:
            com.google.android.gms.measurement.internal.zzap r1 = r18.zzgo()     // Catch:{ all -> 0x00ad }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x00ad }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r19)     // Catch:{ all -> 0x00ad }
            com.google.android.gms.measurement.internal.zzan r4 = r18.zzgl()     // Catch:{ all -> 0x00ad }
            java.lang.String r4 = r4.zzbu(r8)     // Catch:{ all -> 0x00ad }
            r1.zzd(r2, r3, r4, r0)     // Catch:{ all -> 0x00ad }
            if (r10 == 0) goto L_0x00ac
            r10.close()
        L_0x00ac:
            return r9
        L_0x00ad:
            r0 = move-exception
        L_0x00ae:
            if (r10 == 0) goto L_0x00b3
            r10.close()
        L_0x00b3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzi(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzfj");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzfj> zzbk(java.lang.String r23) {
        /*
            r22 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzaf()
            r22.zzcl()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r22.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            java.lang.String r3 = "user_attributes"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            java.lang.String r5 = "name"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            java.lang.String r5 = "set_timestamp"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            r6[r11] = r23     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009b }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0097, all -> 0x0093 }
            if (r3 != 0) goto L_0x004a
            if (r2 == 0) goto L_0x0049
            r2.close()
        L_0x0049:
            return r0
        L_0x004a:
            java.lang.String r18 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0097, all -> 0x0093 }
            java.lang.String r3 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0097, all -> 0x0093 }
            if (r3 != 0) goto L_0x0059
            java.lang.String r3 = ""
            r17 = r3
            goto L_0x005b
        L_0x0059:
            r17 = r3
        L_0x005b:
            long r19 = r2.getLong(r13)     // Catch:{ SQLiteException -> 0x0097, all -> 0x0093 }
            r3 = r22
            java.lang.Object r21 = r3.zza(r2, r14)     // Catch:{ SQLiteException -> 0x0091 }
            if (r21 != 0) goto L_0x0079
            com.google.android.gms.measurement.internal.zzap r4 = r22.zzgo()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.measurement.internal.zzar r4 = r4.zzjd()     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r5 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzap.zzbv(r23)     // Catch:{ SQLiteException -> 0x0091 }
            r4.zzg(r5, r6)     // Catch:{ SQLiteException -> 0x0091 }
            goto L_0x0084
        L_0x0079:
            com.google.android.gms.measurement.internal.zzfj r4 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ SQLiteException -> 0x0091 }
            r15 = r4
            r16 = r23
            r15.<init>(r16, r17, r18, r19, r21)     // Catch:{ SQLiteException -> 0x0091 }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x0091 }
        L_0x0084:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0091 }
            if (r4 != 0) goto L_0x004a
            if (r2 == 0) goto L_0x0090
            r2.close()
        L_0x0090:
            return r0
        L_0x0091:
            r0 = move-exception
            goto L_0x00a4
        L_0x0093:
            r0 = move-exception
            r3 = r22
            goto L_0x00bc
        L_0x0097:
            r0 = move-exception
            r3 = r22
            goto L_0x00a4
        L_0x009b:
            r0 = move-exception
            r3 = r22
            r2 = r1
            goto L_0x00bc
        L_0x00a0:
            r0 = move-exception
            r3 = r22
            r2 = r1
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzap r4 = r22.zzgo()     // Catch:{ all -> 0x00bb }
            com.google.android.gms.measurement.internal.zzar r4 = r4.zzjd()     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = "Error querying user properties. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzap.zzbv(r23)     // Catch:{ all -> 0x00bb }
            r4.zze(r5, r6, r0)     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x00ba
            r2.close()
        L_0x00ba:
            return r1
        L_0x00bb:
            r0 = move-exception
        L_0x00bc:
            if (r2 == 0) goto L_0x00c1
            r2.close()
        L_0x00c1:
            goto L_0x00c3
        L_0x00c2:
            throw r0
        L_0x00c3:
            goto L_0x00c2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzbk(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011e, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0125, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0126, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0129, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012a, code lost:
        r14 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014c, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0125 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzfj> zzb(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22)
            r21.zzaf()
            r21.zzcl()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0129, all -> 0x0125 }
            r3 = 3
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x0129, all -> 0x0125 }
            r11 = r22
            r2.add(r11)     // Catch:{ SQLiteException -> 0x0121, all -> 0x0125 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0121, all -> 0x0125 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x0121, all -> 0x0125 }
            boolean r5 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x0121, all -> 0x0125 }
            if (r5 != 0) goto L_0x0033
            r5 = r23
            r2.add(r5)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r6 = " and origin=?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            goto L_0x0035
        L_0x0033:
            r5 = r23
        L_0x0035:
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            if (r6 != 0) goto L_0x004d
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r7 = "*"
            java.lang.String r6 = r6.concat(r7)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            r2.add(r6)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r6 = " and name glob ?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
        L_0x004d:
            int r6 = r2.size()     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.Object[] r2 = r2.toArray(r6)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            r16 = r2
            java.lang.String[] r16 = (java.lang.String[]) r16     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            android.database.sqlite.SQLiteDatabase r12 = r21.getWritableDatabase()     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r13 = "user_attributes"
            r2 = 4
            java.lang.String[] r14 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r2 = "name"
            r10 = 0
            r14[r10] = r2     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r2 = "set_timestamp"
            r8 = 1
            r14[r8] = r2     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r2 = "value"
            r9 = 2
            r14[r9] = r2     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r2 = "origin"
            r14[r3] = r2     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            java.lang.String r15 = r4.toString()     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "1001"
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x011d, all -> 0x0125 }
            boolean r4 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            if (r4 != 0) goto L_0x0094
            if (r2 == 0) goto L_0x0093
            r2.close()
        L_0x0093:
            return r0
        L_0x0094:
            int r4 = r0.size()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r6) goto L_0x00b0
            com.google.android.gms.measurement.internal.zzap r3 = r21.zzgo()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            r3.zzg(r4, r6)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            r14 = r21
            goto L_0x00fd
        L_0x00b0:
            java.lang.String r7 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            long r12 = r2.getLong(r8)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0115 }
            r14 = r21
            java.lang.Object r15 = r14.zza(r2, r9)     // Catch:{ SQLiteException -> 0x0113 }
            java.lang.String r6 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x0113 }
            if (r15 != 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzap r4 = r21.zzgo()     // Catch:{ SQLiteException -> 0x00df }
            com.google.android.gms.measurement.internal.zzar r4 = r4.zzjd()     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r22)     // Catch:{ SQLiteException -> 0x00df }
            r12 = r24
            r4.zzd(r5, r7, r6, r12)     // Catch:{ SQLiteException -> 0x00df }
            r17 = r6
            r12 = 0
            r18 = 2
            r19 = 1
            goto L_0x00f7
        L_0x00df:
            r0 = move-exception
            r5 = r6
            goto L_0x0131
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzfj r5 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ SQLiteException -> 0x010d }
            r4 = r5
            r3 = r5
            r5 = r22
            r17 = r6
            r18 = 2
            r19 = 1
            r8 = r12
            r12 = 0
            r10 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x010b }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x010b }
        L_0x00f7:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x010b }
            if (r3 != 0) goto L_0x0104
        L_0x00fd:
            if (r2 == 0) goto L_0x0103
            r2.close()
        L_0x0103:
            return r0
        L_0x0104:
            r5 = r17
            r3 = 3
            r8 = 1
            r9 = 2
            r10 = 0
            goto L_0x0094
        L_0x010b:
            r0 = move-exception
            goto L_0x0110
        L_0x010d:
            r0 = move-exception
            r17 = r6
        L_0x0110:
            r5 = r17
            goto L_0x0131
        L_0x0113:
            r0 = move-exception
            goto L_0x0131
        L_0x0115:
            r0 = move-exception
            r14 = r21
            goto L_0x0149
        L_0x0119:
            r0 = move-exception
            r14 = r21
            goto L_0x0131
        L_0x011d:
            r0 = move-exception
            r14 = r21
            goto L_0x0130
        L_0x0121:
            r0 = move-exception
            r14 = r21
            goto L_0x012e
        L_0x0125:
            r0 = move-exception
            r14 = r21
            goto L_0x014a
        L_0x0129:
            r0 = move-exception
            r14 = r21
            r11 = r22
        L_0x012e:
            r5 = r23
        L_0x0130:
            r2 = r1
        L_0x0131:
            com.google.android.gms.measurement.internal.zzap r3 = r21.zzgo()     // Catch:{ all -> 0x0148 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ all -> 0x0148 }
            java.lang.String r4 = "(2)Error querying user properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzap.zzbv(r22)     // Catch:{ all -> 0x0148 }
            r3.zzd(r4, r6, r5, r0)     // Catch:{ all -> 0x0148 }
            if (r2 == 0) goto L_0x0147
            r2.close()
        L_0x0147:
            return r1
        L_0x0148:
            r0 = move-exception
        L_0x0149:
            r1 = r2
        L_0x014a:
            if (r1 == 0) goto L_0x014f
            r1.close()
        L_0x014f:
            goto L_0x0151
        L_0x0150:
            throw r0
        L_0x0151:
            goto L_0x0150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zza(zzl zzl) {
        Preconditions.checkNotNull(zzl);
        zzaf();
        zzcl();
        if (zzi(zzl.packageName, zzl.zzahb.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzl.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzl.packageName);
        contentValues.put(Param.ORIGIN, zzl.origin);
        contentValues.put("name", zzl.zzahb.name);
        zza(contentValues, Param.VALUE, zzl.zzahb.getValue());
        contentValues.put("active", Boolean.valueOf(zzl.active));
        contentValues.put("trigger_event_name", zzl.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzl.triggerTimeout));
        zzgm();
        contentValues.put("timed_out_event", zzfk.zza((Parcelable) zzl.zzahc));
        contentValues.put("creation_timestamp", Long.valueOf(zzl.creationTimestamp));
        zzgm();
        contentValues.put("triggered_event", zzfk.zza((Parcelable) zzl.zzahd));
        contentValues.put("triggered_timestamp", Long.valueOf(zzl.zzahb.zzaue));
        contentValues.put("time_to_live", Long.valueOf(zzl.timeToLive));
        zzgm();
        contentValues.put("expired_event", zzfk.zza((Parcelable) zzl.zzahe));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzgo().zzjd().zzg("Failed to insert/update conditional user property (got -1)", zzap.zzbv(zzl.packageName));
            }
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Error storing conditional user property", zzap.zzbv(zzl.packageName), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x015a  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzl zzj(java.lang.String r33, java.lang.String r34) {
        /*
            r32 = this;
            r7 = r34
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r33)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r32.zzaf()
            r32.zzcl()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r32.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r10 = "conditional_properties"
            r0 = 11
            java.lang.String[] r11 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "origin"
            r1 = 0
            r11[r1] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "value"
            r2 = 1
            r11[r2] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "active"
            r3 = 2
            r11[r3] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "trigger_event_name"
            r4 = 3
            r11[r4] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "trigger_timeout"
            r5 = 4
            r11[r5] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "timed_out_event"
            r6 = 5
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "creation_timestamp"
            r15 = 6
            r11[r15] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "triggered_event"
            r14 = 7
            r11[r14] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "triggered_timestamp"
            r13 = 8
            r11[r13] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "time_to_live"
            r12 = 9
            r11[r12] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "expired_event"
            r6 = 10
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            java.lang.String r0 = "app_id=? and name=?"
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            r13[r1] = r33     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = 9
            r12 = r0
            r0 = 8
            r6 = 7
            r14 = r17
            r0 = 6
            r15 = r18
            r16 = r19
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0134, all -> 0x012f }
            boolean r10 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x012b, all -> 0x0127 }
            if (r10 != 0) goto L_0x007f
            if (r9 == 0) goto L_0x007e
            r9.close()
        L_0x007e:
            return r8
        L_0x007f:
            java.lang.String r19 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x012b, all -> 0x0127 }
            r10 = r32
            java.lang.Object r11 = r10.zza(r9, r2)     // Catch:{ SQLiteException -> 0x0125 }
            int r3 = r9.getInt(r3)     // Catch:{ SQLiteException -> 0x0125 }
            if (r3 == 0) goto L_0x0092
            r23 = 1
            goto L_0x0094
        L_0x0092:
            r23 = 0
        L_0x0094:
            java.lang.String r24 = r9.getString(r4)     // Catch:{ SQLiteException -> 0x0125 }
            long r26 = r9.getLong(r5)     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzfg r1 = r32.zzjo()     // Catch:{ SQLiteException -> 0x0125 }
            r2 = 5
            byte[] r2 = r9.getBlob(r2)     // Catch:{ SQLiteException -> 0x0125 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r3 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ SQLiteException -> 0x0125 }
            android.os.Parcelable r1 = r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0125 }
            r25 = r1
            com.google.android.gms.measurement.internal.zzad r25 = (com.google.android.gms.measurement.internal.zzad) r25     // Catch:{ SQLiteException -> 0x0125 }
            long r12 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzfg r0 = r32.zzjo()     // Catch:{ SQLiteException -> 0x0125 }
            byte[] r1 = r9.getBlob(r6)     // Catch:{ SQLiteException -> 0x0125 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r2 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ SQLiteException -> 0x0125 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0125 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzad r28 = (com.google.android.gms.measurement.internal.zzad) r28     // Catch:{ SQLiteException -> 0x0125 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0125 }
            r0 = 9
            long r29 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzfg r0 = r32.zzjo()     // Catch:{ SQLiteException -> 0x0125 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x0125 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r2 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ SQLiteException -> 0x0125 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0125 }
            r31 = r0
            com.google.android.gms.measurement.internal.zzad r31 = (com.google.android.gms.measurement.internal.zzad) r31     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzfh r20 = new com.google.android.gms.measurement.internal.zzfh     // Catch:{ SQLiteException -> 0x0125 }
            r1 = r20
            r2 = r34
            r5 = r11
            r6 = r19
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzl r0 = new com.google.android.gms.measurement.internal.zzl     // Catch:{ SQLiteException -> 0x0125 }
            r17 = r0
            r18 = r33
            r21 = r12
            r17.<init>(r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r31)     // Catch:{ SQLiteException -> 0x0125 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0125 }
            if (r1 == 0) goto L_0x011e
            com.google.android.gms.measurement.internal.zzap r1 = r32.zzgo()     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ SQLiteException -> 0x0125 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r33)     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzan r4 = r32.zzgl()     // Catch:{ SQLiteException -> 0x0125 }
            java.lang.String r4 = r4.zzbu(r7)     // Catch:{ SQLiteException -> 0x0125 }
            r1.zze(r2, r3, r4)     // Catch:{ SQLiteException -> 0x0125 }
        L_0x011e:
            if (r9 == 0) goto L_0x0124
            r9.close()
        L_0x0124:
            return r0
        L_0x0125:
            r0 = move-exception
            goto L_0x0138
        L_0x0127:
            r0 = move-exception
            r10 = r32
            goto L_0x0158
        L_0x012b:
            r0 = move-exception
            r10 = r32
            goto L_0x0138
        L_0x012f:
            r0 = move-exception
            r10 = r32
            r9 = r8
            goto L_0x0158
        L_0x0134:
            r0 = move-exception
            r10 = r32
            r9 = r8
        L_0x0138:
            com.google.android.gms.measurement.internal.zzap r1 = r32.zzgo()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r33)     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzan r4 = r32.zzgl()     // Catch:{ all -> 0x0157 }
            java.lang.String r4 = r4.zzbu(r7)     // Catch:{ all -> 0x0157 }
            r1.zzd(r2, r3, r4, r0)     // Catch:{ all -> 0x0157 }
            if (r9 == 0) goto L_0x0156
            r9.close()
        L_0x0156:
            return r8
        L_0x0157:
            r0 = move-exception
        L_0x0158:
            if (r9 == 0) goto L_0x015d
            r9.close()
        L_0x015d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzj(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzl");
    }

    @WorkerThread
    public final int zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzgo().zzjd().zzd("Error deleting conditional property", zzap.zzbv(str), zzgl().zzbu(str2), e);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzl> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzl> zzb(java.lang.String r40, java.lang.String[] r41) {
        /*
            r39 = this;
            r39.zzaf()
            r39.zzcl()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r39.getWritableDatabase()     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "app_id"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "name"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "active"
            r15 = 4
            r4[r15] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "trigger_event_name"
            r10 = 5
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "trigger_timeout"
            r9 = 6
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "timed_out_event"
            r8 = 7
            r4[r8] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "creation_timestamp"
            r7 = 8
            r4[r7] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "triggered_event"
            r6 = 9
            r4[r6] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "triggered_timestamp"
            r1 = 10
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "time_to_live"
            r1 = 11
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r5 = "expired_event"
            r1 = 12
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "1001"
            r5 = r40
            r1 = 9
            r6 = r41
            r1 = 8
            r7 = r19
            r1 = 7
            r8 = r20
            r1 = 6
            r9 = r21
            r1 = 5
            r10 = r22
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            if (r3 != 0) goto L_0x0088
            if (r2 == 0) goto L_0x0087
            r2.close()
        L_0x0087:
            return r0
        L_0x0088:
            int r3 = r0.size()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00a3
            com.google.android.gms.measurement.internal.zzap r1 = r39.zzgo()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            java.lang.String r3 = "Read more than the max allowed conditional properties, ignoring extra"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r1.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            goto L_0x014b
        L_0x00a3:
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            java.lang.String r10 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            java.lang.String r5 = r2.getString(r13)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r9 = r39
            java.lang.Object r8 = r9.zza(r2, r14)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            int r4 = r2.getInt(r15)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            if (r4 == 0) goto L_0x00be
            r22 = 1
            goto L_0x00c0
        L_0x00be:
            r22 = 0
        L_0x00c0:
            java.lang.String r24 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r6 = 6
            long r25 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzfg r4 = r39.zzjo()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r7 = 7
            byte[] r1 = r2.getBlob(r7)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r6 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            android.os.Parcelable r1 = r4.zza(r1, r6)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzad r1 = (com.google.android.gms.measurement.internal.zzad) r1     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r6 = 8
            long r27 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzfg r4 = r39.zzjo()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r11 = 9
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r7 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            android.os.Parcelable r4 = r4.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r29 = r4
            com.google.android.gms.measurement.internal.zzad r29 = (com.google.android.gms.measurement.internal.zzad) r29     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r6 = 10
            long r16 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r7 = 11
            long r31 = r2.getLong(r7)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzfg r4 = r39.zzjo()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r11 = 12
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzad> r7 = com.google.android.gms.measurement.internal.zzad.CREATOR     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            android.os.Parcelable r4 = r4.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r30 = r4
            com.google.android.gms.measurement.internal.zzad r30 = (com.google.android.gms.measurement.internal.zzad) r30     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzfh r33 = new com.google.android.gms.measurement.internal.zzfh     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r4 = r33
            r34 = 11
            r35 = 10
            r36 = 8
            r37 = 7
            r38 = 6
            r6 = r16
            r9 = r10
            r4.<init>(r5, r6, r8, r9)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzl r4 = new com.google.android.gms.measurement.internal.zzl     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r16 = r4
            r17 = r3
            r18 = r10
            r19 = r33
            r20 = r27
            r23 = r24
            r24 = r1
            r27 = r29
            r28 = r31
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r30)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            if (r1 != 0) goto L_0x0152
        L_0x014b:
            if (r2 == 0) goto L_0x0151
            r2.close()
        L_0x0151:
            return r0
        L_0x0152:
            r1 = 5
            r11 = 0
            goto L_0x0088
        L_0x0156:
            r0 = move-exception
            goto L_0x0179
        L_0x0158:
            r0 = move-exception
            r1 = r2
            goto L_0x0160
        L_0x015b:
            r0 = move-exception
            r2 = 0
            goto L_0x0179
        L_0x015e:
            r0 = move-exception
            r1 = 0
        L_0x0160:
            com.google.android.gms.measurement.internal.zzap r2 = r39.zzgo()     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()     // Catch:{ all -> 0x0177 }
            java.lang.String r3 = "Error querying conditional user property value"
            r2.zzg(r3, r0)     // Catch:{ all -> 0x0177 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0177 }
            if (r1 == 0) goto L_0x0176
            r1.close()
        L_0x0176:
            return r0
        L_0x0177:
            r0 = move-exception
            r2 = r1
        L_0x0179:
            if (r2 == 0) goto L_0x017e
            r2.close()
        L_0x017e:
            goto L_0x0180
        L_0x017f:
            throw r0
        L_0x0180:
            goto L_0x017f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzb(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0181 A[Catch:{ SQLiteException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0185 A[Catch:{ SQLiteException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01b9 A[Catch:{ SQLiteException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01bc A[Catch:{ SQLiteException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01cb A[Catch:{ SQLiteException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01fc A[Catch:{ SQLiteException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0241  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzbl(java.lang.String r23) {
        /*
            r22 = this;
            r1 = r23
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzaf()
            r22.zzcl()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r22.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r4 = "apps"
            r0 = 26
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "app_instance_id"
            r11 = 0
            r5[r11] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "gmp_app_id"
            r12 = 1
            r5[r12] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "resettable_device_id_hash"
            r13 = 2
            r5[r13] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "last_bundle_index"
            r14 = 3
            r5[r14] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "last_bundle_start_timestamp"
            r15 = 4
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "last_bundle_end_timestamp"
            r10 = 5
            r5[r10] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "app_version"
            r9 = 6
            r5[r9] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "app_store"
            r8 = 7
            r5[r8] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "gmp_version"
            r7 = 8
            r5[r7] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 9
            java.lang.String r6 = "dev_cert_hash"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "measurement_enabled"
            r6 = 10
            r5[r6] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 11
            java.lang.String r16 = "day"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 12
            java.lang.String r16 = "daily_public_events_count"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 13
            java.lang.String r16 = "daily_events_count"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 14
            java.lang.String r16 = "daily_conversions_count"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 15
            java.lang.String r16 = "config_fetched_time"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 16
            java.lang.String r16 = "failed_config_fetch_time"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "app_version_int"
            r15 = 17
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 18
            java.lang.String r17 = "firebase_instance_id"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 19
            java.lang.String r17 = "daily_error_events_count"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 20
            java.lang.String r17 = "daily_realtime_events_count"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 21
            java.lang.String r17 = "health_monitor_sample"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "android_id"
            r15 = 22
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "adid_reporting_enabled"
            r15 = 23
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "ssaid_reporting_enabled"
            r15 = 24
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r0 = 25
            java.lang.String r18 = "admob_app_id"
            r5[r0] = r18     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r0 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r19 = 0
            r20 = 0
            r21 = 0
            r15 = 10
            r6 = r0
            r0 = 8
            r15 = 7
            r8 = r19
            r0 = 6
            r9 = r20
            r15 = 5
            r10 = r21
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x021a, all -> 0x0216 }
            if (r4 != 0) goto L_0x00d5
            if (r3 == 0) goto L_0x00d4
            r3.close()
        L_0x00d4:
            return r2
        L_0x00d5:
            com.google.android.gms.measurement.internal.zzg r4 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x021a, all -> 0x0216 }
            r5 = r22
            com.google.android.gms.measurement.internal.zzfa r6 = r5.zzamz     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzbt r6 = r6.zzmb()     // Catch:{ SQLiteException -> 0x0214 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzam(r6)     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r6 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzan(r6)     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r6 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzap(r6)     // Catch:{ SQLiteException -> 0x0214 }
            long r6 = r3.getLong(r14)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzx(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzs(r6)     // Catch:{ SQLiteException -> 0x0214 }
            long r6 = r3.getLong(r15)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzt(r6)     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.setAppVersion(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 7
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzar(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 8
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzv(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 9
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzw(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 10
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r6 != 0) goto L_0x013f
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r0 == 0) goto L_0x013d
            goto L_0x013f
        L_0x013d:
            r0 = 0
            goto L_0x0140
        L_0x013f:
            r0 = 1
        L_0x0140:
            r4.setMeasurementEnabled(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 11
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzaa(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 12
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzab(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 13
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzac(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 14
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzad(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 15
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzy(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 16
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzz(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 17
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r6 == 0) goto L_0x0185
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x018a
        L_0x0185:
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0214 }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x0214 }
        L_0x018a:
            r4.zzu(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 18
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzaq(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 19
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzaf(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 20
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzae(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 21
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzas(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 22
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r6 == 0) goto L_0x01bc
            r6 = 0
            goto L_0x01c0
        L_0x01bc:
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0214 }
        L_0x01c0:
            r4.zzag(r6)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 23
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r6 != 0) goto L_0x01d4
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r0 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r0 = 0
            goto L_0x01d5
        L_0x01d4:
            r0 = 1
        L_0x01d5:
            r4.zze(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 24
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r6 != 0) goto L_0x01e6
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0214 }
            if (r0 == 0) goto L_0x01e7
        L_0x01e6:
            r11 = 1
        L_0x01e7:
            r4.zzf(r11)     // Catch:{ SQLiteException -> 0x0214 }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzao(r0)     // Catch:{ SQLiteException -> 0x0214 }
            r4.zzgv()     // Catch:{ SQLiteException -> 0x0214 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0214 }
            if (r0 == 0) goto L_0x020d
            com.google.android.gms.measurement.internal.zzap r0 = r22.zzgo()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r23)     // Catch:{ SQLiteException -> 0x0214 }
            r0.zzg(r6, r7)     // Catch:{ SQLiteException -> 0x0214 }
        L_0x020d:
            if (r3 == 0) goto L_0x0213
            r3.close()
        L_0x0213:
            return r4
        L_0x0214:
            r0 = move-exception
            goto L_0x0227
        L_0x0216:
            r0 = move-exception
            r5 = r22
            goto L_0x023f
        L_0x021a:
            r0 = move-exception
            r5 = r22
            goto L_0x0227
        L_0x021e:
            r0 = move-exception
            r5 = r22
            r3 = r2
            goto L_0x023f
        L_0x0223:
            r0 = move-exception
            r5 = r22
            r3 = r2
        L_0x0227:
            com.google.android.gms.measurement.internal.zzap r4 = r22.zzgo()     // Catch:{ all -> 0x023e }
            com.google.android.gms.measurement.internal.zzar r4 = r4.zzjd()     // Catch:{ all -> 0x023e }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzap.zzbv(r23)     // Catch:{ all -> 0x023e }
            r4.zze(r6, r1, r0)     // Catch:{ all -> 0x023e }
            if (r3 == 0) goto L_0x023d
            r3.close()
        L_0x023d:
            return r2
        L_0x023e:
            r0 = move-exception
        L_0x023f:
            if (r3 == 0) goto L_0x0244
            r3.close()
        L_0x0244:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzbl(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    @WorkerThread
    public final void zza(zzg zzg) {
        String str = "apps";
        Preconditions.checkNotNull(zzg);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg.zzal());
        contentValues.put("app_instance_id", zzg.getAppInstanceId());
        contentValues.put("gmp_app_id", zzg.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzg.zzgx());
        contentValues.put("last_bundle_index", Long.valueOf(zzg.zzhe()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg.zzgy()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg.zzgz()));
        contentValues.put("app_version", zzg.zzak());
        contentValues.put("app_store", zzg.zzhb());
        contentValues.put("gmp_version", Long.valueOf(zzg.zzhc()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg.zzhd()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzg.zzhi()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg.zzhj()));
        contentValues.put("daily_events_count", Long.valueOf(zzg.zzhk()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg.zzhl()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg.zzhf()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg.zzhg()));
        contentValues.put("app_version_int", Long.valueOf(zzg.zzha()));
        contentValues.put("firebase_instance_id", zzg.getFirebaseInstanceId());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg.zzhn()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg.zzhm()));
        contentValues.put("health_monitor_sample", zzg.zzho());
        contentValues.put("android_id", Long.valueOf(zzg.zzhq()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg.zzhr()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzg.zzhs()));
        contentValues.put("admob_app_id", zzg.zzgw());
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update(str, contentValues, "app_id = ?", new String[]{zzg.zzal()})) == 0 && writableDatabase.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzgo().zzjd().zzg("Failed to insert/update app (got -1). appId", zzap.zzbv(zzg.zzal()));
            }
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Error storing app. appId", zzap.zzbv(zzg.zzal()), e);
        }
    }

    public final long zzbm(String str) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzgq().zzb(str, zzaf.zzajs))))});
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Error deleting over the limit events. appId", zzap.zzbv(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0127  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzr zza(long r22, java.lang.String r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
            r21 = this;
            java.lang.String r0 = "daily_realtime_events_count"
            java.lang.String r1 = "daily_error_events_count"
            java.lang.String r2 = "daily_conversions_count"
            java.lang.String r3 = "daily_public_events_count"
            java.lang.String r4 = "daily_events_count"
            java.lang.String r5 = "day"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r21.zzaf()
            r21.zzcl()
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
            r7[r8] = r24
            com.google.android.gms.measurement.internal.zzr r9 = new com.google.android.gms.measurement.internal.zzr
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r15 = r21.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            java.lang.String r12 = "apps"
            r11 = 6
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r13[r8] = r5     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r13[r6] = r4     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r14 = 2
            r13[r14] = r3     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r11 = 3
            r13[r11] = r2     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r10 = 4
            r13[r10] = r1     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r10 = 5
            r13[r10] = r0     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            java.lang.String r16 = "app_id=?"
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r10[r8] = r24     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r17 = 0
            r18 = 0
            r19 = 0
            r11 = r15
            r14 = r16
            r20 = r15
            r15 = r10
            r16 = r17
            r17 = r18
            r18 = r19
            android.database.Cursor r10 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x010c }
            if (r11 != 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzap r0 = r21.zzgo()     // Catch:{ SQLiteException -> 0x010c }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjg()     // Catch:{ SQLiteException -> 0x010c }
            java.lang.String r1 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzap.zzbv(r24)     // Catch:{ SQLiteException -> 0x010c }
            r0.zzg(r1, r2)     // Catch:{ SQLiteException -> 0x010c }
            if (r10 == 0) goto L_0x0073
            r10.close()
        L_0x0073:
            return r9
        L_0x0074:
            long r11 = r10.getLong(r8)     // Catch:{ SQLiteException -> 0x010c }
            int r8 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x009e
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzahr = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 2
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzahq = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 3
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzahs = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 4
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzaht = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 5
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzahu = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x009e:
            r11 = 1
            if (r25 == 0) goto L_0x00a7
            long r13 = r9.zzahr     // Catch:{ SQLiteException -> 0x010c }
            long r13 = r13 + r11
            r9.zzahr = r13     // Catch:{ SQLiteException -> 0x010c }
        L_0x00a7:
            if (r26 == 0) goto L_0x00ae
            long r13 = r9.zzahq     // Catch:{ SQLiteException -> 0x010c }
            long r13 = r13 + r11
            r9.zzahq = r13     // Catch:{ SQLiteException -> 0x010c }
        L_0x00ae:
            if (r27 == 0) goto L_0x00b5
            long r13 = r9.zzahs     // Catch:{ SQLiteException -> 0x010c }
            long r13 = r13 + r11
            r9.zzahs = r13     // Catch:{ SQLiteException -> 0x010c }
        L_0x00b5:
            if (r28 == 0) goto L_0x00bc
            long r13 = r9.zzaht     // Catch:{ SQLiteException -> 0x010c }
            long r13 = r13 + r11
            r9.zzaht = r13     // Catch:{ SQLiteException -> 0x010c }
        L_0x00bc:
            if (r29 == 0) goto L_0x00c3
            long r13 = r9.zzahu     // Catch:{ SQLiteException -> 0x010c }
            long r13 = r13 + r11
            r9.zzahu = r13     // Catch:{ SQLiteException -> 0x010c }
        L_0x00c3:
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x010c }
            r6.<init>()     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r8 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r5, r8)     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r9.zzahq     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r3, r5)     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r9.zzahr     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r4, r3)     // Catch:{ SQLiteException -> 0x010c }
            long r3 = r9.zzahs     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r2, r3)     // Catch:{ SQLiteException -> 0x010c }
            long r2 = r9.zzaht     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r1, r2)     // Catch:{ SQLiteException -> 0x010c }
            long r1 = r9.zzahu     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r0, r1)     // Catch:{ SQLiteException -> 0x010c }
            java.lang.String r0 = "apps"
            java.lang.String r1 = "app_id=?"
            r2 = r20
            r2.update(r0, r6, r1, r7)     // Catch:{ SQLiteException -> 0x010c }
            if (r10 == 0) goto L_0x010b
            r10.close()
        L_0x010b:
            return r9
        L_0x010c:
            r0 = move-exception
            goto L_0x0113
        L_0x010e:
            r0 = move-exception
            r10 = 0
            goto L_0x012c
        L_0x0111:
            r0 = move-exception
            r10 = 0
        L_0x0113:
            com.google.android.gms.measurement.internal.zzap r1 = r21.zzgo()     // Catch:{ all -> 0x012b }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "Error updating daily counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r24)     // Catch:{ all -> 0x012b }
            r1.zze(r2, r3, r0)     // Catch:{ all -> 0x012b }
            if (r10 == 0) goto L_0x012a
            r10.close()
        L_0x012a:
            return r9
        L_0x012b:
            r0 = move-exception
        L_0x012c:
            if (r10 == 0) goto L_0x0131
            r10.close()
        L_0x0131:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzr");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzbn(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzaf()
            r11.zzcl()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.String r2 = "apps"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.String r5 = "remote_config"
            r9 = 0
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x005f, all -> 0x005c }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x005f, all -> 0x005c }
            r6[r9] = r12     // Catch:{ SQLiteException -> 0x005f, all -> 0x005c }
            r7 = 0
            r8 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005f, all -> 0x005c }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x005a }
            if (r2 != 0) goto L_0x0038
            if (r1 == 0) goto L_0x0037
            r1.close()
        L_0x0037:
            return r0
        L_0x0038:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x005a }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x005a }
            if (r3 == 0) goto L_0x0053
            com.google.android.gms.measurement.internal.zzap r3 = r11.zzgo()     // Catch:{ SQLiteException -> 0x005a }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ SQLiteException -> 0x005a }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzap.zzbv(r12)     // Catch:{ SQLiteException -> 0x005a }
            r3.zzg(r4, r5)     // Catch:{ SQLiteException -> 0x005a }
        L_0x0053:
            if (r1 == 0) goto L_0x0059
            r1.close()
        L_0x0059:
            return r2
        L_0x005a:
            r2 = move-exception
            goto L_0x0061
        L_0x005c:
            r12 = move-exception
            r1 = r0
            goto L_0x0079
        L_0x005f:
            r2 = move-exception
            r1 = r0
        L_0x0061:
            com.google.android.gms.measurement.internal.zzap r3 = r11.zzgo()     // Catch:{ all -> 0x0078 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ all -> 0x0078 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzap.zzbv(r12)     // Catch:{ all -> 0x0078 }
            r3.zze(r4, r12, r2)     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0077
            r1.close()
        L_0x0077:
            return r0
        L_0x0078:
            r12 = move-exception
        L_0x0079:
            if (r1 == 0) goto L_0x007e
            r1.close()
        L_0x007e:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzbn(java.lang.String):byte[]");
    }

    @WorkerThread
    public final boolean zza(zzgi zzgi, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzgi);
        Preconditions.checkNotEmpty(zzgi.zztt);
        Preconditions.checkNotNull(zzgi.zzaxf);
        zzif();
        long currentTimeMillis = zzbx().currentTimeMillis();
        if (zzgi.zzaxf.longValue() < currentTimeMillis - zzn.zzhw() || zzgi.zzaxf.longValue() > zzn.zzhw() + currentTimeMillis) {
            zzgo().zzjg().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzap.zzbv(zzgi.zztt), Long.valueOf(currentTimeMillis), zzgi.zzaxf);
        }
        try {
            byte[] bArr = new byte[zzgi.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzgi.zza(zzk);
            zzk.zzyt();
            byte[] zzb = zzjo().zzb(bArr);
            zzgo().zzjl().zzg("Saving bundle, size", Integer.valueOf(zzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgi.zztt);
            contentValues.put("bundle_end_timestamp", zzgi.zzaxf);
            contentValues.put("data", zzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgi.zzayc != null) {
                contentValues.put("retry_count", zzgi.zzayc);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzgo().zzjd().zzg("Failed to insert bundle (got -1). appId", zzap.zzbv(zzgi.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgo().zzjd().zze("Error storing bundle. appId", zzap.zzbv(zzgi.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgo().zzjd().zze("Data loss. Failed to serialize bundle. appId", zzap.zzbv(zzgi.zztt), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzid() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x002a, all -> 0x0025 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0023 }
            if (r2 == 0) goto L_0x001d
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0023 }
            if (r0 == 0) goto L_0x001c
            r0.close()
        L_0x001c:
            return r1
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.close()
        L_0x0022:
            return r1
        L_0x0023:
            r2 = move-exception
            goto L_0x002c
        L_0x0025:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0040
        L_0x002a:
            r2 = move-exception
            r0 = r1
        L_0x002c:
            com.google.android.gms.measurement.internal.zzap r3 = r6.zzgo()     // Catch:{ all -> 0x003f }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ all -> 0x003f }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzg(r4, r2)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            return r1
        L_0x003f:
            r1 = move-exception
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            r0.close()
        L_0x0045:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzid():java.lang.String");
    }

    public final boolean zzie() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    @WorkerThread
    public final List<Pair<zzgi, Long>> zzb(String str, int i, int i2) {
        int i3 = i2;
        zzaf();
        zzcl();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i3 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzgi, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zza = zzjo().zza(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zza.length + i4 > i3) {
                        break;
                    }
                    zzyx zzj = zzyx.zzj(zza, 0, zza.length);
                    zzgi zzgi = new zzgi();
                    try {
                        zzgi.zza(zzj);
                        if (!cursor.isNull(2)) {
                            zzgi.zzayc = Integer.valueOf(cursor.getInt(2));
                        }
                        i4 += zza.length;
                        arrayList.add(Pair.create(zzgi, Long.valueOf(j)));
                    } catch (IOException e) {
                        zzgo().zzjd().zze("Failed to merge queued bundle. appId", zzap.zzbv(str), e);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzgo().zzjd().zze("Failed to unzip queued bundle. appId", zzap.zzbv(str), e2);
                }
            } while (i4 <= i3);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzgo().zzjd().zze("Error querying bundles. appId", zzap.zzbv(str), e3);
            List<Pair<zzgi, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzif() {
        zzaf();
        zzcl();
        if (zzil()) {
            long j = zzgp().zzanh.get();
            long elapsedRealtime = zzbx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzaf.zzakb.get()).longValue()) {
                zzgp().zzanh.set(elapsedRealtime);
                zzaf();
                zzcl();
                if (zzil()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbx().currentTimeMillis()), String.valueOf(zzn.zzhw())});
                    if (delete > 0) {
                        zzgo().zzjl().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    @VisibleForTesting
    public final void zzc(List<Long> list) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzil()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zza(sb3.toString(), (String[]) null) > 0) {
                zzgo().zzjg().zzbx("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                writableDatabase.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzgo().zzjd().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, zzfu[] zzfuArr) {
        boolean z;
        String str2 = str;
        zzfu[] zzfuArr2 = zzfuArr;
        String str3 = "app_id=? and audience_id=?";
        String str4 = "event_filters";
        String str5 = "app_id=?";
        String str6 = "property_filters";
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfuArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzcl();
            zzaf();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete(str6, str5, new String[]{str2});
            writableDatabase2.delete(str4, str5, new String[]{str2});
            for (zzfu zzfu : zzfuArr2) {
                zzcl();
                zzaf();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfu);
                Preconditions.checkNotNull(zzfu.zzava);
                Preconditions.checkNotNull(zzfu.zzauz);
                if (zzfu.zzauy == null) {
                    zzgo().zzjg().zzg("Audience with no ID. appId", zzap.zzbv(str));
                } else {
                    int intValue = zzfu.zzauy.intValue();
                    zzfv[] zzfvArr = zzfu.zzava;
                    int length = zzfvArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            zzfy[] zzfyArr = zzfu.zzauz;
                            int length2 = zzfyArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    zzfv[] zzfvArr2 = zzfu.zzava;
                                    int length3 = zzfvArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length3) {
                                            z = true;
                                            break;
                                        } else if (!zza(str2, intValue, zzfvArr2[i3])) {
                                            z = false;
                                            break;
                                        } else {
                                            i3++;
                                        }
                                    }
                                    if (z) {
                                        zzfy[] zzfyArr2 = zzfu.zzauz;
                                        int length4 = zzfyArr2.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length4) {
                                                break;
                                            } else if (!zza(str2, intValue, zzfyArr2[i4])) {
                                                z = false;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzcl();
                                        zzaf();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                        writableDatabase3.delete(str6, str3, new String[]{str2, String.valueOf(intValue)});
                                        writableDatabase3.delete(str4, str3, new String[]{str2, String.valueOf(intValue)});
                                    }
                                } else if (zzfyArr[i2].zzave == null) {
                                    zzgo().zzjg().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzap.zzbv(str), zzfu.zzauy);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else if (zzfvArr[i].zzave == null) {
                            zzgo().zzjg().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzap.zzbv(str), zzfu.zzauy);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfu zzfu2 : zzfuArr2) {
                arrayList.add(zzfu2.zzauy);
            }
            zza(str2, (List<Integer>) arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzfv zzfv) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfv);
        if (TextUtils.isEmpty(zzfv.zzavf)) {
            zzgo().zzjg().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzap.zzbv(str), Integer.valueOf(i), String.valueOf(zzfv.zzave));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfv.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzfv.zza(zzk);
            zzk.zzyt();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfv.zzave);
            contentValues.put("event_name", zzfv.zzavf);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzgo().zzjd().zzg("Failed to insert event filter (got -1). appId", zzap.zzbv(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzgo().zzjd().zze("Error storing event filter. appId", zzap.zzbv(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgo().zzjd().zze("Configuration loss. Failed to serialize event filter. appId", zzap.zzbv(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzfy zzfy) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfy);
        if (TextUtils.isEmpty(zzfy.zzavu)) {
            zzgo().zzjg().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzap.zzbv(str), Integer.valueOf(i), String.valueOf(zzfy.zzave));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfy.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzfy.zza(zzk);
            zzk.zzyt();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfy.zzave);
            contentValues.put("property_name", zzfy.zzavu);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgo().zzjd().zzg("Failed to insert property filter (got -1). appId", zzap.zzbv(str));
                return false;
            } catch (SQLiteException e) {
                zzgo().zzjd().zze("Error storing property filter. appId", zzap.zzbv(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgo().zzjd().zze("Configuration loss. Failed to serialize property filter. appId", zzap.zzbv(str), e2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzfv>> zzl(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzcl()
            r12.zzaf()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.getWritableDatabase()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0049
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009c }
            if (r14 == 0) goto L_0x0048
            r14.close()
        L_0x0048:
            return r13
        L_0x0049:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x009c }
            int r2 = r1.length     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.internal.measurement.zzyx r1 = com.google.android.gms.internal.measurement.zzyx.zzj(r1, r10, r2)     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.internal.measurement.zzfv r2 = new com.google.android.gms.internal.measurement.zzfv     // Catch:{ SQLiteException -> 0x009c }
            r2.<init>()     // Catch:{ SQLiteException -> 0x009c }
            r2.zza(r1)     // Catch:{ IOException -> 0x007d }
            int r1 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x009c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x009c }
            if (r3 != 0) goto L_0x0079
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ SQLiteException -> 0x009c }
            r0.put(r1, r3)     // Catch:{ SQLiteException -> 0x009c }
        L_0x0079:
            r3.add(r2)     // Catch:{ SQLiteException -> 0x009c }
            goto L_0x0090
        L_0x007d:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzap r2 = r12.zzgo()     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)     // Catch:{ SQLiteException -> 0x009c }
            r2.zze(r3, r4, r1)     // Catch:{ SQLiteException -> 0x009c }
        L_0x0090:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0049
            if (r14 == 0) goto L_0x009b
            r14.close()
        L_0x009b:
            return r0
        L_0x009c:
            r0 = move-exception
            goto L_0x00a3
        L_0x009e:
            r13 = move-exception
            r14 = r9
            goto L_0x00bb
        L_0x00a1:
            r0 = move-exception
            r14 = r9
        L_0x00a3:
            com.google.android.gms.measurement.internal.zzap r1 = r12.zzgo()     // Catch:{ all -> 0x00ba }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)     // Catch:{ all -> 0x00ba }
            r1.zze(r2, r13, r0)     // Catch:{ all -> 0x00ba }
            if (r14 == 0) goto L_0x00b9
            r14.close()
        L_0x00b9:
            return r9
        L_0x00ba:
            r13 = move-exception
        L_0x00bb:
            if (r14 == 0) goto L_0x00c0
            r14.close()
        L_0x00c0:
            goto L_0x00c2
        L_0x00c1:
            throw r13
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzl(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzfy>> zzm(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzcl()
            r12.zzaf()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.getWritableDatabase()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0049
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009c }
            if (r14 == 0) goto L_0x0048
            r14.close()
        L_0x0048:
            return r13
        L_0x0049:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x009c }
            int r2 = r1.length     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.internal.measurement.zzyx r1 = com.google.android.gms.internal.measurement.zzyx.zzj(r1, r10, r2)     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.internal.measurement.zzfy r2 = new com.google.android.gms.internal.measurement.zzfy     // Catch:{ SQLiteException -> 0x009c }
            r2.<init>()     // Catch:{ SQLiteException -> 0x009c }
            r2.zza(r1)     // Catch:{ IOException -> 0x007d }
            int r1 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x009c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x009c }
            if (r3 != 0) goto L_0x0079
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ SQLiteException -> 0x009c }
            r0.put(r1, r3)     // Catch:{ SQLiteException -> 0x009c }
        L_0x0079:
            r3.add(r2)     // Catch:{ SQLiteException -> 0x009c }
            goto L_0x0090
        L_0x007d:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzap r2 = r12.zzgo()     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)     // Catch:{ SQLiteException -> 0x009c }
            r2.zze(r3, r4, r1)     // Catch:{ SQLiteException -> 0x009c }
        L_0x0090:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0049
            if (r14 == 0) goto L_0x009b
            r14.close()
        L_0x009b:
            return r0
        L_0x009c:
            r0 = move-exception
            goto L_0x00a3
        L_0x009e:
            r13 = move-exception
            r14 = r9
            goto L_0x00bb
        L_0x00a1:
            r0 = move-exception
            r14 = r9
        L_0x00a3:
            com.google.android.gms.measurement.internal.zzap r1 = r12.zzgo()     // Catch:{ all -> 0x00ba }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)     // Catch:{ all -> 0x00ba }
            r1.zze(r2, r13, r0)     // Catch:{ all -> 0x00ba }
            if (r14 == 0) goto L_0x00b9
            r14.close()
        L_0x00b9:
            return r9
        L_0x00ba:
            r13 = move-exception
        L_0x00bb:
            if (r14 == 0) goto L_0x00c0
            r14.close()
        L_0x00c0:
            goto L_0x00c2
        L_0x00c1:
            throw r13
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzm(java.lang.String, java.lang.String):java.util.Map");
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzcl();
        zzaf();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzgq().zzb(str, zzaf.zzaki)));
            if (zza <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzgo().zzjd().zze("Database error querying filters. appId", zzap.zzbv(str), e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzgj> zzbo(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzcl()
            r11.zzaf()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r3 = "audience_id"
            r9 = 0
            r2[r9] = r3     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r3 = "current_results"
            r10 = 1
            r2[r10] = r3     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r4[r9] = r12     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0080 }
            if (r1 != 0) goto L_0x0037
            if (r0 == 0) goto L_0x0036
            r0.close()
        L_0x0036:
            return r8
        L_0x0037:
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap     // Catch:{ SQLiteException -> 0x0080 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0080 }
        L_0x003c:
            int r2 = r0.getInt(r9)     // Catch:{ SQLiteException -> 0x0080 }
            byte[] r3 = r0.getBlob(r10)     // Catch:{ SQLiteException -> 0x0080 }
            int r4 = r3.length     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzyx r3 = com.google.android.gms.internal.measurement.zzyx.zzj(r3, r9, r4)     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzgj r4 = new com.google.android.gms.internal.measurement.zzgj     // Catch:{ SQLiteException -> 0x0080 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0080 }
            r4.zza(r3)     // Catch:{ IOException -> 0x005c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0080 }
            r1.put(r2, r4)     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x0073
        L_0x005c:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzap r4 = r11.zzgo()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.measurement.internal.zzar r4 = r4.zzjd()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzap.zzbv(r12)     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0080 }
            r4.zzd(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0080 }
        L_0x0073:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0080 }
            if (r2 != 0) goto L_0x003c
            if (r0 == 0) goto L_0x007f
            r0.close()
        L_0x007f:
            return r1
        L_0x0080:
            r1 = move-exception
            goto L_0x0087
        L_0x0082:
            r12 = move-exception
            r0 = r8
            goto L_0x009f
        L_0x0085:
            r1 = move-exception
            r0 = r8
        L_0x0087:
            com.google.android.gms.measurement.internal.zzap r2 = r11.zzgo()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzap.zzbv(r12)     // Catch:{ all -> 0x009e }
            r2.zze(r3, r12, r1)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x009d
            r0.close()
        L_0x009d:
            return r8
        L_0x009e:
            r12 = move-exception
        L_0x009f:
            if (r0 == 0) goto L_0x00a4
            r0.close()
        L_0x00a4:
            goto L_0x00a6
        L_0x00a5:
            throw r12
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzbo(java.lang.String):java.util.Map");
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzgo().zzjd().zzbx("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzgo().zzjd().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzgo().zzjd().zzbx("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    public final long zzig() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final long zzn(String str, String str2) {
        long j;
        String str3;
        String str4;
        String str5 = str;
        String str6 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str6);
            sb.append(" from app2 where app_id=?");
            try {
                j = zza(sb.toString(), new String[]{str5}, -1);
                str3 = "app2";
                str4 = "app_id";
                if (j == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(str4, str5);
                    contentValues.put("first_open_count", Integer.valueOf(0));
                    contentValues.put("previous_install_count", Integer.valueOf(0));
                    if (writableDatabase.insertWithOnConflict(str3, null, contentValues, 5) == -1) {
                        zzgo().zzjd().zze("Failed to insert column (got -1). appId", zzap.zzbv(str), str6);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    j = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                j = 0;
                try {
                    zzgo().zzjd().zzd("Error inserting column. appId", zzap.zzbv(str), str6, e);
                    writableDatabase.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(str4, str5);
                contentValues2.put(str6, Long.valueOf(1 + j));
                if (((long) writableDatabase.update(str3, contentValues2, "app_id = ?", new String[]{str5})) == 0) {
                    zzgo().zzjd().zze("Failed to update column (got 0). appId", zzap.zzbv(str), str6);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                zzgo().zzjd().zzd("Error inserting column. appId", zzap.zzbv(str), str6, e);
                writableDatabase.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzgo().zzjd().zzd("Error inserting column. appId", zzap.zzbv(str), str6, e);
            writableDatabase.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public final long zzih() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzgi zzgi) throws IOException {
        long j;
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzgi);
        Preconditions.checkNotEmpty(zzgi.zztt);
        try {
            byte[] bArr = new byte[zzgi.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzgi.zza(zzk);
            zzk.zzyt();
            zzfg zzjo = zzjo();
            Preconditions.checkNotNull(bArr);
            zzjo.zzgm().zzaf();
            MessageDigest messageDigest = zzfk.getMessageDigest();
            if (messageDigest == null) {
                zzjo.zzgo().zzjd().zzbx("Failed to get MD5");
                j = 0;
            } else {
                j = zzfk.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgi.zztt);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzgo().zzjd().zze("Error storing raw event metadata. appId", zzap.zzbv(zzgi.zztt), e);
                throw e;
            }
        } catch (IOException e2) {
            zzgo().zzjd().zze("Data loss. Failed to serialize event metadata. appId", zzap.zzbv(zzgi.zztt), e2);
            throw e2;
        }
    }

    public final boolean zzii() {
        return zza("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzij() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzbp(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzah(long r5) {
        /*
            r4 = this;
            r4.zzaf()
            r4.zzcl()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0044, all -> 0x0041 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0044, all -> 0x0041 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0044, all -> 0x0041 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0044, all -> 0x0041 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0044, all -> 0x0041 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003f }
            if (r1 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzap r6 = r4.zzgo()     // Catch:{ SQLiteException -> 0x003f }
            com.google.android.gms.measurement.internal.zzar r6 = r6.zzjl()     // Catch:{ SQLiteException -> 0x003f }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zzbx(r1)     // Catch:{ SQLiteException -> 0x003f }
            if (r5 == 0) goto L_0x0034
            r5.close()
        L_0x0034:
            return r0
        L_0x0035:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003f }
            if (r5 == 0) goto L_0x003e
            r5.close()
        L_0x003e:
            return r6
        L_0x003f:
            r6 = move-exception
            goto L_0x0046
        L_0x0041:
            r6 = move-exception
            r5 = r0
            goto L_0x005a
        L_0x0044:
            r6 = move-exception
            r5 = r0
        L_0x0046:
            com.google.android.gms.measurement.internal.zzap r1 = r4.zzgo()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zzg(r2, r6)     // Catch:{ all -> 0x0059 }
            if (r5 == 0) goto L_0x0058
            r5.close()
        L_0x0058:
            return r0
        L_0x0059:
            r6 = move-exception
        L_0x005a:
            if (r5 == 0) goto L_0x005f
            r5.close()
        L_0x005f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzah(long):java.lang.String");
    }

    public final long zzik() {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzgo().zzjd().zzg("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzgf, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzaf()
            r7.zzcl()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x007b, all -> 0x0078 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x007b, all -> 0x0078 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x007b, all -> 0x0078 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0078 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x007b, all -> 0x0078 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0078 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0076 }
            if (r2 != 0) goto L_0x0038
            com.google.android.gms.measurement.internal.zzap r8 = r7.zzgo()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjl()     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r9 = "Main event not found"
            r8.zzbx(r9)     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 == 0) goto L_0x0037
            r1.close()
        L_0x0037:
            return r0
        L_0x0038:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0076 }
            long r5 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x0076 }
            int r5 = r2.length     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzyx r2 = com.google.android.gms.internal.measurement.zzyx.zzj(r2, r4, r5)     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzgf r4 = new com.google.android.gms.internal.measurement.zzgf     // Catch:{ SQLiteException -> 0x0076 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0076 }
            r4.zza(r2)     // Catch:{ IOException -> 0x005e }
            android.util.Pair r8 = android.util.Pair.create(r4, r3)     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 == 0) goto L_0x005d
            r1.close()
        L_0x005d:
            return r8
        L_0x005e:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzap r3 = r7.zzgo()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzap.zzbv(r8)     // Catch:{ SQLiteException -> 0x0076 }
            r3.zzd(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 == 0) goto L_0x0075
            r1.close()
        L_0x0075:
            return r0
        L_0x0076:
            r8 = move-exception
            goto L_0x007d
        L_0x0078:
            r8 = move-exception
            r1 = r0
            goto L_0x0091
        L_0x007b:
            r8 = move-exception
            r1 = r0
        L_0x007d:
            com.google.android.gms.measurement.internal.zzap r9 = r7.zzgo()     // Catch:{ all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjd()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "Error selecting main event"
            r9.zzg(r2, r8)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            r1.close()
        L_0x008f:
            return r0
        L_0x0090:
            r8 = move-exception
        L_0x0091:
            if (r1 == 0) goto L_0x0096
            r1.close()
        L_0x0096:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzgf zzgf) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzgf);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzgf.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzgf.zza(zzk);
            zzk.zzyt();
            zzgo().zzjl().zze("Saving complex main event, appId, data size", zzgl().zzbs(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgo().zzjd().zzg("Failed to insert complex main event (got -1). appId", zzap.zzbv(str));
                return false;
            } catch (SQLiteException e) {
                zzgo().zzjd().zze("Error storing complex main event. appId", zzap.zzbv(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgo().zzjd().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzap.zzbv(str), l, e2);
            return false;
        }
    }

    public final boolean zza(zzy zzy, long j, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotEmpty(zzy.zztt);
        zzgf zzgf = new zzgf();
        zzgf.zzawv = Long.valueOf(zzy.zzaic);
        zzgf.zzawt = new zzgg[zzy.zzaid.size()];
        Iterator it = zzy.zzaid.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            zzgg zzgg = new zzgg();
            int i2 = i + 1;
            zzgf.zzawt[i] = zzgg;
            zzgg.name = str;
            zzjo().zza(zzgg, zzy.zzaid.get(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzgf.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzgf.zza(zzk);
            zzk.zzyt();
            zzgo().zzjl().zze("Saving event, name, data size", zzgl().zzbs(zzy.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzy.zztt);
            contentValues.put("name", zzy.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzy.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzgo().zzjd().zzg("Failed to insert raw event (got -1). appId", zzap.zzbv(zzy.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgo().zzjd().zze("Error storing raw event. appId", zzap.zzbv(zzy.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgo().zzjd().zze("Data loss. Failed to serialize event params/data. appId", zzap.zzbv(zzy.zztt), e2);
            return false;
        }
    }

    private final boolean zzil() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }
}

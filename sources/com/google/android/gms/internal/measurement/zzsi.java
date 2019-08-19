package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzsi {
    private static final Object zzbqp = new Object();
    @GuardedBy("loadersLock")
    private static final Map<Uri, zzsi> zzbqq = new HashMap();
    private static final String[] zzbqw = {"key", Param.VALUE};
    private final Uri uri;
    private final ContentResolver zzbqr;
    private final Object zzbqs = new Object();
    private volatile Map<String, String> zzbqt;
    private final Object zzbqu = new Object();
    @GuardedBy("listenersLock")
    private final List<zzsk> zzbqv = new ArrayList();

    private zzsi(ContentResolver contentResolver, Uri uri2) {
        this.zzbqr = contentResolver;
        this.uri = uri2;
        this.zzbqr.registerContentObserver(uri2, false, new zzsj(this, null));
    }

    public static zzsi zza(ContentResolver contentResolver, Uri uri2) {
        zzsi zzsi;
        synchronized (zzbqp) {
            zzsi = (zzsi) zzbqq.get(uri2);
            if (zzsi == null) {
                zzsi = new zzsi(contentResolver, uri2);
                zzbqq.put(uri2, zzsi);
            }
        }
        return zzsi;
    }

    public final Map<String, String> zzsz() {
        Map<String, String> zztb = zzsl.zzd("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zztb() : this.zzbqt;
        if (zztb == null) {
            synchronized (this.zzbqs) {
                Map<String, String> map = this.zzbqt;
                if (map == null) {
                    map = zztb();
                    this.zzbqt = map;
                }
            }
        }
        return zztb != null ? zztb : Collections.emptyMap();
    }

    public final void zzta() {
        synchronized (this.zzbqs) {
            this.zzbqt = null;
        }
    }

    private final Map<String, String> zztb() {
        Cursor query;
        try {
            HashMap hashMap = new HashMap();
            query = this.zzbqr.query(this.uri, zzbqw, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                query.close();
            }
            return hashMap;
        } catch (SQLiteException | SecurityException e) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void zztc() {
        synchronized (this.zzbqu) {
            for (zzsk zztd : this.zzbqv) {
                zztd.zztd();
            }
        }
    }
}

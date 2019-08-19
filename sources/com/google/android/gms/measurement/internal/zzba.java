package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzba extends zzcp {
    @VisibleForTesting
    static final Pair<String, Long> zzanc = new Pair<>("", Long.valueOf(0));
    private SharedPreferences zzabr;
    public zzbe zzand;
    public final zzbd zzane = new zzbd(this, "last_upload", 0);
    public final zzbd zzanf = new zzbd(this, "last_upload_attempt", 0);
    public final zzbd zzang = new zzbd(this, "backoff", 0);
    public final zzbd zzanh = new zzbd(this, "last_delete_stale", 0);
    public final zzbd zzani = new zzbd(this, "midnight_offset", 0);
    public final zzbd zzanj = new zzbd(this, "first_open_time", 0);
    public final zzbd zzank = new zzbd(this, "app_install_time", 0);
    public final zzbf zzanl = new zzbf(this, "app_instance_id", null);
    private String zzanm;
    private boolean zzann;
    private long zzano;
    public final zzbd zzanp = new zzbd(this, "time_before_start", 10000);
    public final zzbd zzanq = new zzbd(this, "session_timeout", 1800000);
    public final zzbc zzanr = new zzbc(this, "start_new_session", true);
    public final zzbf zzans = new zzbf(this, "allow_ad_personalization", null);
    public final zzbd zzant = new zzbd(this, "last_pause_time", 0);
    public final zzbd zzanu = new zzbd(this, "time_active", 0);
    public boolean zzanv;

    /* access modifiers changed from: 0000 */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zzby(String str) {
        String str2 = "";
        zzaf();
        long elapsedRealtime = zzbx().elapsedRealtime();
        String str3 = this.zzanm;
        if (str3 != null && elapsedRealtime < this.zzano) {
            return new Pair<>(str3, Boolean.valueOf(this.zzann));
        }
        this.zzano = elapsedRealtime + zzgq().zza(str, zzaf.zzaje);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zzanm = advertisingIdInfo.getId();
                this.zzann = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzanm == null) {
                this.zzanm = str2;
            }
        } catch (Exception e) {
            zzgo().zzjk().zzg("Unable to get advertising id", e);
            this.zzanm = str2;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzanm, Boolean.valueOf(this.zzann));
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final String zzbz(String str) {
        zzaf();
        String str2 = (String) zzby(str).first;
        MessageDigest messageDigest = zzfk.getMessageDigest();
        if (messageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, messageDigest.digest(str2.getBytes()))});
    }

    zzba(zzbt zzbt) {
        super(zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzgu() {
        this.zzabr = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        String str = "has_been_opened";
        this.zzanv = this.zzabr.getBoolean(str, false);
        if (!this.zzanv) {
            Editor edit = this.zzabr.edit();
            edit.putBoolean(str, true);
            edit.apply();
        }
        zzbe zzbe = new zzbe(this, "health_monitor", Math.max(0, ((Long) zzaf.zzajf.get()).longValue()));
        this.zzand = zzbe;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final SharedPreferences zzjr() {
        zzaf();
        zzcl();
        return this.zzabr;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzca(String str) {
        zzaf();
        Editor edit = zzjr().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final String zzjs() {
        zzaf();
        return zzjr().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzcb(String str) {
        zzaf();
        Editor edit = zzjr().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final String zzjt() {
        zzaf();
        return zzjr().getString("admob_app_id", null);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final Boolean zzju() {
        zzaf();
        String str = "use_service";
        if (!zzjr().contains(str)) {
            return null;
        }
        return Boolean.valueOf(zzjr().getBoolean(str, false));
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzg(boolean z) {
        zzaf();
        zzgo().zzjl().zzg("Setting useService", Boolean.valueOf(z));
        Editor edit = zzjr().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzjv() {
        zzaf();
        zzgo().zzjl().zzbx("Clearing collection preferences.");
        boolean contains = zzjr().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = zzh(true);
        }
        Editor edit = zzjr().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void setMeasurementEnabled(boolean z) {
        zzaf();
        zzgo().zzjl().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = zzjr().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzh(boolean z) {
        zzaf();
        return zzjr().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzjw() {
        zzaf();
        String str = "previous_os_version";
        String string = zzjr().getString(str, null);
        zzgk().zzcl();
        String str2 = VERSION.RELEASE;
        if (!TextUtils.isEmpty(str2) && !str2.equals(string)) {
            Editor edit = zzjr().edit();
            edit.putString(str, str2);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzi(boolean z) {
        zzaf();
        zzgo().zzjl().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        Editor edit = zzjr().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzjx() {
        zzaf();
        return zzjr().getBoolean("deferred_analytics_collection", false);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzjy() {
        return this.zzabr.contains("deferred_analytics_collection");
    }
}

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public final class zzn extends zzco {
    private Boolean zzahf;
    @NonNull
    private zzp zzahg = zzo.zzahh;
    private Boolean zzyk;

    zzn(zzbt zzbt) {
        super(zzbt);
        zzaf.zza(zzbt);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(@NonNull zzp zzp) {
        this.zzahg = zzp;
    }

    static String zzht() {
        return (String) zzaf.zzajd.get();
    }

    @WorkerThread
    public final int zzat(@Size(min = 1) String str) {
        return zzb(str, zzaf.zzajr);
    }

    public final long zzhc() {
        zzgr();
        return 13001;
    }

    public final boolean zzdw() {
        if (this.zzyk == null) {
            synchronized (this) {
                if (this.zzyk == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzyk = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzyk == null) {
                        this.zzyk = Boolean.TRUE;
                        zzgo().zzjd().zzbx("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzyk.booleanValue();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zza<Long> zza) {
        if (str == null) {
            return ((Long) zza.get()).longValue();
        }
        String zzf = this.zzahg.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Long) zza.get()).longValue();
        }
        try {
            return ((Long) zza.get(Long.valueOf(Long.parseLong(zzf)))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) zza.get()).longValue();
        }
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zza<Integer> zza) {
        if (str == null) {
            return ((Integer) zza.get()).intValue();
        }
        String zzf = this.zzahg.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Integer) zza.get()).intValue();
        }
        try {
            return ((Integer) zza.get(Integer.valueOf(Integer.parseInt(zzf)))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) zza.get()).intValue();
        }
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zza<Double> zza) {
        if (str == null) {
            return ((Double) zza.get()).doubleValue();
        }
        String zzf = this.zzahg.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Double) zza.get()).doubleValue();
        }
        try {
            return ((Double) zza.get(Double.valueOf(Double.parseDouble(zzf)))).doubleValue();
        } catch (NumberFormatException e) {
            return ((Double) zza.get()).doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zza<Boolean> zza) {
        if (str == null) {
            return ((Boolean) zza.get()).booleanValue();
        }
        String zzf = this.zzahg.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Boolean) zza.get()).booleanValue();
        }
        return ((Boolean) zza.get(Boolean.valueOf(Boolean.parseBoolean(zzf)))).booleanValue();
    }

    public final boolean zze(String str, zza<Boolean> zza) {
        return zzd(str, zza);
    }

    public final boolean zza(zza<Boolean> zza) {
        return zzd(null, zza);
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    @VisibleForTesting
    public final Boolean zzau(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzgo().zzjd().zzbx("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzgo().zzjd().zzbx("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzgo().zzjd().zzbx("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (!applicationInfo.metaData.containsKey(str)) {
                return null;
            } else {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            }
        } catch (NameNotFoundException e) {
            zzgo().zzjd().zzg("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzhu() {
        zzgr();
        Boolean zzau = zzau("firebase_analytics_collection_deactivated");
        return zzau != null && zzau.booleanValue();
    }

    public final Boolean zzhv() {
        zzgr();
        return zzau("firebase_analytics_collection_enabled");
    }

    public static long zzhw() {
        return ((Long) zzaf.zzakg.get()).longValue();
    }

    public static long zzhx() {
        return ((Long) zzaf.zzajg.get()).longValue();
    }

    public final String zzhy() {
        String str = "";
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", str});
        } catch (ClassNotFoundException e) {
            zzgo().zzjd().zzg("Could not find SystemProperties class", e);
            return str;
        } catch (NoSuchMethodException e2) {
            zzgo().zzjd().zzg("Could not find SystemProperties.get() method", e2);
            return str;
        } catch (IllegalAccessException e3) {
            zzgo().zzjd().zzg("Could not access SystemProperties.get()", e3);
            return str;
        } catch (InvocationTargetException e4) {
            zzgo().zzjd().zzg("SystemProperties.get() threw an exception", e4);
            return str;
        }
    }

    public static boolean zzhz() {
        return ((Boolean) zzaf.zzajc.get()).booleanValue();
    }

    public final boolean zzav(String str) {
        return "1".equals(this.zzahg.zzf(str, "gaia_collection_enabled"));
    }

    public final boolean zzaw(String str) {
        return "1".equals(this.zzahg.zzf(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzax(String str) {
        return zzd(str, zzaf.zzakp);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzay(String str) {
        return zzd(str, zzaf.zzakr);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzaz(String str) {
        return zzd(str, zzaf.zzaks);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzba(String str) {
        return zzd(str, zzaf.zzakk);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final String zzbb(String str) {
        zza<String> zza = zzaf.zzakl;
        if (str == null) {
            return (String) zza.get();
        }
        return (String) zza.get(this.zzahg.zzf(str, zza.getKey()));
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzbc(String str) {
        return zzd(str, zzaf.zzakt);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbd(String str) {
        return zzd(str, zzaf.zzaku);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbe(String str) {
        return zzd(str, zzaf.zzakx);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbf(String str) {
        return zzd(str, zzaf.zzaky);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbg(String str) {
        return zzd(str, zzaf.zzala);
    }

    static boolean zzia() {
        return ((Boolean) zzaf.zzalb.get()).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzib() {
        if (this.zzahf == null) {
            this.zzahf = zzau("app_measurement_lite");
            if (this.zzahf == null) {
                this.zzahf = Boolean.valueOf(false);
            }
        }
        if (this.zzahf.booleanValue() || !this.zzadj.zzkn()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbh(String str) {
        return zzd(str, zzaf.zzakz);
    }

    @WorkerThread
    static boolean zzic() {
        return ((Boolean) zzaf.zzald.get()).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbi(String str) {
        return zzd(str, zzaf.zzale);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzbj(String str) {
        return zzd(str, zzaf.zzalf);
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

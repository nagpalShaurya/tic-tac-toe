package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzyx;
import com.google.android.gms.internal.measurement.zzyy;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Map;

public final class zzbn extends zzez implements zzp {
    @VisibleForTesting
    private static int zzaon = SupportMenu.USER_MASK;
    @VisibleForTesting
    private static int zzaoo = 2;
    private final Map<String, Map<String, String>> zzaop = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzaoq = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzaor = new ArrayMap();
    private final Map<String, zzgb> zzaos = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzaot = new ArrayMap();
    private final Map<String, String> zzaou = new ArrayMap();

    zzbn(zzfa zzfa) {
        super(zzfa);
    }

    @WorkerThread
    private final void zzce(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        if (this.zzaos.get(str) == null) {
            byte[] zzbn = zzjq().zzbn(str);
            if (zzbn == null) {
                this.zzaop.put(str, null);
                this.zzaoq.put(str, null);
                this.zzaor.put(str, null);
                this.zzaos.put(str, null);
                this.zzaou.put(str, null);
                this.zzaot.put(str, null);
                return;
            }
            zzgb zza = zza(str, zzbn);
            this.zzaop.put(str, zza(zza));
            zza(str, zza);
            this.zzaos.put(str, zza);
            this.zzaou.put(str, null);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzgb zzcf(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzce(str);
        return (zzgb) this.zzaos.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzcg(String str) {
        zzaf();
        return (String) this.zzaou.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzch(String str) {
        zzaf();
        this.zzaou.put(str, null);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzci(String str) {
        zzaf();
        this.zzaos.remove(str);
    }

    @WorkerThread
    public final String zzf(String str, String str2) {
        zzaf();
        zzce(str);
        Map map = (Map) this.zzaop.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(zzgb zzgb) {
        zzgc[] zzgcArr;
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzgb == null || zzgb.zzawg == null)) {
            for (zzgc zzgc : zzgb.zzawg) {
                if (zzgc != null) {
                    arrayMap.put(zzgc.zzoj, zzgc.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzgb zzgb) {
        zzga[] zzgaArr;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (!(zzgb == null || zzgb.zzawh == null)) {
            for (zzga zzga : zzgb.zzawh) {
                if (TextUtils.isEmpty(zzga.name)) {
                    zzgo().zzjg().zzbx("EventConfig contained null event name");
                } else {
                    String zzal = Event.zzal(zzga.name);
                    if (!TextUtils.isEmpty(zzal)) {
                        zzga.name = zzal;
                    }
                    arrayMap.put(zzga.name, zzga.zzawb);
                    arrayMap2.put(zzga.name, zzga.zzawc);
                    if (zzga.zzawd != null) {
                        if (zzga.zzawd.intValue() < zzaoo || zzga.zzawd.intValue() > zzaon) {
                            zzgo().zzjg().zze("Invalid sampling rate. Event name, sample rate", zzga.name, zzga.zzawd);
                        } else {
                            arrayMap3.put(zzga.name, zzga.zzawd);
                        }
                    }
                }
            }
        }
        this.zzaoq.put(str, arrayMap);
        this.zzaor.put(str, arrayMap2);
        this.zzaot.put(str, arrayMap3);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        zzfv[] zzfvArr;
        zzfy[] zzfyArr;
        zzfw[] zzfwArr;
        String str3 = str;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzgb zza = zza(str, bArr);
        if (zza == null) {
            return false;
        }
        zza(str3, zza);
        this.zzaos.put(str3, zza);
        this.zzaou.put(str3, str2);
        this.zzaop.put(str3, zza(zza));
        zzj zzjp = zzjp();
        zzfu[] zzfuArr = zza.zzawi;
        Preconditions.checkNotNull(zzfuArr);
        for (zzfu zzfu : zzfuArr) {
            for (zzfv zzfv : zzfu.zzava) {
                String zzal = Event.zzal(zzfv.zzavf);
                if (zzal != null) {
                    zzfv.zzavf = zzal;
                }
                for (zzfw zzfw : zzfv.zzavg) {
                    String zzal2 = Param.zzal(zzfw.zzavn);
                    if (zzal2 != null) {
                        zzfw.zzavn = zzal2;
                    }
                }
            }
            for (zzfy zzfy : zzfu.zzauz) {
                String zzal3 = UserProperty.zzal(zzfy.zzavu);
                if (zzal3 != null) {
                    zzfy.zzavu = zzal3;
                }
            }
        }
        zzjp.zzjq().zza(str3, zzfuArr);
        try {
            zza.zzawi = null;
            bArr2 = new byte[zza.zzvu()];
            zza.zza(zzyy.zzk(bArr2, 0, bArr2.length));
        } catch (IOException e) {
            zzgo().zzjg().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzap.zzbv(str), e);
            bArr2 = bArr;
        }
        zzq zzjq = zzjq();
        Preconditions.checkNotEmpty(str);
        zzjq.zzaf();
        zzjq.zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) zzjq.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                zzjq.zzgo().zzjd().zzg("Failed to update remote config (got 0). appId", zzap.zzbv(str));
            }
        } catch (SQLiteException e2) {
            zzjq.zzgo().zzjd().zze("Error storing remote config. appId", zzap.zzbv(str), e2);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzo(String str, String str2) {
        zzaf();
        zzce(str);
        if (zzck(str) && zzfk.zzcv(str2)) {
            return true;
        }
        if (zzcl(str) && zzfk.zzcq(str2)) {
            return true;
        }
        Map map = (Map) this.zzaoq.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzp(String str, String str2) {
        zzaf();
        zzce(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzaor.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final int zzq(String str, String str2) {
        zzaf();
        zzce(str);
        Map map = (Map) this.zzaot.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final long zzcj(String str) {
        String zzf = zzf(str, "measurement.account.time_zone_offset_minutes");
        if (!TextUtils.isEmpty(zzf)) {
            try {
                return Long.parseLong(zzf);
            } catch (NumberFormatException e) {
                zzgo().zzjg().zze("Unable to parse timezone offset. appId", zzap.zzbv(str), e);
            }
        }
        return 0;
    }

    @WorkerThread
    private final zzgb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzgb();
        }
        zzyx zzj = zzyx.zzj(bArr, 0, bArr.length);
        zzgb zzgb = new zzgb();
        try {
            zzgb.zza(zzj);
            zzgo().zzjl().zze("Parsed config. version, gmp_app_id", zzgb.zzawe, zzgb.zzafx);
            return zzgb;
        } catch (IOException e) {
            zzgo().zzjg().zze("Unable to merge remote config. appId", zzap.zzbv(str), e);
            return new zzgb();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzck(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzcl(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_public"));
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    public final /* bridge */ /* synthetic */ zzfg zzjo() {
        return super.zzjo();
    }

    public final /* bridge */ /* synthetic */ zzj zzjp() {
        return super.zzjp();
    }

    public final /* bridge */ /* synthetic */ zzq zzjq() {
        return super.zzjq();
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

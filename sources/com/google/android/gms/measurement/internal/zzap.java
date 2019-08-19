package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzap extends zzcp {
    /* access modifiers changed from: private */
    public long zzadt = -1;
    /* access modifiers changed from: private */
    public char zzalw = 0;
    @GuardedBy("this")
    private String zzalx;
    private final zzar zzaly = new zzar(this, 6, false, false);
    private final zzar zzalz = new zzar(this, 6, true, false);
    private final zzar zzama = new zzar(this, 6, false, true);
    private final zzar zzamb = new zzar(this, 5, false, false);
    private final zzar zzamc = new zzar(this, 5, true, false);
    private final zzar zzamd = new zzar(this, 5, false, true);
    private final zzar zzame = new zzar(this, 4, false, false);
    private final zzar zzamf = new zzar(this, 3, false, false);
    private final zzar zzamg = new zzar(this, 2, false, false);

    zzap(zzbt zzbt) {
        super(zzbt);
    }

    public final zzar zzjd() {
        return this.zzaly;
    }

    public final zzar zzje() {
        return this.zzalz;
    }

    public final zzar zzjf() {
        return this.zzama;
    }

    public final zzar zzjg() {
        return this.zzamb;
    }

    public final zzar zzjh() {
        return this.zzamc;
    }

    public final zzar zzji() {
        return this.zzamd;
    }

    public final zzar zzjj() {
        return this.zzame;
    }

    public final zzar zzjk() {
        return this.zzamf;
    }

    public final zzar zzjl() {
        return this.zzamg;
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    protected static Object zzbv(String str) {
        if (str == null) {
            return null;
        }
        return new zzas(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        int i2;
        if (!z && isLoggable(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzbo zzkh = this.zzadj.zzkh();
            if (zzkh == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzkh.isInitialized()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i < 0) {
                    i = 0;
                }
                if (i >= 9) {
                    i2 = 8;
                } else {
                    i2 = i;
                }
                zzaq zzaq = new zzaq(this, i2, str, obj, obj2, obj3);
                zzkh.zzc((Runnable) zzaq);
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean isLoggable(int i) {
        return Log.isLoggable(zzjm(), i);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, zzjm(), str);
    }

    @VisibleForTesting
    private final String zzjm() {
        String str;
        synchronized (this) {
            if (this.zzalx == null) {
                if (this.zzadj.zzkm() != null) {
                    this.zzalx = this.zzadj.zzkm();
                } else {
                    this.zzalx = zzn.zzht();
                }
            }
            str = this.zzalx;
        }
        return str;
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zza = zza(z, obj);
        String zza2 = zza(z, obj2);
        String zza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zza)) {
            sb.append(str2);
            sb.append(zza);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zza2)) {
            sb.append(str2);
            sb.append(zza2);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        String str2 = "-";
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = str2;
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzbw = zzbw(AppMeasurement.class.getCanonicalName());
                String zzbw2 = zzbw(zzbt.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            String zzbw3 = zzbw(className);
                            if (zzbw3.equals(zzbw) || zzbw3.equals(zzbw2)) {
                                sb2.append(": ");
                                sb2.append(stackTraceElement);
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof zzas) {
                return ((zzas) obj).zzamp;
            } else {
                if (z) {
                    return str2;
                }
                return String.valueOf(obj);
            }
        }
    }

    private static String zzbw(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final String zzjn() {
        Pair<String, Long> zzfm = zzgp().zzand.zzfm();
        if (zzfm == null || zzfm == zzba.zzanc) {
            return null;
        }
        String valueOf = String.valueOf(zzfm.second);
        String str = (String) zzfm.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
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

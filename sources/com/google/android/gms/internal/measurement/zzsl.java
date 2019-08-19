package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build.VERSION;
import android.support.p000v4.content.PermissionChecker;
import android.util.Log;
import javax.annotation.Nullable;

public abstract class zzsl<T> {
    private static final Object zzbqy = new Object();
    private static boolean zzbqz = false;
    private static volatile Boolean zzbra = null;
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzri = null;
    private final zzsv zzbrb;
    final String zzbrc;
    private final String zzbrd;
    private final T zzbre;
    private T zzbrf;
    private volatile zzsi zzbrg;
    private volatile SharedPreferences zzbrh;

    public static void init(Context context) {
        synchronized (zzbqy) {
            if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (zzri != context) {
                zzbra = null;
            }
            zzri = context;
        }
        zzbqz = false;
    }

    /* access modifiers changed from: protected */
    public abstract T zzfj(String str);

    private zzsl(zzsv zzsv, String str, T t) {
        this.zzbrf = null;
        this.zzbrg = null;
        this.zzbrh = null;
        if (zzsv.zzbrn != null) {
            this.zzbrb = zzsv;
            String valueOf = String.valueOf(zzsv.zzbro);
            String valueOf2 = String.valueOf(str);
            this.zzbrd = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(zzsv.zzbrp);
            String valueOf4 = String.valueOf(str);
            this.zzbrc = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            this.zzbre = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public final T getDefaultValue() {
        return this.zzbre;
    }

    public final T get() {
        if (zzri != null) {
            zzsv zzsv = this.zzbrb;
            T zzte = zzte();
            if (zzte != null) {
                return zzte;
            }
            T zztf = zztf();
            if (zztf != null) {
                return zztf;
            }
            return this.zzbre;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    @TargetApi(24)
    @Nullable
    private final T zzte() {
        zzsv zzsv = this.zzbrb;
        if (zzd("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String str = "Bypass reading Phenotype values for flag: ";
            String valueOf = String.valueOf(this.zzbrc);
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } else if (this.zzbrb.zzbrn != null) {
            zzsi zztg = zztg();
            if (zztg != null) {
                String str2 = (String) zza(new zzsm(this, zztg));
                if (str2 != null) {
                    return zzfj(str2);
                }
            }
        } else {
            zzsv zzsv2 = this.zzbrb;
        }
        return null;
    }

    @Nullable
    private final T zztf() {
        zzsv zzsv = this.zzbrb;
        if (zzth()) {
            try {
                String str = (String) zza(new zzsn(this));
                if (str != null) {
                    return zzfj(str);
                }
            } catch (SecurityException e) {
                String str2 = "Unable to read GServices for flag: ";
                String valueOf = String.valueOf(this.zzbrc);
                Log.e("PhenotypeFlag", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
            }
        }
        return null;
    }

    private static <V> V zza(zzsu<V> zzsu) {
        long clearCallingIdentity;
        try {
            return zzsu.zztj();
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zztj = zzsu.zztj();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zztj;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    private final zzsi zztg() {
        if (this.zzbrg == null) {
            try {
                this.zzbrg = zzsi.zza(zzri.getContentResolver(), this.zzbrb.zzbrn);
            } catch (SecurityException e) {
            }
        }
        return this.zzbrg;
    }

    static boolean zzd(String str, boolean z) {
        try {
            if (zzth()) {
                return ((Boolean) zza(new zzso(str, false))).booleanValue();
            }
            return false;
        } catch (SecurityException e) {
            Log.e("PhenotypeFlag", "Unable to read GServices, returning default value.", e);
            return false;
        }
    }

    private static boolean zzth() {
        if (zzbra == null) {
            Context context = zzri;
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzbra = Boolean.valueOf(z);
        }
        return zzbra.booleanValue();
    }

    /* access modifiers changed from: private */
    public static zzsl<Long> zza(zzsv zzsv, String str, long j) {
        return new zzsp(zzsv, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzsl<Integer> zza(zzsv zzsv, String str, int i) {
        return new zzsq(zzsv, str, Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public static zzsl<Boolean> zza(zzsv zzsv, String str, boolean z) {
        return new zzsr(zzsv, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static zzsl<Double> zza(zzsv zzsv, String str, double d) {
        return new zzss(zzsv, str, Double.valueOf(d));
    }

    /* access modifiers changed from: private */
    public static zzsl<String> zza(zzsv zzsv, String str, String str2) {
        return new zzst(zzsv, str, str2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ String zzti() {
        return zzsg.zza(zzri.getContentResolver(), this.zzbrd, (String) null);
    }

    /* synthetic */ zzsl(zzsv zzsv, String str, Object obj, zzsp zzsp) {
        this(zzsv, str, obj);
    }
}

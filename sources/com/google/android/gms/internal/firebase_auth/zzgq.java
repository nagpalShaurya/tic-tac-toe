package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs.zze;

final class zzgq implements zzhw {
    private static final zzha zzza = new zzgr();
    private final zzha zzyz;

    public zzgq() {
        this(new zzgs(zzfr.zzhc(), zzif()));
    }

    private zzgq(zzha zzha) {
        this.zzyz = (zzha) zzfu.zza(zzha, "messageInfoFactory");
    }

    public final <T> zzhv<T> zze(Class<T> cls) {
        zzhx.zzg(cls);
        zzgz zzc = this.zzyz.zzc(cls);
        if (zzc.zzin()) {
            if (zzfs.class.isAssignableFrom(cls)) {
                return zzhg.zza(zzhx.zzja(), zzfi.zzgs(), zzc.zzio());
            }
            return zzhg.zza(zzhx.zziy(), zzfi.zzgt(), zzc.zzio());
        } else if (zzfs.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzhf.zza(cls, zzc, zzhk.zzir(), zzgl.zzie(), zzhx.zzja(), zzfi.zzgs(), zzgy.zzik());
            }
            return zzhf.zza(cls, zzc, zzhk.zzir(), zzgl.zzie(), zzhx.zzja(), null, zzgy.zzik());
        } else if (zza(zzc)) {
            return zzhf.zza(cls, zzc, zzhk.zziq(), zzgl.zzid(), zzhx.zziy(), zzfi.zzgt(), zzgy.zzij());
        } else {
            return zzhf.zza(cls, zzc, zzhk.zziq(), zzgl.zzid(), zzhx.zziz(), null, zzgy.zzij());
        }
    }

    private static boolean zza(zzgz zzgz) {
        return zzgz.zzim() == zze.zzxn;
    }

    private static zzha zzif() {
        try {
            return (zzha) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return zzza;
        }
    }
}

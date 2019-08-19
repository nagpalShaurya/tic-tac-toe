package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzvm.zze;

final class zzvl implements zzws {
    private static final zzvl zzbyl = new zzvl();

    private zzvl() {
    }

    public static zzvl zzwb() {
        return zzbyl;
    }

    public final boolean zze(Class<?> cls) {
        return zzvm.class.isAssignableFrom(cls);
    }

    public final zzwr zzf(Class<?> cls) {
        if (!zzvm.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzwr) zzvm.zzg(cls.asSubclass(zzvm.class)).zza(zze.zzbyv, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}

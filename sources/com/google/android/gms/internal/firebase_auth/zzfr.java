package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs.zze;

final class zzfr implements zzha {
    private static final zzfr zzwx = new zzfr();

    private zzfr() {
    }

    public static zzfr zzhc() {
        return zzwx;
    }

    public final boolean zzb(Class<?> cls) {
        return zzfs.class.isAssignableFrom(cls);
    }

    public final zzgz zzc(Class<?> cls) {
        if (!zzfs.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzgz) zzfs.zzd(cls.asSubclass(zzfs.class)).zza(zze.zzxh, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}

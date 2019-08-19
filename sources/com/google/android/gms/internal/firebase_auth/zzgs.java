package com.google.android.gms.internal.firebase_auth;

final class zzgs implements zzha {
    private zzha[] zzzb;

    zzgs(zzha... zzhaArr) {
        this.zzzb = zzhaArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzha zzb : this.zzzb) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzgz zzc(Class<?> cls) {
        zzha[] zzhaArr;
        for (zzha zzha : this.zzzb) {
            if (zzha.zzb(cls)) {
                return zzha.zzc(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}

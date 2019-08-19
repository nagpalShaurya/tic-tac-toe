package com.google.android.gms.internal.firebase_auth;

final class zzeo {
    private final byte[] buffer;
    private final zzez zzsv;

    private zzeo(int i) {
        this.buffer = new byte[i];
        this.zzsv = zzez.zzb(this.buffer);
    }

    public final zzeh zzff() {
        this.zzsv.zzgi();
        return new zzeq(this.buffer);
    }

    public final zzez zzfg() {
        return this.zzsv;
    }

    /* synthetic */ zzeo(int i, zzei zzei) {
        this(i);
    }
}

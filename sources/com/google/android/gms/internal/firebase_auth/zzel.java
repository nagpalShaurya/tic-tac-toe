package com.google.android.gms.internal.firebase_auth;

final class zzel extends zzeq {
    private final int zzst;
    private final int zzsu;

    zzel(byte[] bArr, int i, int i2) {
        super(bArr);
        zzd(i, i + i2, bArr.length);
        this.zzst = i;
        this.zzsu = i2;
    }

    public final byte zzk(int i) {
        zze(i, size());
        return this.zzsw[this.zzst + i];
    }

    public final int size() {
        return this.zzsu;
    }

    /* access modifiers changed from: protected */
    public final int zzfe() {
        return this.zzst;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, zzfe() + i, bArr, i2, i3);
    }
}

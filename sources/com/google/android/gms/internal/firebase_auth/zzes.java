package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public abstract class zzes {
    int zzsx;
    int zzsy;
    int zzsz;
    zzex zzta;
    private boolean zztb;

    static zzes zza(byte[] bArr, int i, int i2, boolean z) {
        zzeu zzeu = new zzeu(bArr, 0, i2, false);
        try {
            zzeu.zzo(i2);
            return zzeu;
        } catch (zzgb e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzfh() throws IOException;

    public abstract long zzfi() throws IOException;

    public abstract long zzfj() throws IOException;

    public abstract int zzfk() throws IOException;

    public abstract long zzfl() throws IOException;

    public abstract int zzfm() throws IOException;

    public abstract boolean zzfn() throws IOException;

    public abstract String zzfo() throws IOException;

    public abstract zzeh zzfp() throws IOException;

    public abstract int zzfq() throws IOException;

    public abstract int zzfr() throws IOException;

    public abstract int zzfs() throws IOException;

    public abstract long zzft() throws IOException;

    public abstract int zzfu() throws IOException;

    public abstract long zzfv() throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract long zzfw() throws IOException;

    public abstract boolean zzfx() throws IOException;

    public abstract int zzfy();

    public abstract void zzm(int i) throws zzgb;

    public abstract boolean zzn(int i) throws IOException;

    public abstract int zzo(int i) throws zzgb;

    public abstract void zzp(int i);

    private zzes() {
        this.zzsy = 100;
        this.zzsz = Integer.MAX_VALUE;
        this.zztb = false;
    }

    public static int zzq(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }
}

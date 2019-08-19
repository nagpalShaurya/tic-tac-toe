package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzez extends zzeg {
    private static final Logger logger = Logger.getLogger(zzez.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zztp = zziv.zzjq();
    zzfb zztq = this;

    static class zza extends zzez {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void zzf(int i, int i2) throws IOException {
            zzac((i << 3) | i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzf(i, 0);
            zzab(i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzf(i, 0);
            zzac(i2);
        }

        public final void zzj(int i, int i2) throws IOException {
            zzf(i, 5);
            zzae(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzf(i, 0);
            zzb(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzf(i, 1);
            zzd(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzf(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zza(int i, String str) throws IOException {
            zzf(i, 2);
            zzcz(str);
        }

        public final void zza(int i, zzeh zzeh) throws IOException {
            zzf(i, 2);
            zza(zzeh);
        }

        public final void zza(zzeh zzeh) throws IOException {
            zzac(zzeh.size());
            zzeh.zza((zzeg) this);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzac(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzhb zzhb, zzhv zzhv) throws IOException {
            zzf(i, 2);
            zzdz zzdz = (zzdz) zzhb;
            int zzes = zzdz.zzes();
            if (zzes == -1) {
                zzes = zzhv.zzp(zzdz);
                zzdz.zzg(zzes);
            }
            zzac(zzes);
            zzhv.zza(zzhb, this.zztq);
        }

        public final void zza(int i, zzhb zzhb) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zzf(3, 2);
            zzc(zzhb);
            zzf(1, 4);
        }

        public final void zzb(int i, zzeh zzeh) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zza(3, zzeh);
            zzf(1, 4);
        }

        public final void zzc(zzhb zzhb) throws IOException {
            zzac(zzhb.zzgv());
            zzhb.zzb(this);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzab(int i) throws IOException {
            if (i >= 0) {
                zzac(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zzac(int i) throws IOException {
            if (!zzez.zztp || zzgh() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zziv.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zziv.zza(bArr4, (long) i5, (byte) i);
            }
        }

        /* JADX WARNING: type inference failed for: r0v4, types: [byte[]] */
        /* JADX WARNING: type inference failed for: r5v2, types: [byte, int] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r0v4, types: [byte[]] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r5v2, types: [byte, int] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void zzae(int r5) throws java.io.IOException {
            /*
                r4 = this;
                byte[] r0 = r4.buffer     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r1 = r4.position     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r2 = r1 + 1
                r4.position = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                byte r2 = (byte) r5     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                r0[r1] = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                byte[] r0 = r4.buffer     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r1 = r4.position     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r2 = r1 + 1
                r4.position = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r2 = r5 >> 8
                byte r2 = (byte) r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                r0[r1] = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                byte[] r0 = r4.buffer     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r1 = r4.position     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r2 = r1 + 1
                r4.position = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r2 = r5 >> 16
                byte r2 = (byte) r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                r0[r1] = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                byte[] r0 = r4.buffer     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r1 = r4.position     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r2 = r1 + 1
                r4.position = r2     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                int r5 = r5 >> 24
                r0[r1] = r5     // Catch:{ IndexOutOfBoundsException -> 0x0032 }
                return
            L_0x0032:
                r5 = move-exception
                com.google.android.gms.internal.firebase_auth.zzez$zzb r0 = new com.google.android.gms.internal.firebase_auth.zzez$zzb
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                int r3 = r4.position
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r1[r2] = r3
                int r2 = r4.limit
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r3 = 1
                r1[r3] = r2
                r2 = 2
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r1[r2] = r3
                java.lang.String r2 = "Pos: %d, limit: %d, len: %d"
                java.lang.String r1 = java.lang.String.format(r2, r1)
                r0.<init>(r1, r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzez.zza.zzae(int):void");
        }

        public final void zzb(long j) throws IOException {
            if (!zzez.zztp || zzgh() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zziv.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zziv.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzd(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzcz(String str) throws IOException {
            int i = this.position;
            try {
                int zzah = zzah(str.length() * 3);
                int zzah2 = zzah(str.length());
                if (zzah2 == zzah) {
                    this.position = i + zzah2;
                    int zza = zzix.zza(str, this.buffer, this.position, zzgh());
                    this.position = i;
                    zzac((zza - i) - zzah2);
                    this.position = zza;
                    return;
                }
                zzac(zzix.zza(str));
                this.position = zzix.zza(str, this.buffer, this.position, zzgh());
            } catch (zzjb e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final int zzgh() {
            return this.limit - this.position;
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzb(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }
    }

    public static zzez zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzeh zzeh) throws IOException;

    public abstract void zza(int i, zzhb zzhb) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zzhb zzhb, zzhv zzhv) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzeh zzeh) throws IOException;

    public abstract void zzab(int i) throws IOException;

    public abstract void zzac(int i) throws IOException;

    public abstract void zzae(int i) throws IOException;

    public abstract void zzb(int i, zzeh zzeh) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(long j) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(zzhb zzhb) throws IOException;

    public abstract void zzcz(String str) throws IOException;

    public abstract void zzd(long j) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzgh();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    private zzez() {
    }

    public final void zzi(int i, int i2) throws IOException {
        zzh(i, zzam(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzj(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzj(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzad(int i) throws IOException {
        zzac(zzam(i));
    }

    public final void zzc(long j) throws IOException {
        zzb(zzj(j));
    }

    public final void zza(float f) throws IOException {
        zzae(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzd(Double.doubleToRawLongBits(d));
    }

    public final void zzs(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzk(int i, int i2) {
        return zzaf(i) + zzag(i2);
    }

    public static int zzl(int i, int i2) {
        return zzaf(i) + zzah(i2);
    }

    public static int zzm(int i, int i2) {
        return zzaf(i) + zzah(zzam(i2));
    }

    public static int zzn(int i, int i2) {
        return zzaf(i) + 4;
    }

    public static int zzo(int i, int i2) {
        return zzaf(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzaf(i) + zzf(j);
    }

    public static int zze(int i, long j) {
        return zzaf(i) + zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzaf(i) + zzf(zzj(j));
    }

    public static int zzg(int i, long j) {
        return zzaf(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzaf(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzaf(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzaf(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzaf(i) + 1;
    }

    public static int zzp(int i, int i2) {
        return zzaf(i) + zzag(i2);
    }

    public static int zzb(int i, String str) {
        return zzaf(i) + zzda(str);
    }

    public static int zzc(int i, zzeh zzeh) {
        int zzaf = zzaf(i);
        int size = zzeh.size();
        return zzaf + zzah(size) + size;
    }

    public static int zza(int i, zzgi zzgi) {
        int zzaf = zzaf(i);
        int zzgv = zzgi.zzgv();
        return zzaf + zzah(zzgv) + zzgv;
    }

    static int zzb(int i, zzhb zzhb, zzhv zzhv) {
        return zzaf(i) + zza(zzhb, zzhv);
    }

    public static int zzb(int i, zzhb zzhb) {
        return (zzaf(1) << 1) + zzl(2, i) + zzaf(3) + zzd(zzhb);
    }

    public static int zzd(int i, zzeh zzeh) {
        return (zzaf(1) << 1) + zzl(2, i) + zzc(3, zzeh);
    }

    public static int zzb(int i, zzgi zzgi) {
        return (zzaf(1) << 1) + zzl(2, i) + zza(3, zzgi);
    }

    public static int zzaf(int i) {
        return zzah(i << 3);
    }

    public static int zzag(int i) {
        if (i >= 0) {
            return zzah(i);
        }
        return 10;
    }

    public static int zzah(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((i & -268435456) == 0) {
            return 4;
        }
        return 5;
    }

    public static int zzai(int i) {
        return zzah(zzam(i));
    }

    public static int zzaj(int i) {
        return 4;
    }

    public static int zzak(int i) {
        return 4;
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzf(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(long j) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public static int zzal(int i) {
        return zzag(i);
    }

    public static int zzda(String str) {
        int i;
        try {
            i = zzix.zza(str);
        } catch (zzjb e) {
            i = str.getBytes(zzfu.UTF_8).length;
        }
        return zzah(i) + i;
    }

    public static int zza(zzgi zzgi) {
        int zzgv = zzgi.zzgv();
        return zzah(zzgv) + zzgv;
    }

    public static int zzb(zzeh zzeh) {
        int size = zzeh.size();
        return zzah(size) + size;
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzah(length) + length;
    }

    public static int zzd(zzhb zzhb) {
        int zzgv = zzhb.zzgv();
        return zzah(zzgv) + zzgv;
    }

    static int zza(zzhb zzhb, zzhv zzhv) {
        zzdz zzdz = (zzdz) zzhb;
        int zzes = zzdz.zzes();
        if (zzes == -1) {
            zzes = zzhv.zzp(zzdz);
            zzdz.zzg(zzes);
        }
        return zzah(zzes) + zzes;
    }

    private static int zzam(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public final void zzgi() {
        if (zzgh() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzjb zzjb) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzjb);
        byte[] bytes = str.getBytes(zzfu.UTF_8);
        try {
            zzac(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzhb zzhb, zzhv zzhv) {
        int zzaf = zzaf(i) << 1;
        zzdz zzdz = (zzdz) zzhb;
        int zzes = zzdz.zzes();
        if (zzes == -1) {
            zzes = zzhv.zzp(zzdz);
            zzdz.zzg(zzes);
        }
        return zzaf + zzes;
    }

    @Deprecated
    public static int zze(zzhb zzhb) {
        return zzhb.zzgv();
    }

    @Deprecated
    public static int zzan(int i) {
        return zzah(i);
    }
}

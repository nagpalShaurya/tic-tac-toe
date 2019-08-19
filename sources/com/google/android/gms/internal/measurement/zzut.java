package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzut extends zzuc {
    private static final Logger logger = Logger.getLogger(zzut.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzbuv = zzyh.zzyi();
    zzuv zzbuw = this;

    static class zza extends zzut {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i;
                    this.position = i;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void zzc(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzax(i2);
        }

        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzay(i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzba(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzav(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzax(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzfw(str);
        }

        public final void zza(int i, zzud zzud) throws IOException {
            zzc(i, 2);
            zza(zzud);
        }

        public final void zza(zzud zzud) throws IOException {
            zzay(zzud.size());
            zzud.zza((zzuc) this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        public final void zza(int i, zzwt zzwt) throws IOException {
            zzc(i, 2);
            zzb(zzwt);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzwt zzwt, zzxj zzxj) throws IOException {
            zzc(i, 2);
            zztw zztw = (zztw) zzwt;
            int zztu = zztw.zztu();
            if (zztu == -1) {
                zztu = zzxj.zzae(zztw);
                zztw.zzah(zztu);
            }
            zzay(zztu);
            zzxj.zza(zzwt, this.zzbuw);
        }

        public final void zzb(int i, zzwt zzwt) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzwt);
            zzc(1, 4);
        }

        public final void zzb(int i, zzud zzud) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzud);
            zzc(1, 4);
        }

        public final void zzb(zzwt zzwt) throws IOException {
            zzay(zzwt.zzvu());
            zzwt.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzwt zzwt, zzxj zzxj) throws IOException {
            zztw zztw = (zztw) zzwt;
            int zztu = zztw.zztu();
            if (zztu == -1) {
                zztu = zzxj.zzae(zztw);
                zztw.zzah(zztu);
            }
            zzay(zztu);
            zzxj.zza(zzwt, this.zzbuw);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzav((long) i);
            }
        }

        public final void zzay(int i) throws IOException {
            if (!zzut.zzbuv || zzvg() < 10) {
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zzyh.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzyh.zza(bArr4, (long) i5, (byte) i);
            }
        }

        /* JADX WARNING: type inference failed for: r0v4, types: [byte[]] */
        /* JADX WARNING: type inference failed for: r5v2, types: [byte, int] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r0v4, types: [byte[]] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r5v2, types: [byte, int] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void zzba(int r5) throws java.io.IOException {
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
                com.google.android.gms.internal.measurement.zzut$zzc r0 = new com.google.android.gms.internal.measurement.zzut$zzc
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzut.zza.zzba(int):void");
        }

        public final void zzav(long j) throws IOException {
            if (!zzut.zzbuv || zzvg() < 10) {
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzyh.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzyh.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzax(long j) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzfw(String str) throws IOException {
            int i = this.position;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    this.position = i + zzbd2;
                    int zza = zzyj.zza(str, this.buffer, this.position, zzvg());
                    this.position = i;
                    zzay((zza - i) - zzbd2);
                    this.position = zza;
                    return;
                }
                zzay(zzyj.zza(str));
                this.position = zzyj.zza(str, this.buffer, this.position, zzvg());
            } catch (zzyn e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public void flush() {
        }

        public final int zzvg() {
            return this.limit - this.position;
        }

        public final int zzvi() {
            return this.position - this.offset;
        }
    }

    static final class zzb extends zza {
        private final ByteBuffer zzbux;
        private int zzbuy;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzbux = byteBuffer;
            this.zzbuy = byteBuffer.position();
        }

        public final void flush() {
            this.zzbux.position(this.zzbuy + zzvi());
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(String str) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzc(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }
    }

    static final class zzd extends zzut {
        private final int zzbuy;
        private final ByteBuffer zzbuz;
        private final ByteBuffer zzbva;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzbuz = byteBuffer;
            this.zzbva = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzbuy = byteBuffer.position();
        }

        public final void zzc(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzax(i2);
        }

        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzay(i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzba(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzav(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzax(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzfw(str);
        }

        public final void zza(int i, zzud zzud) throws IOException {
            zzc(i, 2);
            zza(zzud);
        }

        public final void zza(int i, zzwt zzwt) throws IOException {
            zzc(i, 2);
            zzb(zzwt);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzwt zzwt, zzxj zzxj) throws IOException {
            zzc(i, 2);
            zza(zzwt, zzxj);
        }

        public final void zzb(int i, zzwt zzwt) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzwt);
            zzc(1, 4);
        }

        public final void zzb(int i, zzud zzud) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzud);
            zzc(1, 4);
        }

        public final void zzb(zzwt zzwt) throws IOException {
            zzay(zzwt.zzvu());
            zzwt.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzwt zzwt, zzxj zzxj) throws IOException {
            zztw zztw = (zztw) zzwt;
            int zztu = zztw.zztu();
            if (zztu == -1) {
                zztu = zzxj.zzae(zztw);
                zztw.zzah(zztu);
            }
            zzay(zztu);
            zzxj.zza(zzwt, this.zzbuw);
        }

        public final void zzc(byte b) throws IOException {
            try {
                this.zzbva.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zza(zzud zzud) throws IOException {
            zzay(zzud.size());
            zzud.zza((zzuc) this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzav((long) i);
            }
        }

        public final void zzay(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzbva.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzbva.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzba(int i) throws IOException {
            try {
                this.zzbva.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzav(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzbva.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzbva.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzax(long j) throws IOException {
            try {
                this.zzbva.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzbva.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzfw(String str) throws IOException {
            int position = this.zzbva.position();
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int position2 = this.zzbva.position() + zzbd2;
                    this.zzbva.position(position2);
                    zzfy(str);
                    int position3 = this.zzbva.position();
                    this.zzbva.position(position);
                    zzay(position3 - position2);
                    this.zzbva.position(position3);
                    return;
                }
                zzay(zzyj.zza(str));
                zzfy(str);
            } catch (zzyn e) {
                this.zzbva.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void flush() {
            this.zzbuz.position(this.zzbva.position());
        }

        public final int zzvg() {
            return this.zzbva.remaining();
        }

        private final void zzfy(String str) throws IOException {
            try {
                zzyj.zza(str, this.zzbva);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            }
        }
    }

    static final class zze extends zzut {
        private final ByteBuffer zzbuz;
        private final ByteBuffer zzbva;
        private final long zzbvb;
        private final long zzbvc;
        private final long zzbvd;
        private final long zzbve = (this.zzbvd - 10);
        private long zzbvf = this.zzbvc;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzbuz = byteBuffer;
            this.zzbva = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzbvb = zzyh.zzb(byteBuffer);
            this.zzbvc = this.zzbvb + ((long) byteBuffer.position());
            this.zzbvd = this.zzbvb + ((long) byteBuffer.limit());
        }

        public final void zzc(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzax(i2);
        }

        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzay(i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzba(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzav(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzax(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzfw(str);
        }

        public final void zza(int i, zzud zzud) throws IOException {
            zzc(i, 2);
            zza(zzud);
        }

        public final void zza(int i, zzwt zzwt) throws IOException {
            zzc(i, 2);
            zzb(zzwt);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzwt zzwt, zzxj zzxj) throws IOException {
            zzc(i, 2);
            zza(zzwt, zzxj);
        }

        public final void zzb(int i, zzwt zzwt) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzwt);
            zzc(1, 4);
        }

        public final void zzb(int i, zzud zzud) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzud);
            zzc(1, 4);
        }

        public final void zzb(zzwt zzwt) throws IOException {
            zzay(zzwt.zzvu());
            zzwt.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzwt zzwt, zzxj zzxj) throws IOException {
            zztw zztw = (zztw) zzwt;
            int zztu = zztw.zztu();
            if (zztu == -1) {
                zztu = zzxj.zzae(zztw);
                zztw.zzah(zztu);
            }
            zzay(zztu);
            zzxj.zza(zzwt, this.zzbuw);
        }

        public final void zzc(byte b) throws IOException {
            long j = this.zzbvf;
            if (j < this.zzbvd) {
                this.zzbvf = 1 + j;
                zzyh.zza(j, b);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.zzbvd), Integer.valueOf(1)}));
        }

        public final void zza(zzud zzud) throws IOException {
            zzay(zzud.size());
            zzud.zza((zzuc) this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzav((long) i);
            }
        }

        public final void zzay(int i) throws IOException {
            if (this.zzbvf <= this.zzbve) {
                while ((i & -128) != 0) {
                    long j = this.zzbvf;
                    this.zzbvf = j + 1;
                    zzyh.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzbvf;
                this.zzbvf = 1 + j2;
                zzyh.zza(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.zzbvf;
                if (j3 >= this.zzbvd) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j3), Long.valueOf(this.zzbvd), Integer.valueOf(1)}));
                } else if ((i & -128) == 0) {
                    this.zzbvf = 1 + j3;
                    zzyh.zza(j3, (byte) i);
                    return;
                } else {
                    this.zzbvf = j3 + 1;
                    zzyh.zza(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        public final void zzba(int i) throws IOException {
            this.zzbva.putInt((int) (this.zzbvf - this.zzbvb), i);
            this.zzbvf += 4;
        }

        public final void zzav(long j) throws IOException {
            if (this.zzbvf <= this.zzbve) {
                while ((j & -128) != 0) {
                    long j2 = this.zzbvf;
                    this.zzbvf = j2 + 1;
                    zzyh.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzbvf;
                this.zzbvf = 1 + j3;
                zzyh.zza(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.zzbvf;
                if (j4 >= this.zzbvd) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j4), Long.valueOf(this.zzbvd), Integer.valueOf(1)}));
                } else if ((j & -128) == 0) {
                    this.zzbvf = 1 + j4;
                    zzyh.zza(j4, (byte) ((int) j));
                    return;
                } else {
                    this.zzbvf = j4 + 1;
                    zzyh.zza(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        public final void zzax(long j) throws IOException {
            this.zzbva.putLong((int) (this.zzbvf - this.zzbvb), j);
            this.zzbvf += 8;
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.zzbvd - j;
                long j3 = this.zzbvf;
                if (j2 >= j3) {
                    zzyh.zza(bArr, (long) i, j3, j);
                    this.zzbvf += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException(Param.VALUE);
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzbvf), Long.valueOf(this.zzbvd), Integer.valueOf(i2)}));
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzfw(String str) throws IOException {
            long j = this.zzbvf;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i = ((int) (this.zzbvf - this.zzbvb)) + zzbd2;
                    this.zzbva.position(i);
                    zzyj.zza(str, this.zzbva);
                    int position = this.zzbva.position() - i;
                    zzay(position);
                    this.zzbvf += (long) position;
                    return;
                }
                int zza = zzyj.zza(str);
                zzay(zza);
                zzbe(this.zzbvf);
                zzyj.zza(str, this.zzbva);
                this.zzbvf += (long) zza;
            } catch (zzyn e) {
                this.zzbvf = j;
                zzbe(this.zzbvf);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc((Throwable) e3);
            }
        }

        public final void flush() {
            this.zzbuz.position((int) (this.zzbvf - this.zzbvb));
        }

        public final int zzvg() {
            return (int) (this.zzbvd - this.zzbvf);
        }

        private final void zzbe(long j) {
            this.zzbva.position((int) (j - this.zzbvb));
        }
    }

    public static zzut zzj(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzud zzud) throws IOException;

    public abstract void zza(int i, zzwt zzwt) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zzwt zzwt, zzxj zzxj) throws IOException;

    public abstract void zza(zzud zzud) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(zzwt zzwt, zzxj zzxj) throws IOException;

    public abstract void zzav(long j) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzax(long j) throws IOException;

    public abstract void zzay(int i) throws IOException;

    public abstract void zzb(int i, zzud zzud) throws IOException;

    public abstract void zzb(int i, zzwt zzwt) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzwt zzwt) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzfw(String str) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzvg();

    public static zzut zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zzyh.zzyj()) {
            return new zze(byteBuffer);
        } else {
            return new zzd(byteBuffer);
        }
    }

    private zzut() {
    }

    public final void zzf(int i, int i2) throws IOException {
        zze(i, zzbi(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzbd(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzaz(int i) throws IOException {
        zzay(zzbi(i));
    }

    public final void zzaw(long j) throws IOException {
        zzav(zzbd(j));
    }

    public final void zza(float f) throws IOException {
        zzba(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) throws IOException {
        zzax(Double.doubleToRawLongBits(d));
    }

    public final void zzu(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzh(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzi(int i, int i2) {
        return zzbb(i) + zzbd(i2);
    }

    public static int zzj(int i, int i2) {
        return zzbb(i) + zzbd(zzbi(i2));
    }

    public static int zzk(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + zzaz(j);
    }

    public static int zze(int i, long j) {
        return zzbb(i) + zzaz(j);
    }

    public static int zzf(int i, long j) {
        return zzbb(i) + zzaz(zzbd(j));
    }

    public static int zzg(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbb(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzbb(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbb(i) + 1;
    }

    public static int zzm(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzc(int i, String str) {
        return zzbb(i) + zzfx(str);
    }

    public static int zzc(int i, zzud zzud) {
        int zzbb = zzbb(i);
        int size = zzud.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zza(int i, zzwa zzwa) {
        int zzbb = zzbb(i);
        int zzvu = zzwa.zzvu();
        return zzbb + zzbd(zzvu) + zzvu;
    }

    public static int zzc(int i, zzwt zzwt) {
        return zzbb(i) + zzc(zzwt);
    }

    static int zzb(int i, zzwt zzwt, zzxj zzxj) {
        return zzbb(i) + zzb(zzwt, zzxj);
    }

    public static int zzd(int i, zzwt zzwt) {
        return (zzbb(1) << 1) + zzi(2, i) + zzc(3, zzwt);
    }

    public static int zzd(int i, zzud zzud) {
        return (zzbb(1) << 1) + zzi(2, i) + zzc(3, zzud);
    }

    public static int zzb(int i, zzwa zzwa) {
        return (zzbb(1) << 1) + zzi(2, i) + zza(3, zzwa);
    }

    public static int zzbb(int i) {
        return zzbd(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzbd(int i) {
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

    public static int zzbe(int i) {
        return zzbd(zzbi(i));
    }

    public static int zzbf(int i) {
        return 4;
    }

    public static int zzbg(int i) {
        return 4;
    }

    public static int zzay(long j) {
        return zzaz(j);
    }

    public static int zzaz(long j) {
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

    public static int zzba(long j) {
        return zzaz(zzbd(j));
    }

    public static int zzbb(long j) {
        return 8;
    }

    public static int zzbc(long j) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzv(boolean z) {
        return 1;
    }

    public static int zzbh(int i) {
        return zzbc(i);
    }

    public static int zzfx(String str) {
        int i;
        try {
            i = zzyj.zza(str);
        } catch (zzyn e) {
            i = str.getBytes(zzvo.UTF_8).length;
        }
        return zzbd(i) + i;
    }

    public static int zza(zzwa zzwa) {
        int zzvu = zzwa.zzvu();
        return zzbd(zzvu) + zzvu;
    }

    public static int zzb(zzud zzud) {
        int size = zzud.size();
        return zzbd(size) + size;
    }

    public static int zzk(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public static int zzc(zzwt zzwt) {
        int zzvu = zzwt.zzvu();
        return zzbd(zzvu) + zzvu;
    }

    static int zzb(zzwt zzwt, zzxj zzxj) {
        zztw zztw = (zztw) zzwt;
        int zztu = zztw.zztu();
        if (zztu == -1) {
            zztu = zzxj.zzae(zztw);
            zztw.zzah(zztu);
        }
        return zzbd(zztu) + zztu;
    }

    private static int zzbi(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private static long zzbd(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzyn zzyn) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzyn);
        byte[] bytes = str.getBytes(zzvo.UTF_8);
        try {
            zzay(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc((Throwable) e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzwt zzwt, zzxj zzxj) {
        int zzbb = zzbb(i) << 1;
        zztw zztw = (zztw) zzwt;
        int zztu = zztw.zztu();
        if (zztu == -1) {
            zztu = zzxj.zzae(zztw);
            zztw.zzah(zztu);
        }
        return zzbb + zztu;
    }

    @Deprecated
    public static int zzd(zzwt zzwt) {
        return zzwt.zzvu();
    }

    @Deprecated
    public static int zzbj(int i) {
        return zzbd(i);
    }
}

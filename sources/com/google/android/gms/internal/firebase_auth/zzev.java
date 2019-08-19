package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzev extends zzes {
    private final byte[] buffer;
    private int pos;
    private int zztd;
    private int zztf;
    private int zztg;
    private final InputStream zzth;
    private int zzti;
    private int zztj;
    private zzew zztk;

    private zzev(InputStream inputStream, int i) {
        super();
        this.zztg = Integer.MAX_VALUE;
        this.zztk = null;
        zzfu.zza(inputStream, "input");
        this.zzth = inputStream;
        this.buffer = new byte[i];
        this.zzti = 0;
        this.pos = 0;
        this.zztj = 0;
    }

    public final int zzfh() throws IOException {
        if (zzfx()) {
            this.zztf = 0;
            return 0;
        }
        this.zztf = zzfz();
        int i = this.zztf;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzgb.zzhs();
    }

    public final void zzm(int i) throws zzgb {
        if (this.zztf != i) {
            throw zzgb.zzht();
        }
    }

    public final boolean zzn(int i) throws IOException {
        int zzfh;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzti - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzgb.zzhr();
            }
            while (i3 < 10) {
                if (zzge() < 0) {
                    i3++;
                }
            }
            throw zzgb.zzhr();
            return true;
        } else if (i2 == 1) {
            zzr(8);
            return true;
        } else if (i2 == 2) {
            zzr(zzfz());
            return true;
        } else if (i2 == 3) {
            do {
                zzfh = zzfh();
                if (zzfh == 0) {
                    break;
                }
            } while (zzn(zzfh));
            zzm(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzr(4);
                return true;
            }
            throw zzgb.zzhu();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzgc());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzgb());
    }

    public final long zzfi() throws IOException {
        return zzga();
    }

    public final long zzfj() throws IOException {
        return zzga();
    }

    public final int zzfk() throws IOException {
        return zzfz();
    }

    public final long zzfl() throws IOException {
        return zzgc();
    }

    public final int zzfm() throws IOException {
        return zzgb();
    }

    public final boolean zzfn() throws IOException {
        return zzga() != 0;
    }

    public final String readString() throws IOException {
        int zzfz = zzfz();
        if (zzfz > 0) {
            int i = this.zzti;
            int i2 = this.pos;
            if (zzfz <= i - i2) {
                String str = new String(this.buffer, i2, zzfz, zzfu.UTF_8);
                this.pos += zzfz;
                return str;
            }
        }
        if (zzfz == 0) {
            return "";
        }
        if (zzfz > this.zzti) {
            return new String(zzu(zzfz), zzfu.UTF_8);
        }
        zzs(zzfz);
        String str2 = new String(this.buffer, this.pos, zzfz, zzfu.UTF_8);
        this.pos += zzfz;
        return str2;
    }

    public final String zzfo() throws IOException {
        byte[] bArr;
        int zzfz = zzfz();
        int i = this.pos;
        int i2 = 0;
        if (zzfz <= this.zzti - i && zzfz > 0) {
            bArr = this.buffer;
            this.pos = i + zzfz;
            i2 = i;
        } else if (zzfz == 0) {
            return "";
        } else {
            if (zzfz <= this.zzti) {
                zzs(zzfz);
                bArr = this.buffer;
                this.pos = zzfz;
            } else {
                bArr = zzu(zzfz);
            }
        }
        return zzix.zzg(bArr, i2, zzfz);
    }

    public final zzeh zzfp() throws IOException {
        int zzfz = zzfz();
        int i = this.zzti;
        int i2 = this.pos;
        if (zzfz <= i - i2 && zzfz > 0) {
            zzeh zzb = zzeh.zzb(this.buffer, i2, zzfz);
            this.pos += zzfz;
            return zzb;
        } else if (zzfz == 0) {
            return zzeh.zzso;
        } else {
            byte[] zzv = zzv(zzfz);
            if (zzv != null) {
                return zzeh.zza(zzv);
            }
            int i3 = this.pos;
            int i4 = this.zzti;
            int i5 = i4 - i3;
            this.zztj += i4;
            this.pos = 0;
            this.zzti = 0;
            List<byte[]> zzw = zzw(zzfz - i5);
            ArrayList arrayList = new ArrayList(zzw.size() + 1);
            arrayList.add(zzeh.zzb(this.buffer, i3, i5));
            for (byte[] zza : zzw) {
                arrayList.add(zzeh.zza(zza));
            }
            return zzeh.zze(arrayList);
        }
    }

    public final int zzfq() throws IOException {
        return zzfz();
    }

    public final int zzfr() throws IOException {
        return zzfz();
    }

    public final int zzfs() throws IOException {
        return zzgb();
    }

    public final long zzft() throws IOException {
        return zzgc();
    }

    public final int zzfu() throws IOException {
        return zzq(zzfz());
    }

    public final long zzfv() throws IOException {
        return zza(zzga());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzfz() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzti
            if (r1 == r0) goto L_0x006d
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r3
            goto L_0x006a
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x006a
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x0069
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0069
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0069
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006d
            goto L_0x006a
        L_0x0069:
            r1 = r3
        L_0x006a:
            r5.pos = r1
            return r0
        L_0x006d:
            long r0 = r5.zzfw()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzev.zzfz():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzga() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzti
            if (r1 == r0) goto L_0x00be
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00be
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0026
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            long r2 = (long) r0
            r3 = r2
            goto L_0x00bb
        L_0x0026:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0037
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto L_0x00bb
        L_0x0037:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0048
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            long r2 = (long) r0
            r3 = r2
            goto L_0x00bb
        L_0x0048:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r1 = r1 ^ r3
            r3 = r1
            r1 = r0
            goto L_0x00bb
        L_0x005f:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0073
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r3 = r3 ^ r5
            goto L_0x00bb
        L_0x0073:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0089
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r1 = r1 ^ r3
            r3 = r1
            r1 = r0
            goto L_0x00bb
        L_0x0089:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x009d
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r3 = r3 ^ r5
            goto L_0x00bb
        L_0x009d:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00be
            goto L_0x00bb
        L_0x00ba:
            r1 = r0
        L_0x00bb:
            r11.pos = r1
            return r3
        L_0x00be:
            long r0 = r11.zzfw()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzev.zzga():long");
    }

    /* access modifiers changed from: 0000 */
    public final long zzfw() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzge = zzge();
            j |= ((long) (zzge & Byte.MAX_VALUE)) << i;
            if ((zzge & 128) == 0) {
                return j;
            }
        }
        throw zzgb.zzhr();
    }

    private final int zzgb() throws IOException {
        int i = this.pos;
        if (this.zzti - i < 4) {
            zzs(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzgc() throws IOException {
        int i = this.pos;
        if (this.zzti - i < 8) {
            zzs(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int zzo(int i) throws zzgb {
        if (i >= 0) {
            int i2 = i + this.zztj + this.pos;
            int i3 = this.zztg;
            if (i2 <= i3) {
                this.zztg = i2;
                zzgd();
                return i3;
            }
            throw zzgb.zzhp();
        }
        throw zzgb.zzhq();
    }

    private final void zzgd() {
        this.zzti += this.zztd;
        int i = this.zztj;
        int i2 = this.zzti;
        int i3 = i + i2;
        int i4 = this.zztg;
        if (i3 > i4) {
            this.zztd = i3 - i4;
            this.zzti = i2 - this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzp(int i) {
        this.zztg = i;
        zzgd();
    }

    public final boolean zzfx() throws IOException {
        return this.pos == this.zzti && !zzt(1);
    }

    public final int zzfy() {
        return this.zztj + this.pos;
    }

    private final void zzs(int i) throws IOException {
        if (zzt(i)) {
            return;
        }
        if (i > (this.zzsz - this.zztj) - this.pos) {
            throw zzgb.zzhv();
        }
        throw zzgb.zzhp();
    }

    private final boolean zzt(int i) throws IOException {
        while (this.pos + i > this.zzti) {
            int i2 = this.zzsz;
            int i3 = this.zztj;
            int i4 = i2 - i3;
            int i5 = this.pos;
            if (i > i4 - i5 || i3 + i5 + i > this.zztg) {
                return false;
            }
            if (i5 > 0) {
                int i6 = this.zzti;
                if (i6 > i5) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i5, bArr, 0, i6 - i5);
                }
                this.zztj += i5;
                this.zzti -= i5;
                this.pos = 0;
            }
            InputStream inputStream = this.zzth;
            byte[] bArr2 = this.buffer;
            int i7 = this.zzti;
            int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.zzsz - this.zztj) - this.zzti));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzth.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzti += read;
                zzgd();
                if (this.zzti >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte zzge() throws IOException {
        if (this.pos == this.zzti) {
            zzs(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzu(int i) throws IOException {
        byte[] zzv = zzv(i);
        if (zzv != null) {
            return zzv;
        }
        int i2 = this.pos;
        int i3 = this.zzti;
        int i4 = i3 - i2;
        this.zztj += i3;
        this.pos = 0;
        this.zzti = 0;
        List<byte[]> zzw = zzw(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzw) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzv(int i) throws IOException {
        if (i == 0) {
            return zzfu.EMPTY_BYTE_ARRAY;
        }
        if (i >= 0) {
            int i2 = this.zztj + this.pos + i;
            if (i2 - this.zzsz <= 0) {
                int i3 = this.zztg;
                if (i2 <= i3) {
                    int i4 = this.zzti - this.pos;
                    int i5 = i - i4;
                    if (i5 >= 4096 && i5 > this.zzth.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
                    this.zztj += this.zzti;
                    this.pos = 0;
                    this.zzti = 0;
                    while (i4 < bArr.length) {
                        int read = this.zzth.read(bArr, i4, i - i4);
                        if (read != -1) {
                            this.zztj += read;
                            i4 += read;
                        } else {
                            throw zzgb.zzhp();
                        }
                    }
                    return bArr;
                }
                zzr((i3 - this.zztj) - this.pos);
                throw zzgb.zzhp();
            }
            throw zzgb.zzhv();
        }
        throw zzgb.zzhq();
    }

    private final List<byte[]> zzw(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzth.read(bArr, i2, bArr.length - i2);
                if (read != -1) {
                    this.zztj += read;
                    i2 += read;
                } else {
                    throw zzgb.zzhp();
                }
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzr(int i) throws IOException {
        int i2 = this.zzti;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zztj;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zztg;
            if (i6 <= i7) {
                this.zztj = i4 + i5;
                int i8 = this.zzti - i5;
                this.zzti = 0;
                this.pos = 0;
                while (i8 < i) {
                    try {
                        long j = (long) (i - i8);
                        long skip = this.zzth.skip(j);
                        if (skip < 0 || skip > j) {
                            String valueOf = String.valueOf(this.zzth.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                        i8 += (int) skip;
                    } catch (Throwable th) {
                        this.zztj += i8;
                        zzgd();
                        throw th;
                    }
                }
                this.zztj += i8;
                zzgd();
                return;
            }
            zzr((i7 - i4) - i5);
            throw zzgb.zzhp();
        } else {
            throw zzgb.zzhq();
        }
    }
}

package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Arrays;

final class zzeu extends zzes {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zztc;
    private int zztd;
    private int zzte;
    private int zztf;
    private int zztg;

    private zzeu(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zztg = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzte = this.pos;
        this.zztc = z;
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
            if (this.limit - this.pos >= 10) {
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
            int i = this.limit;
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
        if (zzfz < 0) {
            throw zzgb.zzhq();
        }
        throw zzgb.zzhp();
    }

    public final String zzfo() throws IOException {
        int zzfz = zzfz();
        if (zzfz > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzfz <= i - i2) {
                String zzg = zzix.zzg(this.buffer, i2, zzfz);
                this.pos += zzfz;
                return zzg;
            }
        }
        if (zzfz == 0) {
            return "";
        }
        if (zzfz <= 0) {
            throw zzgb.zzhq();
        }
        throw zzgb.zzhp();
    }

    public final zzeh zzfp() throws IOException {
        byte[] bArr;
        int zzfz = zzfz();
        if (zzfz > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzfz <= i - i2) {
                zzeh zzb = zzeh.zzb(this.buffer, i2, zzfz);
                this.pos += zzfz;
                return zzb;
            }
        }
        if (zzfz == 0) {
            return zzeh.zzso;
        }
        if (zzfz > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzfz <= i3 - i4) {
                this.pos = zzfz + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzeh.zza(bArr);
            }
        }
        if (zzfz > 0) {
            throw zzgb.zzhp();
        } else if (zzfz == 0) {
            bArr = zzfu.EMPTY_BYTE_ARRAY;
            return zzeh.zza(bArr);
        } else {
            throw zzgb.zzhq();
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
            int r1 = r5.limit
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzeu.zzfz():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzga() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzeu.zzga():long");
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
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzgb.zzhp();
    }

    private final long zzgc() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzgb.zzhp();
    }

    public final int zzo(int i) throws zzgb {
        if (i >= 0) {
            int zzfy = i + zzfy();
            int i2 = this.zztg;
            if (zzfy <= i2) {
                this.zztg = zzfy;
                zzgd();
                return i2;
            }
            throw zzgb.zzhp();
        }
        throw zzgb.zzhq();
    }

    private final void zzgd() {
        this.limit += this.zztd;
        int i = this.limit;
        int i2 = i - this.zzte;
        int i3 = this.zztg;
        if (i2 > i3) {
            this.zztd = i2 - i3;
            this.limit = i - this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzp(int i) {
        this.zztg = i;
        zzgd();
    }

    public final boolean zzfx() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzfy() {
        return this.pos - this.zzte;
    }

    private final byte zzge() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzgb.zzhp();
    }

    private final void zzr(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzgb.zzhq();
        }
        throw zzgb.zzhp();
    }
}

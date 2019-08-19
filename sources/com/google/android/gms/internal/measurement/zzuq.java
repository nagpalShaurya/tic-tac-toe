package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

final class zzuq extends zzuo {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbum;
    private int zzbun;
    private int zzbuo;
    private int zzbup;
    private int zzbuq;

    private zzuq(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbuq = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzbuo = this.pos;
        this.zzbum = z;
    }

    public final int zzug() throws IOException {
        if (zzuw()) {
            this.zzbup = 0;
            return 0;
        }
        this.zzbup = zzuy();
        int i = this.zzbup;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw new zzvt("Protocol message contained an invalid tag (zero).");
    }

    public final void zzan(int i) throws zzvt {
        if (this.zzbup != i) {
            throw zzvt.zzwn();
        }
    }

    public final boolean zzao(int i) throws IOException {
        int zzug;
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
                throw zzvt.zzwm();
            }
            while (i3 < 10) {
                if (zzvd() < 0) {
                    i3++;
                }
            }
            throw zzvt.zzwm();
            return true;
        } else if (i2 == 1) {
            zzas(8);
            return true;
        } else if (i2 == 2) {
            zzas(zzuy());
            return true;
        } else if (i2 == 3) {
            do {
                zzug = zzug();
                if (zzug == 0) {
                    break;
                }
            } while (zzao(zzug));
            zzan(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzas(4);
                return true;
            }
            throw zzvt.zzwo();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzvb());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzva());
    }

    public final long zzuh() throws IOException {
        return zzuz();
    }

    public final long zzui() throws IOException {
        return zzuz();
    }

    public final int zzuj() throws IOException {
        return zzuy();
    }

    public final long zzuk() throws IOException {
        return zzvb();
    }

    public final int zzul() throws IOException {
        return zzva();
    }

    public final boolean zzum() throws IOException {
        return zzuz() != 0;
    }

    public final String readString() throws IOException {
        int zzuy = zzuy();
        if (zzuy > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzuy <= i - i2) {
                String str = new String(this.buffer, i2, zzuy, zzvo.UTF_8);
                this.pos += zzuy;
                return str;
            }
        }
        if (zzuy == 0) {
            return "";
        }
        if (zzuy < 0) {
            throw zzvt.zzwl();
        }
        throw zzvt.zzwk();
    }

    public final String zzun() throws IOException {
        int zzuy = zzuy();
        if (zzuy > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzuy <= i - i2) {
                String zzh = zzyj.zzh(this.buffer, i2, zzuy);
                this.pos += zzuy;
                return zzh;
            }
        }
        if (zzuy == 0) {
            return "";
        }
        if (zzuy <= 0) {
            throw zzvt.zzwl();
        }
        throw zzvt.zzwk();
    }

    public final <T extends zzwt> T zza(zzxd<T> zzxd, zzuz zzuz) throws IOException {
        int zzuy = zzuy();
        if (this.zzbuh < this.zzbui) {
            int zzaq = zzaq(zzuy);
            this.zzbuh++;
            T t = (zzwt) zzxd.zza(this, zzuz);
            zzan(0);
            this.zzbuh--;
            zzar(zzaq);
            return t;
        }
        throw zzvt.zzwp();
    }

    public final zzud zzuo() throws IOException {
        byte[] bArr;
        int zzuy = zzuy();
        if (zzuy > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzuy <= i - i2) {
                zzud zzb = zzud.zzb(this.buffer, i2, zzuy);
                this.pos += zzuy;
                return zzb;
            }
        }
        if (zzuy == 0) {
            return zzud.zzbtz;
        }
        if (zzuy > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzuy <= i3 - i4) {
                this.pos = zzuy + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzud.zzi(bArr);
            }
        }
        if (zzuy > 0) {
            throw zzvt.zzwk();
        } else if (zzuy == 0) {
            bArr = zzvo.zzbzj;
            return zzud.zzi(bArr);
        } else {
            throw zzvt.zzwl();
        }
    }

    public final int zzup() throws IOException {
        return zzuy();
    }

    public final int zzuq() throws IOException {
        return zzuy();
    }

    public final int zzur() throws IOException {
        return zzva();
    }

    public final long zzus() throws IOException {
        return zzvb();
    }

    public final int zzut() throws IOException {
        int zzuy = zzuy();
        return (-(zzuy & 1)) ^ (zzuy >>> 1);
    }

    public final long zzuu() throws IOException {
        long zzuz = zzuz();
        return (-(zzuz & 1)) ^ (zzuz >>> 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzuy() throws java.io.IOException {
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
            long r0 = r5.zzuv()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzuq.zzuy():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzuz() throws java.io.IOException {
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
            long r0 = r11.zzuv()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzuq.zzuz():long");
    }

    /* access modifiers changed from: 0000 */
    public final long zzuv() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvd = zzvd();
            j |= ((long) (zzvd & Byte.MAX_VALUE)) << i;
            if ((zzvd & 128) == 0) {
                return j;
            }
        }
        throw zzvt.zzwm();
    }

    private final int zzva() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzvt.zzwk();
    }

    private final long zzvb() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzvt.zzwk();
    }

    public final int zzaq(int i) throws zzvt {
        if (i >= 0) {
            int zzux = i + zzux();
            int i2 = this.zzbuq;
            if (zzux <= i2) {
                this.zzbuq = zzux;
                zzvc();
                return i2;
            }
            throw zzvt.zzwk();
        }
        throw zzvt.zzwl();
    }

    private final void zzvc() {
        this.limit += this.zzbun;
        int i = this.limit;
        int i2 = i - this.zzbuo;
        int i3 = this.zzbuq;
        if (i2 > i3) {
            this.zzbun = i2 - i3;
            this.limit = i - this.zzbun;
            return;
        }
        this.zzbun = 0;
    }

    public final void zzar(int i) {
        this.zzbuq = i;
        zzvc();
    }

    public final boolean zzuw() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzux() {
        return this.pos - this.zzbuo;
    }

    private final byte zzvd() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzvt.zzwk();
    }

    public final void zzas(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzvt.zzwl();
        }
        throw zzvt.zzwk();
    }
}

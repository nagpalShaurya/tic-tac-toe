package com.google.android.gms.internal.firebase_auth;

final class zzja extends zziz {
    zzja() {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r13[r14] > -65) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0081, code lost:
        if (r13[r14] > -65) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r13[r14] > -65) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = -19
            r1 = -62
            r2 = -16
            r3 = 0
            r4 = -96
            r5 = -32
            r6 = -1
            r7 = -65
            if (r12 == 0) goto L_0x0084
            if (r14 < r15) goto L_0x0013
            return r12
        L_0x0013:
            byte r8 = (byte) r12
            if (r8 >= r5) goto L_0x001f
            if (r8 < r1) goto L_0x001e
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0085
        L_0x001e:
            return r6
        L_0x001f:
            if (r8 >= r2) goto L_0x0048
            int r12 = r12 >> 8
            r12 = r12 ^ r6
            byte r12 = (byte) r12
            if (r12 != 0) goto L_0x0035
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 < r15) goto L_0x0032
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzt(r8, r14)
            return r12
        L_0x0032:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x0035:
            if (r12 > r7) goto L_0x0047
            if (r8 != r5) goto L_0x003b
            if (r12 < r4) goto L_0x0047
        L_0x003b:
            if (r8 != r0) goto L_0x003f
            if (r12 >= r4) goto L_0x0047
        L_0x003f:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            goto L_0x0085
        L_0x0047:
            return r6
        L_0x0048:
            int r9 = r12 >> 8
            r9 = r9 ^ r6
            byte r9 = (byte) r9
            if (r9 != 0) goto L_0x005d
            int r12 = r14 + 1
            byte r9 = r13[r14]
            if (r12 < r15) goto L_0x005a
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzt(r8, r9)
            return r12
        L_0x005a:
            r14 = r12
            r12 = 0
            goto L_0x0060
        L_0x005d:
            int r12 = r12 >> 16
            byte r12 = (byte) r12
        L_0x0060:
            if (r12 != 0) goto L_0x0070
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 < r15) goto L_0x006d
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zze(r8, r9, r14)
            return r12
        L_0x006d:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x0070:
            if (r9 > r7) goto L_0x0083
            int r8 = r8 << 28
            int r9 = r9 + 112
            int r8 = r8 + r9
            int r8 = r8 >> 30
            if (r8 != 0) goto L_0x0083
            if (r12 > r7) goto L_0x0083
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0085
        L_0x0083:
            return r6
        L_0x0084:
            r12 = r14
        L_0x0085:
        L_0x0086:
            if (r12 >= r15) goto L_0x008f
            byte r14 = r13[r12]
            if (r14 < 0) goto L_0x008f
            int r12 = r12 + 1
            goto L_0x0086
        L_0x008f:
            if (r12 < r15) goto L_0x0092
            return r3
        L_0x0092:
            if (r12 < r15) goto L_0x0095
            return r3
        L_0x0095:
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 >= 0) goto L_0x00f1
            if (r12 >= r5) goto L_0x00a9
            if (r14 < r15) goto L_0x00a0
            return r12
        L_0x00a0:
            if (r12 < r1) goto L_0x00a8
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x00ef
        L_0x00a8:
            return r6
        L_0x00a9:
            if (r12 >= r2) goto L_0x00c9
            int r8 = r15 + -1
            if (r14 < r8) goto L_0x00b4
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzf(r13, r14, r15)
            return r12
        L_0x00b4:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r7) goto L_0x00c8
            if (r12 != r5) goto L_0x00be
            if (r14 < r4) goto L_0x00c8
        L_0x00be:
            if (r12 != r0) goto L_0x00c2
            if (r14 >= r4) goto L_0x00c8
        L_0x00c2:
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 <= r7) goto L_0x00ef
        L_0x00c8:
            return r6
        L_0x00c9:
            int r8 = r15 + -2
            if (r14 < r8) goto L_0x00d2
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzf(r13, r14, r15)
            return r12
        L_0x00d2:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r7) goto L_0x00f0
            int r12 = r12 << 28
            int r14 = r14 + 112
            int r12 = r12 + r14
            int r12 = r12 >> 30
            if (r12 != 0) goto L_0x00f0
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 > r7) goto L_0x00f0
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 <= r7) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r12 = r14
        L_0x00ef:
            goto L_0x0092
        L_0x00f0:
            return r6
        L_0x00f1:
            r12 = r14
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzja.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: 0000 */
    public final String zzg(byte[] bArr, int i, int i2) throws zzgb {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte b = bArr[r13];
                if (!zziy.zzd(b)) {
                    break;
                }
                i = r13 + 1;
                int i5 = i4 + 1;
                zziy.zza(b, cArr, i4);
                i4 = i5;
            }
            int i6 = i4;
            while (r13 < i3) {
                int i7 = r13 + 1;
                byte b2 = bArr[r13];
                if (zziy.zzd(b2)) {
                    int i8 = i6 + 1;
                    zziy.zza(b2, cArr, i6);
                    while (i7 < i3) {
                        byte b3 = bArr[i7];
                        if (!zziy.zzd(b3)) {
                            break;
                        }
                        i7++;
                        int i9 = i8 + 1;
                        zziy.zza(b3, cArr, i8);
                        i8 = i9;
                    }
                    r13 = i7;
                    i6 = i8;
                } else if (zziy.zze(b2)) {
                    if (i7 < i3) {
                        int i10 = i7 + 1;
                        int i11 = i6 + 1;
                        zziy.zza(b2, bArr[i7], cArr, i6);
                        r13 = i10;
                        i6 = i11;
                    } else {
                        throw zzgb.zzhx();
                    }
                } else if (zziy.zzf(b2)) {
                    if (i7 < i3 - 1) {
                        int i12 = i7 + 1;
                        int i13 = i12 + 1;
                        int i14 = i6 + 1;
                        zziy.zza(b2, bArr[i7], bArr[i12], cArr, i6);
                        r13 = i13;
                        i6 = i14;
                    } else {
                        throw zzgb.zzhx();
                    }
                } else if (i7 < i3 - 2) {
                    int i15 = i7 + 1;
                    byte b4 = bArr[i7];
                    int i16 = i15 + 1;
                    int i17 = i16 + 1;
                    int i18 = i6 + 1;
                    zziy.zza(b2, b4, bArr[i15], bArr[i16], cArr, i6);
                    r13 = i17;
                    i6 = i18 + 1;
                } else {
                    throw zzgb.zzhx();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: 0000 */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = i2 + i;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + i;
            if (i5 >= i3) {
                break;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i5] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i3) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) charAt2;
                i6 = i7;
            } else if (charAt2 < 2048 && i6 <= i3 - 2) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i6 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i6 <= i3 - 3) {
                int i9 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 12) | 480);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
                i6 = i11;
            } else if (i6 <= i3 - 4) {
                int i12 = i4 + 1;
                if (i12 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i12);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i13 = i6 + 1;
                        bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i6 = i15 + 1;
                        bArr[i15] = (byte) ((codePoint & 63) | 128);
                        i4 = i12;
                    } else {
                        i4 = i12;
                    }
                }
                throw new zzjb(i4 - 1, length);
            } else {
                if (55296 <= charAt2 && charAt2 <= 57343) {
                    int i16 = i4 + 1;
                    if (i16 == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i16))) {
                        throw new zzjb(i4, length);
                    }
                }
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i6);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            i4++;
        }
        return i6;
    }
}

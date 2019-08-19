package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzwx<T> implements zzxj<T> {
    private static final int[] zzcax = new int[0];
    private static final Unsafe zzcay = zzyh.zzyk();
    private final int[] zzcaz;
    private final Object[] zzcba;
    private final int zzcbb;
    private final int zzcbc;
    private final zzwt zzcbd;
    private final boolean zzcbe;
    private final boolean zzcbf;
    private final boolean zzcbg;
    private final boolean zzcbh;
    private final int[] zzcbi;
    private final int zzcbj;
    private final int zzcbk;
    private final zzxa zzcbl;
    private final zzwd zzcbm;
    private final zzyb<?, ?> zzcbn;
    private final zzva<?> zzcbo;
    private final zzwo zzcbp;

    private zzwx(int[] iArr, Object[] objArr, int i, int i2, zzwt zzwt, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzxa zzxa, zzwd zzwd, zzyb<?, ?> zzyb, zzva<?> zzva, zzwo zzwo) {
        this.zzcaz = iArr;
        this.zzcba = objArr;
        this.zzcbb = i;
        this.zzcbc = i2;
        this.zzcbf = zzwt instanceof zzvm;
        this.zzcbg = z;
        this.zzcbe = zzva != null && zzva.zze(zzwt);
        this.zzcbh = false;
        this.zzcbi = iArr2;
        this.zzcbj = i3;
        this.zzcbk = i4;
        this.zzcbl = zzxa;
        this.zzcbm = zzwd;
        this.zzcbn = zzyb;
        this.zzcbo = zzva;
        this.zzcbd = zzwt;
        this.zzcbp = zzwo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzwx<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzwr r34, com.google.android.gms.internal.measurement.zzxa r35, com.google.android.gms.internal.measurement.zzwd r36, com.google.android.gms.internal.measurement.zzyb<?, ?> r37, com.google.android.gms.internal.measurement.zzva<?> r38, com.google.android.gms.internal.measurement.zzwo r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzxh
            if (r1 == 0) goto L_0x04b4
            com.google.android.gms.internal.measurement.zzxh r0 = (com.google.android.gms.internal.measurement.zzxh) r0
            int r1 = r0.zzxg()
            int r2 = com.google.android.gms.internal.measurement.zzvm.zze.zzbzc
            r3 = 0
            if (r1 != r2) goto L_0x0013
            r11 = 1
            goto L_0x0014
        L_0x0013:
            r11 = 0
        L_0x0014:
            java.lang.String r1 = r0.zzxp()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003f
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = r5
            r5 = 1
            r9 = 13
        L_0x002c:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x003c
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r8 = r8 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x002c
        L_0x003c:
            int r5 = r5 << r9
            r5 = r5 | r8
            goto L_0x0040
        L_0x003f:
            r10 = 1
        L_0x0040:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x0060
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004d:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005d
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004d
        L_0x005d:
            int r8 = r8 << r10
            r9 = r9 | r8
            goto L_0x0061
        L_0x0060:
            r12 = r8
        L_0x0061:
            if (r9 != 0) goto L_0x0076
            int[] r8 = zzcax
            r15 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            goto L_0x01b0
        L_0x0076:
            int r8 = r12 + 1
            char r9 = r1.charAt(r12)
            if (r9 < r7) goto L_0x0096
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0082:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r10
            r8 = r8 | r9
            r9 = r8
            goto L_0x0097
        L_0x0096:
            r12 = r8
        L_0x0097:
            int r8 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r7) goto L_0x00b7
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a4:
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r12
            r10 = r10 | r8
            int r12 = r12 + 13
            r8 = r13
            goto L_0x00a4
        L_0x00b4:
            int r8 = r8 << r12
            r10 = r10 | r8
            goto L_0x00b8
        L_0x00b7:
            r13 = r8
        L_0x00b8:
            int r8 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r7) goto L_0x00d9
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c5:
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00d5
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r13
            r12 = r12 | r8
            int r13 = r13 + 13
            r8 = r14
            goto L_0x00c5
        L_0x00d5:
            int r8 = r8 << r13
            r8 = r8 | r12
            r12 = r8
            goto L_0x00da
        L_0x00d9:
            r14 = r8
        L_0x00da:
            int r8 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r7) goto L_0x00fb
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e7:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00f7
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r14
            r13 = r13 | r8
            int r14 = r14 + 13
            r8 = r15
            goto L_0x00e7
        L_0x00f7:
            int r8 = r8 << r14
            r8 = r8 | r13
            r13 = r8
            goto L_0x00fc
        L_0x00fb:
            r15 = r8
        L_0x00fc:
            int r8 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r7) goto L_0x011f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x011a
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r15
            r14 = r14 | r8
            int r15 = r15 + 13
            r8 = r16
            goto L_0x0109
        L_0x011a:
            int r8 = r8 << r15
            r8 = r8 | r14
            r14 = r8
            r8 = r16
        L_0x011f:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0143
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012c:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x013e
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r8 = r8 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012c
        L_0x013e:
            int r15 = r15 << r16
            r8 = r8 | r15
            r15 = r17
        L_0x0143:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0170
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r32 = r16
            r16 = r15
            r15 = r32
        L_0x0156:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0169
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x0156
        L_0x0169:
            int r15 = r15 << r17
            r15 = r16 | r15
            r3 = r18
            goto L_0x0172
        L_0x0170:
            r3 = r16
        L_0x0172:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x019e
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r32 = r16
            r16 = r3
            r3 = r32
        L_0x0185:
            int r18 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0198
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r17
            r16 = r16 | r3
            int r17 = r17 + 13
            r3 = r18
            goto L_0x0185
        L_0x0198:
            int r3 = r3 << r17
            r3 = r16 | r3
            r16 = r18
        L_0x019e:
            int r17 = r3 + r8
            int r15 = r17 + r15
            int[] r15 = new int[r15]
            int r17 = r9 << 1
            int r10 = r17 + r10
            r32 = r16
            r16 = r9
            r9 = r12
            r12 = r32
        L_0x01b0:
            sun.misc.Unsafe r6 = zzcay
            java.lang.Object[] r17 = r0.zzxq()
            com.google.android.gms.internal.measurement.zzwt r18 = r0.zzxi()
            java.lang.Class r7 = r18.getClass()
            int r4 = r14 * 3
            int[] r4 = new int[r4]
            r18 = 1
            int r14 = r14 << 1
            java.lang.Object[] r14 = new java.lang.Object[r14]
            int r20 = r3 + r8
            r23 = r3
            r21 = r10
            r22 = r20
            r8 = 0
            r10 = 0
        L_0x01d4:
            if (r12 >= r2) goto L_0x0488
            int r24 = r12 + 1
            char r12 = r1.charAt(r12)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r2) goto L_0x020a
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r32 = r24
            r24 = r12
            r12 = r32
        L_0x01ed:
            int r27 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r2) goto L_0x0203
            r2 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r26
            r24 = r24 | r2
            int r26 = r26 + 13
            r12 = r27
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01ed
        L_0x0203:
            int r2 = r12 << r26
            r12 = r24 | r2
            r2 = r27
            goto L_0x020c
        L_0x020a:
            r2 = r24
        L_0x020c:
            int r24 = r2 + 1
            char r2 = r1.charAt(r2)
            r26 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r3) goto L_0x0241
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r27 = 13
            r32 = r24
            r24 = r2
            r2 = r32
        L_0x0224:
            int r28 = r2 + 1
            char r2 = r1.charAt(r2)
            if (r2 < r3) goto L_0x023a
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r27
            r24 = r24 | r2
            int r27 = r27 + 13
            r2 = r28
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0224
        L_0x023a:
            int r2 = r2 << r27
            r2 = r24 | r2
            r3 = r28
            goto L_0x0243
        L_0x0241:
            r3 = r24
        L_0x0243:
            r24 = r11
            r11 = r2 & 255(0xff, float:3.57E-43)
            r27 = r13
            r13 = r2 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0253
            int r13 = r8 + 1
            r15[r8] = r10
            r8 = r13
        L_0x0253:
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.MAP
            int r13 = r13.mo9228id()
            if (r11 <= r13) goto L_0x0319
            int r13 = r3 + 1
            char r3 = r1.charAt(r3)
            r28 = r8
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r8) goto L_0x0286
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r29 = 13
        L_0x026c:
            int r30 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r8) goto L_0x0281
            r8 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r29
            r3 = r3 | r8
            int r29 = r29 + 13
            r13 = r30
            r8 = 55296(0xd800, float:7.7486E-41)
            goto L_0x026c
        L_0x0281:
            int r8 = r13 << r29
            r3 = r3 | r8
            r13 = r30
        L_0x0286:
            com.google.android.gms.internal.measurement.zzvg r8 = com.google.android.gms.internal.measurement.zzvg.MESSAGE
            int r8 = r8.mo9228id()
            int r8 = r8 + 51
            if (r11 == r8) goto L_0x02c1
            com.google.android.gms.internal.measurement.zzvg r8 = com.google.android.gms.internal.measurement.zzvg.GROUP
            int r8 = r8.mo9228id()
            int r8 = r8 + 51
            if (r11 != r8) goto L_0x029e
            r29 = r13
            goto L_0x02c3
        L_0x029e:
            com.google.android.gms.internal.measurement.zzvg r8 = com.google.android.gms.internal.measurement.zzvg.ENUM
            int r8 = r8.mo9228id()
            int r8 = r8 + 51
            if (r11 != r8) goto L_0x02bd
            r8 = r5 & 1
            r29 = r13
            r13 = 1
            if (r8 != r13) goto L_0x02bf
            int r8 = r10 / 3
            int r8 = r8 << r13
            int r8 = r8 + r13
            int r13 = r21 + 1
            r21 = r17[r21]
            r14[r8] = r21
            r21 = r13
            r13 = 1
            goto L_0x02d0
        L_0x02bd:
            r29 = r13
        L_0x02bf:
            r13 = 1
            goto L_0x02d0
        L_0x02c1:
            r29 = r13
        L_0x02c3:
            int r8 = r10 / 3
            r13 = 1
            int r8 = r8 << r13
            int r8 = r8 + r13
            int r18 = r21 + 1
            r21 = r17[r21]
            r14[r8] = r21
            r21 = r18
        L_0x02d0:
            int r3 = r3 << r13
            r8 = r17[r3]
            boolean r13 = r8 instanceof java.lang.reflect.Field
            if (r13 == 0) goto L_0x02da
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02e2
        L_0x02da:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zza(r7, r8)
            r17[r3] = r8
        L_0x02e2:
            r13 = r9
            long r8 = r6.objectFieldOffset(r8)
            int r9 = (int) r8
            int r3 = r3 + 1
            r8 = r17[r3]
            r30 = r9
            boolean r9 = r8 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x02f5
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02fd
        L_0x02f5:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zza(r7, r8)
            r17[r3] = r8
        L_0x02fd:
            long r8 = r6.objectFieldOffset(r8)
            int r3 = (int) r8
            r31 = r1
            r8 = r3
            r1 = r7
            r19 = r21
            r9 = r30
            r3 = 0
            r18 = 1
            r21 = r0
            r0 = r14
            r32 = r29
            r29 = r13
            r13 = r32
            goto L_0x043e
        L_0x0319:
            r28 = r8
            r13 = r9
            int r8 = r21 + 1
            r9 = r17[r21]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza(r7, r9)
            com.google.android.gms.internal.measurement.zzvg r21 = com.google.android.gms.internal.measurement.zzvg.MESSAGE
            r29 = r13
            int r13 = r21.mo9228id()
            if (r11 == r13) goto L_0x03c6
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.GROUP
            int r13 = r13.mo9228id()
            if (r11 != r13) goto L_0x033d
            r21 = r0
            r13 = 1
            goto L_0x03c9
        L_0x033d:
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.MESSAGE_LIST
            int r13 = r13.mo9228id()
            if (r11 == r13) goto L_0x03b6
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.GROUP_LIST
            int r13 = r13.mo9228id()
            if (r11 != r13) goto L_0x0351
            r21 = r0
            goto L_0x03b8
        L_0x0351:
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.ENUM
            int r13 = r13.mo9228id()
            if (r11 == r13) goto L_0x03a0
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.ENUM_LIST
            int r13 = r13.mo9228id()
            if (r11 == r13) goto L_0x03a0
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.ENUM_LIST_PACKED
            int r13 = r13.mo9228id()
            if (r11 != r13) goto L_0x036a
            goto L_0x03a0
        L_0x036a:
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.MAP
            int r13 = r13.mo9228id()
            if (r11 != r13) goto L_0x039c
            int r13 = r23 + 1
            r15[r23] = r10
            int r21 = r10 / 3
            r18 = 1
            int r21 = r21 << 1
            int r23 = r8 + 1
            r8 = r17[r8]
            r14[r21] = r8
            r8 = r2 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0394
            int r21 = r21 + 1
            int r8 = r23 + 1
            r23 = r17[r23]
            r14[r21] = r23
            r21 = r0
            r23 = r13
            r13 = 1
            goto L_0x03d3
        L_0x0394:
            r21 = r0
            r8 = r23
            r23 = r13
            r13 = 1
            goto L_0x03d3
        L_0x039c:
            r21 = r0
            r13 = 1
            goto L_0x03d3
        L_0x03a0:
            r13 = r5 & 1
            r21 = r0
            r0 = 1
            if (r13 != r0) goto L_0x03b4
            int r13 = r10 / 3
            int r13 = r13 << r0
            int r13 = r13 + r0
            int r0 = r8 + 1
            r8 = r17[r8]
            r14[r13] = r8
            r8 = r0
            r13 = 1
            goto L_0x03d3
        L_0x03b4:
            r13 = 1
            goto L_0x03d3
        L_0x03b6:
            r21 = r0
        L_0x03b8:
            int r0 = r10 / 3
            r13 = 1
            int r0 = r0 << r13
            int r0 = r0 + r13
            int r18 = r8 + 1
            r8 = r17[r8]
            r14[r0] = r8
            r8 = r18
            goto L_0x03d3
        L_0x03c6:
            r21 = r0
            r13 = 1
        L_0x03c9:
            int r0 = r10 / 3
            int r0 = r0 << r13
            int r0 = r0 + r13
            java.lang.Class r18 = r9.getType()
            r14[r0] = r18
        L_0x03d3:
            r0 = r14
            long r13 = r6.objectFieldOffset(r9)
            int r9 = (int) r13
            r13 = r5 & 1
            r14 = 1
            if (r13 != r14) goto L_0x0433
            com.google.android.gms.internal.measurement.zzvg r13 = com.google.android.gms.internal.measurement.zzvg.GROUP
            int r13 = r13.mo9228id()
            if (r11 > r13) goto L_0x0433
            int r13 = r3 + 1
            char r3 = r1.charAt(r3)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x040c
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x03f5:
            int r30 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r14) goto L_0x0407
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r19
            r3 = r3 | r13
            int r19 = r19 + 13
            r13 = r30
            goto L_0x03f5
        L_0x0407:
            int r13 = r13 << r19
            r3 = r3 | r13
            r13 = r30
        L_0x040c:
            r18 = 1
            int r19 = r16 << 1
            int r30 = r3 / 32
            int r19 = r19 + r30
            r14 = r17[r19]
            r31 = r1
            boolean r1 = r14 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0420
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x0428
        L_0x0420:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = zza(r7, r14)
            r17[r19] = r14
        L_0x0428:
            r1 = r7
            r19 = r8
            long r7 = r6.objectFieldOffset(r14)
            int r8 = (int) r7
            int r3 = r3 % 32
            goto L_0x043e
        L_0x0433:
            r31 = r1
            r1 = r7
            r19 = r8
            r18 = 1
            r13 = r3
            r3 = 0
            r8 = 0
        L_0x043e:
            r7 = 18
            if (r11 < r7) goto L_0x044c
            r7 = 49
            if (r11 > r7) goto L_0x044c
            int r7 = r22 + 1
            r15[r22] = r9
            r22 = r7
        L_0x044c:
            int r7 = r10 + 1
            r4[r10] = r12
            int r10 = r7 + 1
            r12 = r2 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0459
            r12 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x045a
        L_0x0459:
            r12 = 0
        L_0x045a:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0461
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0462
        L_0x0461:
            r2 = 0
        L_0x0462:
            r2 = r2 | r12
            int r11 = r11 << 20
            r2 = r2 | r11
            r2 = r2 | r9
            r4[r7] = r2
            int r2 = r10 + 1
            int r3 = r3 << 20
            r3 = r3 | r8
            r4[r10] = r3
            r14 = r0
            r7 = r1
            r10 = r2
            r12 = r13
            r0 = r21
            r11 = r24
            r2 = r25
            r3 = r26
            r13 = r27
            r8 = r28
            r9 = r29
            r1 = r31
            r21 = r19
            goto L_0x01d4
        L_0x0488:
            r21 = r0
            r26 = r3
            r29 = r9
            r24 = r11
            r27 = r13
            r0 = r14
            com.google.android.gms.internal.measurement.zzwx r1 = new com.google.android.gms.internal.measurement.zzwx
            com.google.android.gms.internal.measurement.zzwt r10 = r21.zzxi()
            r12 = 0
            r5 = r1
            r6 = r4
            r7 = r0
            r8 = r29
            r9 = r27
            r13 = r15
            r14 = r26
            r15 = r20
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x04b4:
            com.google.android.gms.internal.measurement.zzxw r0 = (com.google.android.gms.internal.measurement.zzxw) r0
            r0.zzxg()
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x04c0
        L_0x04bf:
            throw r0
        L_0x04c0:
            goto L_0x04bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwx.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzwr, com.google.android.gms.internal.measurement.zzxa, com.google.android.gms.internal.measurement.zzwd, com.google.android.gms.internal.measurement.zzyb, com.google.android.gms.internal.measurement.zzva, com.google.android.gms.internal.measurement.zzwo):com.google.android.gms.internal.measurement.zzwx");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T newInstance() {
        return this.zzcbl.newInstance(this.zzcbd);
    }

    public final boolean equals(T t, T t2) {
        int length = this.zzcaz.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzbq = zzbq(i);
                long j = (long) (zzbq & 1048575);
                switch ((zzbq & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || zzyh.zzl(t, j) != zzyh.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzyh.zzl(t, j) != zzyh.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzyh.zzl(t, j) != zzyh.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzyh.zzl(t, j) != zzyh.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzyh.zzm(t, j) != zzyh.zzm(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzyh.zzl(t, j) != zzyh.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzyh.zzk(t, j) != zzyh.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzyh.zzl(t, j) != zzyh.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j));
                        break;
                    case 50:
                        z = zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zzbr = (long) (zzbr(i) & 1048575);
                        if (zzyh.zzk(t, zzbr) != zzyh.zzk(t2, zzbr) || !zzxl.zze(zzyh.zzp(t, j), zzyh.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzcbn.zzah(t).equals(this.zzcbn.zzah(t2))) {
                return false;
            } else {
                if (this.zzcbe) {
                    return this.zzcbo.zzs(t).equals(this.zzcbo.zzs(t2));
                }
                return true;
            }
        }
    }

    public final int hashCode(T t) {
        int length = this.zzcaz.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzbq = zzbq(i2);
            int i3 = this.zzcaz[i2];
            long j = (long) (1048575 & zzbq);
            int i4 = 37;
            switch ((zzbq & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzvo.zzbf(Double.doubleToLongBits(zzyh.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzyh.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzvo.zzbf(zzyh.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzvo.zzbf(zzyh.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzyh.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzvo.zzbf(zzyh.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzyh.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzvo.zzw(zzyh.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzyh.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zzyh.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzyh.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzyh.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zzyh.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zzyh.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzvo.zzbf(zzyh.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzyh.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzvo.zzbf(zzyh.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zzyh.zzp(t, j);
                    if (zzp2 != null) {
                        i4 = zzp2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzyh.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzyh.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzbf(Double.doubleToLongBits(zzf(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzg(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzbf(zzi(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzbf(zzi(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzbf(zzi(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzw(zzj(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzyh.zzp(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzyh.zzp(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzyh.zzp(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzbf(zzi(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzvo.zzbf(zzi(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzyh.zzp(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzcbn.zzah(t).hashCode();
        if (this.zzcbe) {
            return (hashCode * 53) + this.zzcbo.zzs(t).hashCode();
        }
        return hashCode;
    }

    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzcaz.length; i += 3) {
                int zzbq = zzbq(i);
                long j = (long) (1048575 & zzbq);
                int i2 = this.zzcaz[i];
                switch ((zzbq & 267386880) >>> 20) {
                    case 0:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzo(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 1:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzn(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 2:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 3:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 4:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zzb((Object) t, j, zzyh.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 5:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 6:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zzb((Object) t, j, zzyh.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 7:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzm(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 8:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzp(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzp(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 11:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zzb((Object) t, j, zzyh.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 12:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zzb((Object) t, j, zzyh.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 13:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zzb((Object) t, j, zzyh.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 14:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 15:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zzb((Object) t, j, zzyh.zzk(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 16:
                        if (!zzb(t2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzl(t2, j));
                            zzc(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzcbm.zza(t, t2, j);
                        break;
                    case 50:
                        zzxl.zza(this.zzcbp, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzyh.zza((Object) t, j, zzyh.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzcbg) {
                zzxl.zza(this.zzcbn, t, t2);
                if (this.zzcbe) {
                    zzxl.zza(this.zzcbo, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzbq = (long) (zzbq(i) & 1048575);
        if (zzb(t2, i)) {
            Object zzp = zzyh.zzp(t, zzbq);
            Object zzp2 = zzyh.zzp(t2, zzbq);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zzyh.zza((Object) t, zzbq, zzp2);
                    zzc(t, i);
                }
                return;
            }
            zzyh.zza((Object) t, zzbq, zzvo.zzb(zzp, zzp2));
            zzc(t, i);
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzbq = zzbq(i);
        int i2 = this.zzcaz[i];
        long j = (long) (zzbq & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzyh.zzp(t, j);
            Object zzp2 = zzyh.zzp(t2, j);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zzyh.zza((Object) t, j, zzp2);
                    zzb(t, i2, i);
                }
                return;
            }
            zzyh.zza((Object) t, j, zzvo.zzb(zzp, zzp2));
            zzb(t, i2, i);
        }
    }

    public final int zzae(T t) {
        int i;
        int i2;
        long j;
        int i3;
        T t2 = t;
        int i4 = 267386880;
        if (this.zzcbg) {
            Unsafe unsafe = zzcay;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.zzcaz.length) {
                int zzbq = zzbq(i5);
                int i7 = (zzbq & i4) >>> 20;
                int i8 = this.zzcaz[i5];
                long j2 = (long) (zzbq & 1048575);
                if (i7 < zzvg.DOUBLE_LIST_PACKED.mo9228id() || i7 > zzvg.SINT64_LIST_PACKED.mo9228id()) {
                    i3 = 0;
                } else {
                    i3 = this.zzcaz[i5 + 2] & 1048575;
                }
                switch (i7) {
                    case 0:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzb(i8, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzb(i8, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzd(i8, zzyh.zzl(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zze(i8, zzyh.zzl(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzh(i8, zzyh.zzk(t2, j2));
                            break;
                        }
                    case 5:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzg(i8, 0);
                            break;
                        }
                    case 6:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzk(i8, 0);
                            break;
                        }
                    case 7:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzc(i8, true);
                            break;
                        }
                    case 8:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            Object zzp = zzyh.zzp(t2, j2);
                            if (!(zzp instanceof zzud)) {
                                i6 += zzut.zzc(i8, (String) zzp);
                                break;
                            } else {
                                i6 += zzut.zzc(i8, (zzud) zzp);
                                break;
                            }
                        }
                    case 9:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzxl.zzc(i8, zzyh.zzp(t2, j2), zzbn(i5));
                            break;
                        }
                    case 10:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzc(i8, (zzud) zzyh.zzp(t2, j2));
                            break;
                        }
                    case 11:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzi(i8, zzyh.zzk(t2, j2));
                            break;
                        }
                    case 12:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzm(i8, zzyh.zzk(t2, j2));
                            break;
                        }
                    case 13:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzl(i8, 0);
                            break;
                        }
                    case 14:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzh(i8, 0);
                            break;
                        }
                    case 15:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzj(i8, zzyh.zzk(t2, j2));
                            break;
                        }
                    case 16:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzf(i8, zzyh.zzl(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zzb(t2, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzc(i8, (zzwt) zzyh.zzp(t2, j2), zzbn(i5));
                            break;
                        }
                    case 18:
                        i6 += zzxl.zzw(i8, zze(t2, j2), false);
                        break;
                    case 19:
                        i6 += zzxl.zzv(i8, zze(t2, j2), false);
                        break;
                    case 20:
                        i6 += zzxl.zzo(i8, zze(t2, j2), false);
                        break;
                    case 21:
                        i6 += zzxl.zzp(i8, zze(t2, j2), false);
                        break;
                    case 22:
                        i6 += zzxl.zzs(i8, zze(t2, j2), false);
                        break;
                    case 23:
                        i6 += zzxl.zzw(i8, zze(t2, j2), false);
                        break;
                    case 24:
                        i6 += zzxl.zzv(i8, zze(t2, j2), false);
                        break;
                    case 25:
                        i6 += zzxl.zzx(i8, zze(t2, j2), false);
                        break;
                    case 26:
                        i6 += zzxl.zzc(i8, zze(t2, j2));
                        break;
                    case 27:
                        i6 += zzxl.zzc(i8, zze(t2, j2), zzbn(i5));
                        break;
                    case 28:
                        i6 += zzxl.zzd(i8, zze(t2, j2));
                        break;
                    case 29:
                        i6 += zzxl.zzt(i8, zze(t2, j2), false);
                        break;
                    case 30:
                        i6 += zzxl.zzr(i8, zze(t2, j2), false);
                        break;
                    case 31:
                        i6 += zzxl.zzv(i8, zze(t2, j2), false);
                        break;
                    case 32:
                        i6 += zzxl.zzw(i8, zze(t2, j2), false);
                        break;
                    case 33:
                        i6 += zzxl.zzu(i8, zze(t2, j2), false);
                        break;
                    case 34:
                        i6 += zzxl.zzq(i8, zze(t2, j2), false);
                        break;
                    case 35:
                        int zzaf = zzxl.zzaf((List) unsafe.getObject(t2, j2));
                        if (zzaf > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzaf);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzaf) + zzaf;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzae = zzxl.zzae((List) unsafe.getObject(t2, j2));
                        if (zzae > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzae);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzae) + zzae;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zzx = zzxl.zzx((List) unsafe.getObject(t2, j2));
                        if (zzx > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzx);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzx) + zzx;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzy = zzxl.zzy((List) unsafe.getObject(t2, j2));
                        if (zzy > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzy);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzy) + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zzab = zzxl.zzab((List) unsafe.getObject(t2, j2));
                        if (zzab > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzab);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzab) + zzab;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzaf2 = zzxl.zzaf((List) unsafe.getObject(t2, j2));
                        if (zzaf2 > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzaf2);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzaf2) + zzaf2;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzae2 = zzxl.zzae((List) unsafe.getObject(t2, j2));
                        if (zzae2 > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzae2);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzae2) + zzae2;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int zzag = zzxl.zzag((List) unsafe.getObject(t2, j2));
                        if (zzag > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzag);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzag) + zzag;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzac = zzxl.zzac((List) unsafe.getObject(t2, j2));
                        if (zzac > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzac);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzac) + zzac;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int zzaa = zzxl.zzaa((List) unsafe.getObject(t2, j2));
                        if (zzaa > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzaa);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzaa) + zzaa;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzae3 = zzxl.zzae((List) unsafe.getObject(t2, j2));
                        if (zzae3 > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzae3);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzae3) + zzae3;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int zzaf3 = zzxl.zzaf((List) unsafe.getObject(t2, j2));
                        if (zzaf3 > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzaf3);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzaf3) + zzaf3;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzad = zzxl.zzad((List) unsafe.getObject(t2, j2));
                        if (zzad > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzad);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzad) + zzad;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzz = zzxl.zzz((List) unsafe.getObject(t2, j2));
                        if (zzz > 0) {
                            if (this.zzcbh) {
                                unsafe.putInt(t2, (long) i3, zzz);
                            }
                            i6 += zzut.zzbb(i8) + zzut.zzbd(zzz) + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i6 += zzxl.zzd(i8, zze(t2, j2), zzbn(i5));
                        break;
                    case 50:
                        i6 += this.zzcbp.zzb(i8, zzyh.zzp(t2, j2), zzbo(i5));
                        break;
                    case 51:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzb(i8, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzb(i8, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzd(i8, zzi(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zze(i8, zzi(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzh(i8, zzh(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzg(i8, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzk(i8, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzc(i8, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            Object zzp2 = zzyh.zzp(t2, j2);
                            if (!(zzp2 instanceof zzud)) {
                                i6 += zzut.zzc(i8, (String) zzp2);
                                break;
                            } else {
                                i6 += zzut.zzc(i8, (zzud) zzp2);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzxl.zzc(i8, zzyh.zzp(t2, j2), zzbn(i5));
                            break;
                        }
                    case 61:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzc(i8, (zzud) zzyh.zzp(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzi(i8, zzh(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzm(i8, zzh(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzl(i8, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzh(i8, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzj(i8, zzh(t2, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzf(i8, zzi(t2, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzut.zzc(i8, (zzwt) zzyh.zzp(t2, j2), zzbn(i5));
                            break;
                        }
                }
                i5 += 3;
                i4 = 267386880;
            }
            return i6 + zza(this.zzcbn, t2);
        }
        Unsafe unsafe2 = zzcay;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        while (i9 < this.zzcaz.length) {
            int zzbq2 = zzbq(i9);
            int[] iArr = this.zzcaz;
            int i13 = iArr[i9];
            int i14 = (zzbq2 & 267386880) >>> 20;
            if (i14 <= 17) {
                i2 = iArr[i9 + 2];
                int i15 = i2 & 1048575;
                i = 1 << (i2 >>> 20);
                if (i15 != i11) {
                    i12 = unsafe2.getInt(t2, (long) i15);
                } else {
                    i15 = i11;
                }
                i11 = i15;
            } else if (!this.zzcbh || i14 < zzvg.DOUBLE_LIST_PACKED.mo9228id() || i14 > zzvg.SINT64_LIST_PACKED.mo9228id()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzcaz[i9 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzbq2 & 1048575);
            switch (i14) {
                case 0:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzut.zzb(i13, 0.0d);
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzut.zzb(i13, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzut.zzd(i13, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzut.zze(i13, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzut.zzh(i13, unsafe2.getInt(t2, j3));
                        break;
                    }
                case 5:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        i10 += zzut.zzg(i13, 0);
                        break;
                    }
                case 6:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzk(i13, 0);
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzc(i13, true);
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzud)) {
                            i10 += zzut.zzc(i13, (String) object);
                            j = 0;
                            break;
                        } else {
                            i10 += zzut.zzc(i13, (zzud) object);
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzxl.zzc(i13, unsafe2.getObject(t2, j3), zzbn(i9));
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzc(i13, (zzud) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzi(i13, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzm(i13, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzl(i13, 0);
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzh(i13, 0);
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzj(i13, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzf(i13, unsafe2.getLong(t2, j3));
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzc(i13, (zzwt) unsafe2.getObject(t2, j3), zzbn(i9));
                        j = 0;
                        break;
                    }
                case 18:
                    i10 += zzxl.zzw(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 19:
                    i10 += zzxl.zzv(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 20:
                    i10 += zzxl.zzo(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 21:
                    i10 += zzxl.zzp(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 22:
                    i10 += zzxl.zzs(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 23:
                    i10 += zzxl.zzw(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 24:
                    i10 += zzxl.zzv(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 25:
                    i10 += zzxl.zzx(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 26:
                    i10 += zzxl.zzc(i13, (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 27:
                    i10 += zzxl.zzc(i13, (List) unsafe2.getObject(t2, j3), zzbn(i9));
                    j = 0;
                    break;
                case 28:
                    i10 += zzxl.zzd(i13, (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 29:
                    i10 += zzxl.zzt(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 30:
                    i10 += zzxl.zzr(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 31:
                    i10 += zzxl.zzv(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 32:
                    i10 += zzxl.zzw(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 33:
                    i10 += zzxl.zzu(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 34:
                    i10 += zzxl.zzq(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzaf4 = zzxl.zzaf((List) unsafe2.getObject(t2, j3));
                    if (zzaf4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzaf4);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzaf4) + zzaf4;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzae4 = zzxl.zzae((List) unsafe2.getObject(t2, j3));
                    if (zzae4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzae4);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzae4) + zzae4;
                        j = 0;
                        break;
                    }
                case 37:
                    int zzx2 = zzxl.zzx((List) unsafe2.getObject(t2, j3));
                    if (zzx2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzx2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzx2) + zzx2;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzy2 = zzxl.zzy((List) unsafe2.getObject(t2, j3));
                    if (zzy2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzy2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzy2) + zzy2;
                        j = 0;
                        break;
                    }
                case 39:
                    int zzab2 = zzxl.zzab((List) unsafe2.getObject(t2, j3));
                    if (zzab2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzab2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzab2) + zzab2;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzaf5 = zzxl.zzaf((List) unsafe2.getObject(t2, j3));
                    if (zzaf5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzaf5);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzaf5) + zzaf5;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzae5 = zzxl.zzae((List) unsafe2.getObject(t2, j3));
                    if (zzae5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzae5);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzae5) + zzae5;
                        j = 0;
                        break;
                    }
                case 42:
                    int zzag2 = zzxl.zzag((List) unsafe2.getObject(t2, j3));
                    if (zzag2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzag2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzag2) + zzag2;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzac2 = zzxl.zzac((List) unsafe2.getObject(t2, j3));
                    if (zzac2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzac2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzac2) + zzac2;
                        j = 0;
                        break;
                    }
                case 44:
                    int zzaa2 = zzxl.zzaa((List) unsafe2.getObject(t2, j3));
                    if (zzaa2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzaa2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzaa2) + zzaa2;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzae6 = zzxl.zzae((List) unsafe2.getObject(t2, j3));
                    if (zzae6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzae6);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzae6) + zzae6;
                        j = 0;
                        break;
                    }
                case 46:
                    int zzaf6 = zzxl.zzaf((List) unsafe2.getObject(t2, j3));
                    if (zzaf6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzaf6);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzaf6) + zzaf6;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzad2 = zzxl.zzad((List) unsafe2.getObject(t2, j3));
                    if (zzad2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzad2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzad2) + zzad2;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzz2 = zzxl.zzz((List) unsafe2.getObject(t2, j3));
                    if (zzz2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzcbh) {
                            unsafe2.putInt(t2, (long) i2, zzz2);
                        }
                        i10 += zzut.zzbb(i13) + zzut.zzbd(zzz2) + zzz2;
                        j = 0;
                        break;
                    }
                case 49:
                    i10 += zzxl.zzd(i13, (List) unsafe2.getObject(t2, j3), zzbn(i9));
                    j = 0;
                    break;
                case 50:
                    i10 += this.zzcbp.zzb(i13, unsafe2.getObject(t2, j3), zzbo(i9));
                    j = 0;
                    break;
                case 51:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzb(i13, 0.0d);
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzb(i13, 0.0f);
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzd(i13, zzi(t2, j3));
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zze(i13, zzi(t2, j3));
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzh(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzg(i13, 0);
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzk(i13, 0);
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzc(i13, true);
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzud)) {
                            i10 += zzut.zzc(i13, (String) object2);
                            j = 0;
                            break;
                        } else {
                            i10 += zzut.zzc(i13, (zzud) object2);
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzxl.zzc(i13, unsafe2.getObject(t2, j3), zzbn(i9));
                        j = 0;
                        break;
                    }
                case 61:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzc(i13, (zzud) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzi(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzm(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzl(i13, 0);
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzh(i13, 0);
                        j = 0;
                        break;
                    }
                case 66:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzj(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 67:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzf(i13, zzi(t2, j3));
                        j = 0;
                        break;
                    }
                case 68:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzut.zzc(i13, (zzwt) unsafe2.getObject(t2, j3), zzbn(i9));
                        j = 0;
                        break;
                    }
                default:
                    j = 0;
                    break;
            }
            i9 += 3;
            long j4 = j;
        }
        int zza = i10 + zza(this.zzcbn, t2);
        if (this.zzcbe) {
            zza += this.zzcbo.zzs(t2).zzvu();
        }
        return zza;
    }

    private static <UT, UB> int zza(zzyb<UT, UB> zzyb, T t) {
        return zzyb.zzae(zzyb.zzah(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zzyh.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05aa  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b59  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzyw r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzvj()
            int r1 = com.google.android.gms.internal.measurement.zzvm.zze.zzbzf
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c0
            com.google.android.gms.internal.measurement.zzyb<?, ?> r0 = r13.zzcbn
            zza(r0, (T) r14, r15)
            boolean r0 = r13.zzcbe
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.zzva<?> r0 = r13.zzcbo
            com.google.android.gms.internal.measurement.zzvd r0 = r0.zzs(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0033
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0035
        L_0x0033:
            r0 = r3
            r1 = r0
        L_0x0035:
            int[] r7 = r13.zzcaz
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x003a:
            if (r7 < 0) goto L_0x05a8
            int r8 = r13.zzbq(r7)
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
        L_0x0046:
            if (r1 == 0) goto L_0x0064
            com.google.android.gms.internal.measurement.zzva<?> r10 = r13.zzcbo
            int r10 = r10.zzb(r1)
            if (r10 <= r9) goto L_0x0064
            com.google.android.gms.internal.measurement.zzva<?> r10 = r13.zzcbo
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0046
        L_0x0062:
            r1 = r3
            goto L_0x0046
        L_0x0064:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0593;
                case 1: goto L_0x0581;
                case 2: goto L_0x056f;
                case 3: goto L_0x055d;
                case 4: goto L_0x054b;
                case 5: goto L_0x0539;
                case 6: goto L_0x0527;
                case 7: goto L_0x0514;
                case 8: goto L_0x0502;
                case 9: goto L_0x04ec;
                case 10: goto L_0x04d8;
                case 11: goto L_0x04c5;
                case 12: goto L_0x04b2;
                case 13: goto L_0x049f;
                case 14: goto L_0x048c;
                case 15: goto L_0x0479;
                case 16: goto L_0x0466;
                case 17: goto L_0x0450;
                case 18: goto L_0x043c;
                case 19: goto L_0x0428;
                case 20: goto L_0x0414;
                case 21: goto L_0x0400;
                case 22: goto L_0x03ec;
                case 23: goto L_0x03d8;
                case 24: goto L_0x03c4;
                case 25: goto L_0x03b0;
                case 26: goto L_0x039c;
                case 27: goto L_0x0384;
                case 28: goto L_0x0370;
                case 29: goto L_0x035c;
                case 30: goto L_0x0348;
                case 31: goto L_0x0334;
                case 32: goto L_0x0320;
                case 33: goto L_0x030c;
                case 34: goto L_0x02f8;
                case 35: goto L_0x02e4;
                case 36: goto L_0x02d0;
                case 37: goto L_0x02bc;
                case 38: goto L_0x02a8;
                case 39: goto L_0x0294;
                case 40: goto L_0x0280;
                case 41: goto L_0x026c;
                case 42: goto L_0x0258;
                case 43: goto L_0x0244;
                case 44: goto L_0x0230;
                case 45: goto L_0x021c;
                case 46: goto L_0x0208;
                case 47: goto L_0x01f4;
                case 48: goto L_0x01e0;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bc;
                case 51: goto L_0x01aa;
                case 52: goto L_0x0198;
                case 53: goto L_0x0186;
                case 54: goto L_0x0174;
                case 55: goto L_0x0162;
                case 56: goto L_0x0150;
                case 57: goto L_0x013e;
                case 58: goto L_0x012c;
                case 59: goto L_0x011a;
                case 60: goto L_0x0104;
                case 61: goto L_0x00f0;
                case 62: goto L_0x00de;
                case 63: goto L_0x00cc;
                case 64: goto L_0x00ba;
                case 65: goto L_0x00a8;
                case 66: goto L_0x0096;
                case 67: goto L_0x0084;
                case 68: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x05a4
        L_0x006e:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            com.google.android.gms.internal.measurement.zzxj r10 = r13.zzbn(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x05a4
        L_0x0084:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x05a4
        L_0x0096:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x05a4
        L_0x00a8:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x05a4
        L_0x00ba:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x05a4
        L_0x00cc:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x05a4
        L_0x00de:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zze(r9, r8)
            goto L_0x05a4
        L_0x00f0:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            com.google.android.gms.internal.measurement.zzud r8 = (com.google.android.gms.internal.measurement.zzud) r8
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x0104:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            com.google.android.gms.internal.measurement.zzxj r10 = r13.zzbn(r7)
            r15.zza(r9, r8, r10)
            goto L_0x05a4
        L_0x011a:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x05a4
        L_0x012c:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x05a4
        L_0x013e:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x05a4
        L_0x0150:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x05a4
        L_0x0162:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x05a4
        L_0x0174:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza(r9, r10)
            goto L_0x05a4
        L_0x0186:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x05a4
        L_0x0198:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x01aa:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zza(r9, r10)
            goto L_0x05a4
        L_0x01bc:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x05a4
        L_0x01c8:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxj r10 = r13.zzbn(r7)
            com.google.android.gms.internal.measurement.zzxl.zzb(r9, r8, r15, r10)
            goto L_0x05a4
        L_0x01e0:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zze(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x01f4:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzj(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0208:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzg(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x021c:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzl(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0230:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzm(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0244:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzi(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0258:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzn(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x026c:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzk(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0280:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzf(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0294:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzh(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02a8:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzd(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02bc:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzc(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02d0:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzb(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02e4:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zza(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02f8:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zze(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x030c:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzj(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0320:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzg(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0334:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzl(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0348:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzm(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x035c:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzi(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0370:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzb(r9, r8, r15)
            goto L_0x05a4
        L_0x0384:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxj r10 = r13.zzbn(r7)
            com.google.android.gms.internal.measurement.zzxl.zza(r9, r8, r15, r10)
            goto L_0x05a4
        L_0x039c:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zza(r9, r8, r15)
            goto L_0x05a4
        L_0x03b0:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzn(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03c4:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzk(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03d8:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzf(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03ec:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzh(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0400:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzd(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0414:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzc(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0428:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zzb(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x043c:
            int[] r9 = r13.zzcaz
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzxl.zza(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0450:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            com.google.android.gms.internal.measurement.zzxj r10 = r13.zzbn(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x05a4
        L_0x0466:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x05a4
        L_0x0479:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x05a4
        L_0x048c:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x05a4
        L_0x049f:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x05a4
        L_0x04b2:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x05a4
        L_0x04c5:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r10)
            r15.zze(r9, r8)
            goto L_0x05a4
        L_0x04d8:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            com.google.android.gms.internal.measurement.zzud r8 = (com.google.android.gms.internal.measurement.zzud) r8
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x04ec:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            com.google.android.gms.internal.measurement.zzxj r10 = r13.zzbn(r7)
            r15.zza(r9, r8, r10)
            goto L_0x05a4
        L_0x0502:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x05a4
        L_0x0514:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzyh.zzm(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x05a4
        L_0x0527:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x05a4
        L_0x0539:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x05a4
        L_0x054b:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x05a4
        L_0x055d:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r10)
            r15.zza(r9, r10)
            goto L_0x05a4
        L_0x056f:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x05a4
        L_0x0581:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzyh.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x0593:
            boolean r10 = r13.zzb((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzyh.zzo(r14, r10)
            r15.zza(r9, r10)
        L_0x05a4:
            int r7 = r7 + -3
            goto L_0x003a
        L_0x05a8:
            if (r1 == 0) goto L_0x05bf
            com.google.android.gms.internal.measurement.zzva<?> r14 = r13.zzcbo
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x05bd
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x05a8
        L_0x05bd:
            r1 = r3
            goto L_0x05a8
        L_0x05bf:
            return
        L_0x05c0:
            boolean r0 = r13.zzcbg
            if (r0 == 0) goto L_0x0b74
            boolean r0 = r13.zzcbe
            if (r0 == 0) goto L_0x05e2
            com.google.android.gms.internal.measurement.zzva<?> r0 = r13.zzcbo
            com.google.android.gms.internal.measurement.zzvd r0 = r0.zzs(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x05e2
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05e4
        L_0x05e2:
            r0 = r3
            r1 = r0
        L_0x05e4:
            int[] r7 = r13.zzcaz
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x05e9:
            if (r1 >= r7) goto L_0x0b57
            int r9 = r13.zzbq(r1)
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
        L_0x05f5:
            if (r8 == 0) goto L_0x0613
            com.google.android.gms.internal.measurement.zzva<?> r11 = r13.zzcbo
            int r11 = r11.zzb(r8)
            if (r11 > r10) goto L_0x0613
            com.google.android.gms.internal.measurement.zzva<?> r11 = r13.zzcbo
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0611
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x05f5
        L_0x0611:
            r8 = r3
            goto L_0x05f5
        L_0x0613:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0b42;
                case 1: goto L_0x0b30;
                case 2: goto L_0x0b1e;
                case 3: goto L_0x0b0c;
                case 4: goto L_0x0afa;
                case 5: goto L_0x0ae8;
                case 6: goto L_0x0ad6;
                case 7: goto L_0x0ac3;
                case 8: goto L_0x0ab1;
                case 9: goto L_0x0a9b;
                case 10: goto L_0x0a87;
                case 11: goto L_0x0a74;
                case 12: goto L_0x0a61;
                case 13: goto L_0x0a4e;
                case 14: goto L_0x0a3b;
                case 15: goto L_0x0a28;
                case 16: goto L_0x0a15;
                case 17: goto L_0x09ff;
                case 18: goto L_0x09eb;
                case 19: goto L_0x09d7;
                case 20: goto L_0x09c3;
                case 21: goto L_0x09af;
                case 22: goto L_0x099b;
                case 23: goto L_0x0987;
                case 24: goto L_0x0973;
                case 25: goto L_0x095f;
                case 26: goto L_0x094b;
                case 27: goto L_0x0933;
                case 28: goto L_0x091f;
                case 29: goto L_0x090b;
                case 30: goto L_0x08f7;
                case 31: goto L_0x08e3;
                case 32: goto L_0x08cf;
                case 33: goto L_0x08bb;
                case 34: goto L_0x08a7;
                case 35: goto L_0x0893;
                case 36: goto L_0x087f;
                case 37: goto L_0x086b;
                case 38: goto L_0x0857;
                case 39: goto L_0x0843;
                case 40: goto L_0x082f;
                case 41: goto L_0x081b;
                case 42: goto L_0x0807;
                case 43: goto L_0x07f3;
                case 44: goto L_0x07df;
                case 45: goto L_0x07cb;
                case 46: goto L_0x07b7;
                case 47: goto L_0x07a3;
                case 48: goto L_0x078f;
                case 49: goto L_0x0777;
                case 50: goto L_0x076b;
                case 51: goto L_0x0759;
                case 52: goto L_0x0747;
                case 53: goto L_0x0735;
                case 54: goto L_0x0723;
                case 55: goto L_0x0711;
                case 56: goto L_0x06ff;
                case 57: goto L_0x06ed;
                case 58: goto L_0x06db;
                case 59: goto L_0x06c9;
                case 60: goto L_0x06b3;
                case 61: goto L_0x069f;
                case 62: goto L_0x068d;
                case 63: goto L_0x067b;
                case 64: goto L_0x0669;
                case 65: goto L_0x0657;
                case 66: goto L_0x0645;
                case 67: goto L_0x0633;
                case 68: goto L_0x061d;
                default: goto L_0x061b;
            }
        L_0x061b:
            goto L_0x0b53
        L_0x061d:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            com.google.android.gms.internal.measurement.zzxj r11 = r13.zzbn(r1)
            r15.zzb(r10, r9, r11)
            goto L_0x0b53
        L_0x0633:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0b53
        L_0x0645:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0b53
        L_0x0657:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0b53
        L_0x0669:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0b53
        L_0x067b:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0b53
        L_0x068d:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0b53
        L_0x069f:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            com.google.android.gms.internal.measurement.zzud r9 = (com.google.android.gms.internal.measurement.zzud) r9
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x06b3:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            com.google.android.gms.internal.measurement.zzxj r11 = r13.zzbn(r1)
            r15.zza(r10, r9, r11)
            goto L_0x0b53
        L_0x06c9:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0b53
        L_0x06db:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0b53
        L_0x06ed:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0b53
        L_0x06ff:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0b53
        L_0x0711:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0b53
        L_0x0723:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0b53
        L_0x0735:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0b53
        L_0x0747:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x0759:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0b53
        L_0x076b:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            r13.zza(r15, r10, r9, r1)
            goto L_0x0b53
        L_0x0777:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxj r11 = r13.zzbn(r1)
            com.google.android.gms.internal.measurement.zzxl.zzb(r10, r9, r15, r11)
            goto L_0x0b53
        L_0x078f:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zze(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07a3:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzj(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07b7:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzg(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07cb:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzl(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07df:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzm(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07f3:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzi(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0807:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzn(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x081b:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzk(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x082f:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzf(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0843:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzh(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0857:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzd(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x086b:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzc(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x087f:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzb(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0893:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zza(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x08a7:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zze(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08bb:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzj(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08cf:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzg(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08e3:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzl(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08f7:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzm(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x090b:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzi(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x091f:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzb(r10, r9, r15)
            goto L_0x0b53
        L_0x0933:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxj r11 = r13.zzbn(r1)
            com.google.android.gms.internal.measurement.zzxl.zza(r10, r9, r15, r11)
            goto L_0x0b53
        L_0x094b:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zza(r10, r9, r15)
            goto L_0x0b53
        L_0x095f:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzn(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x0973:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzk(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x0987:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzf(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x099b:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzh(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09af:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzd(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09c3:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzc(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09d7:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzb(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09eb:
            int[] r10 = r13.zzcaz
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zza(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09ff:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            com.google.android.gms.internal.measurement.zzxj r11 = r13.zzbn(r1)
            r15.zzb(r10, r9, r11)
            goto L_0x0b53
        L_0x0a15:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0b53
        L_0x0a28:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0b53
        L_0x0a3b:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0b53
        L_0x0a4e:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0b53
        L_0x0a61:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0b53
        L_0x0a74:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0b53
        L_0x0a87:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            com.google.android.gms.internal.measurement.zzud r9 = (com.google.android.gms.internal.measurement.zzud) r9
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x0a9b:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            com.google.android.gms.internal.measurement.zzxj r11 = r13.zzbn(r1)
            r15.zza(r10, r9, r11)
            goto L_0x0b53
        L_0x0ab1:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzyh.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0b53
        L_0x0ac3:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzyh.zzm(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0b53
        L_0x0ad6:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0b53
        L_0x0ae8:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0b53
        L_0x0afa:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzyh.zzk(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0b53
        L_0x0b0c:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0b53
        L_0x0b1e:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzyh.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0b53
        L_0x0b30:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzyh.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x0b42:
            boolean r11 = r13.zzb((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzyh.zzo(r14, r11)
            r15.zza(r10, r11)
        L_0x0b53:
            int r1 = r1 + 3
            goto L_0x05e9
        L_0x0b57:
            if (r8 == 0) goto L_0x0b6e
            com.google.android.gms.internal.measurement.zzva<?> r1 = r13.zzcbo
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b6c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0b57
        L_0x0b6c:
            r8 = r3
            goto L_0x0b57
        L_0x0b6e:
            com.google.android.gms.internal.measurement.zzyb<?, ?> r0 = r13.zzcbn
            zza(r0, (T) r14, r15)
            return
        L_0x0b74:
            r13.zzb((T) r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwx.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzyw):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.measurement.zzyw r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzcbe
            if (r3 == 0) goto L_0x0022
            com.google.android.gms.internal.measurement.zzva<?> r3 = r0.zzcbo
            com.google.android.gms.internal.measurement.zzvd r3 = r3.zzs(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0022
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0024
        L_0x0022:
            r3 = 0
            r5 = 0
        L_0x0024:
            r6 = -1
            int[] r7 = r0.zzcaz
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzcay
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x056e
            int r12 = r0.zzbq(r5)
            int[] r13 = r0.zzcaz
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzcbg
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x006a
            r4 = 17
            if (r15 > r4) goto L_0x006a
            int r4 = r5 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r6) goto L_0x005e
            r17 = r10
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            goto L_0x0061
        L_0x005e:
            r17 = r10
            r13 = r6
        L_0x0061:
            int r4 = r4 >>> 20
            r6 = 1
            int r9 = r6 << r4
            r6 = r13
            r10 = r17
            goto L_0x006f
        L_0x006a:
            r17 = r10
            r10 = r17
            r9 = 0
        L_0x006f:
            if (r10 == 0) goto L_0x008e
            com.google.android.gms.internal.measurement.zzva<?> r4 = r0.zzcbo
            int r4 = r4.zzb(r10)
            if (r4 > r14) goto L_0x008e
            com.google.android.gms.internal.measurement.zzva<?> r4 = r0.zzcbo
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x006f
        L_0x008c:
            r10 = 0
            goto L_0x006f
        L_0x008e:
            r4 = r12 & r16
            long r12 = (long) r4
            switch(r15) {
                case 0: goto L_0x055d;
                case 1: goto L_0x054f;
                case 2: goto L_0x0542;
                case 3: goto L_0x0535;
                case 4: goto L_0x0528;
                case 5: goto L_0x051b;
                case 6: goto L_0x050e;
                case 7: goto L_0x0500;
                case 8: goto L_0x04f2;
                case 9: goto L_0x04e0;
                case 10: goto L_0x04d0;
                case 11: goto L_0x04c2;
                case 12: goto L_0x04b4;
                case 13: goto L_0x04a6;
                case 14: goto L_0x0498;
                case 15: goto L_0x048a;
                case 16: goto L_0x047c;
                case 17: goto L_0x0469;
                case 18: goto L_0x0457;
                case 19: goto L_0x0444;
                case 20: goto L_0x0431;
                case 21: goto L_0x041e;
                case 22: goto L_0x040b;
                case 23: goto L_0x03f8;
                case 24: goto L_0x03e5;
                case 25: goto L_0x03d2;
                case 26: goto L_0x03c0;
                case 27: goto L_0x03a9;
                case 28: goto L_0x0397;
                case 29: goto L_0x0384;
                case 30: goto L_0x0371;
                case 31: goto L_0x035e;
                case 32: goto L_0x034b;
                case 33: goto L_0x0338;
                case 34: goto L_0x0325;
                case 35: goto L_0x0312;
                case 36: goto L_0x02ff;
                case 37: goto L_0x02ec;
                case 38: goto L_0x02d9;
                case 39: goto L_0x02c6;
                case 40: goto L_0x02b3;
                case 41: goto L_0x02a0;
                case 42: goto L_0x028d;
                case 43: goto L_0x027a;
                case 44: goto L_0x0267;
                case 45: goto L_0x0254;
                case 46: goto L_0x0241;
                case 47: goto L_0x022e;
                case 48: goto L_0x021b;
                case 49: goto L_0x0204;
                case 50: goto L_0x01fa;
                case 51: goto L_0x01e7;
                case 52: goto L_0x01d4;
                case 53: goto L_0x01c1;
                case 54: goto L_0x01ae;
                case 55: goto L_0x019b;
                case 56: goto L_0x0188;
                case 57: goto L_0x0175;
                case 58: goto L_0x0162;
                case 59: goto L_0x014f;
                case 60: goto L_0x0138;
                case 61: goto L_0x0123;
                case 62: goto L_0x0110;
                case 63: goto L_0x00fd;
                case 64: goto L_0x00ea;
                case 65: goto L_0x00d7;
                case 66: goto L_0x00c4;
                case 67: goto L_0x00b1;
                case 68: goto L_0x0099;
                default: goto L_0x0096;
            }
        L_0x0096:
            r15 = 0
            goto L_0x056a
        L_0x0099:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x00ae
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzxj r9 = r0.zzbn(r5)
            r2.zzb(r14, r4, r9)
            r15 = 0
            goto L_0x056a
        L_0x00ae:
            r15 = 0
            goto L_0x056a
        L_0x00b1:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x00c1
            long r12 = zzi(r1, r12)
            r2.zzb(r14, r12)
            r15 = 0
            goto L_0x056a
        L_0x00c1:
            r15 = 0
            goto L_0x056a
        L_0x00c4:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x00d4
            int r4 = zzh(r1, r12)
            r2.zzf(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x00d4:
            r15 = 0
            goto L_0x056a
        L_0x00d7:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x00e7
            long r12 = zzi(r1, r12)
            r2.zzj(r14, r12)
            r15 = 0
            goto L_0x056a
        L_0x00e7:
            r15 = 0
            goto L_0x056a
        L_0x00ea:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x00fa
            int r4 = zzh(r1, r12)
            r2.zzn(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x00fa:
            r15 = 0
            goto L_0x056a
        L_0x00fd:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x010d
            int r4 = zzh(r1, r12)
            r2.zzo(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x010d:
            r15 = 0
            goto L_0x056a
        L_0x0110:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0120
            int r4 = zzh(r1, r12)
            r2.zze(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x0120:
            r15 = 0
            goto L_0x056a
        L_0x0123:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0135
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzud r4 = (com.google.android.gms.internal.measurement.zzud) r4
            r2.zza(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x0135:
            r15 = 0
            goto L_0x056a
        L_0x0138:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x014c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzxj r9 = r0.zzbn(r5)
            r2.zza(r14, r4, r9)
            r15 = 0
            goto L_0x056a
        L_0x014c:
            r15 = 0
            goto L_0x056a
        L_0x014f:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x015f
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza(r14, r4, r2)
            r15 = 0
            goto L_0x056a
        L_0x015f:
            r15 = 0
            goto L_0x056a
        L_0x0162:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0172
            boolean r4 = zzj(r1, r12)
            r2.zzb(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x0172:
            r15 = 0
            goto L_0x056a
        L_0x0175:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0185
            int r4 = zzh(r1, r12)
            r2.zzg(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x0185:
            r15 = 0
            goto L_0x056a
        L_0x0188:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0198
            long r12 = zzi(r1, r12)
            r2.zzc(r14, r12)
            r15 = 0
            goto L_0x056a
        L_0x0198:
            r15 = 0
            goto L_0x056a
        L_0x019b:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x01ab
            int r4 = zzh(r1, r12)
            r2.zzd(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x01ab:
            r15 = 0
            goto L_0x056a
        L_0x01ae:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x01be
            long r12 = zzi(r1, r12)
            r2.zza(r14, r12)
            r15 = 0
            goto L_0x056a
        L_0x01be:
            r15 = 0
            goto L_0x056a
        L_0x01c1:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x01d1
            long r12 = zzi(r1, r12)
            r2.zzi(r14, r12)
            r15 = 0
            goto L_0x056a
        L_0x01d1:
            r15 = 0
            goto L_0x056a
        L_0x01d4:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x01e4
            float r4 = zzg(r1, r12)
            r2.zza(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x01e4:
            r15 = 0
            goto L_0x056a
        L_0x01e7:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x01f7
            double r12 = zzf(r1, r12)
            r2.zza(r14, r12)
            r15 = 0
            goto L_0x056a
        L_0x01f7:
            r15 = 0
            goto L_0x056a
        L_0x01fa:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.zza(r2, r14, r4, r5)
            r15 = 0
            goto L_0x056a
        L_0x0204:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxj r12 = r0.zzbn(r5)
            com.google.android.gms.internal.measurement.zzxl.zzb(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x021b:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zze(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x022e:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzj(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0241:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzg(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0254:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzl(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0267:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzm(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x027a:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzi(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x028d:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzn(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02a0:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzk(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02b3:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzf(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02c6:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzh(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02d9:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzd(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02ec:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzc(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02ff:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zzb(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0312:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.measurement.zzxl.zza(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0325:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zze(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0338:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzj(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x034b:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzg(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x035e:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzl(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0371:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzm(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0384:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzi(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0397:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zzb(r4, r9, r2)
            r15 = 0
            goto L_0x056a
        L_0x03a9:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxj r12 = r0.zzbn(r5)
            com.google.android.gms.internal.measurement.zzxl.zza(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x03c0:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzxl.zza(r4, r9, r2)
            r15 = 0
            goto L_0x056a
        L_0x03d2:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzn(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x03e5:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzk(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x03f8:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzf(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x040b:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzh(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x041e:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzd(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0431:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzc(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0444:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.measurement.zzxl.zzb(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0457:
            int[] r4 = r0.zzcaz
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.measurement.zzxl.zza(r4, r9, r2, r15)
            goto L_0x056a
        L_0x0469:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzxj r9 = r0.zzbn(r5)
            r2.zzb(r14, r4, r9)
            goto L_0x056a
        L_0x047c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            long r12 = r8.getLong(r1, r12)
            r2.zzb(r14, r12)
            goto L_0x056a
        L_0x048a:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x056a
        L_0x0498:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            long r12 = r8.getLong(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x056a
        L_0x04a6:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x056a
        L_0x04b4:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x056a
        L_0x04c2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zze(r14, r4)
            goto L_0x056a
        L_0x04d0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzud r4 = (com.google.android.gms.internal.measurement.zzud) r4
            r2.zza(r14, r4)
            goto L_0x056a
        L_0x04e0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzxj r9 = r0.zzbn(r5)
            r2.zza(r14, r4, r9)
            goto L_0x056a
        L_0x04f2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza(r14, r4, r2)
            goto L_0x056a
        L_0x0500:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            boolean r4 = com.google.android.gms.internal.measurement.zzyh.zzm(r1, r12)
            r2.zzb(r14, r4)
            goto L_0x056a
        L_0x050e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x056a
        L_0x051b:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            long r12 = r8.getLong(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x056a
        L_0x0528:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzd(r14, r4)
            goto L_0x056a
        L_0x0535:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            long r12 = r8.getLong(r1, r12)
            r2.zza(r14, r12)
            goto L_0x056a
        L_0x0542:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            long r12 = r8.getLong(r1, r12)
            r2.zzi(r14, r12)
            goto L_0x056a
        L_0x054f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            float r4 = com.google.android.gms.internal.measurement.zzyh.zzn(r1, r12)
            r2.zza(r14, r4)
            goto L_0x056a
        L_0x055d:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            double r12 = com.google.android.gms.internal.measurement.zzyh.zzo(r1, r12)
            r2.zza(r14, r12)
        L_0x056a:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x056e:
            r17 = r10
            r4 = r17
        L_0x0572:
            if (r4 == 0) goto L_0x0588
            com.google.android.gms.internal.measurement.zzva<?> r5 = r0.zzcbo
            r5.zza(r2, r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0586
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x0572
        L_0x0586:
            r4 = 0
            goto L_0x0572
        L_0x0588:
            com.google.android.gms.internal.measurement.zzyb<?, ?> r3 = r0.zzcbn
            zza(r3, (T) r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwx.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzyw):void");
    }

    private final <K, V> void zza(zzyw zzyw, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzyw.zza(i, this.zzcbp.zzad(zzbo(i2)), this.zzcbp.zzz(obj));
        }
    }

    private static <UT, UB> void zza(zzyb<UT, UB> zzyb, T t, zzyw zzyw) throws IOException {
        zzyb.zza(zzyb.zzah(t), zzyw);
    }

    public final void zza(T t, zzxi zzxi, zzuz zzuz) throws IOException {
        int i;
        Object obj;
        zzvd zzvd;
        T t2 = t;
        zzxi zzxi2 = zzxi;
        zzuz zzuz2 = zzuz;
        if (zzuz2 != null) {
            zzyb<?, ?> zzyb = this.zzcbn;
            zzva<?> zzva = this.zzcbo;
            zzvd zzvd2 = null;
            Object obj2 = null;
            while (true) {
                try {
                    int zzve = zzxi.zzve();
                    if (zzve < this.zzcbb || zzve > this.zzcbc) {
                        i = -1;
                    } else {
                        int i2 = 0;
                        int length = (this.zzcaz.length / 3) - 1;
                        while (true) {
                            if (i2 <= length) {
                                int i3 = (length + i2) >>> 1;
                                i = i3 * 3;
                                int i4 = this.zzcaz[i];
                                if (zzve != i4) {
                                    if (zzve < i4) {
                                        length = i3 - 1;
                                    } else {
                                        i2 = i3 + 1;
                                    }
                                }
                            } else {
                                i = -1;
                            }
                        }
                    }
                    if (i >= 0) {
                        int zzbq = zzbq(i);
                        switch ((267386880 & zzbq) >>> 20) {
                            case 0:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.readDouble());
                                zzc(t2, i);
                                break;
                            case 1:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.readFloat());
                                zzc(t2, i);
                                break;
                            case 2:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.zzui());
                                zzc(t2, i);
                                break;
                            case 3:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.zzuh());
                                zzc(t2, i);
                                break;
                            case 4:
                                zzyh.zzb((Object) t2, (long) (zzbq & 1048575), zzxi.zzuj());
                                zzc(t2, i);
                                break;
                            case 5:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.zzuk());
                                zzc(t2, i);
                                break;
                            case 6:
                                zzyh.zzb((Object) t2, (long) (zzbq & 1048575), zzxi.zzul());
                                zzc(t2, i);
                                break;
                            case 7:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.zzum());
                                zzc(t2, i);
                                break;
                            case 8:
                                zza((Object) t2, zzbq, zzxi2);
                                zzc(t2, i);
                                break;
                            case 9:
                                if (!zzb(t2, i)) {
                                    zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi2.zza(zzbn(i), zzuz2));
                                    zzc(t2, i);
                                    break;
                                } else {
                                    long j = (long) (zzbq & 1048575);
                                    zzyh.zza((Object) t2, j, zzvo.zzb(zzyh.zzp(t2, j), zzxi2.zza(zzbn(i), zzuz2)));
                                    break;
                                }
                            case 10:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) zzxi.zzuo());
                                zzc(t2, i);
                                break;
                            case 11:
                                zzyh.zzb((Object) t2, (long) (zzbq & 1048575), zzxi.zzup());
                                zzc(t2, i);
                                break;
                            case 12:
                                int zzuq = zzxi.zzuq();
                                zzvr zzbp = zzbp(i);
                                if (zzbp != null) {
                                    if (!zzbp.zzb(zzuq)) {
                                        obj2 = zzxl.zza(zzve, zzuq, obj2, zzyb);
                                        break;
                                    }
                                }
                                zzyh.zzb((Object) t2, (long) (zzbq & 1048575), zzuq);
                                zzc(t2, i);
                                break;
                            case 13:
                                zzyh.zzb((Object) t2, (long) (zzbq & 1048575), zzxi.zzur());
                                zzc(t2, i);
                                break;
                            case 14:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.zzus());
                                zzc(t2, i);
                                break;
                            case 15:
                                zzyh.zzb((Object) t2, (long) (zzbq & 1048575), zzxi.zzut());
                                zzc(t2, i);
                                break;
                            case 16:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi.zzuu());
                                zzc(t2, i);
                                break;
                            case 17:
                                if (!zzb(t2, i)) {
                                    zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi2.zzb(zzbn(i), zzuz2));
                                    zzc(t2, i);
                                    break;
                                } else {
                                    long j2 = (long) (zzbq & 1048575);
                                    zzyh.zza((Object) t2, j2, zzvo.zzb(zzyh.zzp(t2, j2), zzxi2.zzb(zzbn(i), zzuz2)));
                                    break;
                                }
                            case 18:
                                zzxi2.zzh(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 19:
                                zzxi2.zzi(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 20:
                                zzxi2.zzk(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 21:
                                zzxi2.zzj(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 22:
                                zzxi2.zzl(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 23:
                                zzxi2.zzm(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 24:
                                zzxi2.zzn(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 25:
                                zzxi2.zzo(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 26:
                                if (!zzbs(zzbq)) {
                                    zzxi2.readStringList(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                    break;
                                } else {
                                    zzxi2.zzp(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                    break;
                                }
                            case 27:
                                zzxi2.zza(this.zzcbm.zza(t2, (long) (zzbq & 1048575)), zzbn(i), zzuz2);
                                break;
                            case 28:
                                zzxi2.zzq(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 29:
                                zzxi2.zzr(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 30:
                                List zza = this.zzcbm.zza(t2, (long) (zzbq & 1048575));
                                zzxi2.zzs(zza);
                                obj2 = zzxl.zza(zzve, zza, zzbp(i), obj2, zzyb);
                                break;
                            case 31:
                                zzxi2.zzt(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 32:
                                zzxi2.zzu(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 33:
                                zzxi2.zzv(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 34:
                                zzxi2.zzw(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 35:
                                zzxi2.zzh(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 36:
                                zzxi2.zzi(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 37:
                                zzxi2.zzk(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 38:
                                zzxi2.zzj(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 39:
                                zzxi2.zzl(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 40:
                                zzxi2.zzm(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 41:
                                zzxi2.zzn(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 42:
                                zzxi2.zzo(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 43:
                                zzxi2.zzr(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 44:
                                List zza2 = this.zzcbm.zza(t2, (long) (zzbq & 1048575));
                                zzxi2.zzs(zza2);
                                obj2 = zzxl.zza(zzve, zza2, zzbp(i), obj2, zzyb);
                                break;
                            case 45:
                                zzxi2.zzt(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 46:
                                zzxi2.zzu(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 47:
                                zzxi2.zzv(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 48:
                                zzxi2.zzw(this.zzcbm.zza(t2, (long) (zzbq & 1048575)));
                                break;
                            case 49:
                                long j3 = (long) (zzbq & 1048575);
                                zzxi2.zzb(this.zzcbm.zza(t2, j3), zzbn(i), zzuz2);
                                break;
                            case 50:
                                Object zzbo = zzbo(i);
                                long zzbq2 = (long) (zzbq(i) & 1048575);
                                Object zzp = zzyh.zzp(t2, zzbq2);
                                if (zzp == null) {
                                    zzp = this.zzcbp.zzac(zzbo);
                                    zzyh.zza((Object) t2, zzbq2, zzp);
                                } else if (this.zzcbp.zzaa(zzp)) {
                                    Object zzac = this.zzcbp.zzac(zzbo);
                                    this.zzcbp.zzc(zzac, zzp);
                                    zzyh.zza((Object) t2, zzbq2, zzac);
                                    zzp = zzac;
                                }
                                zzxi2.zza(this.zzcbp.zzy(zzp), this.zzcbp.zzad(zzbo), zzuz2);
                                break;
                            case 51:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Double.valueOf(zzxi.readDouble()));
                                zzb(t2, zzve, i);
                                break;
                            case 52:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Float.valueOf(zzxi.readFloat()));
                                zzb(t2, zzve, i);
                                break;
                            case 53:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Long.valueOf(zzxi.zzui()));
                                zzb(t2, zzve, i);
                                break;
                            case 54:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Long.valueOf(zzxi.zzuh()));
                                zzb(t2, zzve, i);
                                break;
                            case 55:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Integer.valueOf(zzxi.zzuj()));
                                zzb(t2, zzve, i);
                                break;
                            case 56:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Long.valueOf(zzxi.zzuk()));
                                zzb(t2, zzve, i);
                                break;
                            case 57:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Integer.valueOf(zzxi.zzul()));
                                zzb(t2, zzve, i);
                                break;
                            case 58:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Boolean.valueOf(zzxi.zzum()));
                                zzb(t2, zzve, i);
                                break;
                            case 59:
                                zza((Object) t2, zzbq, zzxi2);
                                zzb(t2, zzve, i);
                                break;
                            case 60:
                                if (zza(t2, zzve, i)) {
                                    long j4 = (long) (zzbq & 1048575);
                                    zzyh.zza((Object) t2, j4, zzvo.zzb(zzyh.zzp(t2, j4), zzxi2.zza(zzbn(i), zzuz2)));
                                } else {
                                    zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi2.zza(zzbn(i), zzuz2));
                                    zzc(t2, i);
                                }
                                zzb(t2, zzve, i);
                                break;
                            case 61:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) zzxi.zzuo());
                                zzb(t2, zzve, i);
                                break;
                            case 62:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Integer.valueOf(zzxi.zzup()));
                                zzb(t2, zzve, i);
                                break;
                            case 63:
                                int zzuq2 = zzxi.zzuq();
                                zzvr zzbp2 = zzbp(i);
                                if (zzbp2 != null) {
                                    if (!zzbp2.zzb(zzuq2)) {
                                        obj2 = zzxl.zza(zzve, zzuq2, obj2, zzyb);
                                        break;
                                    }
                                }
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Integer.valueOf(zzuq2));
                                zzb(t2, zzve, i);
                                break;
                            case 64:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Integer.valueOf(zzxi.zzur()));
                                zzb(t2, zzve, i);
                                break;
                            case 65:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Long.valueOf(zzxi.zzus()));
                                zzb(t2, zzve, i);
                                break;
                            case 66:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Integer.valueOf(zzxi.zzut()));
                                zzb(t2, zzve, i);
                                break;
                            case 67:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), (Object) Long.valueOf(zzxi.zzuu()));
                                zzb(t2, zzve, i);
                                break;
                            case 68:
                                zzyh.zza((Object) t2, (long) (zzbq & 1048575), zzxi2.zzb(zzbn(i), zzuz2));
                                zzb(t2, zzve, i);
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = zzyb.zzye();
                                }
                                if (zzyb.zza(obj2, zzxi2)) {
                                    break;
                                } else {
                                    for (int i5 = this.zzcbj; i5 < this.zzcbk; i5++) {
                                        obj2 = zza((Object) t2, this.zzcbi[i5], (UB) obj2, zzyb);
                                    }
                                    if (obj2 != null) {
                                        zzyb.zzg(t2, obj2);
                                    }
                                    return;
                                }
                        }
                    } else if (zzve == Integer.MAX_VALUE) {
                        for (int i6 = this.zzcbj; i6 < this.zzcbk; i6++) {
                            obj2 = zza((Object) t2, this.zzcbi[i6], (UB) obj2, zzyb);
                        }
                        if (obj2 != null) {
                            zzyb.zzg(t2, obj2);
                        }
                        return;
                    } else {
                        if (!this.zzcbe) {
                            obj = null;
                        } else {
                            obj = zzva.zza(zzuz2, this.zzcbd, zzve);
                        }
                        if (obj != null) {
                            if (zzvd2 == null) {
                                zzvd = zzva.zzt(t2);
                            } else {
                                zzvd = zzvd2;
                            }
                            obj2 = zzva.zza(zzxi, obj, zzuz, zzvd, obj2, zzyb);
                            zzvd2 = zzvd;
                        } else {
                            zzyb.zza(zzxi2);
                            if (obj2 == null) {
                                obj2 = zzyb.zzai(t2);
                            }
                            if (!zzyb.zza(obj2, zzxi2)) {
                                for (int i7 = this.zzcbj; i7 < this.zzcbk; i7++) {
                                    obj2 = zza((Object) t2, this.zzcbi[i7], (UB) obj2, zzyb);
                                }
                                if (obj2 != null) {
                                    zzyb.zzg(t2, obj2);
                                }
                                return;
                            }
                        }
                    }
                } catch (zzvu e) {
                    zzyb.zza(zzxi2);
                    if (obj2 == null) {
                        obj2 = zzyb.zzai(t2);
                    }
                    if (!zzyb.zza(obj2, zzxi2)) {
                        for (int i8 = this.zzcbj; i8 < this.zzcbk; i8++) {
                            obj2 = zza((Object) t2, this.zzcbi[i8], (UB) obj2, zzyb);
                        }
                        if (obj2 != null) {
                            zzyb.zzg(t2, obj2);
                        }
                        return;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    for (int i9 = this.zzcbj; i9 < this.zzcbk; i9++) {
                        obj2 = zza((Object) t2, this.zzcbi[i9], (UB) obj2, zzyb);
                    }
                    if (obj2 != null) {
                        zzyb.zzg(t2, obj2);
                    }
                    throw th2;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    private final zzxj zzbn(int i) {
        int i2 = (i / 3) << 1;
        zzxj zzxj = (zzxj) this.zzcba[i2];
        if (zzxj != null) {
            return zzxj;
        }
        zzxj zzi = zzxf.zzxn().zzi((Class) this.zzcba[i2 + 1]);
        this.zzcba[i2] = zzi;
        return zzi;
    }

    private final Object zzbo(int i) {
        return this.zzcba[(i / 3) << 1];
    }

    private final zzvr zzbp(int i) {
        return (zzvr) this.zzcba[((i / 3) << 1) + 1];
    }

    public final void zzu(T t) {
        int i;
        int i2 = this.zzcbj;
        while (true) {
            i = this.zzcbk;
            if (i2 >= i) {
                break;
            }
            long zzbq = (long) (zzbq(this.zzcbi[i2]) & 1048575);
            Object zzp = zzyh.zzp(t, zzbq);
            if (zzp != null) {
                zzyh.zza((Object) t, zzbq, this.zzcbp.zzab(zzp));
            }
            i2++;
        }
        int length = this.zzcbi.length;
        while (i < length) {
            this.zzcbm.zzb(t, (long) this.zzcbi[i]);
            i++;
        }
        this.zzcbn.zzu(t);
        if (this.zzcbe) {
            this.zzcbo.zzu(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzyb<UT, UB> zzyb) {
        int i2 = this.zzcaz[i];
        Object zzp = zzyh.zzp(obj, (long) (zzbq(i) & 1048575));
        if (zzp == null) {
            return ub;
        }
        zzvr zzbp = zzbp(i);
        if (zzbp == null) {
            return ub;
        }
        return zza(i, i2, this.zzcbp.zzy(zzp), zzbp, ub, zzyb);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzvr zzvr, UB ub, zzyb<UT, UB> zzyb) {
        zzwm zzad = this.zzcbp.zzad(zzbo(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!zzvr.zzb(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzyb.zzye();
                }
                zzuk zzam = zzud.zzam(zzwl.zza(zzad, entry.getKey(), entry.getValue()));
                try {
                    zzwl.zza(zzam.zzuf(), zzad, entry.getKey(), entry.getValue());
                    zzyb.zza(ub, i2, zzam.zzue());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzaf(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzcbj) {
                return !this.zzcbe || this.zzcbo.zzs(t).isInitialized();
            }
            int i5 = this.zzcbi[i2];
            int i6 = this.zzcaz[i5];
            int zzbq = zzbq(i5);
            if (!this.zzcbg) {
                int i7 = this.zzcaz[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzcay.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzbq) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzbq) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzbq, zzbn(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map zzz = this.zzcbp.zzz(zzyh.zzp(t, (long) (zzbq & 1048575)));
                            if (!zzz.isEmpty()) {
                                if (this.zzcbp.zzad(zzbo(i5)).zzcat.zzyp() == zzyv.MESSAGE) {
                                    zzxj zzxj = null;
                                    Iterator it = zzz.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzxj == null) {
                                            zzxj = zzxf.zzxn().zzi(next.getClass());
                                        }
                                        if (!zzxj.zzaf(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzyh.zzp(t, (long) (zzbq & 1048575));
                if (!list.isEmpty()) {
                    zzxj zzbn = zzbn(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzbn.zzaf(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzbq, zzbn(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zza(Object obj, int i, zzxj zzxj) {
        return zzxj.zzaf(zzyh.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzyw zzyw) throws IOException {
        if (obj instanceof String) {
            zzyw.zzb(i, (String) obj);
        } else {
            zzyw.zza(i, (zzud) obj);
        }
    }

    private final void zza(Object obj, int i, zzxi zzxi) throws IOException {
        if (zzbs(i)) {
            zzyh.zza(obj, (long) (i & 1048575), (Object) zzxi.zzun());
        } else if (this.zzcbf) {
            zzyh.zza(obj, (long) (i & 1048575), (Object) zzxi.readString());
        } else {
            zzyh.zza(obj, (long) (i & 1048575), (Object) zzxi.zzuo());
        }
    }

    private final int zzbq(int i) {
        return this.zzcaz[i + 1];
    }

    private final int zzbr(int i) {
        return this.zzcaz[i + 2];
    }

    private static boolean zzbs(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzyh.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzyh.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzyh.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzyh.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzyh.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzb(t, i) == zzb(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzcbg) {
            return zzb(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zzb(T t, int i) {
        if (this.zzcbg) {
            int zzbq = zzbq(i);
            long j = (long) (zzbq & 1048575);
            switch ((zzbq & 267386880) >>> 20) {
                case 0:
                    return zzyh.zzo(t, j) != 0.0d;
                case 1:
                    return zzyh.zzn(t, j) != 0.0f;
                case 2:
                    return zzyh.zzl(t, j) != 0;
                case 3:
                    return zzyh.zzl(t, j) != 0;
                case 4:
                    return zzyh.zzk(t, j) != 0;
                case 5:
                    return zzyh.zzl(t, j) != 0;
                case 6:
                    return zzyh.zzk(t, j) != 0;
                case 7:
                    return zzyh.zzm(t, j);
                case 8:
                    Object zzp = zzyh.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzud) {
                        return !zzud.zzbtz.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzyh.zzp(t, j) != null;
                case 10:
                    return !zzud.zzbtz.equals(zzyh.zzp(t, j));
                case 11:
                    return zzyh.zzk(t, j) != 0;
                case 12:
                    return zzyh.zzk(t, j) != 0;
                case 13:
                    return zzyh.zzk(t, j) != 0;
                case 14:
                    return zzyh.zzl(t, j) != 0;
                case 15:
                    return zzyh.zzk(t, j) != 0;
                case 16:
                    return zzyh.zzl(t, j) != 0;
                case 17:
                    return zzyh.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbr = zzbr(i);
            return (zzyh.zzk(t, (long) (zzbr & 1048575)) & (1 << (zzbr >>> 20))) != 0;
        }
    }

    private final void zzc(T t, int i) {
        if (!this.zzcbg) {
            int zzbr = zzbr(i);
            long j = (long) (zzbr & 1048575);
            zzyh.zzb((Object) t, j, zzyh.zzk(t, j) | (1 << (zzbr >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzyh.zzk(t, (long) (zzbr(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzyh.zzb((Object) t, (long) (zzbr(i2) & 1048575), i);
    }
}

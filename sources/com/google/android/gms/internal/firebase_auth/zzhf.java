package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzhf<T> implements zzhv<T> {
    private static final int[] zzzj = new int[0];
    private static final Unsafe zzzk = zziv.zzjs();
    private final zzfg<?> zzaaa;
    private final zzgw zzaab;
    private final int[] zzzl;
    private final Object[] zzzm;
    private final int zzzn;
    private final int zzzo;
    private final zzhb zzzp;
    private final boolean zzzq;
    private final boolean zzzr;
    private final boolean zzzs;
    private final boolean zzzt;
    private final int[] zzzu;
    private final int zzzv;
    private final int zzzw;
    private final zzhi zzzx;
    private final zzgl zzzy;
    private final zzip<?, ?> zzzz;

    private zzhf(int[] iArr, Object[] objArr, int i, int i2, zzhb zzhb, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhi zzhi, zzgl zzgl, zzip<?, ?> zzip, zzfg<?> zzfg, zzgw zzgw) {
        this.zzzl = iArr;
        this.zzzm = objArr;
        this.zzzn = i;
        this.zzzo = i2;
        this.zzzr = zzhb instanceof zzfs;
        this.zzzs = z;
        this.zzzq = zzfg != null && zzfg.zzf(zzhb);
        this.zzzt = false;
        this.zzzu = iArr2;
        this.zzzv = i3;
        this.zzzw = i4;
        this.zzzx = zzhi;
        this.zzzy = zzgl;
        this.zzzz = zzip;
        this.zzaaa = zzfg;
        this.zzzp = zzhb;
        this.zzaab = zzgw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:169:0x0396  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.firebase_auth.zzhf<T> zza(java.lang.Class<T> r35, com.google.android.gms.internal.firebase_auth.zzgz r36, com.google.android.gms.internal.firebase_auth.zzhi r37, com.google.android.gms.internal.firebase_auth.zzgl r38, com.google.android.gms.internal.firebase_auth.zzip<?, ?> r39, com.google.android.gms.internal.firebase_auth.zzfg<?> r40, com.google.android.gms.internal.firebase_auth.zzgw r41) {
        /*
            r0 = r36
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzhp
            if (r1 == 0) goto L_0x0461
            com.google.android.gms.internal.firebase_auth.zzhp r0 = (com.google.android.gms.internal.firebase_auth.zzhp) r0
            int r1 = r0.zzim()
            int r2 = com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxo
            r3 = 0
            if (r1 != r2) goto L_0x0013
            r11 = 1
            goto L_0x0014
        L_0x0013:
            r11 = 0
        L_0x0014:
            java.lang.String r1 = r0.zziv()
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
            int[] r8 = zzzj
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
            r34 = r16
            r16 = r15
            r15 = r34
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
            r34 = r16
            r16 = r3
            r3 = r34
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
            r34 = r16
            r16 = r9
            r9 = r12
            r12 = r34
        L_0x01b0:
            sun.misc.Unsafe r6 = zzzk
            java.lang.Object[] r17 = r0.zziw()
            com.google.android.gms.internal.firebase_auth.zzhb r18 = r0.zzio()
            java.lang.Class r7 = r18.getClass()
            int r4 = r14 * 3
            int[] r4 = new int[r4]
            r18 = 1
            int r14 = r14 << 1
            java.lang.Object[] r14 = new java.lang.Object[r14]
            int r20 = r3 + r8
            r22 = r3
            r23 = r20
            r8 = 0
            r21 = 0
        L_0x01d3:
            if (r12 >= r2) goto L_0x0438
            int r24 = r12 + 1
            char r12 = r1.charAt(r12)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r2) goto L_0x0209
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r34 = r24
            r24 = r12
            r12 = r34
        L_0x01ec:
            int r27 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r2) goto L_0x0202
            r2 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r26
            r24 = r24 | r2
            int r26 = r26 + 13
            r12 = r27
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01ec
        L_0x0202:
            int r2 = r12 << r26
            r12 = r24 | r2
            r2 = r27
            goto L_0x020b
        L_0x0209:
            r2 = r24
        L_0x020b:
            int r24 = r2 + 1
            char r2 = r1.charAt(r2)
            r26 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r3) goto L_0x0240
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r27 = 13
            r34 = r24
            r24 = r2
            r2 = r34
        L_0x0223:
            int r28 = r2 + 1
            char r2 = r1.charAt(r2)
            if (r2 < r3) goto L_0x0239
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r27
            r24 = r24 | r2
            int r27 = r27 + 13
            r2 = r28
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0223
        L_0x0239:
            int r2 = r2 << r27
            r2 = r24 | r2
            r3 = r28
            goto L_0x0242
        L_0x0240:
            r3 = r24
        L_0x0242:
            r24 = r11
            r11 = r2 & 255(0xff, float:3.57E-43)
            r27 = r13
            r13 = r2 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0252
            int r13 = r8 + 1
            r15[r8] = r21
            r8 = r13
        L_0x0252:
            r13 = 51
            r30 = r8
            if (r11 < r13) goto L_0x02f8
            int r13 = r3 + 1
            char r3 = r1.charAt(r3)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r8) goto L_0x0281
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x0267:
            int r33 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r8) goto L_0x027c
            r8 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r32
            r3 = r3 | r8
            int r32 = r32 + 13
            r13 = r33
            r8 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0267
        L_0x027c:
            int r8 = r13 << r32
            r3 = r3 | r8
            r13 = r33
        L_0x0281:
            int r8 = r11 + -51
            r32 = r13
            r13 = 9
            if (r8 == r13) goto L_0x02a7
            r13 = 17
            if (r8 != r13) goto L_0x028f
            goto L_0x02a7
        L_0x028f:
            r13 = 12
            if (r8 != r13) goto L_0x02a5
            r8 = r5 & 1
            r13 = 1
            if (r8 != r13) goto L_0x02a5
            int r8 = r21 / 3
            int r8 = r8 << r13
            int r8 = r8 + r13
            int r13 = r10 + 1
            r10 = r17[r10]
            r14[r8] = r10
            r10 = r13
            r13 = 1
            goto L_0x02b4
        L_0x02a5:
            r13 = 1
            goto L_0x02b4
        L_0x02a7:
            int r8 = r21 / 3
            r13 = 1
            int r8 = r8 << r13
            int r8 = r8 + r13
            int r18 = r10 + 1
            r10 = r17[r10]
            r14[r8] = r10
            r10 = r18
        L_0x02b4:
            int r3 = r3 << r13
            r8 = r17[r3]
            boolean r13 = r8 instanceof java.lang.reflect.Field
            if (r13 == 0) goto L_0x02be
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02c6
        L_0x02be:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zza(r7, r8)
            r17[r3] = r8
        L_0x02c6:
            r13 = r9
            long r8 = r6.objectFieldOffset(r8)
            int r9 = (int) r8
            int r3 = r3 + 1
            r8 = r17[r3]
            r28 = r9
            boolean r9 = r8 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x02d9
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02e1
        L_0x02d9:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zza(r7, r8)
            r17[r3] = r8
        L_0x02e1:
            long r8 = r6.objectFieldOffset(r8)
            int r3 = (int) r8
            r31 = r1
            r8 = r3
            r1 = r7
            r19 = r10
            r9 = r28
            r10 = r32
            r3 = 0
            r18 = 1
            r28 = r13
            goto L_0x0400
        L_0x02f8:
            r13 = r9
            int r8 = r10 + 1
            r9 = r17[r10]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza(r7, r9)
            r10 = 9
            if (r11 == r10) goto L_0x0380
            r10 = 17
            if (r11 != r10) goto L_0x0310
            r28 = r13
            r13 = 1
            goto L_0x0383
        L_0x0310:
            r10 = 27
            if (r11 == r10) goto L_0x0370
            r10 = 49
            if (r11 != r10) goto L_0x031b
            r28 = r13
            goto L_0x0372
        L_0x031b:
            r10 = 12
            if (r11 == r10) goto L_0x035a
            r10 = 30
            if (r11 == r10) goto L_0x035a
            r10 = 44
            if (r11 != r10) goto L_0x0328
            goto L_0x035a
        L_0x0328:
            r10 = 50
            if (r11 != r10) goto L_0x0356
            int r10 = r22 + 1
            r15[r22] = r21
            int r22 = r21 / 3
            r18 = 1
            int r22 = r22 << 1
            int r28 = r8 + 1
            r8 = r17[r8]
            r14[r22] = r8
            r8 = r2 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x034e
            int r22 = r22 + 1
            int r8 = r28 + 1
            r28 = r17[r28]
            r14[r22] = r28
            r22 = r10
            r28 = r13
            r13 = 1
            goto L_0x038d
        L_0x034e:
            r22 = r10
            r8 = r28
            r28 = r13
            r13 = 1
            goto L_0x038d
        L_0x0356:
            r28 = r13
            r13 = 1
            goto L_0x038d
        L_0x035a:
            r10 = r5 & 1
            r28 = r13
            r13 = 1
            if (r10 != r13) goto L_0x036e
            int r10 = r21 / 3
            int r10 = r10 << r13
            int r10 = r10 + r13
            int r13 = r8 + 1
            r8 = r17[r8]
            r14[r10] = r8
            r8 = r13
            r13 = 1
            goto L_0x038d
        L_0x036e:
            r13 = 1
            goto L_0x038d
        L_0x0370:
            r28 = r13
        L_0x0372:
            int r10 = r21 / 3
            r13 = 1
            int r10 = r10 << r13
            int r10 = r10 + r13
            int r18 = r8 + 1
            r8 = r17[r8]
            r14[r10] = r8
            r8 = r18
            goto L_0x038d
        L_0x0380:
            r28 = r13
            r13 = 1
        L_0x0383:
            int r10 = r21 / 3
            int r10 = r10 << r13
            int r10 = r10 + r13
            java.lang.Class r18 = r9.getType()
            r14[r10] = r18
        L_0x038d:
            long r9 = r6.objectFieldOffset(r9)
            int r9 = (int) r9
            r10 = r5 & 1
            if (r10 != r13) goto L_0x03e7
            r10 = 17
            if (r11 > r10) goto L_0x03e7
            int r10 = r3 + 1
            char r3 = r1.charAt(r3)
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r13) goto L_0x03c0
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x03a9:
            int r29 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r13) goto L_0x03bb
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r19
            r3 = r3 | r10
            int r19 = r19 + 13
            r10 = r29
            goto L_0x03a9
        L_0x03bb:
            int r10 = r10 << r19
            r3 = r3 | r10
            r10 = r29
        L_0x03c0:
            r18 = 1
            int r19 = r16 << 1
            int r29 = r3 / 32
            int r19 = r19 + r29
            r13 = r17[r19]
            r31 = r1
            boolean r1 = r13 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x03d4
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x03dc
        L_0x03d4:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza(r7, r13)
            r17[r19] = r13
        L_0x03dc:
            r1 = r7
            r19 = r8
            long r7 = r6.objectFieldOffset(r13)
            int r8 = (int) r7
            int r3 = r3 % 32
            goto L_0x03f2
        L_0x03e7:
            r31 = r1
            r1 = r7
            r19 = r8
            r18 = 1
            r10 = r3
            r3 = 0
            r8 = 0
        L_0x03f2:
            r7 = 18
            if (r11 < r7) goto L_0x0400
            r7 = 49
            if (r11 > r7) goto L_0x0400
            int r7 = r23 + 1
            r15[r23] = r9
            r23 = r7
        L_0x0400:
            int r7 = r21 + 1
            r4[r21] = r12
            int r12 = r7 + 1
            r13 = r2 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x040d
            r13 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x040e
        L_0x040d:
            r13 = 0
        L_0x040e:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0415
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0416
        L_0x0415:
            r2 = 0
        L_0x0416:
            r2 = r2 | r13
            int r11 = r11 << 20
            r2 = r2 | r11
            r2 = r2 | r9
            r4[r7] = r2
            int r21 = r12 + 1
            int r2 = r3 << 20
            r2 = r2 | r8
            r4[r12] = r2
            r7 = r1
            r12 = r10
            r10 = r19
            r11 = r24
            r2 = r25
            r3 = r26
            r13 = r27
            r9 = r28
            r8 = r30
            r1 = r31
            goto L_0x01d3
        L_0x0438:
            r26 = r3
            r28 = r9
            r24 = r11
            r27 = r13
            com.google.android.gms.internal.firebase_auth.zzhf r1 = new com.google.android.gms.internal.firebase_auth.zzhf
            com.google.android.gms.internal.firebase_auth.zzhb r10 = r0.zzio()
            r12 = 0
            r5 = r1
            r6 = r4
            r7 = r14
            r8 = r28
            r9 = r27
            r13 = r15
            r14 = r26
            r15 = r20
            r16 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r41
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x0461:
            com.google.android.gms.internal.firebase_auth.zzii r0 = (com.google.android.gms.internal.firebase_auth.zzii) r0
            r0.zzim()
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x046d
        L_0x046c:
            throw r0
        L_0x046d:
            goto L_0x046c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzgz, com.google.android.gms.internal.firebase_auth.zzhi, com.google.android.gms.internal.firebase_auth.zzgl, com.google.android.gms.internal.firebase_auth.zzip, com.google.android.gms.internal.firebase_auth.zzfg, com.google.android.gms.internal.firebase_auth.zzgw):com.google.android.gms.internal.firebase_auth.zzhf");
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
        return this.zzzx.newInstance(this.zzzp);
    }

    public final boolean equals(T t, T t2) {
        int length = this.zzzl.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzaw = zzaw(i);
                long j = (long) (zzaw & 1048575);
                switch ((zzaw & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zziv.zzo(t, j)) != Double.doubleToLongBits(zziv.zzo(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zziv.zzn(t, j)) != Float.floatToIntBits(zziv.zzn(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zziv.zzl(t, j) != zziv.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zziv.zzl(t, j) != zziv.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zziv.zzk(t, j) != zziv.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zziv.zzl(t, j) != zziv.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zziv.zzk(t, j) != zziv.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zziv.zzm(t, j) != zziv.zzm(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zziv.zzk(t, j) != zziv.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zziv.zzk(t, j) != zziv.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zziv.zzk(t, j) != zziv.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zziv.zzl(t, j) != zziv.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zziv.zzk(t, j) != zziv.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zziv.zzl(t, j) != zziv.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j))) {
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
                        z = zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j));
                        break;
                    case 50:
                        z = zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j));
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
                        long zzax = (long) (zzax(i) & 1048575);
                        if (zziv.zzk(t, zzax) != zziv.zzk(t2, zzax) || !zzhx.zzd(zziv.zzp(t, j), zziv.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzzz.zzs(t).equals(this.zzzz.zzs(t2))) {
                return false;
            } else {
                if (this.zzzq) {
                    return this.zzaaa.zzd(t).equals(this.zzaaa.zzd(t2));
                }
                return true;
            }
        }
    }

    public final int hashCode(T t) {
        int length = this.zzzl.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzaw = zzaw(i2);
            int i3 = this.zzzl[i2];
            long j = (long) (1048575 & zzaw);
            int i4 = 37;
            switch ((zzaw & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzfu.zzk(Double.doubleToLongBits(zziv.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zziv.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzfu.zzu(zziv.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zziv.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zziv.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zziv.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zziv.zzp(t, j);
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
                    i = (i * 53) + zziv.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zziv.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(Double.doubleToLongBits(zzf(t, j)));
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
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
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
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
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
                        i = (i * 53) + zzfu.zzu(zzj(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zziv.zzp(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziv.zzp(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziv.zzp(t, j).hashCode();
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
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
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
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziv.zzp(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzzz.zzs(t).hashCode();
        if (this.zzzq) {
            return (hashCode * 53) + this.zzaaa.zzd(t).hashCode();
        }
        return hashCode;
    }

    public final void zzc(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzzl.length; i += 3) {
                int zzaw = zzaw(i);
                long j = (long) (1048575 & zzaw);
                int i2 = this.zzzl[i];
                switch ((zzaw & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziv.zza((Object) t, j, zziv.zzl(t2, j));
                            zzb(t, i);
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
                        this.zzzy.zza(t, t2, j);
                        break;
                    case 50:
                        zzhx.zza(this.zzaab, t, t2, j);
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
                            zziv.zza((Object) t, j, zziv.zzp(t2, j));
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
                            zziv.zza((Object) t, j, zziv.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzzs) {
                zzhx.zza(this.zzzz, t, t2);
                if (this.zzzq) {
                    zzhx.zza(this.zzaaa, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzaw = (long) (zzaw(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zziv.zzp(t, zzaw);
            Object zzp2 = zziv.zzp(t2, zzaw);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zziv.zza((Object) t, zzaw, zzp2);
                    zzb(t, i);
                }
                return;
            }
            zziv.zza((Object) t, zzaw, zzfu.zza(zzp, zzp2));
            zzb(t, i);
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzaw = zzaw(i);
        int i2 = this.zzzl[i];
        long j = (long) (zzaw & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zziv.zzp(t, j);
            Object zzp2 = zziv.zzp(t2, j);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zziv.zza((Object) t, j, zzp2);
                    zzb(t, i2, i);
                }
                return;
            }
            zziv.zza((Object) t, j, zzfu.zza(zzp, zzp2));
            zzb(t, i2, i);
        }
    }

    public final int zzp(T t) {
        int i;
        int i2;
        long j;
        int i3;
        T t2 = t;
        int i4 = 267386880;
        if (this.zzzs) {
            Unsafe unsafe = zzzk;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.zzzl.length) {
                int zzaw = zzaw(i5);
                int i7 = (zzaw & i4) >>> 20;
                int i8 = this.zzzl[i5];
                long j2 = (long) (zzaw & 1048575);
                if (i7 < zzfm.DOUBLE_LIST_PACKED.mo8538id() || i7 > zzfm.SINT64_LIST_PACKED.mo8538id()) {
                    i3 = 0;
                } else {
                    i3 = this.zzzl[i5 + 2] & 1048575;
                }
                switch (i7) {
                    case 0:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzb(i8, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzb(i8, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzd(i8, zziv.zzl(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zze(i8, zziv.zzl(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzk(i8, zziv.zzk(t2, j2));
                            break;
                        }
                    case 5:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzg(i8, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzn(i8, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzc(i8, true);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            Object zzp = zziv.zzp(t2, j2);
                            if (!(zzp instanceof zzeh)) {
                                i6 += zzez.zzb(i8, (String) zzp);
                                break;
                            } else {
                                i6 += zzez.zzc(i8, (zzeh) zzp);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzhx.zzc(i8, zziv.zzp(t2, j2), zzat(i5));
                            break;
                        }
                    case 10:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzc(i8, (zzeh) zziv.zzp(t2, j2));
                            break;
                        }
                    case 11:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzl(i8, zziv.zzk(t2, j2));
                            break;
                        }
                    case 12:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzp(i8, zziv.zzk(t2, j2));
                            break;
                        }
                    case 13:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzo(i8, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzh(i8, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzm(i8, zziv.zzk(t2, j2));
                            break;
                        }
                    case 16:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzf(i8, zziv.zzl(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zza(t2, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzc(i8, (zzhb) zziv.zzp(t2, j2), zzat(i5));
                            break;
                        }
                    case 18:
                        i6 += zzhx.zzw(i8, zze(t2, j2), false);
                        break;
                    case 19:
                        i6 += zzhx.zzv(i8, zze(t2, j2), false);
                        break;
                    case 20:
                        i6 += zzhx.zzo(i8, zze(t2, j2), false);
                        break;
                    case 21:
                        i6 += zzhx.zzp(i8, zze(t2, j2), false);
                        break;
                    case 22:
                        i6 += zzhx.zzs(i8, zze(t2, j2), false);
                        break;
                    case 23:
                        i6 += zzhx.zzw(i8, zze(t2, j2), false);
                        break;
                    case 24:
                        i6 += zzhx.zzv(i8, zze(t2, j2), false);
                        break;
                    case 25:
                        i6 += zzhx.zzx(i8, zze(t2, j2), false);
                        break;
                    case 26:
                        i6 += zzhx.zzc(i8, zze(t2, j2));
                        break;
                    case 27:
                        i6 += zzhx.zzc(i8, zze(t2, j2), zzat(i5));
                        break;
                    case 28:
                        i6 += zzhx.zzd(i8, zze(t2, j2));
                        break;
                    case 29:
                        i6 += zzhx.zzt(i8, zze(t2, j2), false);
                        break;
                    case 30:
                        i6 += zzhx.zzr(i8, zze(t2, j2), false);
                        break;
                    case 31:
                        i6 += zzhx.zzv(i8, zze(t2, j2), false);
                        break;
                    case 32:
                        i6 += zzhx.zzw(i8, zze(t2, j2), false);
                        break;
                    case 33:
                        i6 += zzhx.zzu(i8, zze(t2, j2), false);
                        break;
                    case 34:
                        i6 += zzhx.zzq(i8, zze(t2, j2), false);
                        break;
                    case 35:
                        int zzab = zzhx.zzab((List) unsafe.getObject(t2, j2));
                        if (zzab > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzab);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzab) + zzab;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzaa = zzhx.zzaa((List) unsafe.getObject(t2, j2));
                        if (zzaa > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzaa);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzaa) + zzaa;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zzt = zzhx.zzt((List) unsafe.getObject(t2, j2));
                        if (zzt > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzt);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzt) + zzt;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzu = zzhx.zzu((List) unsafe.getObject(t2, j2));
                        if (zzu > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzu);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzu) + zzu;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zzx = zzhx.zzx((List) unsafe.getObject(t2, j2));
                        if (zzx > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzx);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzx) + zzx;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzab2 = zzhx.zzab((List) unsafe.getObject(t2, j2));
                        if (zzab2 > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzab2);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzab2) + zzab2;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzaa2 = zzhx.zzaa((List) unsafe.getObject(t2, j2));
                        if (zzaa2 > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzaa2);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzaa2) + zzaa2;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int zzac = zzhx.zzac((List) unsafe.getObject(t2, j2));
                        if (zzac > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzac);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzac) + zzac;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzy = zzhx.zzy((List) unsafe.getObject(t2, j2));
                        if (zzy > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzy);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzy) + zzy;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int zzw = zzhx.zzw((List) unsafe.getObject(t2, j2));
                        if (zzw > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzw);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzw) + zzw;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzaa3 = zzhx.zzaa((List) unsafe.getObject(t2, j2));
                        if (zzaa3 > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzaa3);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzaa3) + zzaa3;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int zzab3 = zzhx.zzab((List) unsafe.getObject(t2, j2));
                        if (zzab3 > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzab3);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzab3) + zzab3;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzz = zzhx.zzz((List) unsafe.getObject(t2, j2));
                        if (zzz > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzz);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzz) + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzv = zzhx.zzv((List) unsafe.getObject(t2, j2));
                        if (zzv > 0) {
                            if (this.zzzt) {
                                unsafe.putInt(t2, (long) i3, zzv);
                            }
                            i6 += zzez.zzaf(i8) + zzez.zzah(zzv) + zzv;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i6 += zzhx.zzd(i8, zze(t2, j2), zzat(i5));
                        break;
                    case 50:
                        i6 += this.zzaab.zzb(i8, zziv.zzp(t2, j2), zzau(i5));
                        break;
                    case 51:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzb(i8, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzb(i8, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzd(i8, zzi(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zze(i8, zzi(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzk(i8, zzh(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzg(i8, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzn(i8, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzc(i8, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            Object zzp2 = zziv.zzp(t2, j2);
                            if (!(zzp2 instanceof zzeh)) {
                                i6 += zzez.zzb(i8, (String) zzp2);
                                break;
                            } else {
                                i6 += zzez.zzc(i8, (zzeh) zzp2);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzhx.zzc(i8, zziv.zzp(t2, j2), zzat(i5));
                            break;
                        }
                    case 61:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzc(i8, (zzeh) zziv.zzp(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzl(i8, zzh(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzp(i8, zzh(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzo(i8, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzh(i8, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzm(i8, zzh(t2, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzf(i8, zzi(t2, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzez.zzc(i8, (zzhb) zziv.zzp(t2, j2), zzat(i5));
                            break;
                        }
                }
                i5 += 3;
                i4 = 267386880;
            }
            return i6 + zza(this.zzzz, t2);
        }
        Unsafe unsafe2 = zzzk;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        while (i9 < this.zzzl.length) {
            int zzaw2 = zzaw(i9);
            int[] iArr = this.zzzl;
            int i13 = iArr[i9];
            int i14 = (zzaw2 & 267386880) >>> 20;
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
            } else if (!this.zzzt || i14 < zzfm.DOUBLE_LIST_PACKED.mo8538id() || i14 > zzfm.SINT64_LIST_PACKED.mo8538id()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzzl[i9 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzaw2 & 1048575);
            switch (i14) {
                case 0:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzez.zzb(i13, 0.0d);
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzez.zzb(i13, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzez.zzd(i13, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzez.zze(i13, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i10 += zzez.zzk(i13, unsafe2.getInt(t2, j3));
                        break;
                    }
                case 5:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        i10 += zzez.zzg(i13, 0);
                        break;
                    }
                case 6:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzn(i13, 0);
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzc(i13, true);
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzeh)) {
                            i10 += zzez.zzb(i13, (String) object);
                            j = 0;
                            break;
                        } else {
                            i10 += zzez.zzc(i13, (zzeh) object);
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzhx.zzc(i13, unsafe2.getObject(t2, j3), zzat(i9));
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzc(i13, (zzeh) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzl(i13, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzp(i13, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzo(i13, 0);
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzh(i13, 0);
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzm(i13, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzf(i13, unsafe2.getLong(t2, j3));
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i12 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzc(i13, (zzhb) unsafe2.getObject(t2, j3), zzat(i9));
                        j = 0;
                        break;
                    }
                case 18:
                    i10 += zzhx.zzw(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 19:
                    i10 += zzhx.zzv(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 20:
                    i10 += zzhx.zzo(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 21:
                    i10 += zzhx.zzp(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 22:
                    i10 += zzhx.zzs(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 23:
                    i10 += zzhx.zzw(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 24:
                    i10 += zzhx.zzv(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 25:
                    i10 += zzhx.zzx(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 26:
                    i10 += zzhx.zzc(i13, (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 27:
                    i10 += zzhx.zzc(i13, (List) unsafe2.getObject(t2, j3), zzat(i9));
                    j = 0;
                    break;
                case 28:
                    i10 += zzhx.zzd(i13, (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 29:
                    i10 += zzhx.zzt(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 30:
                    i10 += zzhx.zzr(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 31:
                    i10 += zzhx.zzv(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 32:
                    i10 += zzhx.zzw(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 33:
                    i10 += zzhx.zzu(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 34:
                    i10 += zzhx.zzq(i13, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzab4 = zzhx.zzab((List) unsafe2.getObject(t2, j3));
                    if (zzab4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzab4);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzab4) + zzab4;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzaa4 = zzhx.zzaa((List) unsafe2.getObject(t2, j3));
                    if (zzaa4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzaa4);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzaa4) + zzaa4;
                        j = 0;
                        break;
                    }
                case 37:
                    int zzt2 = zzhx.zzt((List) unsafe2.getObject(t2, j3));
                    if (zzt2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzt2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzt2) + zzt2;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzu2 = zzhx.zzu((List) unsafe2.getObject(t2, j3));
                    if (zzu2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzu2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzu2) + zzu2;
                        j = 0;
                        break;
                    }
                case 39:
                    int zzx2 = zzhx.zzx((List) unsafe2.getObject(t2, j3));
                    if (zzx2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzx2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzx2) + zzx2;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzab5 = zzhx.zzab((List) unsafe2.getObject(t2, j3));
                    if (zzab5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzab5);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzab5) + zzab5;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzaa5 = zzhx.zzaa((List) unsafe2.getObject(t2, j3));
                    if (zzaa5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzaa5);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzaa5) + zzaa5;
                        j = 0;
                        break;
                    }
                case 42:
                    int zzac2 = zzhx.zzac((List) unsafe2.getObject(t2, j3));
                    if (zzac2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzac2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzac2) + zzac2;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzy2 = zzhx.zzy((List) unsafe2.getObject(t2, j3));
                    if (zzy2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzy2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzy2) + zzy2;
                        j = 0;
                        break;
                    }
                case 44:
                    int zzw2 = zzhx.zzw((List) unsafe2.getObject(t2, j3));
                    if (zzw2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzw2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzw2) + zzw2;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzaa6 = zzhx.zzaa((List) unsafe2.getObject(t2, j3));
                    if (zzaa6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzaa6);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzaa6) + zzaa6;
                        j = 0;
                        break;
                    }
                case 46:
                    int zzab6 = zzhx.zzab((List) unsafe2.getObject(t2, j3));
                    if (zzab6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzab6);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzab6) + zzab6;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzz2 = zzhx.zzz((List) unsafe2.getObject(t2, j3));
                    if (zzz2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzz2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzz2) + zzz2;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzv2 = zzhx.zzv((List) unsafe2.getObject(t2, j3));
                    if (zzv2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzzt) {
                            unsafe2.putInt(t2, (long) i2, zzv2);
                        }
                        i10 += zzez.zzaf(i13) + zzez.zzah(zzv2) + zzv2;
                        j = 0;
                        break;
                    }
                case 49:
                    i10 += zzhx.zzd(i13, (List) unsafe2.getObject(t2, j3), zzat(i9));
                    j = 0;
                    break;
                case 50:
                    i10 += this.zzaab.zzb(i13, unsafe2.getObject(t2, j3), zzau(i9));
                    j = 0;
                    break;
                case 51:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzb(i13, 0.0d);
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzb(i13, 0.0f);
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzd(i13, zzi(t2, j3));
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zze(i13, zzi(t2, j3));
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzk(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzg(i13, 0);
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzn(i13, 0);
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzc(i13, true);
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzeh)) {
                            i10 += zzez.zzb(i13, (String) object2);
                            j = 0;
                            break;
                        } else {
                            i10 += zzez.zzc(i13, (zzeh) object2);
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzhx.zzc(i13, unsafe2.getObject(t2, j3), zzat(i9));
                        j = 0;
                        break;
                    }
                case 61:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzc(i13, (zzeh) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzl(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzp(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzo(i13, 0);
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzh(i13, 0);
                        j = 0;
                        break;
                    }
                case 66:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzm(i13, zzh(t2, j3));
                        j = 0;
                        break;
                    }
                case 67:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzf(i13, zzi(t2, j3));
                        j = 0;
                        break;
                    }
                case 68:
                    if (!zza(t2, i13, i9)) {
                        j = 0;
                        break;
                    } else {
                        i10 += zzez.zzc(i13, (zzhb) unsafe2.getObject(t2, j3), zzat(i9));
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
        int zza = i10 + zza(this.zzzz, t2);
        if (this.zzzq) {
            zza += this.zzaaa.zzd(t2).zzgv();
        }
        return zza;
    }

    private static <UT, UB> int zza(zzip<UT, UB> zzip, T t) {
        return zzip.zzp(zzip.zzs(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zziv.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05aa  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b59  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzjk r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzgk()
            int r1 = com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxr
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c0
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r0 = r13.zzzz
            zza(r0, (T) r14, r15)
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.internal.firebase_auth.zzfg<?> r0 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r0 = r0.zzd(r14)
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
            int[] r7 = r13.zzzl
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x003a:
            if (r7 < 0) goto L_0x05a8
            int r8 = r13.zzaw(r7)
            int[] r9 = r13.zzzl
            r9 = r9[r7]
        L_0x0046:
            if (r1 == 0) goto L_0x0064
            com.google.android.gms.internal.firebase_auth.zzfg<?> r10 = r13.zzaaa
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0064
            com.google.android.gms.internal.firebase_auth.zzfg<?> r10 = r13.zzaaa
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
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
            r15.zzi(r9, r8)
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
            r15.zzq(r9, r8)
            goto L_0x05a4
        L_0x00cc:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x05a4
        L_0x00de:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x05a4
        L_0x00f0:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzeh r8 = (com.google.android.gms.internal.firebase_auth.zzeh) r8
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x0104:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zza(r9, r8, r10)
            goto L_0x05a4
        L_0x011a:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
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
            r15.zzj(r9, r8)
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
            r15.zzg(r9, r8)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x05a4
        L_0x01c8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r9, r8, r15, r10)
            goto L_0x05a4
        L_0x01e0:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x01f4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0208:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x021c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0230:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0244:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0258:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x026c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0280:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0294:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02a8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02bc:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02d0:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02e4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02f8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x030c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0320:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0334:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0348:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x035c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0370:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r9, r8, r15)
            goto L_0x05a4
        L_0x0384:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r9, r8, r15, r10)
            goto L_0x05a4
        L_0x039c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r9, r8, r15)
            goto L_0x05a4
        L_0x03b0:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03c4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03d8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03ec:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0400:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0414:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0428:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x043c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0450:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x05a4
        L_0x0466:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x05a4
        L_0x0479:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x05a4
        L_0x048c:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x05a4
        L_0x049f:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x05a4
        L_0x04b2:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x05a4
        L_0x04c5:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x05a4
        L_0x04d8:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzeh r8 = (com.google.android.gms.internal.firebase_auth.zzeh) r8
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x04ec:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zza(r9, r8, r10)
            goto L_0x05a4
        L_0x0502:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x05a4
        L_0x0514:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x05a4
        L_0x0527:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x05a4
        L_0x0539:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x05a4
        L_0x054b:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x05a4
        L_0x055d:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zza(r9, r10)
            goto L_0x05a4
        L_0x056f:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x05a4
        L_0x0581:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x05a4
        L_0x0593:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r14, r10)
            r15.zza(r9, r10)
        L_0x05a4:
            int r7 = r7 + -3
            goto L_0x003a
        L_0x05a8:
            if (r1 == 0) goto L_0x05bf
            com.google.android.gms.internal.firebase_auth.zzfg<?> r14 = r13.zzaaa
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
            boolean r0 = r13.zzzs
            if (r0 == 0) goto L_0x0b74
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x05e2
            com.google.android.gms.internal.firebase_auth.zzfg<?> r0 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r0 = r0.zzd(r14)
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
            int[] r7 = r13.zzzl
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x05e9:
            if (r1 >= r7) goto L_0x0b57
            int r9 = r13.zzaw(r1)
            int[] r10 = r13.zzzl
            r10 = r10[r1]
        L_0x05f5:
            if (r8 == 0) goto L_0x0613
            com.google.android.gms.internal.firebase_auth.zzfg<?> r11 = r13.zzaaa
            int r11 = r11.zza(r8)
            if (r11 > r10) goto L_0x0613
            com.google.android.gms.internal.firebase_auth.zzfg<?> r11 = r13.zzaaa
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
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
            r15.zzi(r10, r9)
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
            r15.zzq(r10, r9)
            goto L_0x0b53
        L_0x067b:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0b53
        L_0x068d:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0b53
        L_0x069f:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzeh r9 = (com.google.android.gms.internal.firebase_auth.zzeh) r9
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x06b3:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zza(r10, r9, r11)
            goto L_0x0b53
        L_0x06c9:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
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
            r15.zzj(r10, r9)
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
            r15.zzg(r10, r9)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            r13.zza(r15, r10, r9, r1)
            goto L_0x0b53
        L_0x0777:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r10, r9, r15, r11)
            goto L_0x0b53
        L_0x078f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07a3:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07b7:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07cb:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07df:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x07f3:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0807:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x081b:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x082f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0843:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0857:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x086b:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x087f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x0893:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r10, r9, r15, r4)
            goto L_0x0b53
        L_0x08a7:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08bb:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08cf:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08e3:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x08f7:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x090b:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x091f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r10, r9, r15)
            goto L_0x0b53
        L_0x0933:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r10, r9, r15, r11)
            goto L_0x0b53
        L_0x094b:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r10, r9, r15)
            goto L_0x0b53
        L_0x095f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x0973:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x0987:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x099b:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09af:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09c3:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09d7:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09eb:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r10, r9, r15, r5)
            goto L_0x0b53
        L_0x09ff:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zzb(r10, r9, r11)
            goto L_0x0b53
        L_0x0a15:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0b53
        L_0x0a28:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0b53
        L_0x0a3b:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0b53
        L_0x0a4e:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0b53
        L_0x0a61:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0b53
        L_0x0a74:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0b53
        L_0x0a87:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzeh r9 = (com.google.android.gms.internal.firebase_auth.zzeh) r9
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x0a9b:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zza(r10, r9, r11)
            goto L_0x0b53
        L_0x0ab1:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0b53
        L_0x0ac3:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0b53
        L_0x0ad6:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0b53
        L_0x0ae8:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0b53
        L_0x0afa:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0b53
        L_0x0b0c:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0b53
        L_0x0b1e:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0b53
        L_0x0b30:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0b53
        L_0x0b42:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0b53
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r14, r11)
            r15.zza(r10, r11)
        L_0x0b53:
            int r1 = r1 + 3
            goto L_0x05e9
        L_0x0b57:
            if (r8 == 0) goto L_0x0b6e
            com.google.android.gms.internal.firebase_auth.zzfg<?> r1 = r13.zzaaa
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
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r0 = r13.zzzz
            zza(r0, (T) r14, r15)
            return
        L_0x0b74:
            r13.zzb((T) r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjk):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.firebase_auth.zzjk r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzzq
            if (r3 == 0) goto L_0x0022
            com.google.android.gms.internal.firebase_auth.zzfg<?> r3 = r0.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r3 = r3.zzd(r1)
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
            int[] r7 = r0.zzzl
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzzk
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x056e
            int r12 = r0.zzaw(r5)
            int[] r13 = r0.zzzl
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzzs
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
            com.google.android.gms.internal.firebase_auth.zzfg<?> r4 = r0.zzaaa
            int r4 = r4.zza(r10)
            if (r4 > r14) goto L_0x008e
            com.google.android.gms.internal.firebase_auth.zzfg<?> r4 = r0.zzaaa
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
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r5)
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
            r2.zzi(r14, r4)
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
            r2.zzq(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x00fa:
            r15 = 0
            goto L_0x056a
        L_0x00fd:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x010d
            int r4 = zzh(r1, r12)
            r2.zzr(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x010d:
            r15 = 0
            goto L_0x056a
        L_0x0110:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0120
            int r4 = zzh(r1, r12)
            r2.zzh(r14, r4)
            r15 = 0
            goto L_0x056a
        L_0x0120:
            r15 = 0
            goto L_0x056a
        L_0x0123:
            boolean r4 = r0.zza((T) r1, r14, r5)
            if (r4 == 0) goto L_0x0135
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
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
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r5)
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
            r2.zzj(r14, r4)
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
            r2.zzg(r14, r4)
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
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhv r12 = r0.zzat(r5)
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x021b:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x022e:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0241:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0254:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0267:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x027a:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x028d:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02a0:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02b3:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02c6:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02d9:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02ec:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x02ff:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0312:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0325:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0338:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x034b:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x035e:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0371:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0384:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0397:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r4, r9, r2)
            r15 = 0
            goto L_0x056a
        L_0x03a9:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhv r12 = r0.zzat(r5)
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x03c0:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r4, r9, r2)
            r15 = 0
            goto L_0x056a
        L_0x03d2:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x03e5:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x03f8:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x040b:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x041e:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0431:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0444:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r12 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r4, r9, r2, r12)
            r15 = 0
            goto L_0x056a
        L_0x0457:
            int[] r4 = r0.zzzl
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zza(r4, r9, r2, r15)
            goto L_0x056a
        L_0x0469:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r5)
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
            r2.zzi(r14, r4)
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
            r2.zzq(r14, r4)
            goto L_0x056a
        L_0x04b4:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzr(r14, r4)
            goto L_0x056a
        L_0x04c2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x056a
        L_0x04d0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            r2.zza(r14, r4)
            goto L_0x056a
        L_0x04e0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r5)
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
            boolean r4 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r1, r12)
            r2.zzb(r14, r4)
            goto L_0x056a
        L_0x050e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            int r4 = r8.getInt(r1, r12)
            r2.zzj(r14, r4)
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
            r2.zzg(r14, r4)
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
            float r4 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r1, r12)
            r2.zza(r14, r4)
            goto L_0x056a
        L_0x055d:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x056a
            double r12 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r1, r12)
            r2.zza(r14, r12)
        L_0x056a:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x056e:
            r17 = r10
            r4 = r17
        L_0x0572:
            if (r4 == 0) goto L_0x0588
            com.google.android.gms.internal.firebase_auth.zzfg<?> r5 = r0.zzaaa
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
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r3 = r0.zzzz
            zza(r3, (T) r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjk):void");
    }

    private final <K, V> void zza(zzjk zzjk, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjk.zza(i, this.zzaab.zzo(zzau(i2)), this.zzaab.zzk(obj));
        }
    }

    private static <UT, UB> void zza(zzip<UT, UB> zzip, T t, zzjk zzjk) throws IOException {
        zzip.zza(zzip.zzs(t), zzjk);
    }

    public final void zza(T t, zzhq zzhq, zzff zzff) throws IOException {
        int i;
        Object obj;
        zzfj zzfj;
        T t2 = t;
        zzhq zzhq2 = zzhq;
        zzff zzff2 = zzff;
        if (zzff2 != null) {
            zzip<?, ?> zzip = this.zzzz;
            zzfg<?> zzfg = this.zzaaa;
            zzfj zzfj2 = null;
            Object obj2 = null;
            while (true) {
                try {
                    int zzgf = zzhq.zzgf();
                    if (zzgf < this.zzzn || zzgf > this.zzzo) {
                        i = -1;
                    } else {
                        int i2 = 0;
                        int length = (this.zzzl.length / 3) - 1;
                        while (true) {
                            if (i2 <= length) {
                                int i3 = (length + i2) >>> 1;
                                i = i3 * 3;
                                int i4 = this.zzzl[i];
                                if (zzgf != i4) {
                                    if (zzgf < i4) {
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
                        int zzaw = zzaw(i);
                        switch ((267386880 & zzaw) >>> 20) {
                            case 0:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.readDouble());
                                zzb(t2, i);
                                break;
                            case 1:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.readFloat());
                                zzb(t2, i);
                                break;
                            case 2:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.zzfj());
                                zzb(t2, i);
                                break;
                            case 3:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.zzfi());
                                zzb(t2, i);
                                break;
                            case 4:
                                zziv.zzb((Object) t2, (long) (zzaw & 1048575), zzhq.zzfk());
                                zzb(t2, i);
                                break;
                            case 5:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.zzfl());
                                zzb(t2, i);
                                break;
                            case 6:
                                zziv.zzb((Object) t2, (long) (zzaw & 1048575), zzhq.zzfm());
                                zzb(t2, i);
                                break;
                            case 7:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.zzfn());
                                zzb(t2, i);
                                break;
                            case 8:
                                zza((Object) t2, zzaw, zzhq2);
                                zzb(t2, i);
                                break;
                            case 9:
                                if (!zza(t2, i)) {
                                    zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq2.zza(zzat(i), zzff2));
                                    zzb(t2, i);
                                    break;
                                } else {
                                    long j = (long) (zzaw & 1048575);
                                    zziv.zza((Object) t2, j, zzfu.zza(zziv.zzp(t2, j), zzhq2.zza(zzat(i), zzff2)));
                                    break;
                                }
                            case 10:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) zzhq.zzfp());
                                zzb(t2, i);
                                break;
                            case 11:
                                zziv.zzb((Object) t2, (long) (zzaw & 1048575), zzhq.zzfq());
                                zzb(t2, i);
                                break;
                            case 12:
                                int zzfr = zzhq.zzfr();
                                zzfx zzav = zzav(i);
                                if (zzav != null) {
                                    if (!zzav.zzc(zzfr)) {
                                        obj2 = zzhx.zza(zzgf, zzfr, obj2, zzip);
                                        break;
                                    }
                                }
                                zziv.zzb((Object) t2, (long) (zzaw & 1048575), zzfr);
                                zzb(t2, i);
                                break;
                            case 13:
                                zziv.zzb((Object) t2, (long) (zzaw & 1048575), zzhq.zzfs());
                                zzb(t2, i);
                                break;
                            case 14:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.zzft());
                                zzb(t2, i);
                                break;
                            case 15:
                                zziv.zzb((Object) t2, (long) (zzaw & 1048575), zzhq.zzfu());
                                zzb(t2, i);
                                break;
                            case 16:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq.zzfv());
                                zzb(t2, i);
                                break;
                            case 17:
                                if (!zza(t2, i)) {
                                    zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq2.zzb(zzat(i), zzff2));
                                    zzb(t2, i);
                                    break;
                                } else {
                                    long j2 = (long) (zzaw & 1048575);
                                    zziv.zza((Object) t2, j2, zzfu.zza(zziv.zzp(t2, j2), zzhq2.zzb(zzat(i), zzff2)));
                                    break;
                                }
                            case 18:
                                zzhq2.zzd(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 19:
                                zzhq2.zze(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 20:
                                zzhq2.zzg(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 21:
                                zzhq2.zzf(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 22:
                                zzhq2.zzh(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 23:
                                zzhq2.zzi(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 24:
                                zzhq2.zzj(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 25:
                                zzhq2.zzk(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 26:
                                if (!zzay(zzaw)) {
                                    zzhq2.readStringList(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                    break;
                                } else {
                                    zzhq2.zzl(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                    break;
                                }
                            case 27:
                                zzhq2.zza(this.zzzy.zza(t2, (long) (zzaw & 1048575)), zzat(i), zzff2);
                                break;
                            case 28:
                                zzhq2.zzm(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 29:
                                zzhq2.zzn(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 30:
                                List zza = this.zzzy.zza(t2, (long) (zzaw & 1048575));
                                zzhq2.zzo(zza);
                                obj2 = zzhx.zza(zzgf, zza, zzav(i), obj2, zzip);
                                break;
                            case 31:
                                zzhq2.zzp(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 32:
                                zzhq2.zzq(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 33:
                                zzhq2.zzr(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 34:
                                zzhq2.zzs(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 35:
                                zzhq2.zzd(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 36:
                                zzhq2.zze(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 37:
                                zzhq2.zzg(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 38:
                                zzhq2.zzf(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 39:
                                zzhq2.zzh(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 40:
                                zzhq2.zzi(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 41:
                                zzhq2.zzj(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 42:
                                zzhq2.zzk(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 43:
                                zzhq2.zzn(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 44:
                                List zza2 = this.zzzy.zza(t2, (long) (zzaw & 1048575));
                                zzhq2.zzo(zza2);
                                obj2 = zzhx.zza(zzgf, zza2, zzav(i), obj2, zzip);
                                break;
                            case 45:
                                zzhq2.zzp(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 46:
                                zzhq2.zzq(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 47:
                                zzhq2.zzr(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 48:
                                zzhq2.zzs(this.zzzy.zza(t2, (long) (zzaw & 1048575)));
                                break;
                            case 49:
                                long j3 = (long) (zzaw & 1048575);
                                zzhq2.zzb(this.zzzy.zza(t2, j3), zzat(i), zzff2);
                                break;
                            case 50:
                                Object zzau = zzau(i);
                                long zzaw2 = (long) (zzaw(i) & 1048575);
                                Object zzp = zziv.zzp(t2, zzaw2);
                                if (zzp == null) {
                                    zzp = this.zzaab.zzn(zzau);
                                    zziv.zza((Object) t2, zzaw2, zzp);
                                } else if (this.zzaab.zzl(zzp)) {
                                    Object zzn = this.zzaab.zzn(zzau);
                                    this.zzaab.zzb(zzn, zzp);
                                    zziv.zza((Object) t2, zzaw2, zzn);
                                    zzp = zzn;
                                }
                                zzhq2.zza(this.zzaab.zzj(zzp), this.zzaab.zzo(zzau), zzff2);
                                break;
                            case 51:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Double.valueOf(zzhq.readDouble()));
                                zzb(t2, zzgf, i);
                                break;
                            case 52:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Float.valueOf(zzhq.readFloat()));
                                zzb(t2, zzgf, i);
                                break;
                            case 53:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Long.valueOf(zzhq.zzfj()));
                                zzb(t2, zzgf, i);
                                break;
                            case 54:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Long.valueOf(zzhq.zzfi()));
                                zzb(t2, zzgf, i);
                                break;
                            case 55:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Integer.valueOf(zzhq.zzfk()));
                                zzb(t2, zzgf, i);
                                break;
                            case 56:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Long.valueOf(zzhq.zzfl()));
                                zzb(t2, zzgf, i);
                                break;
                            case 57:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Integer.valueOf(zzhq.zzfm()));
                                zzb(t2, zzgf, i);
                                break;
                            case 58:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Boolean.valueOf(zzhq.zzfn()));
                                zzb(t2, zzgf, i);
                                break;
                            case 59:
                                zza((Object) t2, zzaw, zzhq2);
                                zzb(t2, zzgf, i);
                                break;
                            case 60:
                                if (zza(t2, zzgf, i)) {
                                    long j4 = (long) (zzaw & 1048575);
                                    zziv.zza((Object) t2, j4, zzfu.zza(zziv.zzp(t2, j4), zzhq2.zza(zzat(i), zzff2)));
                                } else {
                                    zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq2.zza(zzat(i), zzff2));
                                    zzb(t2, i);
                                }
                                zzb(t2, zzgf, i);
                                break;
                            case 61:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) zzhq.zzfp());
                                zzb(t2, zzgf, i);
                                break;
                            case 62:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Integer.valueOf(zzhq.zzfq()));
                                zzb(t2, zzgf, i);
                                break;
                            case 63:
                                int zzfr2 = zzhq.zzfr();
                                zzfx zzav2 = zzav(i);
                                if (zzav2 != null) {
                                    if (!zzav2.zzc(zzfr2)) {
                                        obj2 = zzhx.zza(zzgf, zzfr2, obj2, zzip);
                                        break;
                                    }
                                }
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Integer.valueOf(zzfr2));
                                zzb(t2, zzgf, i);
                                break;
                            case 64:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Integer.valueOf(zzhq.zzfs()));
                                zzb(t2, zzgf, i);
                                break;
                            case 65:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Long.valueOf(zzhq.zzft()));
                                zzb(t2, zzgf, i);
                                break;
                            case 66:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Integer.valueOf(zzhq.zzfu()));
                                zzb(t2, zzgf, i);
                                break;
                            case 67:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), (Object) Long.valueOf(zzhq.zzfv()));
                                zzb(t2, zzgf, i);
                                break;
                            case 68:
                                zziv.zza((Object) t2, (long) (zzaw & 1048575), zzhq2.zzb(zzat(i), zzff2));
                                zzb(t2, zzgf, i);
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = zzip.zzjm();
                                }
                                if (zzip.zza(obj2, zzhq2)) {
                                    break;
                                } else {
                                    for (int i5 = this.zzzv; i5 < this.zzzw; i5++) {
                                        obj2 = zza((Object) t2, this.zzzu[i5], (UB) obj2, zzip);
                                    }
                                    if (obj2 != null) {
                                        zzip.zzf(t2, obj2);
                                    }
                                    return;
                                }
                        }
                    } else if (zzgf == Integer.MAX_VALUE) {
                        for (int i6 = this.zzzv; i6 < this.zzzw; i6++) {
                            obj2 = zza((Object) t2, this.zzzu[i6], (UB) obj2, zzip);
                        }
                        if (obj2 != null) {
                            zzip.zzf(t2, obj2);
                        }
                        return;
                    } else {
                        if (!this.zzzq) {
                            obj = null;
                        } else {
                            obj = zzfg.zza(zzff2, this.zzzp, zzgf);
                        }
                        if (obj != null) {
                            if (zzfj2 == null) {
                                zzfj = zzfg.zze(t2);
                            } else {
                                zzfj = zzfj2;
                            }
                            obj2 = zzfg.zza(zzhq, obj, zzff, zzfj, obj2, zzip);
                            zzfj2 = zzfj;
                        } else {
                            zzip.zza(zzhq2);
                            if (obj2 == null) {
                                obj2 = zzip.zzt(t2);
                            }
                            if (!zzip.zza(obj2, zzhq2)) {
                                for (int i7 = this.zzzv; i7 < this.zzzw; i7++) {
                                    obj2 = zza((Object) t2, this.zzzu[i7], (UB) obj2, zzip);
                                }
                                if (obj2 != null) {
                                    zzip.zzf(t2, obj2);
                                }
                                return;
                            }
                        }
                    }
                } catch (zzgc e) {
                    zzip.zza(zzhq2);
                    if (obj2 == null) {
                        obj2 = zzip.zzt(t2);
                    }
                    if (!zzip.zza(obj2, zzhq2)) {
                        for (int i8 = this.zzzv; i8 < this.zzzw; i8++) {
                            obj2 = zza((Object) t2, this.zzzu[i8], (UB) obj2, zzip);
                        }
                        if (obj2 != null) {
                            zzip.zzf(t2, obj2);
                        }
                        return;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    for (int i9 = this.zzzv; i9 < this.zzzw; i9++) {
                        obj2 = zza((Object) t2, this.zzzu[i9], (UB) obj2, zzip);
                    }
                    if (obj2 != null) {
                        zzip.zzf(t2, obj2);
                    }
                    throw th2;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    private final zzhv zzat(int i) {
        int i2 = (i / 3) << 1;
        zzhv zzhv = (zzhv) this.zzzm[i2];
        if (zzhv != null) {
            return zzhv;
        }
        zzhv zzf = zzhn.zzit().zzf((Class) this.zzzm[i2 + 1]);
        this.zzzm[i2] = zzf;
        return zzf;
    }

    private final Object zzau(int i) {
        return this.zzzm[(i / 3) << 1];
    }

    private final zzfx zzav(int i) {
        return (zzfx) this.zzzm[((i / 3) << 1) + 1];
    }

    public final void zzf(T t) {
        int i;
        int i2 = this.zzzv;
        while (true) {
            i = this.zzzw;
            if (i2 >= i) {
                break;
            }
            long zzaw = (long) (zzaw(this.zzzu[i2]) & 1048575);
            Object zzp = zziv.zzp(t, zzaw);
            if (zzp != null) {
                zziv.zza((Object) t, zzaw, this.zzaab.zzm(zzp));
            }
            i2++;
        }
        int length = this.zzzu.length;
        while (i < length) {
            this.zzzy.zzb(t, (long) this.zzzu[i]);
            i++;
        }
        this.zzzz.zzf(t);
        if (this.zzzq) {
            this.zzaaa.zzf((Object) t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzip<UT, UB> zzip) {
        int i2 = this.zzzl[i];
        Object zzp = zziv.zzp(obj, (long) (zzaw(i) & 1048575));
        if (zzp == null) {
            return ub;
        }
        zzfx zzav = zzav(i);
        if (zzav == null) {
            return ub;
        }
        return zza(i, i2, this.zzaab.zzj(zzp), zzav, ub, zzip);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfx zzfx, UB ub, zzip<UT, UB> zzip) {
        zzgu zzo = this.zzaab.zzo(zzau(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!zzfx.zzc(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzip.zzjm();
                }
                zzeo zzl = zzeh.zzl(zzgt.zza(zzo, entry.getKey(), entry.getValue()));
                try {
                    zzgt.zza(zzl.zzfg(), zzo, entry.getKey(), entry.getValue());
                    zzip.zza(ub, i2, zzl.zzff());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzq(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzzv) {
                return !this.zzzq || this.zzaaa.zzd(t).isInitialized();
            }
            int i5 = this.zzzu[i2];
            int i6 = this.zzzl[i5];
            int zzaw = zzaw(i5);
            if (!this.zzzs) {
                int i7 = this.zzzl[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzzk.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzaw) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzaw) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzaw, zzat(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map zzk = this.zzaab.zzk(zziv.zzp(t, (long) (zzaw & 1048575)));
                            if (!zzk.isEmpty()) {
                                if (this.zzaab.zzo(zzau(i5)).zzze.zzjw() == zzjj.MESSAGE) {
                                    zzhv zzhv = null;
                                    Iterator it = zzk.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhv == null) {
                                            zzhv = zzhn.zzit().zzf(next.getClass());
                                        }
                                        if (!zzhv.zzq(next)) {
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
                List list = (List) zziv.zzp(t, (long) (zzaw & 1048575));
                if (!list.isEmpty()) {
                    zzhv zzat = zzat(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzat.zzq(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzaw, zzat(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zza(Object obj, int i, zzhv zzhv) {
        return zzhv.zzq(zziv.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzjk zzjk) throws IOException {
        if (obj instanceof String) {
            zzjk.zza(i, (String) obj);
        } else {
            zzjk.zza(i, (zzeh) obj);
        }
    }

    private final void zza(Object obj, int i, zzhq zzhq) throws IOException {
        if (zzay(i)) {
            zziv.zza(obj, (long) (i & 1048575), (Object) zzhq.zzfo());
        } else if (this.zzzr) {
            zziv.zza(obj, (long) (i & 1048575), (Object) zzhq.readString());
        } else {
            zziv.zza(obj, (long) (i & 1048575), (Object) zzhq.zzfp());
        }
    }

    private final int zzaw(int i) {
        return this.zzzl[i + 1];
    }

    private final int zzax(int i) {
        return this.zzzl[i + 2];
    }

    private static boolean zzay(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zziv.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zziv.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zziv.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zziv.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zziv.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzzs) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzzs) {
            int zzaw = zzaw(i);
            long j = (long) (zzaw & 1048575);
            switch ((zzaw & 267386880) >>> 20) {
                case 0:
                    return zziv.zzo(t, j) != 0.0d;
                case 1:
                    return zziv.zzn(t, j) != 0.0f;
                case 2:
                    return zziv.zzl(t, j) != 0;
                case 3:
                    return zziv.zzl(t, j) != 0;
                case 4:
                    return zziv.zzk(t, j) != 0;
                case 5:
                    return zziv.zzl(t, j) != 0;
                case 6:
                    return zziv.zzk(t, j) != 0;
                case 7:
                    return zziv.zzm(t, j);
                case 8:
                    Object zzp = zziv.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeh) {
                        return !zzeh.zzso.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zziv.zzp(t, j) != null;
                case 10:
                    return !zzeh.zzso.equals(zziv.zzp(t, j));
                case 11:
                    return zziv.zzk(t, j) != 0;
                case 12:
                    return zziv.zzk(t, j) != 0;
                case 13:
                    return zziv.zzk(t, j) != 0;
                case 14:
                    return zziv.zzl(t, j) != 0;
                case 15:
                    return zziv.zzk(t, j) != 0;
                case 16:
                    return zziv.zzl(t, j) != 0;
                case 17:
                    return zziv.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzax = zzax(i);
            return (zziv.zzk(t, (long) (zzax & 1048575)) & (1 << (zzax >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzzs) {
            int zzax = zzax(i);
            long j = (long) (zzax & 1048575);
            zziv.zzb((Object) t, j, zziv.zzk(t, j) | (1 << (zzax >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zziv.zzk(t, (long) (zzax(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zziv.zzb((Object) t, (long) (zzax(i2) & 1048575), i);
    }
}

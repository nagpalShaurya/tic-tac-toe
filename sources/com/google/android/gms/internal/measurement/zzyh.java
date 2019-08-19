package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzyh {
    private static final Logger logger = Logger.getLogger(zzyh.class.getName());
    private static final Class<?> zzbtv = zzua.zztz();
    private static final boolean zzbuv = zzyl();
    private static final Unsafe zzcay = zzyk();
    private static final boolean zzccv = zzm(Long.TYPE);
    private static final boolean zzccw = zzm(Integer.TYPE);
    private static final zzd zzccx;
    private static final boolean zzccy = zzym();
    /* access modifiers changed from: private */
    public static final long zzccz = ((long) zzk(byte[].class));
    private static final long zzcda = ((long) zzk(boolean[].class));
    private static final long zzcdb = ((long) zzl(boolean[].class));
    private static final long zzcdc = ((long) zzk(int[].class));
    private static final long zzcdd = ((long) zzl(int[].class));
    private static final long zzcde = ((long) zzk(long[].class));
    private static final long zzcdf = ((long) zzl(long[].class));
    private static final long zzcdg = ((long) zzk(float[].class));
    private static final long zzcdh = ((long) zzl(float[].class));
    private static final long zzcdi = ((long) zzk(double[].class));
    private static final long zzcdj = ((long) zzl(double[].class));
    private static final long zzcdk = ((long) zzk(Object[].class));
    private static final long zzcdl = ((long) zzl(Object[].class));
    private static final long zzcdm;
    /* access modifiers changed from: private */
    public static final boolean zzcdn = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzyh.zzcdn) {
                return zzyh.zzq(obj, j);
            }
            return zzyh.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzyh.zzcdn) {
                zzyh.zza(obj, j, b);
            } else {
                zzyh.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzyh.zzcdn) {
                return zzyh.zzs(obj, j);
            }
            return zzyh.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzyh.zzcdn) {
                zzyh.zzb(obj, j, z);
            } else {
                zzyh.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzyh.zzcdn) {
                return zzyh.zzq(obj, j);
            }
            return zzyh.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzyh.zzcdn) {
                zzyh.zza(obj, j, b);
            } else {
                zzyh.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzyh.zzcdn) {
                return zzyh.zzs(obj, j);
            }
            return zzyh.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzyh.zzcdn) {
                zzyh.zzb(obj, j, z);
            } else {
                zzyh.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzcdo.putByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzcdo.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzcdo.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzcdo.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzcdo.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzcdo.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzcdo.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzcdo.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzcdo.putDouble(obj, j, d);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzcdo.copyMemory(bArr, zzyh.zzccz + j, null, j2, j3);
        }
    }

    static abstract class zzd {
        Unsafe zzcdo;

        zzd(Unsafe unsafe) {
            this.zzcdo = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzcdo.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzcdo.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzcdo.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzcdo.putLong(obj, j, j2);
        }
    }

    private zzyh() {
    }

    static boolean zzyi() {
        return zzbuv;
    }

    static boolean zzyj() {
        return zzccy;
    }

    private static int zzk(Class<?> cls) {
        if (zzbuv) {
            return zzccx.zzcdo.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zzbuv) {
            return zzccx.zzcdo.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzccx.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzccx.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzccx.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzccx.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzccx.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzccx.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzccx.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzccx.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzccx.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzccx.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzccx.zzcdo.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzccx.zzcdo.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzccx.zzy(bArr, zzccz + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzccx.zze(bArr, zzccz + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzccx.zza(bArr, j, j2, j3);
    }

    static void zza(long j, byte b) {
        zzccx.zza(j, b);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzccx.zzl(byteBuffer, zzcdm);
    }

    static Unsafe zzyk() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzyi());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzyl() {
        Unsafe unsafe = zzcay;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzua.zzty()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzym() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = zzcay;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (zzyn() == null) {
                return false;
            }
            if (zzua.zzty()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod(str2, new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzua.zzty()) {
            return false;
        }
        try {
            Class<?> cls2 = zzbtv;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Field zzyn() {
        if (zzua.zzty()) {
            Field zzb2 = zzb(Buffer.class, "effectiveDirectAddress");
            if (zzb2 != null) {
                return zzb2;
            }
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f7  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzyh> r0 = com.google.android.gms.internal.measurement.zzyh.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzyk()
            zzcay = r0
            java.lang.Class r0 = com.google.android.gms.internal.measurement.zzua.zztz()
            zzbtv = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzm(r0)
            zzccv = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzm(r0)
            zzccw = r0
            sun.misc.Unsafe r0 = zzcay
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.measurement.zzua.zzty()
            if (r0 == 0) goto L_0x004d
            boolean r0 = zzccv
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.measurement.zzyh$zzb r1 = new com.google.android.gms.internal.measurement.zzyh$zzb
            sun.misc.Unsafe r0 = zzcay
            r1.<init>(r0)
            goto L_0x0054
        L_0x0040:
            boolean r0 = zzccw
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzyh$zza r1 = new com.google.android.gms.internal.measurement.zzyh$zza
            sun.misc.Unsafe r0 = zzcay
            r1.<init>(r0)
            goto L_0x0054
        L_0x004c:
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.measurement.zzyh$zzc r1 = new com.google.android.gms.internal.measurement.zzyh$zzc
            sun.misc.Unsafe r0 = zzcay
            r1.<init>(r0)
        L_0x0054:
            zzccx = r1
            boolean r0 = zzym()
            zzccy = r0
            boolean r0 = zzyl()
            zzbuv = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzccz = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzcda = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzcdb = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzcdc = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzcdd = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzcde = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzcdf = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzcdg = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzcdh = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzcdi = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzcdj = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzcdk = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzcdl = r0
            java.lang.reflect.Field r0 = zzyn()
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.measurement.zzyh$zzd r1 = zzccx
            if (r1 != 0) goto L_0x00e2
            goto L_0x00e9
        L_0x00e2:
            sun.misc.Unsafe r1 = r1.zzcdo
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00eb
        L_0x00e9:
            r0 = -1
        L_0x00eb:
            zzcdm = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            zzcdn = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzyh.<clinit>():void");
    }
}

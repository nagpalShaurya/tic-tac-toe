package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zziv {
    private static final Logger logger = Logger.getLogger(zziv.class.getName());
    private static final boolean zzabt = zzk(Long.TYPE);
    private static final boolean zzabu = zzk(Integer.TYPE);
    private static final zzd zzabv;
    private static final boolean zzabw = zzju();
    private static final long zzabx = ((long) zzi(byte[].class));
    private static final long zzaby = ((long) zzi(boolean[].class));
    private static final long zzabz = ((long) zzj(boolean[].class));
    private static final long zzaca = ((long) zzi(int[].class));
    private static final long zzacb = ((long) zzj(int[].class));
    private static final long zzacc = ((long) zzi(long[].class));
    private static final long zzacd = ((long) zzj(long[].class));
    private static final long zzace = ((long) zzi(float[].class));
    private static final long zzacf = ((long) zzj(float[].class));
    private static final long zzacg = ((long) zzi(double[].class));
    private static final long zzach = ((long) zzj(double[].class));
    private static final long zzaci = ((long) zzi(Object[].class));
    private static final long zzacj = ((long) zzj(Object[].class));
    private static final long zzack;
    /* access modifiers changed from: private */
    public static final boolean zzacl = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    private static final Class<?> zzsk = zzee.zzey();
    private static final boolean zztp = zzjt();
    private static final Unsafe zzzk = zzjs();

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzq(obj, j);
            }
            return zziv.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zziv.zzacl) {
                zziv.zza(obj, j, b);
            } else {
                zziv.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzs(obj, j);
            }
            return zziv.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zziv.zzacl) {
                zziv.zzb(obj, j, z);
            } else {
                zziv.zzc(obj, j, z);
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
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzq(obj, j);
            }
            return zziv.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zziv.zzacl) {
                zziv.zza(obj, j, b);
            } else {
                zziv.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzs(obj, j);
            }
            return zziv.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zziv.zzacl) {
                zziv.zzb(obj, j, z);
            } else {
                zziv.zzc(obj, j, z);
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
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzacm.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzacm.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzacm.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzacm.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzacm.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzacm.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzacm.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzacm.putDouble(obj, j, d);
        }
    }

    static abstract class zzd {
        Unsafe zzacm;

        zzd(Unsafe unsafe) {
            this.zzacm = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzacm.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzacm.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzacm.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzacm.putLong(obj, j, j2);
        }
    }

    private zziv() {
    }

    static boolean zzjq() {
        return zztp;
    }

    static boolean zzjr() {
        return zzabw;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return zzzk.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zztp) {
            return zzabv.zzacm.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zztp) {
            return zzabv.zzacm.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzabv.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzabv.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzabv.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzabv.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzabv.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzabv.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzabv.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzabv.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzabv.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzabv.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzabv.zzacm.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzabv.zzacm.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzabv.zzy(bArr, zzabx + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzabv.zze(bArr, zzabx + j, b);
    }

    static Unsafe zzjs() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zziw());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzjt() {
        Unsafe unsafe = zzzk;
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
            if (zzee.zzex()) {
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

    private static boolean zzju() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = zzzk;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (zzjv() == null) {
                return false;
            }
            if (zzee.zzex()) {
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

    private static boolean zzk(Class<?> cls) {
        if (!zzee.zzex()) {
            return false;
        }
        try {
            Class<?> cls2 = zzsk;
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

    private static Field zzjv() {
        if (zzee.zzex()) {
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
            java.lang.Class<com.google.android.gms.internal.firebase_auth.zziv> r0 = com.google.android.gms.internal.firebase_auth.zziv.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzjs()
            zzzk = r0
            java.lang.Class r0 = com.google.android.gms.internal.firebase_auth.zzee.zzey()
            zzsk = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzk(r0)
            zzabt = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzk(r0)
            zzabu = r0
            sun.misc.Unsafe r0 = zzzk
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.firebase_auth.zzee.zzex()
            if (r0 == 0) goto L_0x004d
            boolean r0 = zzabt
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.firebase_auth.zziv$zzb r1 = new com.google.android.gms.internal.firebase_auth.zziv$zzb
            sun.misc.Unsafe r0 = zzzk
            r1.<init>(r0)
            goto L_0x0054
        L_0x0040:
            boolean r0 = zzabu
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.internal.firebase_auth.zziv$zza r1 = new com.google.android.gms.internal.firebase_auth.zziv$zza
            sun.misc.Unsafe r0 = zzzk
            r1.<init>(r0)
            goto L_0x0054
        L_0x004c:
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.firebase_auth.zziv$zzc r1 = new com.google.android.gms.internal.firebase_auth.zziv$zzc
            sun.misc.Unsafe r0 = zzzk
            r1.<init>(r0)
        L_0x0054:
            zzabv = r1
            boolean r0 = zzju()
            zzabw = r0
            boolean r0 = zzjt()
            zztp = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzabx = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzaby = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzabz = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzaca = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzacb = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzacc = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzacd = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzace = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzacf = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzacg = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzach = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzaci = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzacj = r0
            java.lang.reflect.Field r0 = zzjv()
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.firebase_auth.zziv$zzd r1 = zzabv
            if (r1 != 0) goto L_0x00e2
            goto L_0x00e9
        L_0x00e2:
            sun.misc.Unsafe r1 = r1.zzacm
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00eb
        L_0x00e9:
            r0 = -1
        L_0x00eb:
            zzack = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            zzacl = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zziv.<clinit>():void");
    }
}

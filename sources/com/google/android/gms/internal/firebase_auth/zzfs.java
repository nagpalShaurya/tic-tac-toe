package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.android.gms.internal.firebase_auth.zzfs.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzfs<MessageType extends zzfs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdz<MessageType, BuilderType> {
    private static Map<Object, zzfs<?, ?>> zzxa = new ConcurrentHashMap();
    protected zziq zzwy = zziq.zzjn();
    private int zzwz = -1;

    public static abstract class zza<MessageType extends zzfs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzea<MessageType, BuilderType> {
        private final MessageType zzxb;
        protected MessageType zzxc;
        private boolean zzxd = false;

        protected zza(MessageType messagetype) {
            this.zzxb = messagetype;
            this.zzxc = (zzfs) messagetype.zza(zze.zzxi, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzhi() {
            if (this.zzxd) {
                MessageType messagetype = (zzfs) this.zzxc.zza(zze.zzxi, (Object) null, (Object) null);
                zza(messagetype, this.zzxc);
                this.zzxc = messagetype;
                this.zzxd = false;
            }
        }

        public final boolean isInitialized() {
            return zzfs.zza(this.zzxc, false);
        }

        /* renamed from: zzhj */
        public MessageType zzhl() {
            if (this.zzxd) {
                return this.zzxc;
            }
            MessageType messagetype = this.zzxc;
            zzhn.zzit().zzr(messagetype).zzf(messagetype);
            this.zzxd = true;
            return this.zzxc;
        }

        /* renamed from: zzhk */
        public final MessageType zzhm() {
            MessageType messagetype = (zzfs) zzhl();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzhn.zzit().zzr(messagetype).zzq(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzxg, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzio(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzhi();
            zza(this.zzxc, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhn.zzit().zzr(messagetype).zzc(messagetype, messagetype2);
        }

        public final /* synthetic */ zzea zzet() {
            return (zza) clone();
        }

        public final /* synthetic */ zzhb zzhh() {
            return this.zzxb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzfs) this.zzxb).zza(zze.zzxj, (Object) null, (Object) null);
            zza.zza((MessageType) (zzfs) zzhl());
            return zza;
        }
    }

    public static class zzb<T extends zzfs<T, ?>> extends zzec<T> {
        private final T zzxb;

        public zzb(T t) {
            this.zzxb = t;
        }

        public final /* synthetic */ Object zza(zzes zzes, zzff zzff) throws zzgb {
            return zzfs.zza(this.zzxb, zzes, zzff);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzfs<MessageType, BuilderType> implements zzhd {
        protected zzfj<Object> zzxe = zzfj.zzgu();
    }

    public static class zzd<ContainingType extends zzhb, Type> extends zzfd<ContainingType, Type> {
    }

    /* 'enum' access flag removed */
    public static final class zze {
        public static final int zzxf = 1;
        public static final int zzxg = 2;
        public static final int zzxh = 3;
        public static final int zzxi = 4;
        public static final int zzxj = 5;
        public static final int zzxk = 6;
        public static final int zzxl = 7;
        private static final /* synthetic */ int[] zzxm = {zzxf, zzxg, zzxh, zzxi, zzxj, zzxk, zzxl};
        public static final int zzxn = 1;
        public static final int zzxo = 2;
        private static final /* synthetic */ int[] zzxp = {zzxn, zzxo};
        public static final int zzxq = 1;
        public static final int zzxr = 2;
        private static final /* synthetic */ int[] zzxs = {zzxq, zzxr};

        public static int[] zzhn() {
            return (int[]) zzxm.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzhe.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzsf != 0) {
            return this.zzsf;
        }
        this.zzsf = zzhn.zzit().zzr(this).hashCode(this);
        return this.zzsf;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzfs) zza(zze.zzxk, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzhn.zzit().zzr(this).equals(this, (zzfs) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzq = zzhn.zzit().zzr(this).zzq(this);
        if (booleanValue) {
            zza(zze.zzxg, (Object) zzq ? this : null, (Object) null);
        }
        return zzq;
    }

    /* access modifiers changed from: 0000 */
    public final int zzes() {
        return this.zzwz;
    }

    /* access modifiers changed from: 0000 */
    public final void zzg(int i) {
        this.zzwz = i;
    }

    public final void zzb(zzez zzez) throws IOException {
        zzhn.zzit().zzf(getClass()).zza(this, zzfb.zza(zzez));
    }

    public final int zzgv() {
        if (this.zzwz == -1) {
            this.zzwz = zzhn.zzit().zzr(this).zzp(this);
        }
        return this.zzwz;
    }

    static <T extends zzfs<?, ?>> T zzd(Class<T> cls) {
        T t = (zzfs) zzxa.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfs) zzxa.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzfs) ((zzfs) zziv.zzh(cls)).zza(zze.zzxk, (Object) null, (Object) null);
            if (t != null) {
                zzxa.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzfs<?, ?>> void zza(Class<T> cls, T t) {
        zzxa.put(cls, t);
    }

    protected static Object zza(zzhb zzhb, String str, Object[] objArr) {
        return new zzhp(zzhb, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzfs<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzhn.zzit().zzr(t).zzq(t);
    }

    protected static zzfy zzhd() {
        return zzft.zzho();
    }

    protected static <E> zzga<E> zzhe() {
        return zzho.zziu();
    }

    static <T extends zzfs<T, ?>> T zza(T t, zzes zzes, zzff zzff) throws zzgb {
        T t2 = (zzfs) t.zza(zze.zzxi, (Object) null, (Object) null);
        try {
            zzhn.zzit().zzr(t2).zza(t2, zzex.zza(zzes), zzff);
            zzhn.zzit().zzr(t2).zzf(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzgb) {
                throw ((zzgb) e.getCause());
            }
            throw new zzgb(e.getMessage()).zzh(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzgb) {
                throw ((zzgb) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzhc zzhf() {
        zza zza2 = (zza) zza(zze.zzxj, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzhc zzhg() {
        return (zza) zza(zze.zzxj, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzhb zzhh() {
        return (zzfs) zza(zze.zzxk, (Object) null, (Object) null);
    }
}

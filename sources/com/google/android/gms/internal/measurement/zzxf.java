package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzxf {
    private static final zzxf zzcbs = new zzxf();
    private final zzxk zzcbt;
    private final ConcurrentMap<Class<?>, zzxj<?>> zzcbu = new ConcurrentHashMap();

    public static zzxf zzxn() {
        return zzcbs;
    }

    public final <T> zzxj<T> zzi(Class<T> cls) {
        String str = "messageType";
        zzvo.zza(cls, str);
        zzxj<T> zzxj = (zzxj) this.zzcbu.get(cls);
        if (zzxj != null) {
            return zzxj;
        }
        zzxj<T> zzh = this.zzcbt.zzh(cls);
        zzvo.zza(cls, str);
        zzvo.zza(zzh, "schema");
        zzxj zzxj2 = (zzxj) this.zzcbu.putIfAbsent(cls, zzh);
        if (zzxj2 != null) {
            return zzxj2;
        }
        return zzh;
    }

    public final <T> zzxj<T> zzag(T t) {
        return zzi(t.getClass());
    }

    private zzxf() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzxk zzxk = null;
        for (int i = 0; i <= 0; i++) {
            zzxk = zzgb(strArr[0]);
            if (zzxk != null) {
                break;
            }
        }
        if (zzxk == null) {
            zzxk = new zzwi();
        }
        this.zzcbt = zzxk;
    }

    private static zzxk zzgb(String str) {
        try {
            return (zzxk) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }
}

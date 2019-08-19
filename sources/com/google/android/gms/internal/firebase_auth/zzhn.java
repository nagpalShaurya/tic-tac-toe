package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzhn {
    private static final zzhn zzaae = new zzhn();
    private final zzhw zzaaf;
    private final ConcurrentMap<Class<?>, zzhv<?>> zzaag = new ConcurrentHashMap();

    public static zzhn zzit() {
        return zzaae;
    }

    public final <T> zzhv<T> zzf(Class<T> cls) {
        String str = "messageType";
        zzfu.zza(cls, str);
        zzhv<T> zzhv = (zzhv) this.zzaag.get(cls);
        if (zzhv != null) {
            return zzhv;
        }
        zzhv<T> zze = this.zzaaf.zze(cls);
        zzfu.zza(cls, str);
        zzfu.zza(zze, "schema");
        zzhv zzhv2 = (zzhv) this.zzaag.putIfAbsent(cls, zze);
        if (zzhv2 != null) {
            return zzhv2;
        }
        return zze;
    }

    public final <T> zzhv<T> zzr(T t) {
        return zzf(t.getClass());
    }

    private zzhn() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzhw zzhw = null;
        for (int i = 0; i <= 0; i++) {
            zzhw = zzdd(strArr[0]);
            if (zzhw != null) {
                break;
            }
        }
        if (zzhw == null) {
            zzhw = new zzgq();
        }
        this.zzaaf = zzhw;
    }

    private static zzhw zzdd(String str) {
        try {
            return (zzhw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }
}

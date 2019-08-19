package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzgx implements zzgw {
    zzgx() {
    }

    public final Map<?, ?> zzj(Object obj) {
        return (zzgv) obj;
    }

    public final zzgu<?, ?> zzo(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzk(Object obj) {
        return (zzgv) obj;
    }

    public final boolean zzl(Object obj) {
        return !((zzgv) obj).isMutable();
    }

    public final Object zzm(Object obj) {
        ((zzgv) obj).zzev();
        return obj;
    }

    public final Object zzn(Object obj) {
        return zzgv.zzig().zzih();
    }

    public final Object zzb(Object obj, Object obj2) {
        zzgv zzgv = (zzgv) obj;
        zzgv zzgv2 = (zzgv) obj2;
        if (!zzgv2.isEmpty()) {
            if (!zzgv.isMutable()) {
                zzgv = zzgv.zzih();
            }
            zzgv.zza(zzgv2);
        }
        return zzgv;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzgv zzgv = (zzgv) obj;
        if (zzgv.isEmpty()) {
            return 0;
        }
        Iterator it = zzgv.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}

package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzwp implements zzwo {
    zzwp() {
    }

    public final Map<?, ?> zzy(Object obj) {
        return (zzwn) obj;
    }

    public final zzwm<?, ?> zzad(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzz(Object obj) {
        return (zzwn) obj;
    }

    public final boolean zzaa(Object obj) {
        return !((zzwn) obj).isMutable();
    }

    public final Object zzab(Object obj) {
        ((zzwn) obj).zzsm();
        return obj;
    }

    public final Object zzac(Object obj) {
        return zzwn.zzxa().zzxb();
    }

    public final Object zzc(Object obj, Object obj2) {
        zzwn zzwn = (zzwn) obj;
        zzwn zzwn2 = (zzwn) obj2;
        if (!zzwn2.isEmpty()) {
            if (!zzwn.isMutable()) {
                zzwn = zzwn.zzxb();
            }
            zzwn.zza(zzwn2);
        }
        return zzwn;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzwn zzwn = (zzwn) obj;
        if (zzwn.isEmpty()) {
            return 0;
        }
        Iterator it = zzwn.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}

package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzwf extends zzwd {
    private static final Class<?> zzcal = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzwf() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzyh.zzp(obj, j);
        if (list instanceof zzwc) {
            obj2 = ((zzwc) list).zzww();
        } else if (!zzcal.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzxe) || !(list instanceof zzvs)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzvs zzvs = (zzvs) list;
                if (zzvs.zztw()) {
                    zzvs.zzsm();
                }
                return;
            }
        } else {
            return;
        }
        zzyh.zza(obj, j, obj2);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzwc) {
                list = new zzwb<>(i);
            } else if (!(zzc instanceof zzxe) || !(zzc instanceof zzvs)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzvs) zzc).zzak(i);
            }
            zzyh.zza(obj, j, (Object) list);
            return list;
        } else if (zzcal.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzyh.zza(obj, j, (Object) arrayList);
            return arrayList;
        } else if (zzc instanceof zzye) {
            zzwb zzwb = new zzwb(zzc.size() + i);
            zzwb.addAll((zzye) zzc);
            zzyh.zza(obj, j, (Object) zzwb);
            return zzwb;
        } else if (!(zzc instanceof zzxe) || !(zzc instanceof zzvs)) {
            return zzc;
        } else {
            zzvs zzvs = (zzvs) zzc;
            if (zzvs.zztw()) {
                return zzc;
            }
            zzvs zzak = zzvs.zzak(zzc.size() + i);
            zzyh.zza(obj, j, (Object) zzak);
            return zzak;
        }
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza;
        }
        zzyh.zza(obj, j, (Object) zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzyh.zzp(obj, j);
    }
}

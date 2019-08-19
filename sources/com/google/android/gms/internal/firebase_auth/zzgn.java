package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzgn extends zzgl {
    private static final Class<?> zzyw = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgn() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zziv.zzp(obj, j);
        if (list instanceof zzgk) {
            obj2 = ((zzgk) list).zzic();
        } else if (!zzyw.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhm) || !(list instanceof zzga)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzga zzga = (zzga) list;
                if (zzga.zzeu()) {
                    zzga.zzev();
                }
                return;
            }
        } else {
            return;
        }
        zziv.zza(obj, j, obj2);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzgk) {
                list = new zzgj<>(i);
            } else if (!(zzc instanceof zzhm) || !(zzc instanceof zzga)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzga) zzc).zzj(i);
            }
            zziv.zza(obj, j, (Object) list);
            return list;
        } else if (zzyw.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zziv.zza(obj, j, (Object) arrayList);
            return arrayList;
        } else if (zzc instanceof zzis) {
            zzgj zzgj = new zzgj(zzc.size() + i);
            zzgj.addAll((zzis) zzc);
            zziv.zza(obj, j, (Object) zzgj);
            return zzgj;
        } else if (!(zzc instanceof zzhm) || !(zzc instanceof zzga)) {
            return zzc;
        } else {
            zzga zzga = (zzga) zzc;
            if (zzga.zzeu()) {
                return zzc;
            }
            zzga zzj = zzga.zzj(zzc.size() + i);
            zziv.zza(obj, j, (Object) zzj);
            return zzj;
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
        zziv.zza(obj, j, (Object) zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zziv.zzp(obj, j);
    }
}

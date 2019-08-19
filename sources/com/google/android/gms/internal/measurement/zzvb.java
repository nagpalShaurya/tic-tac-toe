package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzvm.zzc;
import java.io.IOException;
import java.util.Map.Entry;

final class zzvb extends zzva<Object> {
    zzvb() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean zze(zzwt zzwt) {
        return zzwt instanceof zzc;
    }

    /* access modifiers changed from: 0000 */
    public final zzvd<Object> zzs(Object obj) {
        return ((zzc) obj).zzbys;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Object obj, zzvd<Object> zzvd) {
        ((zzc) obj).zzbys = zzvd;
    }

    /* access modifiers changed from: 0000 */
    public final zzvd<Object> zzt(Object obj) {
        zzvd<Object> zzs = zzs(obj);
        if (!zzs.isImmutable()) {
            return zzs;
        }
        zzvd<Object> zzvd = (zzvd) zzs.clone();
        zza(obj, zzvd);
        return zzvd;
    }

    /* access modifiers changed from: 0000 */
    public final void zzu(Object obj) {
        zzs(obj).zzsm();
    }

    /* access modifiers changed from: 0000 */
    public final <UT, UB> UB zza(zzxi zzxi, Object obj, zzuz zzuz, zzvd<Object> zzvd, UB ub, zzyb<UT, UB> zzyb) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final int zzb(Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzyw zzyw, Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final Object zza(zzuz zzuz, zzwt zzwt, int i) {
        return zzuz.zza(zzwt, i);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzxi zzxi, Object obj, zzuz zzuz, zzvd<Object> zzvd) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzud zzud, Object obj, zzuz zzuz, zzvd<Object> zzvd) throws IOException {
        throw new NoSuchMethodError();
    }
}

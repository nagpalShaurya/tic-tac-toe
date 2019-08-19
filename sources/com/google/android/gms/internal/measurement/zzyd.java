package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzyd extends zzyb<zzyc, zzyc> {
    zzyd() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzxi zzxi) {
        return false;
    }

    private static void zza(Object obj, zzyc zzyc) {
        ((zzvm) obj).zzbym = zzyc;
    }

    /* access modifiers changed from: 0000 */
    public final void zzu(Object obj) {
        ((zzvm) obj).zzbym.zzsm();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzae(Object obj) {
        return ((zzyc) obj).zzvu();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzaj(Object obj) {
        return ((zzyc) obj).zzyh();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzyc zzyc = (zzyc) obj;
        zzyc zzyc2 = (zzyc) obj2;
        if (zzyc2.equals(zzyc.zzyf())) {
            return zzyc;
        }
        return zzyc.zza(zzyc, zzyc2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, zzyw zzyw) throws IOException {
        ((zzyc) obj).zza(zzyw);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, zzyw zzyw) throws IOException {
        ((zzyc) obj).zzb(zzyw);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzyc) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzai(Object obj) {
        zzyc zzyc = ((zzvm) obj).zzbym;
        if (zzyc != zzyc.zzyf()) {
            return zzyc;
        }
        zzyc zzyg = zzyc.zzyg();
        zza(obj, zzyg);
        return zzyg;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzah(Object obj) {
        return ((zzvm) obj).zzbym;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzyc) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzab(Object obj) {
        zzyc zzyc = (zzyc) obj;
        zzyc.zzsm();
        return zzyc;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzye() {
        return zzyc.zzyg();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzyc) obj).zzb((i << 3) | 3, (Object) (zzyc) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, zzud zzud) {
        ((zzyc) obj).zzb((i << 3) | 2, (Object) zzud);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzyc) obj).zzb((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzyc) obj).zzb((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzyc) obj).zzb(i << 3, (Object) Long.valueOf(j));
    }
}

package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzyb<T, B> {
    zzyb() {
    }

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, zzud zzud);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zza(T t, zzyw zzyw) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract boolean zza(zzxi zzxi);

    /* access modifiers changed from: 0000 */
    public abstract T zzab(B b);

    /* access modifiers changed from: 0000 */
    public abstract int zzae(T t);

    /* access modifiers changed from: 0000 */
    public abstract T zzah(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B zzai(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract int zzaj(T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(T t, zzyw zzyw) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzf(Object obj, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzg(Object obj, B b);

    /* access modifiers changed from: 0000 */
    public abstract T zzh(T t, T t2);

    /* access modifiers changed from: 0000 */
    public abstract void zzu(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B zzye();

    /* access modifiers changed from: 0000 */
    public final boolean zza(B b, zzxi zzxi) throws IOException {
        int tag = zzxi.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzxi.zzui());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzxi.zzuk());
            return true;
        } else if (i2 == 2) {
            zza(b, i, zzxi.zzuo());
            return true;
        } else if (i2 == 3) {
            Object zzye = zzye();
            int i3 = 4 | (i << 3);
            while (zzxi.zzve() != Integer.MAX_VALUE) {
                if (!zza((B) zzye, zzxi)) {
                    break;
                }
            }
            if (i3 == zzxi.getTag()) {
                zza(b, i, (T) zzab(zzye));
                return true;
            }
            throw zzvt.zzwn();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzxi.zzul());
                return true;
            }
            throw zzvt.zzwo();
        }
    }
}

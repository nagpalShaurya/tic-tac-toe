package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

abstract class zzip<T, B> {
    zzip() {
    }

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, zzeh zzeh);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zza(T t, zzjk zzjk) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract boolean zza(zzhq zzhq);

    /* access modifiers changed from: 0000 */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(T t, zzjk zzjk) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zze(Object obj, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzf(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract void zzf(Object obj, B b);

    /* access modifiers changed from: 0000 */
    public abstract T zzg(T t, T t2);

    /* access modifiers changed from: 0000 */
    public abstract B zzjm();

    /* access modifiers changed from: 0000 */
    public abstract T zzm(B b);

    /* access modifiers changed from: 0000 */
    public abstract int zzp(T t);

    /* access modifiers changed from: 0000 */
    public abstract T zzs(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B zzt(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract int zzu(T t);

    /* access modifiers changed from: 0000 */
    public final boolean zza(B b, zzhq zzhq) throws IOException {
        int tag = zzhq.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzhq.zzfj());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzhq.zzfl());
            return true;
        } else if (i2 == 2) {
            zza(b, i, zzhq.zzfp());
            return true;
        } else if (i2 == 3) {
            Object zzjm = zzjm();
            int i3 = 4 | (i << 3);
            while (zzhq.zzgf() != Integer.MAX_VALUE) {
                if (!zza((B) zzjm, zzhq)) {
                    break;
                }
            }
            if (i3 == zzhq.getTag()) {
                zza(b, i, (T) zzm(zzjm));
                return true;
            }
            throw zzgb.zzht();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzhq.zzfm());
                return true;
            }
            throw zzgb.zzhu();
        }
    }
}

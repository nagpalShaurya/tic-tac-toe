package com.google.android.gms.internal.firebase_auth;

import java.util.List;

final class zzab extends zzz<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzz zzfp;

    zzab(zzz zzz, int i, int i2) {
        this.zzfp = zzz;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzbp() {
        return this.zzfp.zzbp();
    }

    /* access modifiers changed from: 0000 */
    public final int zzbq() {
        return this.zzfp.zzbq() + this.offset;
    }

    /* access modifiers changed from: 0000 */
    public final int zzbr() {
        return this.zzfp.zzbq() + this.offset + this.length;
    }

    public final E get(int i) {
        zzv.zza(i, this.length);
        return this.zzfp.get(i + this.offset);
    }

    public final zzz<E> zzc(int i, int i2) {
        zzv.zza(i, i2, this.length);
        zzz zzz = this.zzfp;
        int i3 = this.offset;
        return (zzz) zzz.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}

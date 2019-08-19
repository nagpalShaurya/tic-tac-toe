package com.google.android.gms.measurement.internal;

abstract class zzf extends zze {
    private boolean zzvz;

    zzf(zzbt zzbt) {
        super(zzbt);
        this.zzadj.zzb(this);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzgt();

    /* access modifiers changed from: 0000 */
    public final boolean isInitialized() {
        return this.zzvz;
    }

    /* access modifiers changed from: protected */
    public final void zzcl() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzq() {
        if (this.zzvz) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzgt()) {
            this.zzadj.zzkq();
            this.zzvz = true;
        }
    }

    public final void zzgs() {
        if (!this.zzvz) {
            zzgu();
            this.zzadj.zzkq();
            this.zzvz = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public void zzgu() {
    }
}

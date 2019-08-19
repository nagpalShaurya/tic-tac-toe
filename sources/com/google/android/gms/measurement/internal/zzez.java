package com.google.android.gms.measurement.internal;

abstract class zzez extends zzey {
    private boolean zzvz;

    zzez(zzfa zzfa) {
        super(zzfa);
        this.zzamz.zzb(this);
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
        if (!this.zzvz) {
            zzgt();
            this.zzamz.zzma();
            this.zzvz = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}

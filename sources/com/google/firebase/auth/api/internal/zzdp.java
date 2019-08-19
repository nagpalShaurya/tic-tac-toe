package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;

public final class zzdp {
    private final Logger zzgg;
    private final zzdx zzmg;

    public zzdp(@NonNull zzdx zzdx, @NonNull Logger logger) {
        this.zzmg = (zzdx) Preconditions.checkNotNull(zzdx);
        this.zzgg = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zzb(@NonNull zzcz zzcz) {
        try {
            this.zzmg.zzb(zzcz);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zza(@NonNull zzcz zzcz, @NonNull zzct zzct) {
        try {
            this.zzmg.zza(zzcz, zzct);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zza(@NonNull zzcj zzcj) {
        try {
            this.zzmg.zza(zzcj);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zza(@Nullable zzdg zzdg) {
        try {
            this.zzmg.zza(zzdg);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zzde() {
        try {
            this.zzmg.zzde();
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zzdf() {
        try {
            this.zzmg.zzdf();
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzbs(@NonNull String str) {
        try {
            this.zzmg.zzbs(str);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public final void onFailure(@NonNull Status status) {
        try {
            this.zzmg.onFailure(status);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzdg() {
        try {
            this.zzmg.zzdg();
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zza(@NonNull zzcg zzcg) {
        try {
            this.zzmg.zza(zzcg);
        } catch (RemoteException e) {
            this.zzgg.mo7716e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }
}

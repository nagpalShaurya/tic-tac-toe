package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzq;

final class zzac implements zzez<zzcz> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;
    private final /* synthetic */ UserProfileChangeRequest zzjn;

    zzac(zza zza, UserProfileChangeRequest userProfileChangeRequest, zzdp zzdp) {
        this.zzis = zza;
        this.zzjn = userProfileChangeRequest;
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzcz zzcz = (zzcz) obj;
        zzdl zzdl = new zzdl();
        zzdl.zzci(zzcz.zzdw());
        if (this.zzjn.zzck() || this.zzjn.getDisplayName() != null) {
            zzdl.zzcl(this.zzjn.getDisplayName());
        }
        if (this.zzjn.zzcl() || this.zzjn.getPhotoUri() != null) {
            zzdl.zzcm(this.zzjn.zzal());
        }
        this.zzis.zza(this.zzir, zzcz, zzdl, (zzey) this);
    }
}

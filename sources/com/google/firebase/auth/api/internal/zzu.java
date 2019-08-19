package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.firebase.auth.internal.zzq;
import java.util.List;

final class zzu implements zzez<zzcr> {
    private final /* synthetic */ zzez zzjg;
    private final /* synthetic */ zzcz zzjj;
    private final /* synthetic */ zzt zzjk;

    zzu(zzt zzt, zzez zzez, zzcz zzcz) {
        this.zzjk = zzt;
        this.zzjg = zzez;
        this.zzjj = zzcz;
    }

    public final void zzbp(@Nullable String str) {
        this.zzjk.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        List zzdt = ((zzcr) obj).zzdt();
        if (zzdt == null || zzdt.isEmpty()) {
            this.zzjg.zzbp("No users.");
            return;
        }
        zzct zzct = (zzct) zzdt.get(0);
        zzdl zzdl = new zzdl();
        zzdl.zzci(this.zzjj.zzdw()).zzcn(this.zzjk.zzji);
        this.zzjk.zzis.zza(this.zzjk.zzir, this.zzjj, zzct, zzdl, (zzey) this.zzjg);
    }
}

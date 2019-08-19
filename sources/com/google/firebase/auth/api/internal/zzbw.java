package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzl;

@VisibleForTesting
final class zzbw extends zzeo<Void, zza> {
    @NonNull
    private final zzbu zzlb;

    public zzbw(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        super(2);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
        this.zzlb = new zzbu(str, str2, str3);
    }

    public final String zzda() {
        return "reauthenticateWithEmailPassword";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzbx(this)).build();
    }

    public final void zzdd() {
        zzl zza = zzao.zza(this.zzgm, this.zznl);
        if (this.zznd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zza) this.zzne).zza(this.zznk, zza);
            zzc(null);
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzo(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zzd(this.zzlb.getEmail(), this.zzlb.getPassword(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzlb, (zzdx) this.zznc);
        }
    }
}

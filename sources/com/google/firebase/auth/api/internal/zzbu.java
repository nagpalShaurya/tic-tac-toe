package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

@VisibleForTesting
final class zzbu extends zzeo<AuthResult, zza> {
    @NonNull
    private final zzbw zzky;

    public zzbu(@NonNull EmailAuthCredential emailAuthCredential) {
        super(2);
        Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null or empty");
        this.zzky = new zzbw(emailAuthCredential);
    }

    public final String zzda() {
        return "reauthenticateWithEmailLinkWithData";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzbv(this)).build();
    }

    public final void zzdd() {
        zzl zza = zzao.zza(this.zzgm, this.zznl);
        if (this.zznd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zza) this.zzne).zza(this.zznk, zza);
            zzc(new zzf(zza));
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzn(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzky.zzct(), (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzky, (zzdx) this.zznc);
        }
    }
}

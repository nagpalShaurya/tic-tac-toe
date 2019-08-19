package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

final class zzu implements OnFailureListener {
    private final /* synthetic */ zzt zzri;

    zzu(zzt zzt) {
        this.zzri = zzt;
    }

    public final void onFailure(@NonNull Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzs.zzgg.mo7720v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zzri.zzrh.zzei();
        }
    }
}

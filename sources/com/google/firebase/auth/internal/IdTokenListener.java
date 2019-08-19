package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.internal.InternalTokenResult;

@KeepForSdk
public interface IdTokenListener {
    @KeepForSdk
    void onIdTokenChanged(@NonNull InternalTokenResult internalTokenResult);
}

package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.internal.SignInClientImpl;

final class zab extends AbstractClientBuilder<SignInClientImpl, SignInOptions> {
    zab() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        SignInOptions signInOptions;
        SignInOptions signInOptions2 = (SignInOptions) obj;
        if (signInOptions2 == null) {
            signInOptions = SignInOptions.DEFAULT;
        } else {
            signInOptions = signInOptions2;
        }
        SignInClientImpl signInClientImpl = new SignInClientImpl(context, looper, true, clientSettings, signInOptions, connectionCallbacks, onConnectionFailedListener);
        return signInClientImpl;
    }
}

package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace extends zac implements ConnectionCallbacks, OnConnectionFailedListener {
    private static AbstractClientBuilder<? extends zad, SignInOptions> zakh = zaa.zapg;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> mScopes;
    private final AbstractClientBuilder<? extends zad, SignInOptions> zaau;
    private ClientSettings zaes;
    private zad zaga;
    /* access modifiers changed from: private */
    public zach zaki;

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        this(context, handler, clientSettings, zakh);
    }

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.mContext = context;
        this.mHandler = handler;
        this.zaes = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zaau = abstractClientBuilder;
    }

    @WorkerThread
    public final void zaa(zach zach) {
        zad zad = this.zaga;
        if (zad != null) {
            zad.disconnect();
        }
        this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zaau;
        Context context = this.mContext;
        Looper looper = this.mHandler.getLooper();
        ClientSettings clientSettings = this.zaes;
        this.zaga = (zad) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), this, this);
        this.zaki = zach;
        Set<Scope> set = this.mScopes;
        if (set == null || set.isEmpty()) {
            this.mHandler.post(new zacf(this));
        } else {
            this.zaga.connect();
        }
    }

    public final zad zabq() {
        return this.zaga;
    }

    public final void zabs() {
        zad zad = this.zaga;
        if (zad != null) {
            zad.disconnect();
        }
    }

    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zaga.zaa(this);
    }

    @WorkerThread
    public final void onConnectionSuspended(int i) {
        this.zaga.disconnect();
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zaki.zag(connectionResult);
    }

    @BinderThread
    public final void zab(zaj zaj) {
        this.mHandler.post(new zacg(this, zaj));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zac(zaj zaj) {
        ConnectionResult connectionResult = zaj.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacw = zaj.zacw();
            ConnectionResult connectionResult2 = zacw.getConnectionResult();
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.zaki.zag(connectionResult2);
                this.zaga.disconnect();
                return;
            }
            this.zaki.zaa(zacw.getAccountAccessor(), this.mScopes);
        } else {
            this.zaki.zag(connectionResult);
        }
        this.zaga.disconnect();
    }
}

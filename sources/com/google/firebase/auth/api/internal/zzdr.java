package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_auth.zze;

public final class zzdr extends GmsClient<zzea> implements zzdq {
    private static Logger zzgg = new Logger("FirebaseAuth", "FirebaseAuth:");
    private final Context zzjx;
    private final zzef zzmh;

    public zzdr(Context context, Looper looper, ClientSettings clientSettings, zzef zzef, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzjx = (Context) Preconditions.checkNotNull(context);
        this.zzmh = zzef;
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getStartServicePackage() {
        /*
            r9 = this;
            java.lang.String r0 = "firebear.preference"
            java.lang.String r0 = com.google.firebase.auth.api.internal.zzfe.getProperty(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "default"
            if (r1 == 0) goto L_0x000f
            r0 = r2
        L_0x000f:
            int r1 = r0.hashCode()
            java.lang.String r3 = "local"
            r4 = 1
            r5 = 103145323(0x625df6b, float:3.1197192E-35)
            r6 = -1
            r7 = 0
            if (r1 == r5) goto L_0x002b
            r8 = 1544803905(0x5c13d641, float:1.66449585E17)
            if (r1 == r8) goto L_0x0023
        L_0x0022:
            goto L_0x0033
        L_0x0023:
            boolean r1 = r0.equals(r2)
            if (r1 == 0) goto L_0x0022
            r1 = 1
            goto L_0x0034
        L_0x002b:
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x0022
            r1 = 0
            goto L_0x0034
        L_0x0033:
            r1 = -1
        L_0x0034:
            if (r1 == 0) goto L_0x003a
            if (r1 == r4) goto L_0x003a
            r0 = r2
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            int r1 = r0.hashCode()
            if (r1 == r5) goto L_0x0042
        L_0x0041:
            goto L_0x0049
        L_0x0042:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0041
            r6 = 0
        L_0x0049:
            if (r6 == 0) goto L_0x0076
            com.google.android.gms.common.logging.Logger r0 = zzgg
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r2 = "Loading module via FirebaseOptions."
            r0.mo7718i(r2, r1)
            com.google.firebase.auth.api.internal.zzef r0 = r9.zzmh
            boolean r0 = r0.zzjt
            if (r0 == 0) goto L_0x006a
            com.google.android.gms.common.logging.Logger r0 = zzgg
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r2 = "Preparing to create service connection to fallback implementation"
            r0.mo7718i(r2, r1)
            android.content.Context r0 = r9.zzjx
            java.lang.String r0 = r0.getPackageName()
            return r0
        L_0x006a:
            com.google.android.gms.common.logging.Logger r0 = zzgg
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r2 = "Preparing to create service connection to gms implementation"
            r0.mo7718i(r2, r1)
            java.lang.String r0 = "com.google.android.gms"
            return r0
        L_0x0076:
            com.google.android.gms.common.logging.Logger r0 = zzgg
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r2 = "Loading fallback module override."
            r0.mo7718i(r2, r1)
            android.content.Context r0 = r9.zzjx
            java.lang.String r0 = r0.getPackageName()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzdr.getStartServicePackage():java.lang.String");
    }

    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.getLocalVersion(this.zzjx, "com.google.firebase.auth") == 0;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        zzef zzef = this.zzmh;
        if (zzef != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", zzef.getApiKey());
        }
        return getServiceRequestExtraArgs;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final Feature[] getApiFeatures() {
        return zze.zzg;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        if (queryLocalInterface instanceof zzea) {
            return (zzea) queryLocalInterface;
        }
        return new zzec(iBinder);
    }

    @KeepForSdk
    public final /* synthetic */ zzea zzdh() throws DeadObjectException {
        return (zzea) super.getService();
    }
}

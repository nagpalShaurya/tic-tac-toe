package com.google.firebase.auth.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.firebase.FirebaseError;

@KeepName
public class FederatedSignInActivity extends FragmentActivity {
    private static final zzz zzgy = zzz.zzem();
    private static boolean zzrl = false;
    private boolean zzrm = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String str = "Unknown action: ";
            String valueOf = String.valueOf(action);
            Log.e("IdpSignInActivity", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            zzel();
        } else if (zzrl) {
            finish();
        } else {
            zzrl = true;
            if (bundle != null) {
                this.zzrm = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzrm);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String str = "IdpSignInActivity";
        boolean z = false;
        String str2 = "com.google.firebase.auth.internal.OPERATION";
        if ("com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED".equals(intent.getAction())) {
            Log.e(str, "Web sign-in failed, finishing");
            if (zzai.zza(intent)) {
                zze(zzai.zzb(intent));
            } else {
                zzel();
            }
            z = true;
        } else if (intent.hasExtra(str2)) {
            String str3 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST";
            if (intent.hasExtra(str3)) {
                String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.EXTRA_TENANT_ID");
                String stringExtra2 = intent.getStringExtra(str2);
                if ("com.google.firebase.auth.internal.SIGN_IN".equals(stringExtra2) || "com.google.firebase.auth.internal.LINK".equals(stringExtra2) || "com.google.firebase.auth.internal.REAUTHENTICATE".equals(stringExtra2)) {
                    zzdr zzdr = (zzdr) SafeParcelableSerializer.deserializeFromIntentExtra(intent, str3, zzdr.CREATOR);
                    zzrl = false;
                    Intent intent2 = new Intent();
                    SafeParcelableSerializer.serializeToIntentExtra(zzdr, intent2, str3);
                    intent2.putExtra(str2, stringExtra2);
                    intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent2)) {
                        zzac.zza(getApplicationContext(), zzdr, stringExtra2, stringExtra);
                    } else {
                        zzgy.zza(this);
                    }
                    finish();
                    z = true;
                }
            }
        }
        if (!z) {
            if (!this.zzrm) {
                Intent intent3 = new Intent("com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN");
                intent3.setPackage("com.google.android.gms");
                intent3.putExtras(getIntent().getExtras());
                intent3.putExtra(str2, getIntent().getAction());
                try {
                    startActivityForResult(intent3, 40963);
                } catch (ActivityNotFoundException e) {
                    String str4 = "Could not launch web sign-in Intent. Google Play service is unavailable";
                    Log.w(str, str4);
                    zze(new Status(FirebaseError.ERROR_INTERNAL_ERROR, str4));
                }
                this.zzrm = true;
                return;
            }
            zzel();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private final void zzel() {
        zzrl = false;
        this.zzrm = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzac.zza(this, zzq.zzct("WEB_CONTEXT_CANCELED"));
        } else {
            zzgy.zza(this);
        }
        finish();
    }

    private final void zze(Status status) {
        zzrl = false;
        Intent intent = new Intent();
        zzai.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzac.zza(getApplicationContext(), status);
        } else {
            zzgy.zza(this);
        }
        finish();
    }
}

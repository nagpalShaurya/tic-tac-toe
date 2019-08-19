package com.google.firebase.auth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    @Nullable
    public abstract String getDisplayName();

    @Nullable
    public abstract String getEmail();

    @Nullable
    public abstract FirebaseUserMetadata getMetadata();

    @Nullable
    public abstract String getPhoneNumber();

    @Nullable
    public abstract Uri getPhotoUrl();

    @NonNull
    public abstract List<? extends UserInfo> getProviderData();

    @NonNull
    public abstract String getProviderId();

    @Nullable
    public abstract List<String> getProviders();

    @NonNull
    public abstract String getUid();

    public abstract boolean isAnonymous();

    @NonNull
    public abstract FirebaseUser zza(@NonNull List<? extends UserInfo> list);

    public abstract void zza(@NonNull zzcz zzcz);

    @NonNull
    public abstract FirebaseApp zzcc();

    public abstract FirebaseUser zzce();

    @Nullable
    public abstract String zzcf();

    @NonNull
    public abstract zzcz zzcg();

    @NonNull
    public abstract String zzch();

    @NonNull
    public abstract String zzci();

    @NonNull
    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zzcc()).zza(this, z);
    }

    @NonNull
    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zzcc()).zzd(this);
    }

    public Task<Void> reauthenticate(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzcc()).zza(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzcc()).zzb(this, authCredential);
    }

    @NonNull
    public Task<AuthResult> linkWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzcc()).zzc(this, authCredential);
    }

    public Task<AuthResult> unlink(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzcc()).zza(this, str);
    }

    @NonNull
    public Task<Void> updateProfile(@NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zzcc()).zza(this, userProfileChangeRequest);
    }

    @NonNull
    public Task<Void> updateEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzcc()).zzb(this, str);
    }

    public Task<Void> updatePhoneNumber(@NonNull PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zzcc()).zza(this, phoneAuthCredential);
    }

    @NonNull
    public Task<Void> updatePassword(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzcc()).zzc(this, str);
    }

    @NonNull
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zzcc()).zze(this);
    }

    @NonNull
    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzcc()).zza(this, false).continueWithTask(new zzr(this));
    }

    @NonNull
    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzcc()).zza(this, false).continueWithTask(new zzs(this, actionCodeSettings));
    }
}

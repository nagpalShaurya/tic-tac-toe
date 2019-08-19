package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;

@VisibleForTesting
final class zzep extends zzdy {
    final /* synthetic */ zzeo zznx;

    zzep(zzeo zzeo) {
        this.zznx = zzeo;
    }

    public final void zzb(@NonNull zzcz zzcz) throws RemoteException {
        boolean z = true;
        if (this.zznx.zznb != 1) {
            z = false;
        }
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzeo zzeo = this.zznx;
        zzeo.zznk = zzcz;
        zzeo.zzdp();
    }

    public final void zza(@NonNull zzcz zzcz, @NonNull zzct zzct) throws RemoteException {
        boolean z = this.zznx.zznb == 2;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzeo zzeo = this.zznx;
        zzeo.zznk = zzcz;
        zzeo.zznl = zzct;
        zzeo.zzdp();
    }

    public final void zza(@NonNull zzcj zzcj) throws RemoteException {
        boolean z = this.zznx.zznb == 3;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzeo zzeo = this.zznx;
        zzeo.zznm = zzcj;
        zzeo.zzdp();
    }

    public final void zza(@Nullable zzdg zzdg) throws RemoteException {
        boolean z = this.zznx.zznb == 4;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzeo zzeo = this.zznx;
        zzeo.zznn = zzdg;
        zzeo.zzdp();
    }

    public final void zzde() throws RemoteException {
        boolean z = this.zznx.zznb == 5;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzdp();
    }

    public final void zzdf() throws RemoteException {
        boolean z = this.zznx.zznb == 6;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzdp();
    }

    public final void zzbs(@NonNull String str) throws RemoteException {
        boolean z = this.zznx.zznb == 7;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzeo zzeo = this.zznx;
        zzeo.zzno = str;
        zzeo.zzdp();
    }

    public final void zzbt(@NonNull String str) throws RemoteException {
        boolean z = this.zznx.zznb == 8;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzhn = str;
        zza((zzev) new zzeq(this, str));
    }

    public final void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zznx.zznb == 8;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzns = true;
        this.zznx.zznt = true;
        zza((zzev) new zzer(this, phoneAuthCredential));
    }

    public final void zzbu(@NonNull String str) throws RemoteException {
        boolean z = this.zznx.zznb == 8;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzeo zzeo = this.zznx;
        zzeo.zzhn = str;
        zzeo.zzns = true;
        this.zznx.zznt = true;
        zza((zzev) new zzes(this, str));
    }

    public final void onFailure(@NonNull Status status) throws RemoteException {
        if (this.zznx.zznb == 8) {
            this.zznx.zzns = true;
            this.zznx.zznt = false;
            zza((zzev) new zzet(this, status));
            return;
        }
        this.zznx.zzd(status);
        this.zznx.zzc(status);
    }

    public final void zza(@NonNull Status status, @NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zznx.zznb == 2;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzb(status, phoneAuthCredential, null);
    }

    public final void zza(zzcg zzcg) {
        zzb(zzcg.getStatus(), zzcg.zzcv(), zzcg.getEmail());
    }

    private final void zzb(Status status, AuthCredential authCredential, @Nullable String str) {
        this.zznx.zzd(status);
        zzeo zzeo = this.zznx;
        zzeo.zznp = authCredential;
        zzeo.zznq = str;
        if (zzeo.zznf != null) {
            this.zznx.zznf.zza(status);
        }
        this.zznx.zzc(status);
    }

    public final void zzdg() throws RemoteException {
        boolean z = this.zznx.zznb == 9;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzdp();
    }

    private final void zza(zzev zzev) {
        this.zznx.zznj.execute(new zzeu(this, zzev));
    }
}

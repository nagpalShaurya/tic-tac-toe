package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesQueryCreator")
public final class zzk extends AbstractSafeParcelable {
    public static final Creator<zzk> CREATOR = new zzl();
    @Field(getter = "getAllowTestKeys", mo7664id = 3)
    private final boolean zzaa;
    @Field(getter = "getForbidTestKeys", mo7664id = 4)
    private final boolean zzab;
    @Field(getter = "getCallingPackage", mo7664id = 1)
    private final String zzy;
    @Field(getter = "getCallingCertificateBinder", mo7664id = 2, type = "android.os.IBinder")
    @Nullable
    private final zze zzz;

    @Constructor
    zzk(@Param(mo7667id = 1) String str, @Param(mo7667id = 2) @Nullable IBinder iBinder, @Param(mo7667id = 3) boolean z, @Param(mo7667id = 4) boolean z2) {
        this.zzy = str;
        this.zzz = zza(iBinder);
        this.zzaa = z;
        this.zzab = z2;
    }

    zzk(String str, @Nullable zze zze, boolean z, boolean z2) {
        this.zzy = str;
        this.zzz = zze;
        this.zzaa = z;
        this.zzab = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzy, false);
        zze zze = this.zzz;
        if (zze == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = zze.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaa);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzab);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    private static zze zza(@Nullable IBinder iBinder) {
        String str = "Could not unwrap certificate";
        String str2 = "GoogleCertificatesQuery";
        zzf zzf = null;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzb = zzj.zzb(iBinder).zzb();
            byte[] bArr = zzb == null ? null : (byte[]) ObjectWrapper.unwrap(zzb);
            if (bArr != null) {
                zzf = new zzf(bArr);
            } else {
                Log.e(str2, str);
            }
            return zzf;
        } catch (RemoteException e) {
            Log.e(str2, str, e);
            return null;
        }
    }
}

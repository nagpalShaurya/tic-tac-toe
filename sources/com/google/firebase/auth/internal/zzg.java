package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zzd;

public final class zzg implements Creator<zzf> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzl zzl = null;
        zzd zzd = null;
        zzd zzd2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                zzl = (zzl) SafeParcelReader.createParcelable(parcel, readHeader, zzl.CREATOR);
            } else if (fieldId == 2) {
                zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzd2 = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzf(zzl, zzd, zzd2);
    }
}

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new zan();
    @Field(getter = "getConnectionResult", mo7664id = 3)
    private ConnectionResult zadh;
    @Field(getter = "getSaveDefaultAccount", mo7664id = 4)
    private boolean zagf;
    @VersionField(mo7670id = 1)
    private final int zale;
    @Field(mo7664id = 2)
    private IBinder zanw;
    @Field(getter = "isFromCrossClientAuth", mo7664id = 5)
    private boolean zapb;

    @Constructor
    ResolveAccountResponse(@Param(mo7667id = 1) int i, @Param(mo7667id = 2) IBinder iBinder, @Param(mo7667id = 3) ConnectionResult connectionResult, @Param(mo7667id = 4) boolean z, @Param(mo7667id = 5) boolean z2) {
        this.zale = i;
        this.zanw = iBinder;
        this.zadh = connectionResult;
        this.zagf = z;
        this.zapb = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    public IAccountAccessor getAccountAccessor() {
        return Stub.asInterface(this.zanw);
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        this.zanw = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        return this;
    }

    public ConnectionResult getConnectionResult() {
        return this.zadh;
    }

    public boolean getSaveDefaultAccount() {
        return this.zagf;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.zagf = z;
        return this;
    }

    public boolean isFromCrossClientAuth() {
        return this.zapb;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.zapb = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zale);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zanw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getConnectionResult(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, getSaveDefaultAccount());
        SafeParcelWriter.writeBoolean(parcel, 5, isFromCrossClientAuth());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        if (!this.zadh.equals(resolveAccountResponse.zadh) || !getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor())) {
            return false;
        }
        return true;
    }
}

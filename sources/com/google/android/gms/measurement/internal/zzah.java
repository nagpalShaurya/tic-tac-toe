package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;

public abstract class zzah extends zzr implements zzag {
    public zzah() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzad) zzs.zza(parcel, zzad.CREATOR), (zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zza((zzfh) zzs.zza(parcel, zzfh.CREATOR), (zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                zza((zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                zza((zzad) zzs.zza(parcel, zzad.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zzb((zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                List zza = zza((zzh) zzs.zza(parcel, zzh.CREATOR), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 9:
                byte[] zza2 = zza((zzad) zzs.zza(parcel, zzad.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                break;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String zzc = zzc((zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            case 12:
                zza((zzl) zzs.zza(parcel, zzl.CREATOR), (zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzb((zzl) zzs.zza(parcel, zzl.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                List zza3 = zza(parcel.readString(), parcel.readString(), zzs.zza(parcel), (zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                break;
            case 15:
                List zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                break;
            case 16:
                List zza5 = zza(parcel.readString(), parcel.readString(), (zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                break;
            case 17:
                List zze = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zze);
                break;
            case 18:
                zzd((zzh) zzs.zza(parcel, zzh.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}

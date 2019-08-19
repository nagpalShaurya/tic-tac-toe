package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhb;
import java.io.InputStream;

public abstract class zzec<MessageType extends zzhb> implements zzhl<MessageType> {
    private static final zzff zzsj = zzff.zzgp();

    private final MessageType zza(InputStream inputStream, zzff zzff) throws zzgb {
        zzes zzes;
        if (inputStream == null) {
            byte[] bArr = zzfu.EMPTY_BYTE_ARRAY;
            zzes = zzes.zza(bArr, 0, bArr.length, false);
        } else {
            zzes = new zzev(inputStream);
        }
        MessageType messagetype = (zzhb) zza(zzes, zzff);
        try {
            zzes.zzm(0);
            return messagetype;
        } catch (zzgb e) {
            throw e.zzh(messagetype);
        }
    }

    public final /* synthetic */ Object zzb(InputStream inputStream, zzff zzff) throws zzgb {
        zzio zzio;
        zzhb zza = zza(inputStream, zzff);
        if (zza == null || zza.isInitialized()) {
            return zza;
        }
        if (zza instanceof zzdz) {
            zzio = new zzio((zzdz) zza);
        } else if (zza instanceof zzeb) {
            zzio = new zzio((zzeb) zza);
        } else {
            zzio = new zzio(zza);
        }
        throw new zzgb(zzio.getMessage()).zzh(zza);
    }
}

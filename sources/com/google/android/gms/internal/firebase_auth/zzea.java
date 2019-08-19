package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzea;

public abstract class zzea<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhc {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzet */
    public abstract BuilderType clone();

    public final /* synthetic */ zzhc zzb(zzhb zzhb) {
        if (zzhh().getClass().isInstance(zzhb)) {
            return zza((zzdz) zzhb);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}

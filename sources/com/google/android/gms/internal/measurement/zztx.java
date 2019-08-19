package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zztw;
import com.google.android.gms.internal.measurement.zztx;

public abstract class zztx<MessageType extends zztw<MessageType, BuilderType>, BuilderType extends zztx<MessageType, BuilderType>> implements zzwu {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zztv */
    public abstract BuilderType clone();

    public final /* synthetic */ zzwu zza(zzwt zzwt) {
        if (zzwf().getClass().isInstance(zzwt)) {
            return zza((MessageType) (zztw) zzwt);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}

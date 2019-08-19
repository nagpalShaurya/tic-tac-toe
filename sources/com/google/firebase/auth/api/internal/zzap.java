package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzap implements Continuation<ResultT, Task<ResultT>> {
    private final /* synthetic */ zzam zzka;
    private final /* synthetic */ zzao zzkb;

    zzap(zzao zzao, zzam zzam) {
        this.zzkb = zzao;
        this.zzka = zzam;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        if (task.getException() instanceof UnsupportedApiCallException) {
            return this.zzkb.zza(this.zzka.zzdc());
        }
        return task;
    }
}

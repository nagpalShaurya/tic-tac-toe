package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

public final class zzal<O extends ApiOptions> extends GoogleApi<O> {
    public zzal(@NonNull Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        super(context, api, o, statusExceptionMapper);
    }
}

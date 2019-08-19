package com.google.firebase.database;

import android.support.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.ServerValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ServerValue {
    @PublicApi
    @NonNull
    public static final Map<String, String> TIMESTAMP = createServerValuePlaceholder(Param.TIMESTAMP);

    private static Map<String, String> createServerValuePlaceholder(String key) {
        Map<String, String> result = new HashMap<>();
        result.put(ServerValues.NAME_SUBKEY_SERVERVALUE, key);
        return Collections.unmodifiableMap(result);
    }
}

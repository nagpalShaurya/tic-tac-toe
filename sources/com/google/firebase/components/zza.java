package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
abstract class zza implements ComponentContainer {
    zza() {
    }

    public <T> T get(Class<T> anInterface) {
        Provider provider = getProvider(anInterface);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }
}

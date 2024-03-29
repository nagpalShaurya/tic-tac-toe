package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
final class zzl extends zza {
    private final Set<Class<?>> zza;
    private final Set<Class<?>> zzb;
    private final Set<Class<?>> zzc;
    private final ComponentContainer zzd;

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    static class zza implements Publisher {
        private final Set<Class<?>> zza;
        private final Publisher zzb;

        public zza(Set<Class<?>> set, Publisher publisher) {
            this.zza = set;
            this.zzb = publisher;
        }

        /* Debug info: failed to restart local var, previous not found, register: 3 */
        public final void publish(Event<?> event) {
            if (this.zza.contains(event.getType())) {
                this.zzb.publish(event);
            } else {
                throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", new Object[]{event}));
            }
        }
    }

    zzl(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Dependency dependency : component.zzb()) {
            if (dependency.zzc()) {
                hashSet.add(dependency.zza());
            } else {
                hashSet2.add(dependency.zza());
            }
        }
        if (!component.zzd().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.zza = Collections.unmodifiableSet(hashSet);
        this.zzb = Collections.unmodifiableSet(hashSet2);
        this.zzc = component.zzd();
        this.zzd = componentContainer;
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    public final <T> T get(Class<T> anInterface) {
        if (this.zza.contains(anInterface)) {
            T t = this.zzd.get(anInterface);
            if (!anInterface.equals(Publisher.class)) {
                return t;
            }
            return new zza(this.zzc, (Publisher) t);
        }
        throw new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[]{anInterface}));
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    public final <T> Provider<T> getProvider(Class<T> anInterface) {
        if (this.zzb.contains(anInterface)) {
            return this.zzd.getProvider(anInterface);
        }
        throw new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[]{anInterface}));
    }
}

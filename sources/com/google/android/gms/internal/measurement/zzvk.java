package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuz;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzvk<T extends zzuz> {
    private static final Logger logger = Logger.getLogger(zzut.class.getName());
    private static String zzbyk = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzvk() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzwa();

    static <T extends zzuz> T zzd(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzvk.class.getClassLoader();
        if (cls.equals(zzuz.class)) {
            str = zzbyk;
        } else if (cls.getPackage().equals(zzvk.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzuz) cls.cast(((zzvk) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzwa());
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException(e4);
        } catch (ClassNotFoundException e5) {
            Iterator it = ServiceLoader.load(zzvk.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzuz) cls.cast(((zzvk) it.next()).zzwa()));
                } catch (ServiceConfigurationError e6) {
                    ServiceConfigurationError serviceConfigurationError = e6;
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String str2 = "Unable to load ";
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (zzuz) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzuz) cls.getMethod("combine", new Class[]{Collection.class}).invoke(null, new Object[]{arrayList});
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }
}

package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

final class zzhu implements Iterator<zzep> {
    private final Stack<zzhr> zzaap;
    private zzep zzaaq;

    private zzhu(zzeh zzeh) {
        this.zzaap = new Stack<>();
        this.zzaaq = zze(zzeh);
    }

    private final zzep zze(zzeh zzeh) {
        while (zzeh instanceof zzhr) {
            zzhr zzhr = (zzhr) zzeh;
            this.zzaap.push(zzhr);
            zzeh = zzhr.zzaak;
        }
        return (zzep) zzeh;
    }

    public final boolean hasNext() {
        return this.zzaaq != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        zzep zzep;
        boolean z;
        zzep zzep2 = this.zzaaq;
        if (zzep2 != null) {
            while (true) {
                if (!this.zzaap.isEmpty()) {
                    zzep = zze(((zzhr) this.zzaap.pop()).zzaal);
                    if (zzep.size() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                } else {
                    zzep = null;
                    break;
                }
            }
            this.zzaaq = zzep;
            return zzep2;
        }
        throw new NoSuchElementException();
    }
}

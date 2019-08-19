package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

final class zzei implements zzen {
    private final int limit = this.zzss.size();
    private int position = 0;
    private final /* synthetic */ zzeh zzss;

    zzei(zzeh zzeh) {
        this.zzss = zzeh;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        try {
            zzeh zzeh = this.zzss;
            int i = this.position;
            this.position = i + 1;
            return zzeh.zzk(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }
}

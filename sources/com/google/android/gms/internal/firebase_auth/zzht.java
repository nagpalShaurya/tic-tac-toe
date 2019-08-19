package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Stack;

final class zzht {
    private final Stack<zzeh> zzaao;

    private zzht() {
        this.zzaao = new Stack<>();
    }

    /* access modifiers changed from: private */
    public final zzeh zzc(zzeh zzeh, zzeh zzeh2) {
        zzd(zzeh);
        zzd(zzeh2);
        zzeh zzeh3 = (zzeh) this.zzaao.pop();
        while (!this.zzaao.isEmpty()) {
            zzeh3 = new zzhr((zzeh) this.zzaao.pop(), zzeh3);
        }
        return zzeh3;
    }

    private final void zzd(zzeh zzeh) {
        while (!zzeh.zzfc()) {
            if (zzeh instanceof zzhr) {
                zzhr zzhr = (zzhr) zzeh;
                zzd(zzhr.zzaak);
                zzeh = zzhr.zzaal;
            } else {
                String valueOf = String.valueOf(zzeh.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzaz = zzaz(zzeh.size());
        int i = zzhr.zzaai[zzaz + 1];
        if (this.zzaao.isEmpty() || ((zzeh) this.zzaao.peek()).size() >= i) {
            this.zzaao.push(zzeh);
            return;
        }
        int i2 = zzhr.zzaai[zzaz];
        zzeh zzeh2 = (zzeh) this.zzaao.pop();
        while (!this.zzaao.isEmpty() && ((zzeh) this.zzaao.peek()).size() < i2) {
            zzeh2 = new zzhr((zzeh) this.zzaao.pop(), zzeh2);
        }
        zzhr zzhr2 = new zzhr(zzeh2, zzeh);
        while (!this.zzaao.isEmpty()) {
            if (((zzeh) this.zzaao.peek()).size() >= zzhr.zzaai[zzaz(zzhr2.size()) + 1]) {
                break;
            }
            zzhr2 = new zzhr((zzeh) this.zzaao.pop(), zzhr2);
        }
        this.zzaao.push(zzhr2);
    }

    private static int zzaz(int i) {
        int binarySearch = Arrays.binarySearch(zzhr.zzaai, i);
        if (binarySearch < 0) {
            return (-(binarySearch + 1)) - 1;
        }
        return binarySearch;
    }
}

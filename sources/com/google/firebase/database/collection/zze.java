package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator;
import com.google.firebase.database.collection.LLRBNode.Color;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zze<A, B, C> {
    private final Map<B, C> values;
    private final List<A> zzu;
    private final KeyTranslator<A, B> zzv;
    private LLRBValueNode<A, C> zzw;
    private LLRBValueNode<A, C> zzx;

    private zze(List<A> list, Map<B, C> map, KeyTranslator<A, B> keyTranslator) {
        this.zzu = list;
        this.values = map;
        this.zzv = keyTranslator;
    }

    private final LLRBNode<A, C> zza(int i, int i2) {
        if (i2 == 0) {
            return LLRBEmptyNode.getInstance();
        }
        if (i2 == 1) {
            Object obj = this.zzu.get(i);
            return new LLRBBlackValueNode(obj, zzd(obj), null, null);
        }
        int i3 = i2 / 2;
        int i4 = i + i3;
        LLRBNode zza = zza(i, i3);
        LLRBNode zza2 = zza(i4 + 1, i3);
        Object obj2 = this.zzu.get(i4);
        return new LLRBBlackValueNode(obj2, zzd(obj2), zza, zza2);
    }

    private final void zza(Color color, int i, int i2) {
        LLRBNode zza = zza(i2 + 1, i - 1);
        Object obj = this.zzu.get(i2);
        LLRBValueNode<A, C> lLRBRedValueNode = color == Color.RED ? new LLRBRedValueNode<>(obj, zzd(obj), null, zza) : new LLRBBlackValueNode<>(obj, zzd(obj), null, zza);
        if (this.zzw == null) {
            this.zzw = lLRBRedValueNode;
        } else {
            this.zzx.zza(lLRBRedValueNode);
        }
        this.zzx = lLRBRedValueNode;
    }

    public static <A, B, C> zzc<A, C> zzb(List<A> list, Map<B, C> map, KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        Color color;
        zze zze = new zze(list, map, keyTranslator);
        Collections.sort(list, comparator);
        Iterator it = new zzf(list.size()).iterator();
        int size = list.size();
        while (it.hasNext()) {
            zzh zzh = (zzh) it.next();
            size -= zzh.zzab;
            if (zzh.zzaa) {
                color = Color.BLACK;
            } else {
                zze.zza(Color.BLACK, zzh.zzab, size);
                size -= zzh.zzab;
                color = Color.RED;
            }
            zze.zza(color, zzh.zzab, size);
        }
        LLRBNode lLRBNode = zze.zzw;
        if (lLRBNode == null) {
            lLRBNode = LLRBEmptyNode.getInstance();
        }
        return new zzc<>(lLRBNode, comparator);
    }

    private final C zzd(A a) {
        return this.values.get(this.zzv.translate(a));
    }
}

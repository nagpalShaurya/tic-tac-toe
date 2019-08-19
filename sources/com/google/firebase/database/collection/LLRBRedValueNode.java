package com.google.firebase.database.collection;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.database.collection.LLRBNode.Color;

@KeepForSdk
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    LLRBRedValueNode(K k, V v) {
        super(k, v, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
    }

    LLRBRedValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k, v, lLRBNode, lLRBNode2);
    }

    @KeepForSdk
    public boolean isRed() {
        return true;
    }

    @KeepForSdk
    public int size() {
        return getLeft().size() + 1 + getRight().size();
    }

    /* access modifiers changed from: protected */
    public final Color zza() {
        return Color.RED;
    }

    /* access modifiers changed from: protected */
    public final LLRBValueNode<K, V> zza(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBRedValueNode(k, v, lLRBNode, lLRBNode2);
    }
}

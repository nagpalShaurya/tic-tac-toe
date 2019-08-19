package com.google.firebase.database.collection;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.AbstractMap.SimpleEntry;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

@KeepForSdk
public class ImmutableSortedMapIterator<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<LLRBValueNode<K, V>> zzi = new Stack<>();
    private final boolean zzj;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r6 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        r3 = r3.getLeft();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r6 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ImmutableSortedMapIterator(com.google.firebase.database.collection.LLRBNode<K, V> r3, K r4, java.util.Comparator<K> r5, boolean r6) {
        /*
            r2 = this;
            r2.<init>()
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r2.zzi = r0
            r2.zzj = r6
        L_0x000c:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x004c
            if (r4 == 0) goto L_0x0028
            if (r6 == 0) goto L_0x001f
            java.lang.Object r0 = r3.getKey()
            int r0 = r5.compare(r4, r0)
            goto L_0x0029
        L_0x001f:
            java.lang.Object r0 = r3.getKey()
            int r0 = r5.compare(r0, r4)
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            if (r0 >= 0) goto L_0x0032
            if (r6 != 0) goto L_0x0047
        L_0x002d:
            com.google.firebase.database.collection.LLRBNode r3 = r3.getRight()
            goto L_0x000c
        L_0x0032:
            if (r0 != 0) goto L_0x003c
            java.util.Stack<com.google.firebase.database.collection.LLRBValueNode<K, V>> r4 = r2.zzi
            com.google.firebase.database.collection.LLRBValueNode r3 = (com.google.firebase.database.collection.LLRBValueNode) r3
            r4.push(r3)
            return
        L_0x003c:
            java.util.Stack<com.google.firebase.database.collection.LLRBValueNode<K, V>> r0 = r2.zzi
            r1 = r3
            com.google.firebase.database.collection.LLRBValueNode r1 = (com.google.firebase.database.collection.LLRBValueNode) r1
            r0.push(r1)
            if (r6 == 0) goto L_0x0047
            goto L_0x002d
        L_0x0047:
            com.google.firebase.database.collection.LLRBNode r3 = r3.getLeft()
            goto L_0x000c
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.collection.ImmutableSortedMapIterator.<init>(com.google.firebase.database.collection.LLRBNode, java.lang.Object, java.util.Comparator, boolean):void");
    }

    @KeepForSdk
    public boolean hasNext() {
        return this.zzi.size() > 0;
    }

    @KeepForSdk
    public Entry<K, V> next() {
        try {
            LLRBValueNode lLRBValueNode = (LLRBValueNode) this.zzi.pop();
            SimpleEntry simpleEntry = new SimpleEntry(lLRBValueNode.getKey(), lLRBValueNode.getValue());
            if (this.zzj) {
                for (LLRBNode left = lLRBValueNode.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.zzi.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode right = lLRBValueNode.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.zzi.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    @KeepForSdk
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}

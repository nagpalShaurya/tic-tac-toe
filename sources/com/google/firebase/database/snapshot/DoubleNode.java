package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node.HashVersion;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DoubleNode extends LeafNode<DoubleNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Double value;

    public DoubleNode(Double value2, Node priority) {
        super(priority);
        this.value = value2;
    }

    public Object getValue() {
        return this.value;
    }

    public String getHashRepresentation(HashVersion version) {
        String toHash = getPriorityHash(version);
        StringBuilder sb = new StringBuilder();
        sb.append(toHash);
        sb.append("number:");
        String toHash2 = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(toHash2);
        sb2.append(Utilities.doubleToHashString(this.value.doubleValue()));
        return sb2.toString();
    }

    public DoubleNode updatePriority(Node priority) {
        return new DoubleNode(this.value, priority);
    }

    /* access modifiers changed from: protected */
    public LeafType getLeafType() {
        return LeafType.Number;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(DoubleNode other) {
        return this.value.compareTo(other.value);
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof DoubleNode)) {
            return false;
        }
        DoubleNode otherDoubleNode = (DoubleNode) other;
        if (this.value.equals(otherDoubleNode.value) && this.priority.equals(otherDoubleNode.priority)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}

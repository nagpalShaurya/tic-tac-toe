package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node.HashVersion;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class LongNode extends LeafNode<LongNode> {
    private final long value;

    public LongNode(Long value2, Node priority) {
        super(priority);
        this.value = value2.longValue();
    }

    public Object getValue() {
        return Long.valueOf(this.value);
    }

    public String getHashRepresentation(HashVersion version) {
        String toHash = getPriorityHash(version);
        StringBuilder sb = new StringBuilder();
        sb.append(toHash);
        sb.append("number:");
        String toHash2 = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(toHash2);
        sb2.append(Utilities.doubleToHashString((double) this.value));
        return sb2.toString();
    }

    public LongNode updatePriority(Node priority) {
        return new LongNode(Long.valueOf(this.value), priority);
    }

    /* access modifiers changed from: protected */
    public LeafType getLeafType() {
        return LeafType.Number;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(LongNode other) {
        return Utilities.compareLongs(this.value, other.value);
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof LongNode)) {
            return false;
        }
        LongNode otherLongNode = (LongNode) other;
        if (this.value == otherLongNode.value && this.priority.equals(otherLongNode.priority)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        long j = this.value;
        return ((int) (j ^ (j >>> 32))) + this.priority.hashCode();
    }
}

package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.Node.HashVersion;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class BooleanNode extends LeafNode<BooleanNode> {
    private final boolean value;

    public BooleanNode(Boolean value2, Node priority) {
        super(priority);
        this.value = value2.booleanValue();
    }

    public Object getValue() {
        return Boolean.valueOf(this.value);
    }

    public String getHashRepresentation(HashVersion version) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPriorityHash(version));
        sb.append("boolean:");
        sb.append(this.value);
        return sb.toString();
    }

    public BooleanNode updatePriority(Node priority) {
        return new BooleanNode(Boolean.valueOf(this.value), priority);
    }

    /* access modifiers changed from: protected */
    public LeafType getLeafType() {
        return LeafType.Boolean;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(BooleanNode other) {
        boolean z = this.value;
        if (z == other.value) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof BooleanNode)) {
            return false;
        }
        BooleanNode otherBooleanNode = (BooleanNode) other;
        if (this.value == otherBooleanNode.value && this.priority.equals(otherBooleanNode.priority)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        boolean z = this.value;
        return (z ? 1 : 0) + this.priority.hashCode();
    }
}

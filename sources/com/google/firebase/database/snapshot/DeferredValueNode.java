package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.Node.HashVersion;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DeferredValueNode extends LeafNode<DeferredValueNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<Object, Object> value;

    public DeferredValueNode(Map<Object, Object> value2, Node priority) {
        super(priority);
        this.value = value2;
    }

    public Object getValue() {
        return this.value;
    }

    public String getHashRepresentation(HashVersion version) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPriorityHash(version));
        sb.append("deferredValue:");
        sb.append(this.value);
        return sb.toString();
    }

    public DeferredValueNode updatePriority(Node priority) {
        return new DeferredValueNode(this.value, priority);
    }

    /* access modifiers changed from: protected */
    public LeafType getLeafType() {
        return LeafType.DeferredValue;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(DeferredValueNode other) {
        return 0;
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof DeferredValueNode)) {
            return false;
        }
        DeferredValueNode otherDeferredValueNode = (DeferredValueNode) other;
        if (this.value.equals(otherDeferredValueNode.value) && this.priority.equals(otherDeferredValueNode.priority)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node.HashVersion;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class StringNode extends LeafNode<StringNode> {
    private final String value;

    /* renamed from: com.google.firebase.database.snapshot.StringNode$1 */
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    static /* synthetic */ class C05131 {

        /* renamed from: $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion */
        static final /* synthetic */ int[] f52x2aed15f4 = new int[HashVersion.values().length];

        static {
            try {
                f52x2aed15f4[HashVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f52x2aed15f4[HashVersion.V2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public StringNode(String value2, Node priority) {
        super(priority);
        this.value = value2;
    }

    public Object getValue() {
        return this.value;
    }

    public String getHashRepresentation(HashVersion version) {
        int i = C05131.f52x2aed15f4[version.ordinal()];
        String str = "string:";
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(getPriorityHash(version));
            sb.append(str);
            sb.append(this.value);
            return sb.toString();
        } else if (i == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getPriorityHash(version));
            sb2.append(str);
            sb2.append(Utilities.stringHashV2Representation(this.value));
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid hash version for string node: ");
            sb3.append(version);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public StringNode updatePriority(Node priority) {
        return new StringNode(this.value, priority);
    }

    /* access modifiers changed from: protected */
    public LeafType getLeafType() {
        return LeafType.String;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(StringNode other) {
        return this.value.compareTo(other.value);
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof StringNode)) {
            return false;
        }
        StringNode otherStringNode = (StringNode) other;
        if (this.value.equals(otherStringNode.value) && this.priority.equals(otherStringNode.priority)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}

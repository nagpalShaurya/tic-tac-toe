package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.LongNode;
import com.google.firebase.database.snapshot.StringNode;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class NodeSizeEstimator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int LEAF_PRIORITY_OVERHEAD = 24;

    private static long estimateLeafNodeSize(LeafNode<?> node) {
        long valueSize;
        if (node instanceof DoubleNode) {
            valueSize = 8;
        } else if (node instanceof LongNode) {
            valueSize = 8;
        } else if (node instanceof BooleanNode) {
            valueSize = 4;
        } else if (node instanceof StringNode) {
            valueSize = 2 + ((long) ((String) node.getValue()).length());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown leaf node type: ");
            sb.append(node.getClass());
            throw new IllegalArgumentException(sb.toString());
        }
        if (node.getPriority().isEmpty()) {
            return valueSize;
        }
        return 24 + valueSize + estimateLeafNodeSize((LeafNode) node.getPriority());
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.firebase.database.snapshot.Node, code=com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, for r8v0, types: [com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, com.google.firebase.database.snapshot.Node] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long estimateSerializedNodeSize(com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode> r8) {
        /*
            boolean r0 = r8.isEmpty()
            r1 = 4
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            boolean r0 = r8.isLeafNode()
            if (r0 == 0) goto L_0x0017
            r0 = r8
            com.google.firebase.database.snapshot.LeafNode r0 = (com.google.firebase.database.snapshot.LeafNode) r0
            long r0 = estimateLeafNodeSize(r0)
            return r0
        L_0x0017:
            r3 = 1
            java.util.Iterator r0 = r8.iterator()
        L_0x001e:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0043
            java.lang.Object r5 = r0.next()
            com.google.firebase.database.snapshot.NamedNode r5 = (com.google.firebase.database.snapshot.NamedNode) r5
            com.google.firebase.database.snapshot.ChildKey r6 = r5.getName()
            java.lang.String r6 = r6.asString()
            int r6 = r6.length()
            long r6 = (long) r6
            long r3 = r3 + r6
            long r3 = r3 + r1
            com.google.firebase.database.snapshot.Node r6 = r5.getNode()
            long r6 = estimateSerializedNodeSize(r6)
            long r3 = r3 + r6
            goto L_0x001e
        L_0x0043:
            com.google.firebase.database.snapshot.Node r0 = r8.getPriority()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005b
            r0 = 12
            long r3 = r3 + r0
            com.google.firebase.database.snapshot.Node r0 = r8.getPriority()
            com.google.firebase.database.snapshot.LeafNode r0 = (com.google.firebase.database.snapshot.LeafNode) r0
            long r0 = estimateLeafNodeSize(r0)
            long r3 = r3 + r0
        L_0x005b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.utilities.NodeSizeEstimator.estimateSerializedNodeSize(com.google.firebase.database.snapshot.Node):long");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.firebase.database.snapshot.Node, code=com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, for r4v0, types: [com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, com.google.firebase.database.snapshot.Node] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int nodeCount(com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode> r4) {
        /*
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            boolean r0 = r4.isLeafNode()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            java.util.Iterator r1 = r4.iterator()
        L_0x0016:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002c
            java.lang.Object r2 = r1.next()
            com.google.firebase.database.snapshot.NamedNode r2 = (com.google.firebase.database.snapshot.NamedNode) r2
            com.google.firebase.database.snapshot.Node r3 = r2.getNode()
            int r3 = nodeCount(r3)
            int r0 = r0 + r3
            goto L_0x0016
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.utilities.NodeSizeEstimator.nodeCount(com.google.firebase.database.snapshot.Node):int");
    }
}

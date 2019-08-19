package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class RangeMerge {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Path optExclusiveStart;
    private final Path optInclusiveEnd;
    private final Node snap;

    public RangeMerge(Path optExclusiveStart2, Path optInclusiveEnd2, Node snap2) {
        this.optExclusiveStart = optExclusiveStart2;
        this.optInclusiveEnd = optInclusiveEnd2;
        this.snap = snap2;
    }

    public RangeMerge(com.google.firebase.database.connection.RangeMerge rangeMerge) {
        List<String> optStartPathList = rangeMerge.getOptExclusiveStart();
        Path path = null;
        this.optExclusiveStart = optStartPathList != null ? new Path(optStartPathList) : null;
        List<String> optEndPathList = rangeMerge.getOptInclusiveEnd();
        if (optEndPathList != null) {
            path = new Path(optEndPathList);
        }
        this.optInclusiveEnd = path;
        this.snap = NodeUtilities.NodeFromJSON(rangeMerge.getSnap());
    }

    public Node applyTo(Node node) {
        return updateRangeInNode(Path.getEmptyPath(), node, this.snap);
    }

    /* access modifiers changed from: 0000 */
    public Path getStart() {
        return this.optExclusiveStart;
    }

    /* access modifiers changed from: 0000 */
    public Path getEnd() {
        return this.optInclusiveEnd;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.firebase.database.snapshot.Node, code=com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, for r18v0, types: [com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, com.google.firebase.database.snapshot.Node] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.firebase.database.snapshot.Node, code=com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, for r19v0, types: [com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode>, com.google.firebase.database.snapshot.Node] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.database.snapshot.Node updateRangeInNode(com.google.firebase.database.core.Path r17, com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode> r18, com.google.firebase.database.snapshot.Node<com.google.firebase.database.snapshot.NamedNode> r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            com.google.firebase.database.core.Path r4 = r0.optExclusiveStart
            r5 = 1
            if (r4 != 0) goto L_0x000f
            r4 = 1
            goto L_0x0013
        L_0x000f:
            int r4 = r1.compareTo(r4)
        L_0x0013:
            com.google.firebase.database.core.Path r6 = r0.optInclusiveEnd
            if (r6 != 0) goto L_0x0019
            r6 = -1
            goto L_0x001d
        L_0x0019:
            int r6 = r1.compareTo(r6)
        L_0x001d:
            com.google.firebase.database.core.Path r7 = r0.optExclusiveStart
            r8 = 0
            if (r7 == 0) goto L_0x002a
            boolean r7 = r1.contains(r7)
            if (r7 == 0) goto L_0x002a
            r7 = 1
            goto L_0x002b
        L_0x002a:
            r7 = 0
        L_0x002b:
            com.google.firebase.database.core.Path r9 = r0.optInclusiveEnd
            if (r9 == 0) goto L_0x0036
            boolean r9 = r1.contains(r9)
            if (r9 == 0) goto L_0x0036
            r8 = 1
        L_0x0036:
            if (r4 <= 0) goto L_0x003d
            if (r6 >= 0) goto L_0x003d
            if (r8 != 0) goto L_0x003d
            return r3
        L_0x003d:
            if (r4 <= 0) goto L_0x0048
            if (r8 == 0) goto L_0x0048
            boolean r9 = r19.isLeafNode()
            if (r9 == 0) goto L_0x0048
            return r3
        L_0x0048:
            if (r4 <= 0) goto L_0x005a
            if (r6 != 0) goto L_0x005a
            boolean r5 = r18.isLeafNode()
            if (r5 == 0) goto L_0x0059
            com.google.firebase.database.snapshot.EmptyNode r5 = com.google.firebase.database.snapshot.EmptyNode.Empty()
            return r5
        L_0x0059:
            return r2
        L_0x005a:
            if (r7 != 0) goto L_0x0061
            if (r8 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            return r2
        L_0x0061:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            java.util.Iterator r10 = r18.iterator()
        L_0x006a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x007e
            java.lang.Object r11 = r10.next()
            com.google.firebase.database.snapshot.NamedNode r11 = (com.google.firebase.database.snapshot.NamedNode) r11
            com.google.firebase.database.snapshot.ChildKey r12 = r11.getName()
            r9.add(r12)
            goto L_0x006a
        L_0x007e:
            java.util.Iterator r10 = r19.iterator()
        L_0x0082:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0096
            java.lang.Object r11 = r10.next()
            com.google.firebase.database.snapshot.NamedNode r11 = (com.google.firebase.database.snapshot.NamedNode) r11
            com.google.firebase.database.snapshot.ChildKey r12 = r11.getName()
            r9.add(r12)
            goto L_0x0082
        L_0x0096:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            int r11 = r11 + r5
            r10.<init>(r11)
            r5 = r10
            r5.addAll(r9)
            com.google.firebase.database.snapshot.Node r10 = r19.getPriority()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00b8
            com.google.firebase.database.snapshot.Node r10 = r18.getPriority()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x00bf
        L_0x00b8:
            com.google.firebase.database.snapshot.ChildKey r10 = com.google.firebase.database.snapshot.ChildKey.getPriorityKey()
            r5.add(r10)
        L_0x00bf:
            r10 = r18
            java.util.Iterator r11 = r5.iterator()
        L_0x00c5:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00ef
            java.lang.Object r12 = r11.next()
            com.google.firebase.database.snapshot.ChildKey r12 = (com.google.firebase.database.snapshot.ChildKey) r12
            com.google.firebase.database.snapshot.Node r13 = r2.getImmediateChild(r12)
            com.google.firebase.database.core.Path r14 = r1.child(r12)
            com.google.firebase.database.snapshot.Node r15 = r2.getImmediateChild(r12)
            com.google.firebase.database.snapshot.Node r1 = r3.getImmediateChild(r12)
            com.google.firebase.database.snapshot.Node r1 = r0.updateRangeInNode(r14, r15, r1)
            if (r1 == r13) goto L_0x00ec
            com.google.firebase.database.snapshot.Node r10 = r10.updateImmediateChild(r12, r1)
        L_0x00ec:
            r1 = r17
            goto L_0x00c5
        L_0x00ef:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.snapshot.RangeMerge.updateRangeInNode(com.google.firebase.database.core.Path, com.google.firebase.database.snapshot.Node, com.google.firebase.database.snapshot.Node):com.google.firebase.database.snapshot.Node");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RangeMerge{optExclusiveStart=");
        sb.append(this.optExclusiveStart);
        sb.append(", optInclusiveEnd=");
        sb.append(this.optInclusiveEnd);
        sb.append(", snap=");
        sb.append(this.snap);
        sb.append('}');
        return sb.toString();
    }
}

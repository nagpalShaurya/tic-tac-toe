package com.google.firebase.database.snapshot;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;
import com.google.firebase.database.collection.LLRBNode.NodeVisitor;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node.HashVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ChildrenNode implements Node {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Comparator<ChildKey> NAME_ONLY_COMPARATOR = new Comparator<ChildKey>() {
        public int compare(ChildKey o1, ChildKey o2) {
            return o1.compareTo(o2);
        }
    };
    private final ImmutableSortedMap<ChildKey, Node> children;
    private String lazyHash;
    private final Node priority;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public static abstract class ChildVisitor extends NodeVisitor<ChildKey, Node> {
        public abstract void visitChild(ChildKey childKey, Node node);

        public void visitEntry(ChildKey key, Node value) {
            visitChild(key, value);
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class NamedNodeIterator implements Iterator<NamedNode> {
        private final Iterator<Entry<ChildKey, Node>> iterator;

        public NamedNodeIterator(Iterator<Entry<ChildKey, Node>> iterator2) {
            this.iterator = iterator2;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public NamedNode next() {
            Entry<ChildKey, Node> entry = (Entry) this.iterator.next();
            return new NamedNode((ChildKey) entry.getKey(), (Node) entry.getValue());
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    protected ChildrenNode() {
        this.lazyHash = null;
        this.children = Builder.emptyMap(NAME_ONLY_COMPARATOR);
        this.priority = PriorityUtilities.NullPriority();
    }

    protected ChildrenNode(ImmutableSortedMap<ChildKey, Node> children2, Node priority2) {
        this.lazyHash = null;
        if (!children2.isEmpty() || priority2.isEmpty()) {
            this.priority = priority2;
            this.children = children2;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    public boolean hasChild(ChildKey name) {
        return !getImmediateChild(name).isEmpty();
    }

    public boolean isEmpty() {
        return this.children.isEmpty();
    }

    public int getChildCount() {
        return this.children.size();
    }

    public Object getValue() {
        return getValue(false);
    }

    public Object getValue(boolean useExportFormat) {
        if (isEmpty()) {
            return null;
        }
        int numKeys = 0;
        int maxKey = 0;
        boolean allIntegerKeys = true;
        Map<String, Object> result = new HashMap<>();
        Iterator it = this.children.iterator();
        while (it.hasNext()) {
            Entry<ChildKey, Node> entry = (Entry) it.next();
            String key = ((ChildKey) entry.getKey()).asString();
            result.put(key, ((Node) entry.getValue()).getValue(useExportFormat));
            numKeys++;
            if (allIntegerKeys) {
                if (key.length() <= 1 || key.charAt(0) != '0') {
                    Integer keyAsInt = Utilities.tryParseInt(key);
                    if (keyAsInt == null || keyAsInt.intValue() < 0) {
                        allIntegerKeys = false;
                    } else if (keyAsInt.intValue() > maxKey) {
                        maxKey = keyAsInt.intValue();
                    }
                } else {
                    allIntegerKeys = false;
                }
            }
        }
        if (useExportFormat || !allIntegerKeys || maxKey >= numKeys * 2) {
            if (useExportFormat && !this.priority.isEmpty()) {
                result.put(".priority", this.priority.getValue());
            }
            return result;
        }
        List<Object> arrayResult = new ArrayList<>(maxKey + 1);
        for (int i = 0; i <= maxKey; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            arrayResult.add(result.get(sb.toString()));
        }
        return arrayResult;
    }

    public ChildKey getPredecessorChildKey(ChildKey childKey) {
        return (ChildKey) this.children.getPredecessorKey(childKey);
    }

    public ChildKey getSuccessorChildKey(ChildKey childKey) {
        return (ChildKey) this.children.getSuccessorKey(childKey);
    }

    public String getHashRepresentation(HashVersion version) {
        if (version == HashVersion.V1) {
            StringBuilder toHash = new StringBuilder();
            String str = ":";
            if (!this.priority.isEmpty()) {
                toHash.append("priority:");
                toHash.append(this.priority.getHashRepresentation(HashVersion.V1));
                toHash.append(str);
            }
            List<NamedNode> nodes = new ArrayList<>();
            boolean sawPriority = false;
            Iterator it = iterator();
            while (it.hasNext()) {
                NamedNode node = (NamedNode) it.next();
                nodes.add(node);
                sawPriority = sawPriority || !node.getNode().getPriority().isEmpty();
            }
            if (sawPriority) {
                Collections.sort(nodes, PriorityIndex.getInstance());
            }
            for (NamedNode node2 : nodes) {
                String hashString = node2.getNode().getHash();
                if (!hashString.equals("")) {
                    toHash.append(str);
                    toHash.append(node2.getName().asString());
                    toHash.append(str);
                    toHash.append(hashString);
                }
            }
            return toHash.toString();
        }
        throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
    }

    public String getHash() {
        if (this.lazyHash == null) {
            String hashString = getHashRepresentation(HashVersion.V1);
            this.lazyHash = hashString.isEmpty() ? "" : Utilities.sha1HexDigest(hashString);
        }
        return this.lazyHash;
    }

    public boolean isLeafNode() {
        return false;
    }

    public Node getPriority() {
        return this.priority;
    }

    public Node updatePriority(Node priority2) {
        if (this.children.isEmpty()) {
            return EmptyNode.Empty();
        }
        return new ChildrenNode(this.children, priority2);
    }

    public Node getImmediateChild(ChildKey name) {
        if (name.isPriorityChildName() && !this.priority.isEmpty()) {
            return this.priority;
        }
        if (this.children.containsKey(name)) {
            return (Node) this.children.get(name);
        }
        return EmptyNode.Empty();
    }

    public Node getChild(Path path) {
        ChildKey front = path.getFront();
        if (front == null) {
            return this;
        }
        return getImmediateChild(front).getChild(path.popFront());
    }

    public void forEachChild(ChildVisitor visitor) {
        forEachChild(visitor, false);
    }

    public void forEachChild(final ChildVisitor visitor, boolean includePriority) {
        if (!includePriority || getPriority().isEmpty()) {
            this.children.inOrderTraversal(visitor);
        } else {
            this.children.inOrderTraversal(new NodeVisitor<ChildKey, Node>() {
                boolean passedPriorityKey = false;

                public void visitEntry(ChildKey key, Node value) {
                    if (!this.passedPriorityKey && key.compareTo(ChildKey.getPriorityKey()) > 0) {
                        this.passedPriorityKey = true;
                        visitor.visitChild(ChildKey.getPriorityKey(), ChildrenNode.this.getPriority());
                    }
                    visitor.visitChild(key, value);
                }
            });
        }
    }

    public ChildKey getFirstChildKey() {
        return (ChildKey) this.children.getMinKey();
    }

    public ChildKey getLastChildKey() {
        return (ChildKey) this.children.getMaxKey();
    }

    public Node updateChild(Path path, Node newChildNode) {
        ChildKey front = path.getFront();
        if (front == null) {
            return newChildNode;
        }
        if (front.isPriorityChildName()) {
            return updatePriority(newChildNode);
        }
        return updateImmediateChild(front, getImmediateChild(front).updateChild(path.popFront(), newChildNode));
    }

    public Iterator<NamedNode> iterator() {
        return new NamedNodeIterator(this.children.iterator());
    }

    public Iterator<NamedNode> reverseIterator() {
        return new NamedNodeIterator(this.children.reverseIterator());
    }

    public Node updateImmediateChild(ChildKey key, Node newChildNode) {
        if (key.isPriorityChildName()) {
            return updatePriority(newChildNode);
        }
        ImmutableSortedMap<ChildKey, Node> newChildren = this.children;
        if (newChildren.containsKey(key)) {
            newChildren = newChildren.remove(key);
        }
        if (!newChildNode.isEmpty()) {
            newChildren = newChildren.insert(key, newChildNode);
        }
        if (newChildren.isEmpty()) {
            return EmptyNode.Empty();
        }
        return new ChildrenNode(newChildren, this.priority);
    }

    public int compareTo(Node o) {
        if (isEmpty()) {
            return o.isEmpty() ? 0 : -1;
        }
        if (!o.isLeafNode() && !o.isEmpty()) {
            return o == Node.MAX_NODE ? -1 : 0;
        }
        return 1;
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        if (otherObj == this) {
            return true;
        }
        if (!(otherObj instanceof ChildrenNode)) {
            return false;
        }
        ChildrenNode other = (ChildrenNode) otherObj;
        if (!getPriority().equals(other.getPriority()) || this.children.size() != other.children.size()) {
            return false;
        }
        Iterator<Entry<ChildKey, Node>> thisIterator = this.children.iterator();
        Iterator<Entry<ChildKey, Node>> otherIterator = other.children.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            Entry<ChildKey, Node> thisNameNode = (Entry) thisIterator.next();
            Entry<ChildKey, Node> otherNamedNode = (Entry) otherIterator.next();
            if (((ChildKey) thisNameNode.getKey()).equals(otherNamedNode.getKey())) {
                if (!((Node) thisNameNode.getValue()).equals(otherNamedNode.getValue())) {
                }
            }
            return false;
        }
        if (!thisIterator.hasNext() && !otherIterator.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public int hashCode() {
        int hashCode = 0;
        Iterator it = iterator();
        while (it.hasNext()) {
            NamedNode entry = (NamedNode) it.next();
            hashCode = (((hashCode * 31) + entry.getName().hashCode()) * 17) + entry.getNode().hashCode();
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        toString(builder, 0);
        return builder.toString();
    }

    private static void addIndentation(StringBuilder builder, int indentation) {
        for (int i = 0; i < indentation; i++) {
            builder.append(" ");
        }
    }

    private void toString(StringBuilder builder, int indentation) {
        String str;
        if (!this.children.isEmpty() || !this.priority.isEmpty()) {
            builder.append("{\n");
            Iterator it = this.children.iterator();
            while (true) {
                str = "\n";
                if (!it.hasNext()) {
                    break;
                }
                Entry<ChildKey, Node> childEntry = (Entry) it.next();
                addIndentation(builder, indentation + 2);
                builder.append(((ChildKey) childEntry.getKey()).asString());
                builder.append("=");
                if (childEntry.getValue() instanceof ChildrenNode) {
                    ((ChildrenNode) childEntry.getValue()).toString(builder, indentation + 2);
                } else {
                    builder.append(((Node) childEntry.getValue()).toString());
                }
                builder.append(str);
            }
            if (!this.priority.isEmpty()) {
                addIndentation(builder, indentation + 2);
                builder.append(".priority=");
                builder.append(this.priority.toString());
                builder.append(str);
            }
            addIndentation(builder, indentation);
            builder.append("}");
            return;
        }
        builder.append("{ }");
    }
}

package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class CompoundWrite implements Iterable<Entry<Path, Node>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final CompoundWrite EMPTY = new CompoundWrite(new ImmutableTree(null));
    private final ImmutableTree<Node> writeTree;

    private CompoundWrite(ImmutableTree<Node> writeTree2) {
        this.writeTree = writeTree2;
    }

    public static CompoundWrite emptyWrite() {
        return EMPTY;
    }

    public static CompoundWrite fromValue(Map<String, Object> merge) {
        ImmutableTree<Node> writeTree2 = ImmutableTree.emptyInstance();
        for (Entry<String, Object> entry : merge.entrySet()) {
            writeTree2 = writeTree2.setTree(new Path((String) entry.getKey()), new ImmutableTree<>(NodeUtilities.NodeFromJSON(entry.getValue())));
        }
        return new CompoundWrite(writeTree2);
    }

    public static CompoundWrite fromChildMerge(Map<ChildKey, Node> merge) {
        ImmutableTree<Node> writeTree2 = ImmutableTree.emptyInstance();
        for (Entry<ChildKey, Node> entry : merge.entrySet()) {
            writeTree2 = writeTree2.setTree(new Path((ChildKey) entry.getKey()), new ImmutableTree<>((Node) entry.getValue()));
        }
        return new CompoundWrite(writeTree2);
    }

    public static CompoundWrite fromPathMerge(Map<Path, Node> merge) {
        ImmutableTree<Node> writeTree2 = ImmutableTree.emptyInstance();
        for (Entry<Path, Node> entry : merge.entrySet()) {
            writeTree2 = writeTree2.setTree((Path) entry.getKey(), new ImmutableTree<>((Node) entry.getValue()));
        }
        return new CompoundWrite(writeTree2);
    }

    public CompoundWrite addWrite(Path path, Node node) {
        if (path.isEmpty()) {
            return new CompoundWrite(new ImmutableTree(node));
        }
        Path rootMostPath = this.writeTree.findRootMostPathWithValue(path);
        if (rootMostPath != null) {
            Path relativePath = Path.getRelative(rootMostPath, path);
            Node value = (Node) this.writeTree.get(rootMostPath);
            ChildKey back = relativePath.getBack();
            if (back != null && back.isPriorityChildName() && value.getChild(relativePath.getParent()).isEmpty()) {
                return this;
            }
            return new CompoundWrite(this.writeTree.set(rootMostPath, value.updateChild(relativePath, node)));
        }
        return new CompoundWrite(this.writeTree.setTree(path, new ImmutableTree<>(node)));
    }

    public CompoundWrite addWrite(ChildKey key, Node node) {
        return addWrite(new Path(key), node);
    }

    public CompoundWrite addWrites(final Path path, CompoundWrite updates) {
        return (CompoundWrite) updates.writeTree.fold(this, new TreeVisitor<Node, CompoundWrite>() {
            public CompoundWrite onNodeValue(Path relativePath, Node value, CompoundWrite accum) {
                return accum.addWrite(path.child(relativePath), value);
            }
        });
    }

    public CompoundWrite removeWrite(Path path) {
        if (path.isEmpty()) {
            return EMPTY;
        }
        return new CompoundWrite(this.writeTree.setTree(path, ImmutableTree.emptyInstance()));
    }

    public boolean hasCompleteWrite(Path path) {
        return getCompleteNode(path) != null;
    }

    public Node rootWrite() {
        return (Node) this.writeTree.getValue();
    }

    public Node getCompleteNode(Path path) {
        Path rootMost = this.writeTree.findRootMostPathWithValue(path);
        if (rootMost != null) {
            return ((Node) this.writeTree.get(rootMost)).getChild(Path.getRelative(rootMost, path));
        }
        return null;
    }

    public List<NamedNode> getCompleteChildren() {
        List<NamedNode> children = new ArrayList<>();
        if (this.writeTree.getValue() != null) {
            for (NamedNode entry : (Node) this.writeTree.getValue()) {
                children.add(new NamedNode(entry.getName(), entry.getNode()));
            }
        } else {
            Iterator it = this.writeTree.getChildren().iterator();
            while (it.hasNext()) {
                Entry<ChildKey, ImmutableTree<Node>> entry2 = (Entry) it.next();
                ImmutableTree<Node> childTree = (ImmutableTree) entry2.getValue();
                if (childTree.getValue() != null) {
                    children.add(new NamedNode((ChildKey) entry2.getKey(), (Node) childTree.getValue()));
                }
            }
        }
        return children;
    }

    public CompoundWrite childCompoundWrite(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        Node shadowingNode = getCompleteNode(path);
        if (shadowingNode != null) {
            return new CompoundWrite(new ImmutableTree(shadowingNode));
        }
        return new CompoundWrite(this.writeTree.subtree(path));
    }

    public Map<ChildKey, CompoundWrite> childCompoundWrites() {
        Map<ChildKey, CompoundWrite> children = new HashMap<>();
        Iterator it = this.writeTree.getChildren().iterator();
        while (it.hasNext()) {
            Entry<ChildKey, ImmutableTree<Node>> entries = (Entry) it.next();
            children.put((ChildKey) entries.getKey(), new CompoundWrite((ImmutableTree) entries.getValue()));
        }
        return children;
    }

    public boolean isEmpty() {
        return this.writeTree.isEmpty();
    }

    private Node applySubtreeWrite(Path relativePath, ImmutableTree<Node> writeTree2, Node node) {
        if (writeTree2.getValue() != null) {
            return node.updateChild(relativePath, (Node) writeTree2.getValue());
        }
        Node priorityWrite = null;
        Iterator it = writeTree2.getChildren().iterator();
        while (it.hasNext()) {
            Entry<ChildKey, ImmutableTree<Node>> childTreeEntry = (Entry) it.next();
            ImmutableTree<Node> childTree = (ImmutableTree) childTreeEntry.getValue();
            ChildKey childKey = (ChildKey) childTreeEntry.getKey();
            if (childKey.isPriorityChildName()) {
                priorityWrite = (Node) childTree.getValue();
            } else {
                node = applySubtreeWrite(relativePath.child(childKey), childTree, node);
            }
        }
        if (!node.getChild(relativePath).isEmpty() && priorityWrite != null) {
            node = node.updateChild(relativePath.child(ChildKey.getPriorityKey()), priorityWrite);
        }
        return node;
    }

    public Node apply(Node node) {
        return applySubtreeWrite(Path.getEmptyPath(), this.writeTree, node);
    }

    public Map<String, Object> getValue(final boolean exportFormat) {
        final Map<String, Object> writes = new HashMap<>();
        this.writeTree.foreach(new TreeVisitor<Node, Void>() {
            public Void onNodeValue(Path relativePath, Node value, Void accum) {
                writes.put(relativePath.wireFormat(), value.getValue(exportFormat));
                return null;
            }
        });
        return writes;
    }

    public Iterator<Entry<Path, Node>> iterator() {
        return this.writeTree.iterator();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        return ((CompoundWrite) o).getValue(true).equals(getValue(true));
    }

    public int hashCode() {
        return getValue(true).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompoundWrite{");
        sb.append(getValue(true).toString());
        sb.append("}");
        return sb.toString();
    }
}

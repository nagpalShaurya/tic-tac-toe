package com.google.firebase.database.core.persistence;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class PruneForest {
    private static final Predicate<Boolean> KEEP_PREDICATE = new Predicate<Boolean>() {
        public boolean evaluate(Boolean prune) {
            return !prune.booleanValue();
        }
    };
    private static final ImmutableTree<Boolean> KEEP_TREE = new ImmutableTree<>(Boolean.valueOf(false));
    private static final Predicate<Boolean> PRUNE_PREDICATE = new Predicate<Boolean>() {
        public boolean evaluate(Boolean prune) {
            return prune.booleanValue();
        }
    };
    private static final ImmutableTree<Boolean> PRUNE_TREE = new ImmutableTree<>(Boolean.valueOf(true));
    private final ImmutableTree<Boolean> pruneForest;

    public PruneForest() {
        this.pruneForest = ImmutableTree.emptyInstance();
    }

    private PruneForest(ImmutableTree<Boolean> pruneForest2) {
        this.pruneForest = pruneForest2;
    }

    public boolean prunesAnything() {
        return this.pruneForest.containsMatchingValue(PRUNE_PREDICATE);
    }

    public boolean shouldPruneUnkeptDescendants(Path path) {
        Boolean shouldPrune = (Boolean) this.pruneForest.leafMostValue(path);
        return shouldPrune != null && shouldPrune.booleanValue();
    }

    public boolean shouldKeep(Path path) {
        Boolean shouldPrune = (Boolean) this.pruneForest.leafMostValue(path);
        return shouldPrune != null && !shouldPrune.booleanValue();
    }

    public boolean affectsPath(Path path) {
        return this.pruneForest.rootMostValue(path) != null || !this.pruneForest.subtree(path).isEmpty();
    }

    public PruneForest child(ChildKey key) {
        ImmutableTree child = this.pruneForest.getChild(key);
        if (child == null) {
            child = new ImmutableTree((Boolean) this.pruneForest.getValue());
        } else if (child.getValue() == null && this.pruneForest.getValue() != null) {
            child = child.set(Path.getEmptyPath(), (Boolean) this.pruneForest.getValue());
        }
        return new PruneForest(child);
    }

    public PruneForest child(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        return child(path.getFront()).child(path.popFront());
    }

    public <T> T foldKeptNodes(T startValue, final TreeVisitor<Void, T> treeVisitor) {
        return this.pruneForest.fold(startValue, new TreeVisitor<Boolean, T>() {
            public T onNodeValue(Path relativePath, Boolean prune, T accum) {
                if (!prune.booleanValue()) {
                    return treeVisitor.onNodeValue(relativePath, null, accum);
                }
                return accum;
            }
        });
    }

    public PruneForest prune(Path path) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        } else if (this.pruneForest.rootMostValueMatching(path, PRUNE_PREDICATE) != null) {
            return this;
        } else {
            return new PruneForest(this.pruneForest.setTree(path, PRUNE_TREE));
        }
    }

    public PruneForest keep(Path path) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            return this;
        }
        return new PruneForest(this.pruneForest.setTree(path, KEEP_TREE));
    }

    public PruneForest keepAll(Path path, Set<ChildKey> children) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            return this;
        }
        return doAll(path, children, KEEP_TREE);
    }

    public PruneForest pruneAll(Path path, Set<ChildKey> children) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        } else if (this.pruneForest.rootMostValueMatching(path, PRUNE_PREDICATE) != null) {
            return this;
        } else {
            return doAll(path, children, PRUNE_TREE);
        }
    }

    private PruneForest doAll(Path path, Set<ChildKey> children, ImmutableTree<Boolean> keepOrPruneTree) {
        ImmutableTree<Boolean> subtree = this.pruneForest.subtree(path);
        ImmutableSortedMap<ChildKey, ImmutableTree<Boolean>> childrenMap = subtree.getChildren();
        for (ChildKey key : children) {
            childrenMap = childrenMap.insert(key, keepOrPruneTree);
        }
        return new PruneForest(this.pruneForest.setTree(path, new ImmutableTree((Boolean) subtree.getValue(), childrenMap)));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PruneForest)) {
            return false;
        }
        if (!this.pruneForest.equals(((PruneForest) o).pruneForest)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.pruneForest.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{PruneForest:");
        sb.append(this.pruneForest.toString());
        sb.append("}");
        return sb.toString();
    }
}

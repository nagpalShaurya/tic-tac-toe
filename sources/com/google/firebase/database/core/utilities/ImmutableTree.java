package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ImmutableTree<T> implements Iterable<Entry<Path, T>> {
    private static final ImmutableTree EMPTY = new ImmutableTree(null, EMPTY_CHILDREN);
    private static final ImmutableSortedMap EMPTY_CHILDREN = Builder.emptyMap(StandardComparator.getComparator(ChildKey.class));
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> children;
    private final T value;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface TreeVisitor<T, R> {
        R onNodeValue(Path path, T t, R r);
    }

    public static <V> ImmutableTree<V> emptyInstance() {
        return EMPTY;
    }

    public ImmutableTree(T value2, ImmutableSortedMap<ChildKey, ImmutableTree<T>> children2) {
        this.value = value2;
        this.children = children2;
    }

    public ImmutableTree(T value2) {
        this(value2, EMPTY_CHILDREN);
    }

    public T getValue() {
        return this.value;
    }

    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> getChildren() {
        return this.children;
    }

    public boolean isEmpty() {
        return this.value == null && this.children.isEmpty();
    }

    public Path findRootMostMatchingPath(Path relativePath, Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return Path.getEmptyPath();
        }
        if (relativePath.isEmpty()) {
            return null;
        }
        ChildKey front = relativePath.getFront();
        ImmutableTree<T> child = (ImmutableTree) this.children.get(front);
        if (child == null) {
            return null;
        }
        Path path = child.findRootMostMatchingPath(relativePath.popFront(), predicate);
        if (path == null) {
            return null;
        }
        return new Path(front).child(path);
    }

    public Path findRootMostPathWithValue(Path relativePath) {
        return findRootMostMatchingPath(relativePath, Predicate.TRUE);
    }

    public T rootMostValue(Path relativePath) {
        return rootMostValueMatching(relativePath, Predicate.TRUE);
    }

    public T rootMostValueMatching(Path relativePath, Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return this.value;
        }
        ImmutableTree immutableTree = this;
        Iterator it = relativePath.iterator();
        while (it.hasNext()) {
            immutableTree = (ImmutableTree) immutableTree.children.get((ChildKey) it.next());
            if (immutableTree == null) {
                return null;
            }
            T t2 = immutableTree.value;
            if (t2 != null && predicate.evaluate(t2)) {
                return immutableTree.value;
            }
        }
        return null;
    }

    public T leafMostValue(Path relativePath) {
        return leafMostValueMatching(relativePath, Predicate.TRUE);
    }

    public T leafMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t = this.value;
        T currentValue = (t == null || !predicate.evaluate(t)) ? null : this.value;
        ImmutableTree immutableTree = this;
        Iterator it = path.iterator();
        while (it.hasNext()) {
            immutableTree = (ImmutableTree) immutableTree.children.get((ChildKey) it.next());
            if (immutableTree == null) {
                return currentValue;
            }
            T t2 = immutableTree.value;
            if (t2 != null && predicate.evaluate(t2)) {
                currentValue = immutableTree.value;
            }
        }
        return currentValue;
    }

    public boolean containsMatchingValue(Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return true;
        }
        Iterator it = this.children.iterator();
        while (it.hasNext()) {
            if (((ImmutableTree) ((Entry) it.next()).getValue()).containsMatchingValue(predicate)) {
                return true;
            }
        }
        return false;
    }

    public ImmutableTree<T> getChild(ChildKey child) {
        ImmutableTree<T> childTree = (ImmutableTree) this.children.get(child);
        if (childTree != null) {
            return childTree;
        }
        return emptyInstance();
    }

    public ImmutableTree<T> subtree(Path relativePath) {
        if (relativePath.isEmpty()) {
            return this;
        }
        ImmutableTree<T> childTree = (ImmutableTree) this.children.get(relativePath.getFront());
        if (childTree != null) {
            return childTree.subtree(relativePath.popFront());
        }
        return emptyInstance();
    }

    public ImmutableTree<T> set(Path relativePath, T value2) {
        if (relativePath.isEmpty()) {
            return new ImmutableTree<>(value2, this.children);
        }
        ChildKey front = relativePath.getFront();
        ImmutableTree<T> child = (ImmutableTree) this.children.get(front);
        if (child == null) {
            child = emptyInstance();
        }
        return new ImmutableTree<>(this.value, this.children.insert(front, child.set(relativePath.popFront(), value2)));
    }

    public ImmutableTree<T> remove(Path relativePath) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> newChildren;
        if (!relativePath.isEmpty()) {
            ChildKey front = relativePath.getFront();
            ImmutableTree<T> child = (ImmutableTree) this.children.get(front);
            if (child == null) {
                return this;
            }
            ImmutableTree<T> newChild = child.remove(relativePath.popFront());
            if (newChild.isEmpty()) {
                newChildren = this.children.remove(front);
            } else {
                newChildren = this.children.insert(front, newChild);
            }
            if (this.value != null || !newChildren.isEmpty()) {
                return new ImmutableTree<>(this.value, newChildren);
            }
            return emptyInstance();
        } else if (this.children.isEmpty()) {
            return emptyInstance();
        } else {
            return new ImmutableTree<>(null, this.children);
        }
    }

    public T get(Path relativePath) {
        if (relativePath.isEmpty()) {
            return this.value;
        }
        ImmutableTree<T> child = (ImmutableTree) this.children.get(relativePath.getFront());
        if (child != null) {
            return child.get(relativePath.popFront());
        }
        return null;
    }

    public ImmutableTree<T> setTree(Path relativePath, ImmutableTree<T> newTree) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> newChildren;
        if (relativePath.isEmpty()) {
            return newTree;
        }
        ChildKey front = relativePath.getFront();
        ImmutableTree<T> child = (ImmutableTree) this.children.get(front);
        if (child == null) {
            child = emptyInstance();
        }
        ImmutableTree<T> newChild = child.setTree(relativePath.popFront(), newTree);
        if (newChild.isEmpty()) {
            newChildren = this.children.remove(front);
        } else {
            newChildren = this.children.insert(front, newChild);
        }
        return new ImmutableTree<>(this.value, newChildren);
    }

    public void foreach(TreeVisitor<T, Void> visitor) {
        fold(Path.getEmptyPath(), visitor, null);
    }

    public <R> R fold(R accum, TreeVisitor<? super T, R> visitor) {
        return fold(Path.getEmptyPath(), visitor, accum);
    }

    private <R> R fold(Path relativePath, TreeVisitor<? super T, R> visitor, R accum) {
        Iterator it = this.children.iterator();
        while (it.hasNext()) {
            Entry<ChildKey, ImmutableTree<T>> subtree = (Entry) it.next();
            accum = ((ImmutableTree) subtree.getValue()).fold(relativePath.child((ChildKey) subtree.getKey()), visitor, accum);
        }
        T t = this.value;
        if (t != null) {
            return visitor.onNodeValue(relativePath, t, accum);
        }
        return accum;
    }

    public Collection<T> values() {
        final ArrayList<T> list = new ArrayList<>();
        foreach(new TreeVisitor<T, Void>() {
            public Void onNodeValue(Path relativePath, T value, Void accum) {
                list.add(value);
                return null;
            }
        });
        return list;
    }

    public Iterator<Entry<Path, T>> iterator() {
        final List<Entry<Path, T>> list = new ArrayList<>();
        foreach(new TreeVisitor<T, Void>() {
            public Void onNodeValue(Path relativePath, T value, Void accum) {
                list.add(new SimpleImmutableEntry(relativePath, value));
                return null;
            }
        });
        return list.iterator();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImmutableTree { value=");
        builder.append(getValue());
        builder.append(", children={");
        Iterator it = this.children.iterator();
        while (it.hasNext()) {
            Entry<ChildKey, ImmutableTree<T>> child = (Entry) it.next();
            builder.append(((ChildKey) child.getKey()).asString());
            builder.append("=");
            builder.append(child.getValue());
        }
        builder.append("} }");
        return builder.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImmutableTree that = (ImmutableTree) o;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap == null ? that.children != null : !immutableSortedMap.equals(that.children)) {
            return false;
        }
        T t = this.value;
        if (t == null ? that.value == null : t.equals(that.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        T t = this.value;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap != null) {
            i = immutableSortedMap.hashCode();
        }
        return hashCode + i;
    }
}

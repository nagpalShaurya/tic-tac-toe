package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.NoSuchElementException;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class MutableData {
    /* access modifiers changed from: private */
    public final SnapshotHolder holder;
    /* access modifiers changed from: private */
    public final Path prefixPath;

    MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    private MutableData(SnapshotHolder holder2, Path path) {
        this.holder = holder2;
        this.prefixPath = path;
        ValidationPath.validateWithObject(this.prefixPath, getValue());
    }

    /* access modifiers changed from: 0000 */
    public Node getNode() {
        return this.holder.getNode(this.prefixPath);
    }

    @PublicApi
    public boolean hasChildren() {
        Node node = getNode();
        return !node.isLeafNode() && !node.isEmpty();
    }

    @PublicApi
    public boolean hasChild(String path) {
        return !getNode().getChild(new Path(path)).isEmpty();
    }

    @PublicApi
    @NonNull
    public MutableData child(@NonNull String path) {
        Validation.validatePathString(path);
        return new MutableData(this.holder, this.prefixPath.child(new Path(path)));
    }

    @PublicApi
    public long getChildrenCount() {
        return (long) getNode().getChildCount();
    }

    @PublicApi
    @NonNull
    public Iterable<MutableData> getChildren() {
        Node node = getNode();
        if (node.isEmpty() || node.isLeafNode()) {
            return new Iterable<MutableData>() {
                public Iterator<MutableData> iterator() {
                    return new Iterator<MutableData>() {
                        public boolean hasNext() {
                            return false;
                        }

                        @NonNull
                        public MutableData next() {
                            throw new NoSuchElementException();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }
                    };
                }
            };
        }
        final Iterator<NamedNode> iter = IndexedNode.from(node).iterator();
        return new Iterable<MutableData>() {
            public Iterator<MutableData> iterator() {
                return new Iterator<MutableData>() {
                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @NonNull
                    public MutableData next() {
                        return new MutableData(MutableData.this.holder, MutableData.this.prefixPath.child(((NamedNode) iter.next()).getName()));
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }
                };
            }
        };
    }

    @Nullable
    @PublicApi
    public String getKey() {
        if (this.prefixPath.getBack() != null) {
            return this.prefixPath.getBack().asString();
        }
        return null;
    }

    @Nullable
    @PublicApi
    public Object getValue() {
        return getNode().getValue();
    }

    @Nullable
    @PublicApi
    public <T> T getValue(@NonNull Class<T> valueType) {
        return CustomClassMapper.convertToCustomClass(getNode().getValue(), valueType);
    }

    @Nullable
    @PublicApi
    public <T> T getValue(@NonNull GenericTypeIndicator<T> t) {
        return CustomClassMapper.convertToCustomClass(getNode().getValue(), t);
    }

    @PublicApi
    public void setValue(@Nullable Object value) throws DatabaseException {
        ValidationPath.validateWithObject(this.prefixPath, value);
        Object bouncedValue = CustomClassMapper.convertToPlainJavaTypes(value);
        Validation.validateWritableObject(bouncedValue);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(bouncedValue));
    }

    @PublicApi
    public void setPriority(@Nullable Object priority) {
        this.holder.update(this.prefixPath, getNode().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, priority)));
    }

    @Nullable
    @PublicApi
    public Object getPriority() {
        return getNode().getPriority().getValue();
    }

    public boolean equals(Object o) {
        return (o instanceof MutableData) && this.holder.equals(((MutableData) o).holder) && this.prefixPath.equals(((MutableData) o).prefixPath);
    }

    public String toString() {
        ChildKey front = this.prefixPath.getFront();
        StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        sb.append(front != null ? front.asString() : "<none>");
        sb.append(", value = ");
        sb.append(this.holder.getRootNode().getValue(true));
        sb.append(" }");
        return sb.toString();
    }
}

package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.Iterator;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DataSnapshot {
    private final IndexedNode node;
    /* access modifiers changed from: private */
    public final DatabaseReference query;

    DataSnapshot(DatabaseReference ref, IndexedNode node2) {
        this.node = node2;
        this.query = ref;
    }

    @PublicApi
    @NonNull
    public DataSnapshot child(@NonNull String path) {
        return new DataSnapshot(this.query.child(path), IndexedNode.from(this.node.getNode().getChild(new Path(path))));
    }

    @PublicApi
    public boolean hasChild(@NonNull String path) {
        if (this.query.getParent() == null) {
            Validation.validateRootPathString(path);
        } else {
            Validation.validatePathString(path);
        }
        return !this.node.getNode().getChild(new Path(path)).isEmpty();
    }

    @PublicApi
    public boolean hasChildren() {
        return this.node.getNode().getChildCount() > 0;
    }

    @PublicApi
    public boolean exists() {
        return !this.node.getNode().isEmpty();
    }

    @Nullable
    @PublicApi
    public Object getValue() {
        return this.node.getNode().getValue();
    }

    @Nullable
    @PublicApi
    public Object getValue(boolean useExportFormat) {
        return this.node.getNode().getValue(useExportFormat);
    }

    @Nullable
    @PublicApi
    public <T> T getValue(@NonNull Class<T> valueType) {
        return CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), valueType);
    }

    @Nullable
    @PublicApi
    public <T> T getValue(@NonNull GenericTypeIndicator<T> t) {
        return CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), t);
    }

    @PublicApi
    public long getChildrenCount() {
        return (long) this.node.getNode().getChildCount();
    }

    @PublicApi
    @NonNull
    public DatabaseReference getRef() {
        return this.query;
    }

    @Nullable
    @PublicApi
    public String getKey() {
        return this.query.getKey();
    }

    @PublicApi
    @NonNull
    public Iterable<DataSnapshot> getChildren() {
        final Iterator<NamedNode> iter = this.node.iterator();
        return new Iterable<DataSnapshot>() {
            public Iterator<DataSnapshot> iterator() {
                return new Iterator<DataSnapshot>() {
                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @NonNull
                    public DataSnapshot next() {
                        NamedNode namedNode = (NamedNode) iter.next();
                        return new DataSnapshot(DataSnapshot.this.query.child(namedNode.getName().asString()), IndexedNode.from(namedNode.getNode()));
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
    public Object getPriority() {
        Object priority = this.node.getNode().getPriority().getValue();
        if (priority instanceof Long) {
            return Double.valueOf((double) ((Long) priority).longValue());
        }
        return priority;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataSnapshot { key = ");
        sb.append(this.query.getKey());
        sb.append(", value = ");
        sb.append(this.node.getNode().getValue(true));
        sb.append(" }");
        return sb.toString();
    }
}

package com.google.firebase.database.core;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ServerValues {
    public static final String NAME_SUBKEY_SERVERVALUE = ".sv";

    public static Map<String, Object> generateServerValues(Clock clock) {
        Map<String, Object> values = new HashMap<>();
        values.put(Param.TIMESTAMP, Long.valueOf(clock.millis()));
        return values;
    }

    public static Object resolveDeferredValue(Object value, Map<String, Object> serverValues) {
        if (value instanceof Map) {
            Map mapValue = (Map) value;
            String str = NAME_SUBKEY_SERVERVALUE;
            if (mapValue.containsKey(str)) {
                String serverValueKey = (String) mapValue.get(str);
                if (serverValues.containsKey(serverValueKey)) {
                    return serverValues.get(serverValueKey);
                }
            }
        }
        return value;
    }

    public static SparseSnapshotTree resolveDeferredValueTree(SparseSnapshotTree tree, final Map<String, Object> serverValues) {
        final SparseSnapshotTree resolvedTree = new SparseSnapshotTree();
        tree.forEachTree(new Path(""), new SparseSnapshotTreeVisitor() {
            public void visitTree(Path prefixPath, Node tree) {
                SparseSnapshotTree.this.remember(prefixPath, ServerValues.resolveDeferredValueSnapshot(tree, serverValues));
            }
        });
        return resolvedTree;
    }

    public static Node resolveDeferredValueSnapshot(Node data, final Map<String, Object> serverValues) {
        Object priorityVal = data.getPriority().getValue();
        if (priorityVal instanceof Map) {
            Map priorityMapValue = (Map) priorityVal;
            String str = NAME_SUBKEY_SERVERVALUE;
            if (priorityMapValue.containsKey(str)) {
                priorityVal = serverValues.get((String) priorityMapValue.get(str));
            }
        }
        Node priority = PriorityUtilities.parsePriority(priorityVal);
        if (data.isLeafNode()) {
            Object value = resolveDeferredValue(data.getValue(), serverValues);
            if (!value.equals(data.getValue()) || !priority.equals(data.getPriority())) {
                return NodeUtilities.NodeFromJSON(value, priority);
            }
            return data;
        } else if (data.isEmpty()) {
            return data;
        } else {
            ChildrenNode childNode = (ChildrenNode) data;
            final SnapshotHolder holder = new SnapshotHolder(childNode);
            childNode.forEachChild(new ChildVisitor() {
                public void visitChild(ChildKey name, Node child) {
                    Node newChildNode = ServerValues.resolveDeferredValueSnapshot(child, serverValues);
                    if (newChildNode != child) {
                        holder.update(new Path(name.asString()), newChildNode);
                    }
                }
            });
            if (!holder.getRootNode().getPriority().equals(priority)) {
                return holder.getRootNode().updatePriority(priority);
            }
            return holder.getRootNode();
        }
    }

    public static CompoundWrite resolveDeferredValueMerge(CompoundWrite merge, Map<String, Object> serverValues) {
        CompoundWrite write = CompoundWrite.emptyWrite();
        Iterator it = merge.iterator();
        while (it.hasNext()) {
            Entry<Path, Node> entry = (Entry) it.next();
            write = write.addWrite((Path) entry.getKey(), resolveDeferredValueSnapshot((Node) entry.getValue(), serverValues));
        }
        return write;
    }
}

package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    /* access modifiers changed from: 0000 */
    public String toString(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("<value>: ");
        sb.append(this.value);
        String str = "\n";
        sb.append(str);
        String result = sb.toString();
        if (this.children.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(result);
            sb2.append(prefix);
            sb2.append("<empty>");
            return sb2.toString();
        }
        for (Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(result);
            sb3.append(prefix);
            sb3.append(entry.getKey());
            sb3.append(":\n");
            TreeNode treeNode = (TreeNode) entry.getValue();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(prefix);
            sb4.append("\t");
            sb3.append(treeNode.toString(sb4.toString()));
            sb3.append(str);
            result = sb3.toString();
        }
        return result;
    }
}

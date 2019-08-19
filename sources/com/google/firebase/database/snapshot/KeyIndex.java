package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class KeyIndex extends Index {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final KeyIndex INSTANCE = new KeyIndex();

    public static KeyIndex getInstance() {
        return INSTANCE;
    }

    private KeyIndex() {
    }

    public boolean isDefinedOn(Node a) {
        return true;
    }

    public NamedNode makePost(ChildKey name, Node value) {
        return new NamedNode(ChildKey.fromString((String) value.getValue()), EmptyNode.Empty());
    }

    public NamedNode maxPost() {
        return NamedNode.getMaxNode();
    }

    public String getQueryDefinition() {
        return ".key";
    }

    public int compare(NamedNode o1, NamedNode o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public boolean equals(Object o) {
        return o instanceof KeyIndex;
    }

    public int hashCode() {
        return 37;
    }

    public String toString() {
        return "KeyIndex";
    }
}

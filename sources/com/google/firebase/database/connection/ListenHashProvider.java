package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface ListenHashProvider {
    CompoundHash getCompoundHash();

    String getSimpleHash();

    boolean shouldIncludeCompoundHash();
}

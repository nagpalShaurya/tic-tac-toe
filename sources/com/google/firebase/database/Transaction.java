package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.snapshot.Node;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Transaction {

    @PublicApi
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface Handler {
        @PublicApi
        @NonNull
        Result doTransaction(@NonNull MutableData mutableData);

        @PublicApi
        void onComplete(@Nullable DatabaseError databaseError, boolean z, @Nullable DataSnapshot dataSnapshot);
    }

    @PublicApi
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public static class Result {
        private Node data;
        private boolean success;

        private Result(boolean success2, Node data2) {
            this.success = success2;
            this.data = data2;
        }

        @PublicApi
        public boolean isSuccess() {
            return this.success;
        }

        public Node getNode() {
            return this.data;
        }
    }

    @PublicApi
    @NonNull
    public static Result abort() {
        return new Result(false, null);
    }

    @PublicApi
    @NonNull
    public static Result success(@NonNull MutableData resultData) {
        return new Result(true, resultData.getNode());
    }
}

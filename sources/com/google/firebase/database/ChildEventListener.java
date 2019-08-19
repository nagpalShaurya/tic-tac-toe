package com.google.firebase.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.annotations.PublicApi;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface ChildEventListener {
    @PublicApi
    void onCancelled(@NonNull DatabaseError databaseError);

    @PublicApi
    void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String str);

    @PublicApi
    void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String str);

    @PublicApi
    void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String str);

    @PublicApi
    void onChildRemoved(@NonNull DataSnapshot dataSnapshot);
}

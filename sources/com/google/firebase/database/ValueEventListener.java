package com.google.firebase.database;

import android.support.annotation.NonNull;
import com.google.firebase.annotations.PublicApi;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface ValueEventListener {
    @PublicApi
    void onCancelled(@NonNull DatabaseError databaseError);

    @PublicApi
    void onDataChange(@NonNull DataSnapshot dataSnapshot);
}

package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class PathAndId {

    /* renamed from: id */
    private long f46id;
    private Path path;

    public PathAndId(Path path2, long id) {
        this.path = path2;
        this.f46id = id;
    }

    public Path getPath() {
        return this.path;
    }

    public long getId() {
        return this.f46id;
    }
}

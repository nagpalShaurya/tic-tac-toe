package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class TrackedQuery {
    public final boolean active;
    public final boolean complete;

    /* renamed from: id */
    public final long f45id;
    public final long lastUse;
    public final QuerySpec querySpec;

    public TrackedQuery(long id, QuerySpec querySpec2, long lastUse2, boolean complete2, boolean active2) {
        this.f45id = id;
        if (!querySpec2.loadsAllData() || querySpec2.isDefault()) {
            this.querySpec = querySpec2;
            this.lastUse = lastUse2;
            this.complete = complete2;
            this.active = active2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public TrackedQuery updateLastUse(long lastUse2) {
        TrackedQuery trackedQuery = new TrackedQuery(this.f45id, this.querySpec, lastUse2, this.complete, this.active);
        return trackedQuery;
    }

    public TrackedQuery setComplete() {
        TrackedQuery trackedQuery = new TrackedQuery(this.f45id, this.querySpec, this.lastUse, true, this.active);
        return trackedQuery;
    }

    public TrackedQuery setActiveState(boolean isActive) {
        TrackedQuery trackedQuery = new TrackedQuery(this.f45id, this.querySpec, this.lastUse, this.complete, isActive);
        return trackedQuery;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        TrackedQuery query = (TrackedQuery) o;
        if (!(this.f45id == query.f45id && this.querySpec.equals(query.querySpec) && this.lastUse == query.lastUse && this.complete == query.complete && this.active == query.active)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f45id).hashCode() * 31) + this.querySpec.hashCode()) * 31) + Long.valueOf(this.lastUse).hashCode()) * 31) + Boolean.valueOf(this.complete).hashCode()) * 31) + Boolean.valueOf(this.active).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrackedQuery{id=");
        sb.append(this.f45id);
        sb.append(", querySpec=");
        sb.append(this.querySpec);
        sb.append(", lastUse=");
        sb.append(this.lastUse);
        sb.append(", complete=");
        sb.append(this.complete);
        sb.append(", active=");
        sb.append(this.active);
        sb.append("}");
        return sb.toString();
    }
}

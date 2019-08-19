package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Index;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class QuerySpec {
    private final QueryParams params;
    private final Path path;

    public static QuerySpec defaultQueryAtPath(Path path2) {
        return new QuerySpec(path2, QueryParams.DEFAULT_PARAMS);
    }

    public QuerySpec(Path path2, QueryParams params2) {
        this.path = path2;
        this.params = params2;
    }

    public Path getPath() {
        return this.path;
    }

    public QueryParams getParams() {
        return this.params;
    }

    public static QuerySpec fromPathAndQueryObject(Path path2, Map<String, Object> map) {
        return new QuerySpec(path2, QueryParams.fromQueryObject(map));
    }

    public Index getIndex() {
        return this.params.getIndex();
    }

    public boolean isDefault() {
        return this.params.isDefault();
    }

    public boolean loadsAllData() {
        return this.params.loadsAllData();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.path);
        sb.append(":");
        sb.append(this.params);
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuerySpec that = (QuerySpec) o;
        if (this.path.equals(that.path) && this.params.equals(that.params)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.params.hashCode();
    }
}

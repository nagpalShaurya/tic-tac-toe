package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Tag {
    private final long tagNumber;

    public Tag(long tagNumber2) {
        this.tagNumber = tagNumber2;
    }

    public long getTagNumber() {
        return this.tagNumber;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tag{tagNumber=");
        sb.append(this.tagNumber);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (this.tagNumber != ((Tag) o).tagNumber) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.tagNumber;
        return (int) (j ^ (j >>> 32));
    }
}

package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Path implements Iterable<ChildKey>, Comparable<Path> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Path EMPTY_PATH = new Path("");
    /* access modifiers changed from: private */
    public final int end;
    /* access modifiers changed from: private */
    public final ChildKey[] pieces;
    /* access modifiers changed from: private */
    public final int start;

    public static Path getRelative(Path from, Path to) {
        ChildKey outerFront = from.getFront();
        ChildKey innerFront = to.getFront();
        if (outerFront == null) {
            return to;
        }
        if (outerFront.equals(innerFront)) {
            return getRelative(from.popFront(), to.popFront());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("INTERNAL ERROR: ");
        sb.append(to);
        sb.append(" is not contained in ");
        sb.append(from);
        throw new DatabaseException(sb.toString());
    }

    public static Path getEmptyPath() {
        return EMPTY_PATH;
    }

    public Path(ChildKey... segments) {
        this.pieces = (ChildKey[]) Arrays.copyOf(segments, segments.length);
        this.start = 0;
        this.end = segments.length;
        for (ChildKey childKey : segments) {
        }
    }

    public Path(List<String> segments) {
        this.pieces = new ChildKey[segments.size()];
        int i = 0;
        for (String segment : segments) {
            int i2 = i + 1;
            this.pieces[i] = ChildKey.fromString(segment);
            i = i2;
        }
        this.start = 0;
        this.end = segments.size();
    }

    public Path(String pathString) {
        String[] segments = pathString.split("/", -1);
        int count = 0;
        for (String segment : segments) {
            if (segment.length() > 0) {
                count++;
            }
        }
        this.pieces = new ChildKey[count];
        int j = 0;
        for (String segment2 : segments) {
            if (segment2.length() > 0) {
                int j2 = j + 1;
                this.pieces[j] = ChildKey.fromString(segment2);
                j = j2;
            }
        }
        this.start = 0;
        this.end = this.pieces.length;
    }

    private Path(ChildKey[] pieces2, int start2, int end2) {
        this.pieces = pieces2;
        this.start = start2;
        this.end = end2;
    }

    public Path child(Path path) {
        int newSize = size() + path.size();
        ChildKey[] newPieces = new ChildKey[newSize];
        System.arraycopy(this.pieces, this.start, newPieces, 0, size());
        System.arraycopy(path.pieces, path.start, newPieces, size(), path.size());
        return new Path(newPieces, 0, newSize);
    }

    public Path child(ChildKey child) {
        int size = size();
        ChildKey[] newPieces = new ChildKey[(size + 1)];
        System.arraycopy(this.pieces, this.start, newPieces, 0, size);
        newPieces[size] = child;
        return new Path(newPieces, 0, size + 1);
    }

    public String toString() {
        String str = "/";
        if (isEmpty()) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            builder.append(str);
            builder.append(this.pieces[i].asString());
        }
        return builder.toString();
    }

    public String wireFormat() {
        String str = "/";
        if (isEmpty()) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            if (i > this.start) {
                builder.append(str);
            }
            builder.append(this.pieces[i].asString());
        }
        return builder.toString();
    }

    public List<String> asList() {
        List<String> result = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            result.add(((ChildKey) it.next()).asString());
        }
        return result;
    }

    public ChildKey getFront() {
        if (isEmpty()) {
            return null;
        }
        return this.pieces[this.start];
    }

    public Path popFront() {
        int newStart = this.start;
        if (!isEmpty()) {
            newStart++;
        }
        return new Path(this.pieces, newStart, this.end);
    }

    public Path getParent() {
        if (isEmpty()) {
            return null;
        }
        return new Path(this.pieces, this.start, this.end - 1);
    }

    public ChildKey getBack() {
        if (!isEmpty()) {
            return this.pieces[this.end - 1];
        }
        return null;
    }

    public boolean isEmpty() {
        return this.start >= this.end;
    }

    public int size() {
        return this.end - this.start;
    }

    public Iterator<ChildKey> iterator() {
        return new Iterator<ChildKey>() {
            int offset = Path.this.start;

            public boolean hasNext() {
                return this.offset < Path.this.end;
            }

            public ChildKey next() {
                if (hasNext()) {
                    ChildKey[] access$200 = Path.this.pieces;
                    int i = this.offset;
                    ChildKey child = access$200[i];
                    this.offset = i + 1;
                    return child;
                }
                throw new NoSuchElementException("No more elements.");
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove component from immutable Path!");
            }
        };
    }

    public boolean contains(Path other) {
        if (size() > other.size()) {
            return false;
        }
        int i = this.start;
        int j = other.start;
        while (i < this.end) {
            if (!this.pieces[i].equals(other.pieces[j])) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Path)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        Path otherPath = (Path) other;
        if (size() != otherPath.size()) {
            return false;
        }
        int i = this.start;
        int j = otherPath.start;
        while (i < this.end && j < otherPath.end) {
            if (!this.pieces[i].equals(otherPath.pieces[j])) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = 0;
        for (int i = this.start; i < this.end; i++) {
            hashCode = (hashCode * 37) + this.pieces[i].hashCode();
        }
        return hashCode;
    }

    public int compareTo(Path other) {
        int i = this.start;
        int j = other.start;
        while (i < this.end && j < other.end) {
            int comp = this.pieces[i].compareTo(other.pieces[j]);
            if (comp != 0) {
                return comp;
            }
            i++;
            j++;
        }
        if (i == this.end && j == other.end) {
            return 0;
        }
        if (i == this.end) {
            return -1;
        }
        return 1;
    }
}

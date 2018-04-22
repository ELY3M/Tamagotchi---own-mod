package org.acra.file;

import android.support.annotation.NonNull;
import java.io.File;
import java.util.Comparator;

public final class LastModifiedComparator implements Comparator<File> {
    public int compare(@NonNull File lhs, @NonNull File rhs) {
        return (int) (lhs.lastModified() - rhs.lastModified());
    }
}

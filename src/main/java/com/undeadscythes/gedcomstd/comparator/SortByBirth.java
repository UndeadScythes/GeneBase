package com.undeadscythes.gedcomstd.comparator;

import java.util.*;

/**
 * Compare two {@link Individual}s by date of birth.
 *
 * @author UndeadScythes
 */
public final class SortByBirth implements Comparator<Individual> {
    /**
     * Younger {@link Individual}s come first.
     */
    public static final SortByBirth ASCENDING;
    /**
     * Older {@link Individual}s come first.
     */
    public static final SortByBirth DESCENDING;

    static {
        ASCENDING = new SortByBirth(true);
        DESCENDING = new SortByBirth(false);
    }

    private boolean ascending;

    private SortByBirth(final boolean ascending) {
        this.ascending = ascending;
    }

    public int compare(final Individual indi1, final Individual indi2) {
        return 0; //TODO: Implement me
    }
}

package com.undeadscythes.genebase.comparator;

import com.undeadscythes.genebase.record.*;
import java.util.*;

/**
 * Compare two {@link Individual}s by name.
 *
 * @author UndeadScythes
 */
public class SortByName implements Comparator<Individual> {
    /**
     * Alphabetical.
     */
    public static final SortByName ASCENDING;
    /**
     * Reverse alphabetical.
     */
    public static final SortByName DESCENDING;

    static {
        ASCENDING = new SortByName(true);
        DESCENDING = new SortByName(false);
    }

    private final boolean ascending;

    private SortByName(final boolean ascending) {
        this.ascending = ascending;
    }

    public int compare(final Individual indi1, final Individual indi2) {
        return 0; //TODO: Implement me
    }
}

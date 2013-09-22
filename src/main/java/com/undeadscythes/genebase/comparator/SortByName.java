package com.undeadscythes.genebase.comparator;

import com.undeadscythes.genebase.record.*;
import java.util.*;

/**
 * Compare two {@link Individual}s by name.
 *
 * @author UndeadScythes
 */
public final class SortByName implements Comparator<Individual> {
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
        final String family1 = indi1.getFamilyName();
        final String family2 = indi2.getFamilyName();
        if (!family1.equals(family2)) return ascending ? family1.compareTo(family2) : family2.compareTo(family1);
        final String given1 = indi1.getGivenName();
        final String given2 = indi2.getGivenName();
        return ascending ? given1.compareTo(given2) : given2.compareTo(given1);
    }
}

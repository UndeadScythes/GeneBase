package com.undeadscythes.genebase.comparator;

import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.record.*;
import com.undeadscythes.genebase.structure.*;
import com.undeadscythes.metaturtle.exception.*;
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

    private final boolean ascending;

    private SortByBirth(final boolean ascending) {
        this.ascending = ascending;
    }

    public int compare(final Individual indi1, final Individual indi2) {
        final Event birth1;
        final Event birth2;
        try {
            birth1 = (Event)indi1.getFirst(GEDTag.BIRT);
        } catch (NoMetadataSetException ex) {
            return ascending ? -1 : 1;
        }
        try {
            birth2 = (Event)indi1.getFirst(GEDTag.BIRT);
        } catch (NoMetadataSetException ex) {
            return ascending ? 1 : -1;
        }
        return ascending ? SortByDate.INCREASING.compare(birth1, birth2) : SortByDate.DECREASING.compare(birth1, birth2);
    }

    /**
     * Sort a list using this {@link SortByName}.
     */
    public void sort(final List<Individual> coll) {
        Collections.sort(coll, this);
    }
}

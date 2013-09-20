package com.undeadscythes.genebase.comparator;

import com.undeadscythes.genebase.structure.*;
import com.undeadscythes.metaturtle.*;
import java.util.*;

/**
 * Compare two {@link Event}s by date.
 *
 * @author UndeadScythes
 */
public final class SortByDate implements Comparator<Metadata> {
    /**
     * Earliest {@link Event}s come first.
     */
    public static final SortByDate INCREASING;
    /**
     * Oldest {@link Event}s come first.
     */
    public static final SortByDate DECREASING;

    static {
        INCREASING = new SortByDate(true);
        DECREASING = new SortByDate(false);
    }

    private final boolean increasing;

    private SortByDate(final boolean increasing) {
        this.increasing = increasing;
        //TODO: Implement me
    }

    public int compare(final Metadata data1, final Metadata data2) {
        return 0; //TODO: Implement me
    }
}

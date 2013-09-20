package com.undeadscythes.genebase.comparator;

import com.undeadscythes.genebase.structure.*;
import java.util.*;

/**
 * Compare two {@link Event}s by date.
 *
 * @author UndeadScythes
 */
public final class SortByDate implements Comparator<Event> {
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

    public int compare(final Event date1, final Event date2) {
        return 0; //TODO: Implement me
    }
}

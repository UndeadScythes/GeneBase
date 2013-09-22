package com.undeadscythes.genebase.comparator;

import com.undeadscythes.genebase.structure.Date;
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

    /**
     * @see Comparable#compareTo(Object) Comparable.compareTo(Date)
     */
    public static int compare(final Date date1, final Date date2) {
        if (date1.year != date2.year) return date1.year - date2.year;
        if (date1.month != date2.month) return date1.month - date2.month;
        if (date1.quarter != date2.quarter) return date1.quarter - date2.quarter;
        if (date1.day != date2.day) return date1.day - date2.day;
        return 0;
    }

    private final boolean increasing;

    private SortByDate(final boolean increasing) {
        this.increasing = increasing;
    }

    public int compare(final Event event1, final Event event2) {
        final Date date1 = event1.getDate();
        final Date date2 = event2.getDate();
        return increasing ? compare(date1, date2) : compare(date2, date1);
    }
}

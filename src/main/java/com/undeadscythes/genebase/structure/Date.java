package com.undeadscythes.genebase.structure;

import com.undeadscythes.genebase.comparator.*;
import com.undeadscythes.genebase.structure.Date;
import static java.lang.String.*;
import java.util.*;

/**
 * This class offers some handy tools for manipulating dates in a way that can
 * be translated in the {@link com.undeadscythes.genebase.gedcom.GEDCOM} form.
 *
 * @author UndeadScythes
 */
public class Date {
    private static final List<String> MONTHS = new ArrayList<String>(12);

    static {
        MONTHS.add("JANUARY");
        MONTHS.add("FEBRUARY");
        MONTHS.add("MARCH");
        MONTHS.add("APRIL");
        MONTHS.add("MAY");
        MONTHS.add("JUNE");
        MONTHS.add("JULY");
        MONTHS.add("AUGUST");
        MONTHS.add("SEPTEMBER");
        MONTHS.add("OCTOBER");
        MONTHS.add("NOVEMBER");
        MONTHS.add("DECEMBER");
    }

    public final int year;
    public final int quarter;
    public final int month;
    public final int day;

    /**
     * Create an exact {@link Date} with the given properties.
     */
    public Date(final int day, final int month, final int year) {
        this.year = year;
        this.quarter = (month - 1) / 3 + 1;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return valueOf((day < 10 ? "0" + day : valueOf(day)) + " " + MONTHS.get(month - 1).substring(0, 2) + " " + year);
    }

    /**
     * Compare this {@link Date} to another, defaults to
     * {@link com.undeadscythes.genebase.comparator.SortByDate#INCREASING INCREASING}.
     */
    public int compareTo(final Date date) {
        return SortByDate.compare(this, date);
    }
}

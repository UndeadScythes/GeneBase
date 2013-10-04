package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.gedform.exception.ParsingException;
import com.undeadscythes.genebase.comparator.SortByDate;
import com.undeadscythes.genebase.gedcom.GEDTag;
import com.undeadscythes.genebase.holder.Holder;
import com.undeadscythes.genebase.specific.DateAccuracy;
import static com.undeadscythes.genebase.specific.DateAccuracy.*;
import com.undeadscythes.genebase.specific.Month;

/**
 * This class offers some handy tools for manipulating dates in a way that can
 * be translated in the {@link com.undeadscythes.genebase.gedcom.GEDCOM} form.
 *
 * @author UndeadScythes
 */
public class Date extends Holder {
    private static final long serialVersionUID = 1L;
    private final static String YEAR_DATE = "[0-9]{3,4}";
    private final static String MONTH_DATE = "[a-zA-Z]{3,9} " + YEAR_DATE;
    private final static String FULL_DATE = "[0-9]{1,2} " + MONTH_DATE;
    private final static String GED_DATE = "(" + FULL_DATE + "|" + MONTH_DATE + "|" + YEAR_DATE + ")";

    /**
     * Contains only the string 'Unknown'.
     */
    public static final Date UNKNOWN = new Date("Unknown");

    /**
     * Parse a {@link Date} from the head of the given {@link String}.
     */
    @SuppressWarnings("fallthrough")
    public static Date parseDate(final Cluster cluster) {
        final String value = cluster.pullHead().value.toUpperCase();
        final String[] split = value.split(" ");
        Date date = new Date(value);
        try {
            final DateAccuracy acc = DateAccuracy.getByName(split[0]);
            switch (acc) {
                case BET:
                    try {
                        date = parsePair(acc, value.replace(split[0] + " ", ""));
                        break;
                    } catch (ParsingException ex) {}
                case FROM:
                    try {
                        date = parsePair(acc, value.replace(split[0] + " ", ""));
                        break;
                    } catch (ParsingException ex) {}
                default:
                    final Date temp = parseDate(Cluster.topLevel(value.replace(split[0] + " ", "")));
                    if (temp.accuracy.equals(DateAccuracy.PHRASE)) break;
                    date = new Date(temp, acc);
                    break;
            }
        } catch (ParsingException ex) {
            if (value.matches(FULL_DATE)) {
                try {
                    date = new Date(Integer.parseInt(split[0]), Month.getMonth(split[1]), Integer.parseInt(split[2]));
                } catch (ParsingException ex2) {}
            } else if(value.matches(MONTH_DATE)) {
                try {
                    date = new Date(0, Month.getMonth(split[0]), Integer.parseInt(split[1]));
                } catch (ParsingException ex2) {}
            } else if(value.matches(YEAR_DATE)) {
                date = new Date(0, Month.UNK, Integer.parseInt(value));
            }
        }
        load(date, cluster.pullCluster());
        return date;
    }

    private static Date parsePair(final DateAccuracy acc, final String value) throws ParsingException {
        final String glue;
        if (acc.equals(DateAccuracy.BET)) {
            glue = " AND ";
        } else {
            glue = " TO ";
        }
        if (value.contains(glue)) {
            final String[] pair = value.split(glue);
            return new Date(parseDate(Cluster.topLevel(pair[0])), parseDate(Cluster.topLevel(pair[1])), acc);
        }
        throw new ParsingException("");
    }

    public final int year;
    public final int quarter;
    public final Month month;
    public final int day;
    public final DateAccuracy accuracy;
    /**
     * If a valid month cannot be parsed then the value is stored here.
     */
    public final String phrase;
    /**
     * If this date represents a range the later value is stored here.
     */
    public final Date secondary;

    /**
     * Create an exact {@link Date} with the given properties.
     */
    public Date(final int day, final Month month, final int year) {
        super(GEDTag.DATE);
        this.year = year;
        this.quarter = ((month.ordinal() % 12) - 1) / 3 + 1;
        this.month = month;
        this.day = day;
        this.accuracy = DateAccuracy.EXACT;
        phrase = "";
        secondary = null;
    }

    /**
     * Create an approximate {@link Date} with the given properties.
     */
    public Date(final Date date, final DateAccuracy acc) {
        super(GEDTag.DATE);
        this.year = date.year;
        this.quarter = ((date.month.ordinal() % 12) - 1) / 3 + 1;
        this.month = date.month;
        this.day = date.day;
        this.accuracy = acc;
        phrase = "";
        secondary = null;
    }

    /**
     * Create an ranged {@link Date} with the given properties.
     */
    public Date(final Date date1, final Date date2, final DateAccuracy acc) {
        super(GEDTag.DATE);
        this.year = date1.year;
        this.quarter = ((date1.month.ordinal() % 12) - 1) / 3 + 1;
        this.month = date1.month;
        this.day = date1.day;
        this.accuracy = acc;
        phrase = "";
        secondary = date2;
    }

    /**
     * Create a fallback {@link Date}.
     */
    public Date(final String fallback) {
        super(GEDTag.DATE);
        this.year = 0;
        this.quarter = 0;
        this.month = Month.UNK;
        this.day = 0;
        this.phrase = fallback;
        this.accuracy = DateAccuracy.PHRASE;
        secondary = null;
    }

    @Override
    public String getValue() {
        if (accuracy.equals(DateAccuracy.PHRASE)) return "(" + phrase + ")";
        final String dayString = day > 0 ? (day < 10 ? "0" + day : String.valueOf(day)) + " " : "";
        final String accString = accuracy.equals(DateAccuracy.EXACT) ? "" : accuracy.name() + " ";
        final String monthString = !month.equals(Month.UNK) || day > 0 ? month.getShort() + " " : "";
        final String secondDate;
        final String glue;
        if (secondary != null) {
            if (accuracy.equals(DateAccuracy.BET)) {
                glue = " AND ";
            } else {
                glue = " TO ";
            }
            secondDate = secondary.getValue();
        } else {
            glue = "";
            secondDate = "";
        }
        return accString + dayString + monthString + fattenYear(year) + glue + secondDate;
    }

    private String fattenYear(final int year) {
        String string = String.valueOf(year);
        while (string.length() < 3) {
            string = "0" + string;
        }
        return string;
    }

    /**
     * Compare this {@link Date} to another, defaults to
     * {@link com.undeadscythes.genebase.comparator.SortByDate#INCREASING INCREASING}.
     */
    public int compareTo(final Date date) {
        return SortByDate.compare(this, date);
    }

    @Override
    public String toString() {
        return getValue();
    }
}

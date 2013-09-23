package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.comparator.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.holder.*;
import com.undeadscythes.genebase.structure.Date;
import com.undeadscythes.metaturtle.metadata.*;
import java.util.*;

/**
 * An {@link Event} is a property that has both a time and place.
 *
 * @author UndeadScythes
 */
public class Event extends Holder {
    private static final long serialVersionUID = 1L;

    public static final List<Property> EVENT_TAGS = new ArrayList<Property>(Arrays.asList(GEDTag.BIRT, GEDTag.EVEN));

    private Date date;
    private Place place;
    private GEDTag type;

    /**
     * Create an {@link Event} with a given {@link Cluster}.
     */
    public Event(final Cluster cluster) {
        super(cluster); //TODO: Implement me
    }

    /**
     * Set the {@link Date} this event occurred.
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * Get the type of this {@link Event}.
     */
    public void setTag(final GEDTag type) {
        this.type = type;
    }

    /**
     * Get the {@link Date} this event occurred.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Compare this {@link Event} to another {@link Event} by {@link Date},
     * defaults to
     * {@link com.undeadscythes.genebase.comparator.SortByDate#INCREASING INCREASING}.
     */
    public int compareTo(final Event event) {
        return SortByDate.INCREASING.compare(this, event);
    }

    /**
     * Get the {@link Place} this event took place.
     */
    public Place getPlace() {
        return place;
    }
}

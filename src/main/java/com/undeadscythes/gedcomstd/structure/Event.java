package com.undeadscythes.gedcomstd.structure;

import com.undeadscythes.gedcomstd.*;
import com.undeadscythes.gedcomstd.meta.*;

/**
 * An {@link Event} is a property that has both a time and place.
 *
 * @author UndeadScythes
 */
public class Event extends Holder {
    /**
     * Create an {@link Event} with a given {@link String}.
     */
    public Event(final String string) {
        super("", ""); //TODO: Implement me
    }

    /**
     * Set the {@link Date} this event occurred.
     */
    public void setDate(final Date date) {
        //TODO: Implement me
    }

    /**
     * Get the type of this {@link Event}.
     */
    public void setTag(final GEDTag type) {
        //TODO: Implement me
    }

    /**
     * Get the {@link Date} this event occurred.
     */
    public Date getDate() {
        //TODO: Implement me
        return new Date(0, 0, 0);
    }

    /**
     * Compare this {@link Event} to another {@link Event} by {@link Date},
     * defaults to
     * {@link com.undeadscythes.gedcomstd.comparator.SortByDate#INCREASING INCREASING}.
     */
    public int compareTo(final Comparable<Event> event) {
        return 0; //TODO: Implement me
    }

    /**
     * Get the {@link Place} this event took place.
     */
    public Place getPlace() {
        return new Place(); //TODO: Implement me
    }
}

package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.comparator.SortByDate;
import com.undeadscythes.genebase.gedcom.GEDTag;
import com.undeadscythes.genebase.gedcom.NamedTag;
import com.undeadscythes.genebase.holder.Holder;
import com.undeadscythes.metaturtle.exception.NoMetadataSetException;

/**
 * An {@link Event} is a property that has both a time and place.
 *
 * @author UndeadScythes
 */
public class Event extends Holder {
    private static final long serialVersionUID = 1L;

    private Date date;
    private Place place;
    private NamedTag type;

    public Event(final Cluster cluster) {
        super(cluster);
        this.type = GEDTag.getByName(cluster.getTag());
        cluster.reset();
        while (cluster.hasNext()) {
            final Cluster next = cluster.pullCluster();
            if (GEDTag.DATE.equals(next.getTag())) {
                date = Date.parseDate(next);
            } else if (GEDTag.PLAC.equals(next.getTag())) {
                place = new Place(next);
            }
        }
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
    public Date getDate() throws NoMetadataSetException {
        if (date == null) throw new NoMetadataSetException("DATE");
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

    public Place getPlace() throws NoMetadataSetException {
        if (date == null) throw new NoMetadataSetException("PLAC");
        return place;
    }

    @Override
    public String toString() {
        String date = "";
        String place = "";
        try {
            date = getDate().toString();
        } catch (NoMetadataSetException ex) {}
        try {
            place = getPlace().toString();
        } catch (NoMetadataSetException ex) {}
        return !date.isEmpty() && !place.isEmpty() ? date + " in " + place : date + place;
    }
}

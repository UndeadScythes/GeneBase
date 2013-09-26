package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.comparator.SortByDate;
import com.undeadscythes.genebase.gedcom.GEDTag;
import com.undeadscythes.genebase.gedcom.NamedTag;
import com.undeadscythes.genebase.holder.Holder;
import com.undeadscythes.metaturtle.exception.NoMetadataSetException;
import com.undeadscythes.metaturtle.metadata.Property;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An {@link Event} is a property that has both a time and place.
 *
 * @author UndeadScythes
 */
public class Event extends Holder {
    private static final long serialVersionUID = 1L;

    public static final List<Property> EVENT_TAGS = new ArrayList<Property>(Arrays.asList(
            GEDTag.BIRT,
            GEDTag.DEAT,
            GEDTag.EVEN,
            GEDTag.RESI));

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

    /**
     * Get the {@link Place} this event took place.
     */
    public Place getPlace() {
        return place;
    }
}

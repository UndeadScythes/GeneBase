package com.undeadscythes.gedcomstd.record;

import com.undeadscythes.gedcomstd.gedcom.GEDTag;
import com.undeadscythes.gedform.*;

/**
 * A submitter is a record of an individual who has made a contribution to this
 * GEDCOM.
 *
 * @author UndeadScythes
 */
public class Submitter extends UniqueHolder {
    private static final long serialVersionUID = 2L;

    /**
     * Load this {@link Submitter} with the data in the given {@link Cluster}.
     */
    public Submitter(final Cluster cluster) {
        super(GEDTag.SUBM, cluster);
    }
}

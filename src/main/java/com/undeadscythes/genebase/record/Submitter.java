package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.meta.*;

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

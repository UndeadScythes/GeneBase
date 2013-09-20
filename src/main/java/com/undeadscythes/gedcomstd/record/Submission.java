package com.undeadscythes.gedcomstd.record;

import com.undeadscythes.gedcomstd.*;
import com.undeadscythes.gedcomstd.meta.*;
import com.undeadscythes.gedform.*;

/**
 * A {@link Submission} provides information about what this
 * {@link Transmission} is trying to convey to a receiving system.
 *
 * @author UndeadScythes
 */
public class Submission extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Submission} with the data in the given {@link Cluster}.
     */
    public Submission(final Cluster cluster) {
        super(GEDTag.SUBN, cluster);
    }
}

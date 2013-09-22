package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.holder.*;

/**
 * A physical location.
 *
 * @author UndeadScythes
 */
public class Place extends Holder {
    private static final long serialVersionUID = 1L;

    /**
     * Create an {@link Place} with a given {@link Cluster}.
     */
    public Place(final Cluster cluster) {
        super(cluster);
    }
}

package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.meta.*;

/**
 * The header contains information about the GEDCOM transmission.
 *
 * @author UndeadScythes
 */
public class Header extends Holder {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Header} with the data in the given {@link Cluster}.
     */
    public Header(final Cluster cluster) {
        super(cluster.pullHead(), cluster);
    }
}

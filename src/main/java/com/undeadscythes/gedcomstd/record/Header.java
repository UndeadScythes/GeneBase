package com.undeadscythes.gedcomstd.record;

import com.undeadscythes.gedcomstd.meta.*;
import com.undeadscythes.gedform.*;

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
        super(cluster.popHead(), cluster);
    }
}

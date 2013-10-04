package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.holder.Holder;

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

    @Override
    public String toString() {
        return getValue();
    }
}

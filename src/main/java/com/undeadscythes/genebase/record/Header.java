package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.gedcom.GEDTag.Tag;
import com.undeadscythes.genebase.holder.Holder;

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
        super(Tag.HEAD, cluster);
    }

    @Override
    public String getFriendly() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO: Implement me
    }
}

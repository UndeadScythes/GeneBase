package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.gedcom.GEDTag;
import com.undeadscythes.genebase.gedcom.NamedTag;
import com.undeadscythes.genebase.holder.Holder;

/**
 * @author UndeadScythes
 */
public class Fact extends Holder {
    private static final long serialVersionUID = 1L;

    /**
     * Construct a generic {@link Fact}.
     */
    public Fact(final Cluster cluster) {
        super(GEDTag.getByName(cluster.getTag()), cluster);
    }

    /**
     * Construct a generic {@link Fact}.
     */
    public Fact(final NamedTag tag, final Cluster cluster) {
        super(tag, cluster);
    }

    /**
     * Construct a generic {@link Fact}.
     */
    public Fact(final NamedTag tag, final String string) {
        super(tag, string);
    }

    @Override
    public String getFriendly() {
        return getValue();
    }
}

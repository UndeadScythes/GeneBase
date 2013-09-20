package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.meta.*;

/**
 * A {@link Source} is an object that provides evidence for a property of
 * another entity.
 *
 * @author UndeadScythes
 */
public class Source extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    private final Repository repository;

    /**
     * Load the {@link Source} with the data in the given {@link Cluster}.
     */
    public Source(final Cluster cluster) {
        super(GEDTag.SOUR, cluster);
        repository = null; //TODO: Implement me
    }
}

package com.undeadscythes.gedcomstd.record;

import com.undeadscythes.gedcomstd.*;
import com.undeadscythes.gedcomstd.meta.*;
import com.undeadscythes.gedform.*;

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

package com.undeadscythes.gedcomstd.record;

import com.undeadscythes.gedcomstd.*;
import com.undeadscythes.gedcomstd.meta.*;
import com.undeadscythes.gedform.*;

/**
 * A {@link Note} is a brief description about an entity by the author.
 *
 * @author UndeadScythes
 */
public class Note extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Note} with the data from the given {@link Cluster}.
     */
    public Note(final Cluster cluster) {
        super(GEDTag.NOTE, cluster);
    }
}
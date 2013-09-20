package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.meta.*;

/**
 * Multimedia covers a wide variety of encoded embedded objects.
 *
 * @author UndeadScythes
 */
public class Multimedia extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Multimedia} with the data in the given {@link Cluster}.
     */
    public Multimedia(final Cluster cluster) {
        super(GEDTag.OBJE, cluster);
    }
}

package com.undeadscythes.gedcomstd.record;

import com.undeadscythes.gedcomstd.gedcom.GEDTag;
import com.undeadscythes.gedform.*;

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

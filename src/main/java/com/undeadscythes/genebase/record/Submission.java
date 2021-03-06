package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.holder.*;

/**
 * A {@link Submission} provides information about what this
 * {@link Transmission} is trying to convey to a receiving system.
 *
 * @author UndeadScythes
 */
public class Submission extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Submission} with the data in the given {@link Cluster}.
     */
    public Submission(final Cluster cluster) {
        super(RecordType.SUBN, cluster);
    }
}

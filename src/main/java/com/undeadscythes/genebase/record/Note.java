package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.holder.*;

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
        super(RecordType.NOTE, cluster);
    }
}

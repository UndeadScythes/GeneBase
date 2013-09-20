package com.undeadscythes.gedcomstd.meta;

import com.undeadscythes.gedcomstd.*;
import com.undeadscythes.gedform.*;
import com.undeadscythes.metaturtle.*;
import com.undeadscythes.tipscript.*;

/**
 * A convenience wrapper of the {@link UniqueMeta} class.
 *
 * @author UndeadScythes
 */
public class UniqueHolder extends UniqueMeta<String> {
    private static final long serialVersionUID = 1L;

    /**
     * @see UniqueHolder#UniqueHolder(MetaType, UID)
     */
    public UniqueHolder(final GEDTag type, final String uid) {
        super(type, uid);
    }

    /**
     * Load a {@link UniqueHolder} from a {@link Cluster}.
     */
    public UniqueHolder(final GEDTag tag, final Cluster cluster) {
        this(tag, cluster.pullHead().xref);
    }

    /**
     * Output the contents of this {@link UniqueHolder} to the given
     * {@link TipScript} file.
     */
    public String dump(final TipScript out, final String prefix) {
        return ""; //TODO: Implement me
    }
}

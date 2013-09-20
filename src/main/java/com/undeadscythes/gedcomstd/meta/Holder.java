package com.undeadscythes.gedcomstd.meta;

import com.undeadscythes.gedform.*;
import com.undeadscythes.metaturtle.*;

/**
 * A convenience wrapper of the {@link Metadata} class.
 *
 * @author UndeadScythes
 */
public class Holder extends Metadata {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Holder} with the data in the given {@link Cluster}.
     */
    public Holder(final LineStruct line, final Cluster cluster) {
        this(line.tag, line.value);
    }

    /**
     * @see Metadata#Metadata(String, String)
     */
    public Holder(final String property, final String value) {
        super(property, value);
    }
}

package com.undeadscythes.genebase.holder;

import com.undeadscythes.gedform.*;
import com.undeadscythes.metaturtle.metadata.*;
import com.undeadscythes.tipscript.*;

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
    public Holder(final Cluster cluster) {
        this(cluster.pullHead().tag, cluster.pullHead().value);
        //TODO: Load cluster
    }

    /**
     * @see Metadata#Metadata(String, String)
     */
    public Holder(final String property, final String value) {
        super(property, value);
    }

    /**
     * Output the contents of this {@link Holder} to the given
     * {@link TipScript} file.
     */
    public void dump(final TipScript out, final String prefix) {
        out.printf(prefix + getProperty() + ": " + getValue());
        for (Metadata data : this) {
            ((Holder)data).dump(out, "  " + prefix);
        }
    }
}

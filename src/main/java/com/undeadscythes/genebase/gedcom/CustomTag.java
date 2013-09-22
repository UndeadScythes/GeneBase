package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.metaturtle.metadata.*;

/**
 * A custom {@link com.undeadscythes.genebase.gedcom.GEDTag}.
 *
 * @author UndeadScythes
 */
public class CustomTag implements Property {
    /**
     * The actual representation of this custom
     * {@link com.undeadscythes.genebase.gedcom.GEDTag}.
     */
    public final String tag;
    /**
     * The formal representation of this tag.
     */
    public final String formal;

    /**
     * Create a custom tag with the {@link String} specified.
     */
    public CustomTag(final String tag) {
        this(tag, tag.toUpperCase().charAt(0) + tag.substring(1).toLowerCase());
    }

    /**
     * Create a custom tag with the {@link String} specified and the given
     * formal name.
     */
    public CustomTag(final String tag, final String formal) {
        this.tag = tag.toUpperCase();
        this.formal = formal;
    }

    public boolean equals(final String string) {
        return string.equals(tag);
    }

    public String getString() {
        return tag;
    }
}

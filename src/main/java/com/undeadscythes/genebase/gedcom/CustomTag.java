package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.metaturtle.metadata.Property;

/**
 * A custom {@link com.undeadscythes.genebase.gedcom.GEDTag}.
 *
 * @author UndeadScythes
 */
public class CustomTag implements NamedTag {
    private final String tag;
    private final String formal;

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

    @Override
    public boolean equals(final String string) {
        return string.equals(tag);
    }

    @Override
    public String getString() {
        return tag;
    }

    @Override
    public String getFormal() {
        return formal;
    }

    @Override
    public boolean equals(final Property property) {
        return tag.equals(property.getString());
    }
}

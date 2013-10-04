package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.genebase.gedcom.GEDTag.TagType;
import com.undeadscythes.genebase.holder.Holder;
import com.undeadscythes.genebase.structure.Fact;

/**
 * A custom {@link com.undeadscythes.genebase.gedcom.GEDTag}.
 *
 * @author UndeadScythes
 */
public class CustomTag extends NamedTag {
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
    public String getFormal() {
        return formal;
    }

    @Override
    public TagType getType() {
        return TagType.CUSTOM;
    }

    @Override
    protected int propertyHash() {
        return tag.hashCode();
    }

    @Override
    protected String propertyString() {
        return tag;
    }

    @Override
    public Class<? extends Holder> getStructure() {
        return Fact.class;
    }
}

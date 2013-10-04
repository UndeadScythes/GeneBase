package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.genebase.gedcom.GEDTag.TagType;
import com.undeadscythes.metaturtle.metadata.Property;

/**
 * A tag with a specific name.
 *
 * @author UndeadScythes
 */
public abstract class NamedTag extends Property {
    /**
     * Get the formal name of this {@link NamedTag}.
     */
    public abstract String getFormal();

    /**
     * Get the type of this NamedTag.
     */
    public abstract TagType getType();

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean propertyEquals(final Object obj) {
        if (obj instanceof String) return ((String)obj).equals(toString());
        if (obj instanceof Property) return ((Property)obj).toString().equals(toString());
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected abstract int propertyHash();

    /**
     * {@inheritDoc}
     */
    @Override
    protected abstract String propertyString();
}

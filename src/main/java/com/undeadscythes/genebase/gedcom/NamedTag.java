package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.genebase.gedcom.GEDTag.TagType;
import com.undeadscythes.metaturtle.metadata.Property;

/**
 * A tag with a specific name.
 *
 * @author UndeadScythes
 */
public interface NamedTag extends Property {
    /**
     * Get the formal name of this {@link NamedTag}.
     */
    String getFormal();

    /**
     * Get the type of this NamedTag.
     */
    TagType getType();
}

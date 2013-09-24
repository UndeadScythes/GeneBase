package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.metaturtle.metadata.*;

/**
 * @author UndeadScythes
 */
public interface NamedTag extends Property {
    /**
     * Get the formal name of this {@link NamedTag}.
     */
    String getFormal();
}

package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.genebase.exception.*;
import com.undeadscythes.metaturtle.unique.*;

/**
 * Types of unique top level record that have a specific sub-structure.
 *
 * @author UndeadScythes
 */
public enum RecordType implements MetaType {
    FAM("Family"),
    HEAD("Header"),
    INDI("Individual"),
    NOTE("Note"),
    OBJE("Object"),
    REPO("Repository"),
    SOUR("Source"),
    SUBM("Submitter"),
    SUBN("Submission"),
    TRLR("Trailer");

    /**
     * The formal name of this {@link RecordType}.
     */
    public final String formal;

    private RecordType(final String formal) {
        this.formal = formal;
    }

    /**
     * Get the actual name of this {@link RecordType}.
     */
    public String getName() {
        return name();
    }

    /**
     * Get a {@link RecordType} with a matching name.
     */
    public static RecordType getByName(final String name) {
        for (RecordType type : values()) {
            if (type.getName().equals(name)) return type;
        }
        throw new NoValidTypeException(name);
    }
}

package com.undeadscythes.genebase.specific;

/**
 * The gender of an {@link Individual}.
 *
 * @author UndeadScythes
 */
public enum Gender {
    MALE,
    FEMALE,
    UNKNOWN;

    /**
     * Get a gender from the value stored in a {@link GEDCOM}.
     */
    public static Gender getByName(final String string) {
        if ("M".equals(string)) return MALE;
        if ("F".equals(string)) return FEMALE;
        return UNKNOWN;
    }
}

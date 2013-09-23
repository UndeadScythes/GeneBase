package com.undeadscythes.genebase.specific;

import com.undeadscythes.gedform.exception.*;

/**
 * Describes the accuracy or range of a date value.
 *
 * @author UndeadScythes
 */
public enum DateAccuracy {
    ABT,
    CAL,
    EST,
    BEF,
    AFT,
    BET,
    FROM,
    TO,
    EXACT,
    PHRASE;

    /**
     * Get an accuracy value by name.
     */
    public static DateAccuracy getByName(final String name) throws ParsingException {
        for (DateAccuracy acc : values()) {
            if(acc.name().equals(name.toUpperCase())) return acc;
        }
        throw new ParsingException(name);
    }
}

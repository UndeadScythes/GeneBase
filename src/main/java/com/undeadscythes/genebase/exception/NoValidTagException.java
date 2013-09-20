package com.undeadscythes.genebase.exception;

/**
 * Thrown when no valid {@link com.undeadscythes.gedcomstd.GEDTag} can be found for a given string.
 *
 * @author UndeadScythes
 */
public class NoValidTagException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * The tag that could not be found.
     */
    public final String tag;

    /**
     * Pass the name of the tag that could not be found.
     */
    public NoValidTagException(final String tag) {
        super("No valid type found with the tag " + tag + ".");
        this.tag = tag;
    }
}

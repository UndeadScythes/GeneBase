package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.gedform.Transmission;
import com.undeadscythes.gedform.exception.ParsingException;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * The {@link GEDCOM} implements the {@link Transmission}.
 *
 * @author UndeadScythes
 */
public class GEDCOM extends Transmission {
    private static final long serialVersionUID = 1L;

    private final File file;

    /**
     * Create an empty {@link GEDCOM}.
     */
    public GEDCOM() {
        super(0);
        file = new File("");
    }

    /**
     * Parse a {@link File} into this {@link GEDCOM}.
     */
    public GEDCOM(final String path) throws ParsingException {
        super(new File(path));
        file = new File(path);
    }

    /**
     * Parse a {@link File} with a given encoding into this {@link GEDCOM}.
     */
    public GEDCOM(final String path, final String encoding) throws ParsingException, UnsupportedEncodingException {
        super(new File(path), encoding);
        file = new File(path);
    }

    /**
     * Get the {@link File} this {@link GEDCOM} was loaded from.
     */
    public File getFile() {
        return file;
    }

    /**
     * Convenience method to get the {@link File#getName() file name} of the
     * {@link File} used to load this {@link GEDCOM}.
     */
    public String getFileName() {
        return file.getName();
    }
}

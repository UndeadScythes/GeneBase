package com.undeadscythes.gedcomstd.gedcom;

import com.undeadscythes.gedform.*;
import com.undeadscythes.gedform.exception.*;
import java.io.*;

/**
 * The {@link GEDCOM} implements the {@link Transmission}.
 *
 * @author UndeadScythes
 */
public class GEDCOM extends Transmission {
    private static final long serialVersionUID = 1L;

    private final File file;

    /**
     * Parse a file into this GEDCOM.
     */
    public GEDCOM(final String path) throws ParsingException {
        super(0);
        file = new File(path);
        addAll(parse(file));
    }

    /**
     * Get the file this GEDCOM was loaded from.
     */
    public File getFile() {
        return file;
    }

    /**
     * Convenience method to get the file name of the file used to load this
     * GEDCOM.
     */
    public String getFileName() {
        return file.getName();
    }
}

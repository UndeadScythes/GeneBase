package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.gedform.exception.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.holder.*;
import static java.util.Collections.*;
import java.util.*;

/**
 * An individual contains information and events relating to itself.
 *
 * @author UndeadScythes
 */
public class Individual extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    /**
     * A preset {@link Individual} that represents an unknown person.
     */
    public static final Individual UNKNOWN;

    static {
        final Cluster cluster = new Cluster(2);
        try {
            cluster.add(new LineStruct("0 @@ INDI"));
            cluster.add(new LineStruct("1 NAME Unknown"));
        } catch (ParsingException ex) {}
        UNKNOWN = new Individual(cluster);
    }

    private final List<Family> families = new ArrayList<Family>(0);

    /**
     * Load this {@link Individual} with the data in the given {@link Cluster}.
     */
    public Individual(final Cluster cluster) {
        super(RecordType.INDI, cluster);
    }

    /**
     * Get an immutable list of {@link Family}s this {@link Individual} is
     * associated with.
     */
    public List<Family> getFamilies() {
        return unmodifiableList(families);
    }

    /**
     * Get the family name of this {@link Individual}.
     */
    public String getFamilyName() {
        return ""; //TODO: Implement me
    }

    /**
     * Get the given name(s) of this {@link Individual}.
     */
    public String getGivenName() {
        return ""; //TODO: Implement me
    }

    /**
     *Get the full name of this {@link Individual}.
     */
    public String getFullName() {
        final String given = getGivenName();
        final String family = getFamilyName();
        return (given.isEmpty() ? "?" : given) + (family.isEmpty() ? "" : " " + getFamilyName());
    }
}

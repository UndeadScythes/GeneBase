package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.*;
import com.undeadscythes.gedform.exception.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.meta.*;
import com.undeadscythes.metaturtle.*;
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
            cluster.add(new LineStruct("1 NAME /Unknown/"));
        } catch (ParsingException ex) {}
        UNKNOWN = new Individual(cluster);
    }

    private final Map<String, Family> families;

    /**
     * Load this {@link Individual} with the data in the given {@link Cluster}.
     */
    public Individual(final Cluster cluster) {
        super(GEDTag.INDI, cluster);
        families = new HashMap<String, Family>(0);
    }

    /**
     * Get a list of {@link Family}s this {@link Individual} is associated
     * with.
     */
    public Collection<Family> getFamilies() {
        return families.values();
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
        return ""; //TODO: Implement me
    }

    /**
     * Get a sorted list of {@link Metadata} with a property equals to the given
     * {@link GEDTag}.
     */
    public List<Metadata> getData(final GEDTag tag, final Comparator<Metadata> comp) {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (data.equals(tag.getTag())) matches.add(data);
        }
        Collections.sort(matches, comp);
        return matches;
    }
}

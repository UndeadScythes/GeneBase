package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.gedform.LineStruct;
import com.undeadscythes.gedform.exception.ParsingException;
import com.undeadscythes.genebase.gedcom.GEDTag.Tag;
import com.undeadscythes.genebase.gedcom.RecordType;
import com.undeadscythes.genebase.holder.UniqueHolder;
import com.undeadscythes.genebase.specific.Gender;
import com.undeadscythes.genebase.specific.Relation;
import com.undeadscythes.genebase.structure.Date;
import com.undeadscythes.genebase.structure.Event;
import com.undeadscythes.metaturtle.exception.NoMetadataSetException;
import com.undeadscythes.metaturtle.unique.UID;
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
     * Load this {@link Individual} with the data in the given {@link Cluster}.
     */
    public Individual(final UID uid) {
        super(RecordType.INDI, uid);
    }

    /**
     * Get an immutable list of {@link Family}s this {@link Individual} is
     * associated with.
     */
    public List<Family> getFamilies() {
        return Collections.unmodifiableList(families);
    }

    /**
     * Get families to which this Individual has the given relation.
     */
    public List<Family> getFamilies(final Relation relation) {
        final List<Family> matches = new ArrayList<Family>(0);
        for (Family family : families) {
            if (family.getRelation(getUID()).equals(relation)) matches.add(family);
        }
        return matches;
    }

    /**
     * Get families to which this Individual has the given relations.
     */
    public List<Family> getFamilies(final List<Relation> relations) {
        final List<Family> matches = new ArrayList<Family>(0);
        for (Family family : families) {
            if (relations.contains(family.getRelation(getUID()))) matches.add(family);
        }
        return matches;
    }

    /**
     * Convenience method to get this Individuals' spouse, returns only the
     * first match found.
     */
    public List<Individual> getSpouses() {
        final List<Individual> spouses = new ArrayList<Individual>(0);
        final List<Family> matches = getFamilies(Relation.SPOUSE);
        for (Family family : matches) {
            if (getGender().equals(Gender.MALE)) spouses.add(family.getMother());
            if (getGender().equals(Gender.FEMALE)) spouses.add(family.getFather());
        }
        return spouses;
    }

    /**
     * Convenience method to get this Individuals' father.
     */
    public Individual getFather() {
        final List<Family> matches = getFamilies(Relation.CHILD);
        if (!matches.isEmpty()) {
            return matches.get(0).getFather();
        }
        return UNKNOWN;
    }

    /**
     * Convenience method to get this Individuals' mother.
     */
    public Individual getMother() {
        final List<Family> matches = getFamilies(Relation.CHILD);
        if (!matches.isEmpty()) {
            return matches.get(0).getMother();
        }
        return UNKNOWN;
    }

    /**
     * Convenience method to get a known parent of this Individual.
     */
    public Individual getParent() {
        final List<Family> matches = getFamilies(Relation.CHILD);
        if (!matches.isEmpty()) {
            if (!matches.get(0).getMother().equals(UNKNOWN)) return matches.get(0).getMother();
            if (!matches.get(0).getFather().equals(UNKNOWN)) return matches.get(0).getFather();
        }
        return UNKNOWN;
    }

    /**
     * Convenience method to get this Individuals' children.
     */
    public List<Individual> getChildren() {
        final List<Individual> children = new ArrayList<Individual>(0);
        final List<Family> matches = getFamilies(Relation.SPOUSE);
        for (Family family : matches) {
            children.addAll(family.getChildren());
        }
        return children;
    }

    /**
     * Convenience method to get this Individuals' children with the given
     * partner.
     */
    public List<Individual> getChildren(final Individual spouse) {
        if (spouse.equals(UNKNOWN)) return getChildren();
        final List<Individual> children = new ArrayList<Individual>(0);
        final List<Family> matches = getFamilies(Relation.SPOUSE);
        for (Family family : matches) {
            if (family.hasMember(spouse.getUID())) children.addAll(family.getChildren());
        }
        return children;
    }

    /**
     * Get this Individuals siblings.
     */
    public List<Individual> getSiblings() {
        final List<Individual> siblings = new ArrayList<Individual>(0);
        final List<Family> matches = getFamilies(Relation.CHILD);
        for (Family family : matches) {
            for (Individual indi : family.getChildren()) {
                if (indi.getUID().equals(getUID())) continue;
                siblings.add(indi);
            }
        }
        return siblings;
    }

    /**
     * Get the family name of this {@link Individual}.
     */
    public String getFamilyName() {
        try {
            return getFirst(Tag.NAME.getGEDTag()).getValue().split("/")[1].trim();
        } catch (NoMetadataSetException ex) {
            return "";
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "";
        }
    }

    /**
     * Get the given name(s) of this {@link Individual}.
     */
    public String getGivenName() {
        try {
            return getFirst(Tag.NAME.getGEDTag()).getValue().split("/")[0].trim();
        } catch (NoMetadataSetException ex) {
            return "";
        }
    }

    /**
     *Get the full name of this {@link Individual}.
     */
    public String getFullName() {
        final String given = getGivenName();
        final String family = getFamilyName();
        return (given.isEmpty() ? "?" : given) + (family.isEmpty() ? "" : " " + getFamilyName());
    }

    /**
     * Get the gender of this {@link Individual}.
     */
    public Gender getGender() {
        try {
            return Gender.getByName(getFirst(Tag.SEX.getGEDTag()).getValue());
        } catch (NoMetadataSetException ex) {
            return Gender.UNKNOWN;
        }
    }

    /**
     * Get the birth date of this individual.
     */
    public Date getBirth() {
        try {
            return ((Event)getFirst(Tag.BIRT.getGEDTag())).getDate();
        } catch (NoMetadataSetException ex) {
            return Date.UNKNOWN;
        }
    }

    /**
     * Get the death date of this individual.
     */
    public Date getDeath() {
        try {
            return ((Event)getFirst(Tag.DEAT.getGEDTag())).getDate();
        } catch (NoMetadataSetException ex) {
            return Date.UNKNOWN;
        }
    }

    /**
     * Link this Individual to a given Family.
     */
    public void addFamily(final Family family) {
        families.add(family);
    }
}

package com.undeadscythes.genebase.record;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.gedcom.GEDTag;
import com.undeadscythes.genebase.gedcom.RecordType;
import com.undeadscythes.genebase.holder.UniqueHolder;
import com.undeadscythes.genebase.specific.Gender;
import com.undeadscythes.genebase.specific.Relation;
import com.undeadscythes.metaturtle.exception.NoMetadataSetException;
import com.undeadscythes.metaturtle.metadata.Metadata;
import com.undeadscythes.metaturtle.unique.UID;
import com.undeadscythes.metaturtle.unique.UniqueMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@link Family} is a collection of individuals related by parentage.
 *
 * @author UndeadScythes
 */
public class Family extends UniqueHolder {
    private static final long serialVersionUID = 1L;

    private final Map<Individual, Relation> members = new HashMap<Individual, Relation>(2);

    /**
     * Load this {@link Family} with the data contained in the given
     * {@link Cluster}.
     */
    public Family(final Cluster record) {
        super(RecordType.FAM, record);
    }

    /**
     * @see #hasMember(UID)
     */
    public boolean hasMember(final String uid) {
        return hasMember(new UID(uid));
    }

    /**
     * Get the mother of this family.
     */
    public Individual getMother() {
        for (Map.Entry<Individual, Relation> i : members.entrySet()) {
            if (i.getValue().equals(Relation.WIFE)) return i.getKey();
        }
        return Individual.UNKNOWN;
    }

    /**
     * Get the father of this family.
     */
    public Individual getFather() {
        for (Map.Entry<Individual, Relation> i : members.entrySet()) {
            if (i.getValue().equals(Relation.HUSBAND)) return i.getKey();
        }
        return Individual.UNKNOWN;
    }

    /**
     * Get the children of this family.
     */
    public List<Individual> getChildren() {
        final List<Individual> children = new ArrayList<Individual>(0);
        for (Map.Entry<Individual, Relation> i : members.entrySet()) {
            if (Relation.CHILD.contains(i.getValue())) children.add(i.getKey());
        }
        return children;
    }

    /**
     * Check if this {@link Family} contains an {@link Individual} with a given
     * {@link UID}.
     */
    public boolean hasMember(final UID uid) {
        for (Individual indi : members.keySet()) {
            if (indi.getUID().equals(uid)) return true;
        }
        return false;
    }

    /**
     * Get a user friendly printout of this {@link Family}.
     */
    public String print() {
        return ""; //TODO: Implement me
    }

    /**
     * Get the {@link Relation} the {@link Individual} with the given
     * {@link UID} has to this {@link Family}.
     */
    public Relation getRelation(final UID uid) {
        for (Map.Entry<Individual, Relation> i : members.entrySet()) {
            if (i.getKey().getUID().equals(uid)) return i.getValue();
        }
        return Relation.NONE;
    }

    /**
     * Link Families to their respective members.
     */
    public void setMembers(final Map<UID, UniqueMeta> list) {
        try {
            final Individual indi = (Individual)list.get(new UID(getFirst(GEDTag.HUSB).getValue()));
            indi.addFamily(this);
            members.put(indi, Relation.HUSBAND);
        } catch (NoMetadataSetException ex) {}
        try {
            final Individual indi = (Individual)list.get(new UID(getFirst(GEDTag.WIFE).getValue()));
            indi.addFamily(this);
            members.put(indi, Relation.WIFE);
        } catch (NoMetadataSetException ex) {}
        for (Metadata child : getList(GEDTag.CHIL)) {
            final Individual indi = (Individual)list.get(new UID(child.getValue()));
            indi.addFamily(this);
            if (indi.getGender().equals(Gender.MALE)) {
                members.put(indi, Relation.SON);
            } else if (indi.getGender().equals(Gender.FEMALE)) {
                members.put(indi, Relation.DAUGHTER);
            } else {
                members.put(indi, Relation.BUDAK);
            }
        }
    }

    /**
     * Get a parent of this family that is not UNKNOWN.
     */
    public Individual getParent() {
        if (!getFather().equals(Individual.UNKNOWN)) {
            return getFather();
        } else if (!getMother().equals(Individual.UNKNOWN)) {
            return getMother();
        } else {
            return Individual.UNKNOWN;
        }
    }
}

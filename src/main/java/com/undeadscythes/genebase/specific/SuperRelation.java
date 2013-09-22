package com.undeadscythes.genebase.specific;

import com.undeadscythes.genebase.record.*;
import java.util.*;

/**
 * @author UndeadScythes
 */
public enum SuperRelation {
    /**
     * {@link Relation#PARENT PARENT} - {@link Relation#FATHER FATHER}.
     */
    GRAND_FATHER(Relation.PARENT, Relation.FATHER),
    /**
     * {@link Relation#PARENT PARENT} - {@link Relation#MOTHER MOTHER}.
     */
    GRAND_MOTHER(Relation.PARENT, Relation.MOTHER),
    /**
     * {@link Relation#PARENT PARENT} - {@link Relation#SISTER SISTER}.
     */
    AUNT(Relation.PARENT, Relation.SISTER),
    /**
     * {@link Relation#PARENT PARENT} - {@link Relation#BROTHER BROTHER}.
     */
    UNCLE(Relation.PARENT, Relation.BROTHER),
    /**
     * {@link Relation#SIBLING SIBLING} - {@link Relation#SON SON}.
     */
    NEPHEW(Relation.SIBLING, Relation.SON),
    /**
     * {@link Relation#SIBLING SIBLING} - {@link Relation#DAUGHTER DAUGHTER}.
     */
    NIECE(Relation.SIBLING, Relation.DAUGHTER),
    /**
     * {@link Relation#PARENT PARENT} - {@link Relation#SIBLING SIBLING} - {@link Relation#CHILD CHILD}.
     */
    COUSIN(Relation.PARENT, Relation.SIBLING, Relation.CHILD),
    /**
     * {@link Relation#NONE NONE}.
     */
    NONE(Relation.NONE);

    private final List<List<Relation>> path = new ArrayList<List<Relation>>(1);

    private SuperRelation(final List<Relation> first, final Relation second) {
        path.add(first);
        final List<Relation> list = new ArrayList<Relation>(1);
        list.add(second);
        path.add(list);
    }

    private SuperRelation(final List<Relation> first, final List<Relation> second, final List<Relation> third) {
        path.add(first);
        path.add(second);
        path.add(third);
    }

    private SuperRelation(final Relation first) {
        final List<Relation> list = new ArrayList<Relation>(1);
        list.add(first);
        path.add(list);
    }

    /**
     * Get the {@link SuperRelation} between these individuals, if any.
     */
    public static SuperRelation getRelation(final Individual indi1, final Individual indi2) {
        return SuperRelation.NONE; //TODO: Implement me
    }
}

package com.undeadscythes.genebase.specific;

import java.util.*;

/**
 * The type of relationship between two {@link com.undeadscythes.genebase.record.Individual}s.
 *
 * @author UndeadScythes
 */
public enum Relation {
    MOTHER,
    FATHER,
    BROTHER,
    SISTER,
    SON,
    DAUGHTER,
    FRIEND,
    HUSBAND,
    WIFE,
    NONE;

    /**
     * {@link #MOTHER MOTHER}, {@link #FATHER FATHER}.
     */
    public static final List<Relation> PARENT = new ArrayList<Relation>(Arrays.asList(MOTHER, FATHER));

    /**
     * {@link #BROTHER BROTHER}, {@link #SISTER SISTER}.
     */
    public static final List<Relation> SIBLING = new ArrayList<Relation>(Arrays.asList(BROTHER, SISTER));

    /**
     * {@link #SON SON}, {@link #DAUGHTER DAUGHTER}.
     */
    public static final List<Relation> CHILD = new ArrayList<Relation>(Arrays.asList(SON, DAUGHTER));

    /**
     * {@link #HUSBAND HUSBAND}, {@link #WIFE WIFE}.
     */
    public static final List<Relation> SPOUSE = new ArrayList<Relation>(Arrays.asList(HUSBAND, WIFE));
}

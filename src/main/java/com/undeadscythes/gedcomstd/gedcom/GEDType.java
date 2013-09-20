package com.undeadscythes.gedcomstd.gedcom;

import java.util.*;

/**
 * Types of cluster that have a specific sub-structure.
 *
 * @author UndeadScythes
 */
public class GEDType {
    /**
     * Top level {@link GEDTag}s that are contained within the main
     * {@link GEDCOM} structure.
     */
    public static final List<GEDTag> TOP_LEVEL_TAGS = new ArrayList<GEDTag>(Arrays.asList(GEDTag.HEAD, GEDTag.SUBM, GEDTag.SUBN, GEDTag.FAM, GEDTag.INDI, GEDTag.SOUR, GEDTag.OBJE, GEDTag.NOTE, GEDTag.REPO));;
}

package com.undeadscythes.genebase.structure;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.gedcom.GEDTag.Tag;
import com.undeadscythes.genebase.holder.Holder;
import com.undeadscythes.genebase.record.Individual;

/**
 * Represents the name of an {@link Individual}.
 *
 * @author UndeadScythes
 */
public class Name extends Holder {
    private static final long serialVersionUID = 1L;

    private String givenName;
    private String familyName;

    /**
     * Create a new {@link Name} from a {@link Cluster}.
     */
    public Name(final Cluster cluster) {
        super(Tag.NAME, cluster);
        final String name = cluster.pullHead().value;
        givenName = name.split("/")[0].trim();
        familyName = name.split("/").length > 1 ? name.split("/")[1].trim() : "";
    }

    @Override
    public String getFriendly() {
        return givenName + " " + familyName;
    }
}

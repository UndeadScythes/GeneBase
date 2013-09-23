package com.undeadscythes.genebase;

import com.undeadscythes.gedform.*;
import com.undeadscythes.gedform.exception.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.holder.*;
import com.undeadscythes.genebase.record.*;
import com.undeadscythes.metaturtle.*;
import com.undeadscythes.metaturtle.metadata.*;
import com.undeadscythes.metaturtle.unique.*;
import com.undeadscythes.tipscript.*;
import java.io.*;

/**
 * The {@link GeneBase} is a more versatile database-like structure containing
 * the same information as the {@link GEDCOM}.
 *
 * @author UndeadScythes
 */
public class GeneBase extends MetaTurtle {
    private static final long serialVersionUID = 1L;

    private final GEDCOM gedcom;

    /**
     * Load this {@link GeneBase} with the information from a {@link GEDCOM}.
     */
    public GeneBase(final GEDCOM gedcom) {
        super(new UID(gedcom.getFileName().replace(".ged", "")));
        this.gedcom = gedcom;
        while (gedcom.hasNext()) {
            final Cluster record = gedcom.pullCluster();
            final String tag;
            try {
                tag = record.getTag();
            } catch (EmptyClusterException ex) {
                continue;
            }
            switch (RecordType.getByName(tag)) {
                case HEAD:
                    add(new Header(record));
                    break;
                case SUBN:
                    addUniqueMeta(new Submission(record));
                    break;
                case FAM:
                    addUniqueMeta(new Family(record));
                    break;
                case INDI:
                    addUniqueMeta(new Individual(record));
                    break;
                case OBJE:
                    addUniqueMeta(new Multimedia(record));
                    break;
                case NOTE:
                    addUniqueMeta(new Note(record));
                    break;
                case REPO:
                    addUniqueMeta(new Repository(record));
                    break;
                case SOUR:
                    addUniqueMeta(new Source(record));
                    break;
                case SUBM:
                    addUniqueMeta(new Submitter(record));
                    break;
                case TRLR:
                    break;
                default:
            }
        }
    }

    /**
     * Output the contents of this {@link GeneBase} to the file opened in the
     * given {@link TipScript}.
     */
    public void dump(final TipScript out) {
        for (Metadata data : this) {
            ((Holder)data).dump(out, "- ");
        }
        for (RecordType type : RecordType.values()) {
            for (UniqueMeta data : getUniqueMeta(type)) {
                ((UniqueHolder)data).dump(out, "- ");
            }
        }
    }

    /**
     * Save the contents of this {@link GeneBase} to a {@link GEDCOM} format in
     * the file given in the {@link TipScript}.
     */
    public void save(final TipScript out) {
        //TODO: Implement me
    }

    /**
     * Get the {@link GEDCOM} transmission that was used to populate this
     * {@link GeneBase}.
     */
    public GEDCOM getGEDCOM() {
        return gedcom;
    }

    @Override
    public void load(final String path) throws IOException {
        //TODO: Implement me
    }

    @Override
    public void save() {
        //TODO: Implement me
    }
}

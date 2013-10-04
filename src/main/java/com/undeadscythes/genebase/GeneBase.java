package com.undeadscythes.genebase;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.gedform.exception.ParsingException;
import com.undeadscythes.genebase.gedcom.GEDCOM;
import com.undeadscythes.genebase.gedcom.RecordType;
import com.undeadscythes.genebase.holder.Holder;
import com.undeadscythes.genebase.holder.UniqueHolder;
import com.undeadscythes.genebase.record.*;
import com.undeadscythes.metaturtle.MetaTurtle;
import com.undeadscythes.metaturtle.metadata.Metadata;
import com.undeadscythes.metaturtle.unique.UID;
import com.undeadscythes.metaturtle.unique.UniqueMeta;
import com.undeadscythes.tipscript.TipScript;
import java.io.File;
import java.io.IOException;

/**
 * The {@link GeneBase} is a more versatile database-like structure containing
 * the same information as the {@link GEDCOM}.
 *
 * @author UndeadScythes
 */
public class GeneBase extends MetaTurtle {
    private static final long serialVersionUID = 1L;

    /**
     * A GeneBase with no stored data.
     */
    public static final GeneBase NULL_GENEBASE = new GeneBase(new UID(""));

    private final GEDCOM gedcom;

    private GeneBase(final UID uid) {
        super(uid);
        gedcom = new GEDCOM();
    }

    /**
     * Load this {@link GeneBase} with the information from a {@link GEDCOM}.
     */
    public GeneBase(final GEDCOM gedcom) {
        super(new UID(gedcom.getFileName().replace(".ged", "")));
        this.gedcom = gedcom;
        while (gedcom.hasNext()) {
            final Cluster record = gedcom.pullCluster();
            switch (RecordType.getByName(record.getTag())) {
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
        for (UniqueMeta family : getUniqueMeta(RecordType.FAM)) {
            ((Family)family).setMembers(getMap(RecordType.INDI));
        }
    }

    /**
     * Create a new GeneBase from a GEDCOM in a given file.
     */
    public GeneBase(final File file) throws ParsingException {
        super(new UID(file.getName()));
        gedcom = new GEDCOM(file.getPath());
    }

    /**
     * Create an empty GeneBase with a given prefix {@link UID}.
     */
    public GeneBase() {
        super(new UID("Untitled " + new UID().toString()));
        gedcom = new GEDCOM();
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
        for (Metadata data : this) {
            ((Holder)data).save(out, 0);
        }
        for (RecordType type : RecordType.values()) {
            for (UniqueMeta data : getUniqueMeta(type)) {
                ((UniqueHolder)data).save(out, 0);
            }
        }
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

    /**
     * Check if this GeneBase has been assigned a 'null' UID.
     *
     * @see UID#isNull()
     */
    public boolean isNull() {
        return getUID().isNull();
    }
}

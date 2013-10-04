package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.genebase.exception.NoValidTagException;
import com.undeadscythes.metaturtle.metadata.Property;
import java.util.*;

/**
 * A tag which defines the content of a sub-cluster.
 *
 * @author UndeadScythes
 */
public final class GEDTag extends NamedTag {
    private final static List<Property> CUSTOM_TAGS = new ArrayList<Property>(0);

    static {
        for (Tag tag : Tag.values()) {
            CUSTOM_TAGS.add(tag.getGEDTag());
        }
    }

    /**
     * Add a {@link CustomTag}.
     */
    public static void addTag(final CustomTag tag) {
        CUSTOM_TAGS.add(tag);
    }

    /**
     * Get an immutable list of all {@link GEDTag}s and {@link CustomTag}s.
     */
    public static List<Property> getValues() {
        return Collections.unmodifiableList(CUSTOM_TAGS);
    }

    /**
     * Get a {@link Property} matching a given name.
     */
    public static NamedTag getByName(final String name) {
        for (Property tag : getValues()) {
            if (tag.toString().equals(name)) return (NamedTag)tag;
        }
        throw new NoValidTagException(name);
    }

    private final Tag tag;

    private GEDTag(final Tag tag) {
        this.tag = tag;
    }

    @Override
    protected int propertyHash() {
        return tag.name().hashCode();
    }

    @Override
    protected String propertyString() {
        return tag.name();
    }

    @Override
    public String getFormal() {
        return tag.getFormal();
    }

    /**
     * Get the type of this GEDTag.
     */
    @Override
    public TagType getType() {
        return tag.getType();
    }

    /**
     * Represents a tag type.
     */
    public enum TagType {
        EVENT,
        FACT,
        SOURCE,
        OTHER,
        CUSTOM;
    }

    /**
     * Represents an actual tag text.
     */
    public enum Tag {
        ABBR("Abbreviation"),
        ADDR("Address", TagType.FACT),
        ADR1("Address 1"),
        ADR2("Address 2"),
        ADOP("Adoption", TagType.EVENT),
        AFN("Ancestral file number"),
        AGE("Age"),
        AGNC("Agency"),
        ALIA("Alias"),
        ANCE("Ancestors"),
        ANCI("Ancestor interest"),
        ANUL("Annulment", TagType.EVENT),
        ASSO("Associates"),
        AUTH("Author"),
        BAPL("LDS baptism", TagType.EVENT),
        BAPM("Baptism", TagType.EVENT),
        BARM("Bar mitzvah", TagType.EVENT),
        BASM("Bat mitzvah", TagType.EVENT),
        BIRT("Birth", TagType.EVENT),
        BLES("Blessing", TagType.EVENT),
        /**
         * @deprecated Removed in 5.5.1
         * @see #OBJE OBJE
         */
        @Deprecated
        BLOB("Binary object"),
        BURI("Burial", TagType.EVENT),
        CALN("Call number"),
        CAST("Caste"),
        CAUS("Cause"),
        CENS("Census", TagType.EVENT),
        CHAN("Change"),
        CHAR("Character"),
        CHIL("Child"),
        CHR("Christening", TagType.EVENT),
        CHRA("Adult Christening", TagType.EVENT),
        CITY("City"),
        /**
         * Added in 5.6.
         */
        CLNDR("Calendar type"),
        CONF("Confirmation", TagType.EVENT),
        CONL("LDS confirmation", TagType.EVENT),
        COPR("Copyright"),
        CORP("Corporate"),
        CREM("Cremation", TagType.EVENT),
        CTRY("Country"),
        DATA("Data"),
        DATE("Date"),
        DEAT("Death", TagType.EVENT),
        DESC("Descendants"),
        DESI("Descendant interest"),
        DEST("Destination"),
        DIV("Divorce", TagType.EVENT),
        DIVF("Divorce filed", TagType.EVENT),
        DSCR("Physical description"),
        EDUC("Education"),
        /**
         * Added in 5.5.1.
         */
        EMAIL("Email"),
        EMIG("Emigration", TagType.EVENT),
        ENDL("LDS endowment", TagType.EVENT),
        ENGA("Engagement", TagType.EVENT),
        EVEN("Event", TagType.EVENT),
        /**
         * Added in 5.5.1.
         */
        FACT("Fact"),
        FAMC("Family child"),
        FAMF("Family file"),
        FAMS("Family spouse"),
        /**
         * Added in 5.5.1.
         */
        FAX("Facimilie"),
        FCOM("First communion", TagType.EVENT),
        FILE("File"),
        /**
         * Added in 5.5.1.
         */
        FONE("Phonetic"),
        FORM("Format"),
        GEDC("GEDCOM"),
        GIVN("Given name"),
        GRAD("Graduation", TagType.EVENT),
        HUSB("Husband"),
        IDNO("ID number"),
        IMMI("Immigration", TagType.EVENT),
        LANG("Language"),
        /**
         * Added in 5.5.1.
         */
        LATI("Latitude"),
        /**
         * @deprecated Removed in 5.6
         */
        @Deprecated
        LEGA("Legatee"),
        /**
         * Added in 5.5.1.
         */
        LONG("Longitude"),
        /**
         * Added in 5.5.1.
         */
        MAP("Map"),
        MARB("Marriage bann", TagType.EVENT),
        MARC("Marriage contract", TagType.EVENT),
        MARL("Marriage license", TagType.EVENT),
        MARR("Marriage"),
        MARS("Marriage settlement", TagType.EVENT),
        MEDI("Media"),
        NAME("Name", TagType.FACT),
        NATI("Nationality"),
        NATU("Naturalization", TagType.EVENT),
        NCHI("Number of children"),
        NICK("Nickname"),
        NMR("Number of marriages"),
        NOTE("Note"),
        NPFX("Name prefix"),
        NSFX("Name suffix"),
        OBJE("Object"),
        OCCU("Occupation"),
        ORDI("Ordinance"),
        ORDN("Ordination", TagType.EVENT),
        PAGE("Page"),
        PEDI("Pedigree"),
        PHON("Phone"),
        PLAC("Place"),
        POST("Postal code"),
        PROB("Probate", TagType.EVENT),
        PROP("Property"),
        PUBL("Publication"),
        QUAY("Quality of data"),
        REFN("Reference"),
        RELA("Relationship"),
        RELI("Religion"),
        RESI("Residence", TagType.EVENT),
        RESN("Restriction"),
        RETI("Retirement", TagType.EVENT),
        RFN("Record file number"),
        RIN("Record ID number"),
        ROLE("Role"),
        /**
         * Added in 5.5.1.
         */
        ROMN("Romanized"),
        SEX("Gender", TagType.FACT),
        SLGC("LDS sealing child", TagType.EVENT),
        SLGS("LDS sealing spouse", TagType.EVENT),
        SOUR("Source", TagType.SOURCE),
        SPFX("Family name prefix"),
        SSN("Social security number"),
        STAE("State"),
        STAT("Status"),
        SUBM("Submitter"),
        SUBN("Submission"),
        SURN("Family name"),
        TEMP("Temple"),
        TEXT("Text"),
        TIME("Time"),
        TITL("Title"),
        TYPE("Type"),
        /**
         * Added in 5.6
         */
        URL("URL"),
        VERS("Version"),
        /**
         * Added in 5.6.
         */
        WAC("LDS washing and clothing"),
        WIFE("Wife"),
        WILL("Will", TagType.EVENT),
        /**
         * Added in 5.5.1.
         *
         * @deprecated Removed in 5.6
         * @see #URL URL
         */
        @Deprecated
        WWW("Website");

        private final String formal;
        private final TagType type;

        private Tag(final String formal) {
            this(formal, TagType.OTHER);
        }

        private Tag(final String formal, final TagType type) {
            this.formal = formal;
            this.type = type;
        }

        private String getFormal() {
            return formal;
        }

        private TagType getType() {
            return type;
        }

        /**
         * Get the corresponding {@link GEDTag} with this {@link Tag}.
         */
        public GEDTag getGEDTag() {
            return new GEDTag(this);
        }
    }
}

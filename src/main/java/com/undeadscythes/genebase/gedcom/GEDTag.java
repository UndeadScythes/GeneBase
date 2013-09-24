package com.undeadscythes.genebase.gedcom;

import com.undeadscythes.genebase.exception.*;
import com.undeadscythes.metaturtle.metadata.*;
import java.util.*;

/**
 * A tag which defines the content of a sub-cluster.
 *
 * @author UndeadScythes
 */
public enum GEDTag implements NamedTag {
    ABBR("Abbreviation"),
    ADDR("Address"),
    ADR1("Address 1"),
    ADR2("Address 2"),
    ADOP("Adoption"),
    AFN("Ancestral file number"),
    AGE("Age"),
    AGNC("Agency"),
    ALIA("Alias"),
    ANCE("Ancestors"),
    ANCI("Ancestor interest"),
    ANUL("Annulment"),
    ASSO("Associates"),
    AUTH("Author"),
    BAPL("LDS baptism"),
    BAPM("Baptism"),
    BARM("Bar mitzvah"),
    BASM("Bat mitzvah"),
    BIRT("Birth"),
    BLES("Blessing"),
    /**
     * @deprecated Removed in 5.5.1
     * @see #OBJE OBJE
     */
    @Deprecated
    BLOB("Binary object"),
    BURI("Burial"),
    CALN("Call number"),
    CAST("Caste"),
    CAUS("Cause"),
    CENS("Census"),
    CHAN("Change"),
    CHAR("Character"),
    CHIL("Child"),
    CHR("Christening"),
    CHRA("Adult Christening"),
    CITY("City"),
    /**
     * Added in 5.6.
     */
    CLNDR("Calendar type"),
    CONF("Confirmation"),
    CONL("LDS confirmation"),
    COPR("Copyright"),
    CORP("Corporate"),
    CREM("Cremation"),
    CTRY("Country"),
    DATA("Data"),
    DATE("Date"),
    DEAT("Death"),
    DESC("Descendants"),
    DESI("Descendant interest"),
    DEST("Destination"),
    DIV("Divorce"),
    DIVF("Divorce filed"),
    DSCR("Physical description"),
    EDUC("Education"),
    /**
     * Added in 5.5.1.
     */
    EMAIL("Email"),
    EMIG("Emigration"),
    ENDL("LDS endowment"),
    ENGA("Engagement"),
    EVEN("Event"),
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
    FCOM("First communion"),
    FILE("File"),
    /**
     * Added in 5.5.1.
     */
    FONE("Phonetic"),
    FORM("Format"),
    GEDC("GEDCOM"),
    GIVN("Given name"),
    GRAD("Graduation"),
    HUSB("Husband"),
    IDNO("ID number"),
    IMMI("Immigration"),
    LANG("Language"),
    /**
     * Added in 5.5.1.
     */
    LATI("latitude"),
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
    MARB("Marriage bann"),
    MARC("Marriage contract"),
    MARL("Marriage license"),
    MARR("Marriage"),
    MARS("Marriage settlement"),
    MEDI("media"),
    NAME("Name"),
    NATI("Nationality"),
    NATU("naturalization"),
    NCHI("Number of children"),
    NICK("Nickname"),
    NMR("Number of marriages"),
    NOTE("Note"),
    NPFX("Name prefix"),
    NSFX("Name suffix"),
    OBJE("Object"),
    OCCU("Occupation"),
    ORDI("Ordinance"),
    ORDN("Ordination"),
    PAGE("Page"),
    PEDI("Pedigree"),
    PHON("Phone"),
    PLAC("Place"),
    POST("Postal code"),
    PROB("Probate"),
    PROP("Property"),
    PUBL("Publication"),
    QUAY("Quality of data"),
    REFN("Reference"),
    RELA("Relationship"),
    RELI("Religion"),
    RESI("Residence"),
    RESN("Restriction"),
    RETI("Retirement"),
    RFN("Record file number"),
    RIN("Record ID number"),
    ROLE("Role"),
    /**
     * Added in 5.5.1.
     */
    ROMN("Romanized"),
    SEX("Gender"),
    SLGC("LDS sealing child"),
    SLGS("LDS sealing spouse"),
    SOUR("Source"),
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
    WILL("Will"),
    /**
     * Added in 5.5.1.
     *
     * @deprecated Removed in 5.6
     * @see #URL URL
     */
    @Deprecated
    WWW("Website");

    private final String formal;

    private GEDTag(final String formal) {
        this.formal = formal;
    }

    private final static List<Property> CUSTOM_TAGS = new ArrayList<Property>(0);

    static {
        CUSTOM_TAGS.addAll(Arrays.asList(values()));
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
            if (tag.getString().equals(name)) return (NamedTag)tag;
        }
        throw new NoValidTagException(name);
    }

    @Override
    public boolean equals(final String string) {
        return getString().equals(string);
    }

    @Override
    public String getString() {
        return name();
    }

    @Override
    public String getFormal() {
        return formal;
    }
}

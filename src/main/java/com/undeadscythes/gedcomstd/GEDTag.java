package com.undeadscythes.gedcomstd;

import com.undeadscythes.gedcomstd.exception.*;
import com.undeadscythes.metaturtle.*;
import java.util.*;

/**
 * A tag which defines the content of a sub-cluster.
 *
 * @author UndeadScythes
 */
public enum GEDTag implements MetaType {
    ABBR, ADDR, ADR1, ADR2, ADOP, AFN, AGE, AGNC, ALIA, ANCE, ANCI, ANUL, ASSO, AUTH,
    BAPL, BAPM, BARM, BASM, BIRT, BLES, BLOB, BURI,
    CALN, CAST, CAUS, CENS, CHAN, CHAR, CHIL, CHR, CHRA, CITY, CONC, CONF, CONL, CONT, COPR, CORP, CREM, CTRY,
    DATA, DATE, DEAT, DESC, DESI, DEST, DIV, DIVF, DSCR,
    EDUC, EMIG, ENDL, ENGA, EVEN,
    FAM, FAMC, FAMF, FAMS, FCOM, FILE, FORM,
    GEDC, GIVN, GRAD,
    HEAD, HUSB,
    IDNO, IMMI, INDI,
    LANG, LEGA,
    MARB, MARC, MARL, MARR, MARS, MEDI,
    NAME, NATI, NATU, NCHI, NICK, NMR, NOTE, NPFX, NSFX,
    OBJE, OCCU, ORDI, ORDN,
    PAGE, PEDI, PHON, PLAC, POST, PROB, PROP, PUBL,
    QUAY,
    REFN, RELA, RELI, REPO, RESI, RESN, RETI, RFN, RIN, ROLE,
    SEX, SLGC, SLGS, SOUR, SPFX, SSN, STAE, STAT, SUBM, SUBN, SURN,
    TEMP, TEXT, TIME, TITL, TRLR, TYPE,
    VERS,
    WIFE,
    WILL,

    MAP, // 5.5.1
    LATI, // 5.5.1
    LONG, // 5.5.1
    FONE, // 5.5.1
    ROMN, // 5.5.1
    FACT, // 5.5.1
    FAX, // 5.5.1
    WWW, // 5.5.1
    EMAIL; // 5.5.1

    private final static List<CustomTag> CUSTOM_TAGS = new ArrayList<CustomTag>(0);

    /**
     * Add a {@link CustomTag}.
     */
    public static void addTag(final CustomTag tag) {
        CUSTOM_TAGS.add(tag);
    }

    /**
     * Get the printable name of this {@link GEDTag}.
     */
    public String getTag() {
        return name();
    }

    /**
     * Get a {@link GEDTag} matching a given name.
     */
    public static GEDTag getByName(final String name) {
        for (GEDTag tag : values()) {
            if (tag.getTag().equals(name)) return tag;
        }
        throw new NoValidTagException(name);
    }
}

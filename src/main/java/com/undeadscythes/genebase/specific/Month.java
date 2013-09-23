package com.undeadscythes.genebase.specific;

import com.undeadscythes.gedform.exception.*;

/**
 * Representations of calendar months.
 *
 * @author UndeadScythes
 */
public enum Month {
    // Gregorian calendar
    JAN("JANUARY"),
    FEB("FEBRUARY"),
    MAR("MARCH"),
    APR("APRIL"),
    MAY("MAY"),
    JUN("JUNE"),
    JUL("JULY"),
    AUG("AUGUST"),
    SEP("SEPTEMBER"),
    OCT("OCTOBER"),
    NOV("NOVEMBER"),
    DEC("DECEMBER"),
    // French Republic calendar
    VEND("VENDEMIAIRE"),
    BRUM("BRUMAIRE"),
    FRIM("FRIMAIRE"),
    NIVO("NIVOSE"),
    PLUV("PLUVIOSE"),
    VENT("VENTOSE"),
    GERM("GERMINAL"),
    FLOR("FLOREAL"),
    PRAI("PRAIRIAL"),
    MESS("MESSIDOR"),
    THER("THERMIDOR"),
    FRUC("FRUCTIDOR"),
    COMP("JOUR COMPLEMENTAIRS"),
    // Hebrew calendar
    TSH("TISHRI"),
    CSH("CHESHVAN"),
    KSL("KISLEV"),
    TVT("TEVET"),
    SHV("SHEVAT"),
    ADR("ADAR"),
    ADS("ADAR SHENI"),
    NSN("NISAN"),
    IYR("IYAR"),
    SVN("SIVAN"),
    TMZ("TAMMUZ"),
    AAV("AV"),
    ELL("ELUL"),
    // Unknown
    UNK("UNKNOWN");

    /**
     * The name of the month, all capitals.
     */
    public final String name;

    private Month(final String name) {
        this.name = name;
    }

    /**
     * Get the standard shorthand form of this month.
     */
    public String getShort() {
        return name();
    }

    /**
     * Get a month number from the name of a month.
     */
    public static Month getMonth(final String month) throws ParsingException {
        final String monthUpper = month.toUpperCase();
        for (Month test : values()) {
            if (test.name.startsWith(monthUpper) || test.getShort().startsWith(monthUpper)) return test;
        }
        throw new ParsingException(month);
    }
}

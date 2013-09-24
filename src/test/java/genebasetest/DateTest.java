package genebasetest;

import com.undeadscythes.gedform.*;
import com.undeadscythes.gedform.exception.*;
import com.undeadscythes.genebase.structure.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class DateTest {
    @Test
    public void testParse() throws ParsingException {
        assertEquals("01 SEP 1999", Date.parseDate(Cluster.topLevel("1 sep 1999")).getValue());
        assertEquals("SEP 1999", Date.parseDate(Cluster.topLevel("sep 1999")).getValue());
        assertEquals("SEP 1999", Date.parseDate(Cluster.topLevel("september 1999")).getValue());
        assertEquals("ABT 1999", Date.parseDate(Cluster.topLevel("abt 1999")).getValue());
        assertEquals("CAL 1999", Date.parseDate(Cluster.topLevel("cal 1999")).getValue());
        assertEquals("EST 01 SEP 1999", Date.parseDate(Cluster.topLevel("est 1 sep 1999")).getValue());
        assertEquals("BEF 1999", Date.parseDate(Cluster.topLevel("bef 1999")).getValue());
        assertEquals("AFT 1999", Date.parseDate(Cluster.topLevel("aft 1999")).getValue());
        assertEquals("BET 1999 AND 2000", Date.parseDate(Cluster.topLevel("bet 1999 and 2000")).getValue());
        assertEquals("FROM 1999", Date.parseDate(Cluster.topLevel("from 1999")).getValue());
        assertEquals("TO 1999", Date.parseDate(Cluster.topLevel("to 1999")).getValue());
        assertEquals("FROM 1999 TO 2000", Date.parseDate(Cluster.topLevel("from 1999 to 2000")).getValue());
        assertEquals("EST 30 DEC 1997", Date.parseDate(Cluster.topLevel("EST 30 DEC 1997")).getValue());
        assertEquals("02 TVT 5758", Date.parseDate(Cluster.topLevel("2 tvt 5758")).getValue());
    }
}

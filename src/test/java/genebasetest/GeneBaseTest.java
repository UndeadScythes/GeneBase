package genebasetest;

import com.undeadscythes.gedform.exception.*;
import com.undeadscythes.genebase.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.tipscript.*;
import java.util.logging.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class GeneBaseTest {
    @Test
    public void testTGC551() throws ParsingException {
        final GeneBase geneBase = new GeneBase(new GEDCOM("src/test/resources/TGC551.ged"));
        assertFalse("isEmpty()", geneBase.isEmpty());
        final TipScript tipScript = new TipScript(Logger.getLogger(getClass().getName()), "Test: ");
        tipScript.openFile("test.ged");
        geneBase.dump(tipScript);
        tipScript.closeFile();
    }

    @Test
    public void testTGC551LF() throws ParsingException {
        final GeneBase geneBase = new GeneBase(new GEDCOM("src/test/resources/TGC551LF.ged"));
        assertFalse("isEmpty()", geneBase.isEmpty());
    }

    @Test
    public void testTGC55C() throws ParsingException {
        final GeneBase geneBase = new GeneBase(new GEDCOM("src/test/resources/TGC55C.ged"));
        assertFalse("isEmpty()", geneBase.isEmpty());
    }

    @Test
    public void testTGC55CLF() throws ParsingException {
        final GeneBase geneBase = new GeneBase(new GEDCOM("src/test/resources/TGC55CLF.ged"));
        assertFalse("isEmpty()", geneBase.isEmpty());
    }
}

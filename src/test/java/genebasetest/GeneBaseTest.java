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
    public void testTGC55C() throws ParsingException {
        final GeneBase geneBase = new GeneBase(new GEDCOM("src/test/resources/TGC55C.ged"));
        assertFalse("isEmpty()", geneBase.isEmpty());
        final TipScript tipScript = new TipScript(Logger.getLogger(getClass().getName()), "Test: ");
        tipScript.openFile("test.ged");
        geneBase.dump(tipScript);
        tipScript.closeFile();
    }
}

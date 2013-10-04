package genebasetest;

import com.undeadscythes.gedform.exception.ParsingException;
import com.undeadscythes.genebase.GeneBase;
import com.undeadscythes.genebase.gedcom.GEDCOM;
import com.undeadscythes.genebase.gedcom.GEDTag.Tag;
import com.undeadscythes.genebase.gedcom.RecordType;
import com.undeadscythes.metaturtle.exception.NoMetadataSetException;
import com.undeadscythes.metaturtle.exception.NoUniqueMetaException;
import com.undeadscythes.metaturtle.unique.UID;
import com.undeadscythes.tipscript.TipScript;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author UndeadScythes
 */
public class GeneBaseTest {
    @Test
    public void testTGC55C() throws ParsingException, NoUniqueMetaException, NoMetadataSetException {
        final GeneBase geneBase = new GeneBase(new GEDCOM("src/test/resources/TGC55C.ged"));
        assertFalse(geneBase.isEmpty());
        final TipScript tipScript = new TipScript(Logger.getLogger(getClass().getName()), "Test: ");
        tipScript.openFile("test.ged");
        geneBase.dump(tipScript);
        tipScript.closeFile();
        assertEquals("Charlie Accented /ANSEL/", geneBase.getUniqueMeta(RecordType.INDI, new UID("I14")).getFirst(Tag.NAME.getGEDTag()).getValue());
    }
}

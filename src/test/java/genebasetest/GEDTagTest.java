package genebasetest;

import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.metaturtle.metadata.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class GEDTagTest extends Assert {
    @Test
    public void testGetByTag() {
        for (Property tag : GEDTag.getValues()) {
            assertEquals(tag, GEDTag.getByName(tag.getString()));
        }
    }
}

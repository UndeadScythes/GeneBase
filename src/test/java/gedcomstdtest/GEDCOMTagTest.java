package gedcomstdtest;

import com.undeadscythes.gedcomstd.gedcom.GEDTag;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class GEDCOMTagTest extends Assert {
    @Test
    public void testGetByTag() {
        for (GEDTag tag : GEDTag.values()) {
            assertEquals("getByName", tag, GEDTag.getByName(tag.getTag()));
        }
    }
}

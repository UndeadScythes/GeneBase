package genebasetest;

import com.undeadscythes.genebase.gedcom.GEDTag;
import com.undeadscythes.metaturtle.metadata.Property;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author UndeadScythes
 */
public class GEDTagTest extends Assert {
    @Test
    public void testGetByTag() {
        for (Property tag : GEDTag.getValues()) {
            assertEquals(tag, GEDTag.getByName(tag.toString()));
        }
    }
}

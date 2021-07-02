import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MockDictionaryTest {
    HashMap<String, Summary> hashmap = null;

    @Before
    public void setUp() {
        MockDictionary dictionary = new MockDictionary();
        dictionary.printDictionary();
        hashmap = dictionary.getDictionary();

    }

    @Test
    public void testSetup() {
        assertEquals(1550, hashmap.get("20130209").getActivityList().
                get(0).getDistance(), .001);
    }
}
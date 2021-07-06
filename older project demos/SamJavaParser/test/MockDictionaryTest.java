// We are using JUNIT4!

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.*;

public class MockDictionaryTest {
    HashMap<String, Summary> hashmap;
    MockDictionary dictionary;

    @Before
    public void setUp() {
        dictionary = new MockDictionary();
    }

    @Test
    public void testSetup() {
        assertEquals(1550, dictionary.getDictionaryEntry().get("20130209").getActivityList().
                get(0).getDistance(), .001);
    }
}
import java.util.HashMap;
import java.util.Set;

public class MockDictionary {
    HashMap<String, Summary> dictionaryEntry;

    public MockDictionary() {
        this.createDictionary();
    }

    public void createDictionary(){

        Activity mockActivity1 = new Activity("walking",
                "walking", 1845.0, 1562.0,
                2254, 78);

        Activity mockActivity2 = new Activity("transport",
                "transport", 2621.0, 17662.0);

        Summary mockSummary = new Summary();
        mockSummary.addActivity(mockActivity1);
        mockSummary.addActivity(mockActivity1);

        this.dictionaryEntry.put("20130209", mockSummary);
    }

    public HashMap<String, Summary> getDictionaryEntry() {
        return this.dictionaryEntry;
    }

    public void printDictionary() {
        Set<String> keys = dictionaryEntry.keySet();
        for (String key: keys) {
            System.out.println(key);
        }

    }
}

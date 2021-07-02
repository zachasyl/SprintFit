import java.util.HashMap;
import java.util.Set;

public class MockDictionary {
    HashMap<String, Summary> dictionary = null;

    public MockDictionary() {
        this.dictionary = createDictionary();

    }
    public HashMap<String, Summary> createDictionary(){

        Activity mockActivity1 = new Activity("walking",
                "walking", 1845.0, 1562.0,
                2254, 78);

        Activity mockActivity2 = new Activity("transport",
                "transport", 2621.0, 17662.0);

        Summary mockSummary = new Summary();
        mockSummary.addActivity(mockActivity1);
        mockSummary.addActivity(mockActivity1);

        HashMap<String, Activity> mockDictionary = new HashMap<>();
        this.dictionary.put("20130209", mockSummary);

        return this.dictionary;
    }

    public HashMap<String, Summary> getDictionary() {
        return this.dictionary;
    }

    public void printDictionary() {
        Set<String> keys = dictionary.keySet();
        for (String key: keys) {
            System.out.println(key);
        }

    }
}

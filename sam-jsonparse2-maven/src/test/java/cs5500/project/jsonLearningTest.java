package cs5500.project;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;

public class jsonLearningTest {

  @Test
  public void count() {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
    Reader reader = new InputStreamReader(inputStream);
    // Element is abstract JSON thing
    JsonElement rootElement = JsonParser.parseReader(reader);
    // Convert element to object
    // TODO maybe skip the root element step and convert straight to object?
    JsonObject rootObject = rootElement.getAsJsonObject();

    JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");

    JsonArray array = null;


    for (Entry<String, JsonElement> entry: pages.entrySet()) {
      JsonObject entryObject = entry.getValue().getAsJsonObject();
      array = entryObject.getAsJsonArray("revisions");
    }

    Assert.assertEquals(4, array.size());

  }

}

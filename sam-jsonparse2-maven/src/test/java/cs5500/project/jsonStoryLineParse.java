package cs5500.project;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.junit.Test;

public class jsonStoryLineParse {

  @Test
  public void count() {
    InputStream inputStream = getClass().getClassLoader()
        .getResourceAsStream("storylineOneDay");
    Reader reader = new InputStreamReader(inputStream);
    JsonElement rootElement = JsonParser.parseReader(reader);
    JsonArray array = rootElement.getAsJsonArray();

    System.out.println(array);
    JsonElement element = array.get(0);
    System.out.println(element.getClass());
    //JsonObject rootObject = rootElement.getAsJsonObject();
    //System.out.println(array);

    System.out.println(array.get(0).getAsJsonObject().get("summary").getAsJsonArray().get(0).getAsJsonObject().get("distance"));
//    for (Entry<String, JsonElement> entry: rootObject.entrySet()) {
//      System.out.println(entry.getValue());
//    }
  }

}

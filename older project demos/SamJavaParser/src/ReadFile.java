import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class reads the file and returns a JSON Array object containing
 * all the contents of the file.
 */
class ReadFile {
  private static JSONArray fileContentArray;
  private static String file = "resources/storyline.json";

  public ReadFile() {
    this.fileContentArray = readFile();
  }

  public static JSONArray readFile() {
    try {
      String contents = new String((Files.readAllBytes(Paths.get(file))));
      fileContentArray = new JSONArray(contents);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileContentArray;
  }

  public JSONArray getContentArray() {
    return this.fileContentArray;
  }
}
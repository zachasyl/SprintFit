import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;


public class GsonAttempt1 {

  public static void main(String[] args) {

    try (JsonWriter writer = new JsonWriter(new FileWriter()))


  }



}

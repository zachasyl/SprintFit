package cs5500.project;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.net.UnknownHostException;

public class MongoDB {
  public static MongoClient mongoClient;

  public static void main(String[] args) throws UnknownHostException {

    try {
      mongoClient = new MongoClient( "127.0.0.1", 27017);
      System.out.println("Connected to MongoDB!");
    } catch (MongoException e) {
      e.printStackTrace();
      }
      // This section will be uncommented later, when the Client is being used outside of this class.
      // This section closes the client when it's done.
//    } finally {
//      if (mongoClient != null)
//        mongoClient.close();
//    }

    MongoDatabase database = mongoClient.getDatabase("peopledb");
    MongoCollection<Document> collection = database.getCollection("persons");
    Document myDoc = collection.find().first();
    System.out.println(myDoc);
  }
}

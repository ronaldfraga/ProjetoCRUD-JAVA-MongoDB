package db;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    private static MongoClient client = null;
    private static MongoDatabase database = null;

    public static MongoDatabase getConnection() {
        if (database == null) {
            client = MongoClients.create("mongodb://localhost:27017");
            database = client.getDatabase("meubanco");
        }
        return database;
    }

    public static void closeConnection() {
        if (client != null) client.close();
    }
}
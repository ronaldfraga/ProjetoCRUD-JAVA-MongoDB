package model.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import db.MongoDB;
import model.dao.UserDao;
import model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMongoDB implements UserDao {

    private MongoCollection<Document> collection;

    public UserDaoMongoDB() {
        MongoDatabase db = MongoDB.getConnection();
        this.collection = db.getCollection("user");
    }

    @Override
    public void insert(User obj) {
        Document doc = new Document("name", obj.getName())
                .append("email", obj.getEmail());

        collection.insertOne(doc);
        obj.setId(doc.getObjectId("_id").toHexString());
    }

    @Override
    public void update(User obj) {
        Document update = new Document("$set",
                new Document("name", obj.getName())
                        .append("email", obj.getEmail()));

        collection.updateOne(
                Filters.eq("_id", new ObjectId(obj.getId())),
                update
        );
    }

    @Override
    public void deleteById(String id) {
        collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    @Override
    public User findById(String id) {
        Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();

        if (doc == null) return null;

        return new User(
                doc.getObjectId("_id").toHexString(),
                doc.getString("name"),
                doc.getString("email")
        );
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        for (Document doc : collection.find()) {
            User u = new User();
            u.setId(doc.getObjectId("_id").toHexString());
            u.setName(doc.getString("name"));
            u.setEmail(doc.getString("email"));
            list.add(u);
        }

        return list;
    }
}

package mongo;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoMain {

    public static void main(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        mongoDatabase.getCollection("myCollection").drop();

        mongoDatabase.createCollection("myCollection");
        MongoCollection<Document> collection = mongoDatabase.getCollection("myCollection");

        Document document = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100);

        collection.insertOne(document);


        document = new Document("title", "sqlite")
                .append("description", "relational database")
                .append("likes", 50);

        collection.insertOne(document);

        System.out.println("Document inserted successfully");

        collection = mongoDatabase.getCollection("myCollection");

        FindIterable<Document> documents = collection.find();
        for(Document doc : documents){
            System.out.println(doc.toJson());
        }

    }

}

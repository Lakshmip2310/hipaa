package com.sahilmahajan.dataprivacyproject.Connections;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDB {

    private static MongoClient mongoClient;
    private static MongoCollection<Document> collection;

    public MongoCollection<Document> getcollection() {
        return collection;
    }

    public static void Connect(String Database, String Collection) {

        //TODO
        //Fil the connection string
        mongoClient = MongoClients.create("mongodb://127.0.0.1:27017/?readPreference=primary&gssapiServiceName=mongodb&appname=MongoDB%20Compass&directConnection=true&ssl=false&maxIdleTimeMS=120000");
        MongoDatabase database = mongoClient.getDatabase(Database);

        collection = database.getCollection(Collection);
    }

    public void CloseConnect() {
        mongoClient.close();
    }
}

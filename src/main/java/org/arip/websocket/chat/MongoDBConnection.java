package org.arip.websocket.chat;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Initialize MongoDB connection
    static {
        String uri = "mongodb://localhost:27017"; // Replace with your URI
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase("chatapp1"); // Replace with your database name
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}

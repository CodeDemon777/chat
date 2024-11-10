package org.arip.websocket.chat;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ChatService {
    private static final MongoDatabase database = MongoDBConnection.getDatabase();
    private static final MongoCollection<Document> messagesCollection = database.getCollection("messages");

    public static void saveMessage(Message message) {
        Document doc = new Document("from", message.getFrom())
                .append("to", message.getTo())
                .append("content", message.getContent())
                .append("timestamp", System.currentTimeMillis());
        
        messagesCollection.insertOne(doc);
    }
}

package org.lab8.services.hilos;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class ThreadDto {
    private final MongoCollection<Document> coleccionHilo;

    public ThreadDto(MongoDatabase database) {
        this.coleccionHilo = database.getCollection("Thread");

        Long documentos = coleccionHilo.countDocuments();

        if (documentos.intValue() == 0) {
            Document hiloPrincipal = new Document("nombre", "Principal")
                    .append("posts", new ArrayList<Document>());
            coleccionHilo.insertOne(hiloPrincipal);
        }
    }

    public String getThread() {
        Bson projection = Projections.fields(Projections.include("nombre", "posts"), Projections.excludeId());
        Document hilo = coleccionHilo.find().projection(projection).first();
        Gson json = new Gson();
        if (hilo != null) {
            return json.toJson(hilo);
        } else {
            return json.toJson(new Document());
        }
    }

    public void addPost(String arroba, String mensaje) {
        List<Document> post = (List<Document>) coleccionHilo.find().first().get("posts");
        post.addFirst(new Document("arroba", arroba).append("mensaje", mensaje));

        coleccionHilo.findOneAndUpdate(eq("nombre", "Principal"), set("posts", post));
    }
}
package org.lab8.services.posts;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

public class PostDto {

    private final MongoCollection<Document> coleccionPost;

    public PostDto(MongoDatabase database) {
        this.coleccionPost = database.getCollection("posts");
    }

    public void addPost(String arroba, String mensaje) {
        Document nuevoPost = new Document("user", arroba)
                .append("message", mensaje);
        coleccionPost.insertOne(nuevoPost);
    }

    public String listAllPost() {
        Gson json = new Gson();
        Bson projection = Projections.fields(Projections.include("user", "message"),
                Projections.excludeId());
        List<Document> posts = new ArrayList<>();
        coleccionPost.find().projection(projection).into(posts);

        return json.toJson(posts);
    }

    public String postsPerUsers(String arroba) {
        Bson projection = Projections.fields(Projections.include("user", "message"),
                Projections.excludeId());
        List<Document> postsUsuario = new ArrayList<>();
        coleccionPost.find(eq("user", arroba)).projection(projection).into(postsUsuario);
        Gson json = new Gson();

        return json.toJson(postsUsuario);
    }

    public void deletePost(String arroba, String mensaje) {
        Bson filtro = Filters.and(eq("user", arroba), eq("message", mensaje));
        coleccionPost.deleteOne(filtro);
    }
}
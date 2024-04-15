package org.lab8.services.usuarios;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class UserDto {
    private final MongoCollection<Document> coleccionUsuario;

    public UserDto(MongoDatabase database) {
        this.coleccionUsuario = database.getCollection("users");
    }

    public void addUser(String nombre, String correo) {
        Document newUser = new Document("name", nombre)
                .append("arroba", "@" + nombre.replace(" ", "_"))
                .append("email", correo);
        coleccionUsuario.insertOne(newUser);
    }

    public void listAllUsers() {
        FindIterable<Document> users = coleccionUsuario.find();
        for (Document user : users) {
            System.out.println(user.toJson());
        }
    }

    public String getUser(String arroba) {
        Bson projection = Projections.fields(Projections.include("arroba"),
                Projections.excludeId());
        Document usuario = coleccionUsuario.find(eq("arroba", arroba.replace(" ", "_"))).projection(projection).first();
        Gson json = new Gson();
        if (usuario != null) {
            return json.toJson(usuario);
        } else {
            return json.toJson(new Document());
        }
    }

    public void deleteUser(String arroba) {
        coleccionUsuario.deleteOne(eq("arroba", arroba));
    }
}
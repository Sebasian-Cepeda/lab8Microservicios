package org.lab8.services.hilos;

import org.lab8.config.MongoDB;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/thread")
public class Thread {
    private ThreadDto thread = new ThreadDto(MongoDB.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String obtenerHilo() {
        return thread.getThread().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void agregarPost(@FormParam("userAccount") String account, @FormParam("message") String message) {
        thread.addPost(account, message);
    }
}
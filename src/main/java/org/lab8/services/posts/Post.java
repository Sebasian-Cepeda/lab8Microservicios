package org.lab8.services.posts;

import org.lab8.config.MongoDB;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/post")
public class Post {

    private PostDto post = new PostDto(MongoDB.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{nombre}")
    public String obtenerPost(@PathParam("nombre") String nombre) {
        return post.obtenerPostsUsuario("@" + nombre);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String obtenerPosts() {
        return post.listarPost();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void crearPost(@FormParam("arroba") String arroba, @FormParam("mensaje") String mensaje) {
        post.añadirPost(arroba, mensaje);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void eliminarPost(@FormParam("arroba") String arroba, @FormParam("mensaje") String mensaje) {
        post.eliminarPost(arroba, mensaje);
    }
}
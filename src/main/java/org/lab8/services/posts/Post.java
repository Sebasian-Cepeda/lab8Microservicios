package org.lab8.services.posts;

import org.lab8.config.MongoDB;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/post")
public class Post {

    private PostDto post = new PostDto(MongoDB.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public String getPost(@PathParam("name") String name) {
        return post.postsPerUsers("@" + name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPosts() {
        return post.listAllPost();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newPost(@FormParam("userAccount") String account, @FormParam("messaje") String message) {
        post.addPost(account, message);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void removePost(@FormParam("userAccount") String account, @FormParam("message") String message) {
        post.deletePost(account, message);
    }
}
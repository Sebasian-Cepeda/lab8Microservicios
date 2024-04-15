package org.lab8.services.usuarios;

import org.lab8.config.MongoDB;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class User {
    private UserDto usuarios = new UserDto(MongoDB.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userAccoount}")
    public String getUser(@PathParam("userAccoount") String arroba) {
        return usuarios.getUser(arroba);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createUser(@FormParam("name") String nombre, @FormParam("email") String correo) {
        usuarios.addUser(nombre, correo);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void delUser(@FormParam("name") String nombre) {
        usuarios.deleteUser("@" + nombre);
    }
}
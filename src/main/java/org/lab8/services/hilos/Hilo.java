package org.lab8.services.hilos;

import org.lab8.config.MongoDB;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hilo")
public class Hilo {
    private HiloDto hilo = new HiloDto(MongoDB.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String obtenerHilo() {
        return hilo.obtenerHilo().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void agregarPost(@FormParam("arroba") String arroba, @FormParam("mensaje") String mensaje) {
        hilo.añadirPost(arroba, mensaje);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import models.Palinsesto;
import models.Palinsesto_Imp;

/**
 *
 * @author leonardo
 */
@Path("palinsesti")
public class PalinsestiRes {
        
    @GET
    @Produces("application/json")
    public Response getPalinsestiByDataOdierna(){
 
        return Response.ok("ritorna il palinsesto odierno di tutti i canali").build();
    }
    
    @GET
    @Produces("application/json")
    public Response getPalinsestiByData(){
 
        return Response.ok("ritorna il palinsesto di ogni canali per la data indicata").build();
    }

    
}

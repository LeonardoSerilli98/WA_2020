/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import models.Canale;
import models.Canale_Imp;

/**
 *
 * @author leonardo
 */
public class CanaleRes {
   
    public CanaleRes(){
        Canale c = new Canale_Imp();       
    }
    
    
    //esempio per GET /Canali/<singoloCanale>
    @GET
    @Produces("application/json")
    public  List<String> esempioSingoloCanale(){
        List<String> list = new ArrayList();
        list.add("singolo canale");
        
        return list;
    }
    
    @Path("provami")
    @GET
    @Produces("application/json")
    public  List<String> metodoProvami(
           @QueryParam("param") String param){
        List<String> list = new ArrayList();
        list.add("metodo provami" + param);
        
        return list;
    }
    
    
    @Path("uriInfoEsempio")
    @GET
    @Produces("application/json")
    public  Response esempioSingoloCanaleURL(
        @Context UriInfo uri){
        
         List<String> list = new ArrayList();
        
        //uso la variabile uriinfo che incorpora la url con la quale sono arrivato al metodo
        // posso costruitmi il path delle url a partire dalla uri di base
            //ad esempio posso prendere i path di altri metodi della classe
        
        URI url = uri.getBaseUriBuilder()           //l'uri di base è localhost/rest/canali/id
                .path(getClass())                   // aggiungo */Canali al path
                .path(getClass(), "metodoProvami")  //aggiungo il path indicato sopra il metodoProvami -/provami?param=?
                .build();                           //posso sostituire il parametro rimasto vuoto nell'uri direttamente dal build()
        
         Map<String, Object> e = new HashMap<>();
         e.put("url", url.toString());
        
        return Response.ok(e).build();
        
    }
            
    
    
}

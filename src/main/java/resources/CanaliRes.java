/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import authResources.Logged;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import models.Canale;
import models.Canale_Imp;
import models.Immagine_Imp;

/**
 *
 * @author leonardo
 */

//cosi ho mappato il path /rest/canale per la 'Root Resource': canale
@Path("canali")
public class CanaliRes {
    
    //la notazione '@produces' verra triggerata quando verra fatta una GET che richiede un json
        //prenderà l'output del metodo e lo trasformerà in json
    
    // Nota: poi ritorneremo solo risorse di tipo response anziche liste di stringhe
        //poiche con la sintassi 'Response.ok(<stringhe>).build()' ci ritorna anche lo status code
    @Logged
    @GET
    @Produces("application/json")
    public List<String> esempio(
            //api/canali?param1=asd
            @QueryParam("param1") String p1
            ){
 
        //esmpio di return
        List<String> list = new ArrayList();
        list.add("elemento1: " + p1);
      
        
        return list;
        
    }
    
    
    // Response è un oggetto specifico di JAXRS che permette di associare all'oggetto 
        // il codice di stato che ci interessa, non è proprio un oggetto ma un builder, quindi 
        //per costruire l'oggetto va chiamato il metodo build(),
        // posso anche aggiungere un header alla risposta .header("versione", "1.1").build()
    @Path("serializza")
    @GET
    @Produces("application/json")
    public Response esempioSerializzazione(){
        
        try{
            //esempio di return di un model serializzato
            if(false /* il canale esiste */ ){   
                Canale c = new Canale_Imp();
                c.setNome("canale5");
                c.setImmagine(new Immagine_Imp());
                c.getImmagine().setNome("img1");
                c.getImmagine().setTipo("asd");
                c.getImmagine().setTaglia(1024);

                return Response.ok(c).build();
            }else{

                // con response posso anche genereare dei messaggi di errore come 404,
                    // con associato messaggio
                   
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("il canale non esiste")
                        .build();
            }
        }catch(Exception e){
            
            // cone response posso gestire tutte le mie eccezzioni
                //notabene, le eccezzioni vanno tutte gestite, 
                //le uniche throwable sono quelle di tipo WebApplicationException 
                // che è una classe di JAXRS (vedi la classe RESTWebApplicatinException del prof)
                // dovremmo fare una classe del genere
            return Response.serverError()
                    .entity(e.getMessage())
                    .build();
            
            // ad esempio usando la classe del prof basta fare
            
            //return throw new RESTWebApplicationException(e);
            
            //cosi il costruttore crea l'eccezione e vene throwata
            
            
            
        }
        
        
    }

         
    @Path("esempioPost")
    @POST
    @Consumes("application/json")
    public Response esempioStore(@Context UriInfo uriinfo, Canale c ){
        
        return Response.ok(c).build();
      
    }
    
    
    //qui diamo il controllo all'item singolo canale, da asd in poi il match dei 
        //pattern saranno controllati nella classe 'CanaleRes', basta formatttare un metodo
        // del genere per passare il controllo ad altre classi risorsa 
    
    
    // /canali/id
    @Path("{id: [1-9]+}")
    public CanaleRes canaleRes(){
        return new CanaleRes();
    }
}

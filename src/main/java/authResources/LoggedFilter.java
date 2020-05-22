package authResources;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author didattica
 */
@Provider
@Logged
@Priority(Priorities.AUTHENTICATION)
public class LoggedFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        String token = null;
        
        //prendiamo il token 
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring("Bearer".length()).trim();
        } 
        
        if (token != null && !token.isEmpty()) {
            try {
                
                //validiamo il token
                String user = validateToken(token);
                
                if (user != null) {
                    //inseriamo nel contesto i risultati dell'autenticazione
                    //per farli usare dai nostri metodi restful
                    requestContext.setProperty("token", token);
                    requestContext.setProperty("user", user);
                    
                } else {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            } catch (Exception e) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        } else {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private String validateToken(String token) {
//      //JWT                
//        Key key = AppGlobals.getInstance().getJwtKey();
//      Jws<Claims> jwsc = Jwts.parser().setSigningKey(key).parseClaimsJws(token);

        return "pippo"; //andrebbe derivato dal token!
    }

}

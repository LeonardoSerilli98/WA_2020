/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import models.Immagine;

/**
 *
 * @author leonardo
 */
public class ImmagineSerializer extends StdSerializer<Immagine>{
    
    public ImmagineSerializer() {
        this(null);
    }

    public ImmagineSerializer(Class<Immagine> t) {
        super(t);
    }


    @Override
    public void serialize(Immagine t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        
        jg.writeStartObject();
        jg.writeObjectField("nome", t.getNome());
        jg.writeObjectField("tipo", t.getTipo());
        jg.writeNumberField("taglia", t.getTaglia());
        jg.writeEndObject();
    }
    
}

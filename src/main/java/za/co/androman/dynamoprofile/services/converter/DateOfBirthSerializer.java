package za.co.androman.dynamoprofile.services.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@JsonComponent
public class DateOfBirthSerializer extends StdSerializer<Date> {

    private static SimpleDateFormat formatter
      = new SimpleDateFormat("dd/MM/yyyy");

    public DateOfBirthSerializer() {
        this(null); 
    } 

    public DateOfBirthSerializer(Class<Date> t) {
        super(t); 
    }

    @Override
    public void serialize(
            Date value, JsonGenerator gen, SerializerProvider arg2)
      throws IOException, JsonProcessingException {
        gen.writeString(formatter.format(value));
    }
}
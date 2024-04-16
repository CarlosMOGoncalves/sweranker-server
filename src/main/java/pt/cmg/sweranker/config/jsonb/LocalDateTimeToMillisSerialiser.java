/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.config.jsonb;

import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

/**
 * This serialiser is used for converting LocalDateTime to Millis.
 * Normally, just using {@link JsonbDateFormat.TIME_IN_MILLIS} would be enough, but Yasson's default
 * writes LocalDateTime in millis as Strings and we used Longs...
 * <br>
 * Note that this effectively overrides the default Serializer so it pretty much disregards any additional
 * configuration in place, it just writes Dates as Longs
 * 
 * @author Carlos Gonçalves
 */
public class LocalDateTimeToMillisSerialiser implements JsonbSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime dateToSerialize, JsonGenerator generator, SerializationContext ctx) {

        if (dateToSerialize != null) {
            generator.write(dateToSerialize.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        } else {
            generator.write((String) null);
        }

    }

}

/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.config.jsonb;

import java.util.Locale;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * This is a Context Resolver that configures the JSONB feature globally.
 * 
 * @author Carlos Gonçalves
 */
@Provider
public class JSONBConfigurator implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class<?> type) {

        return JsonbBuilder.newBuilder()
            .withConfig(createConfiguration())
            .build();

    }

    private JsonbConfig createConfiguration() {
        return new JsonbConfig()
            .withSerializers(new DateToMillisSerialiser(), new LocalDateTimeToMillisSerialiser())
            .withNullValues(true)
            // The usage of this format is mainly because there is no need to write a deserializer for Dates, unlike the serializer
            .withDateFormat(JsonbDateFormat.TIME_IN_MILLIS, Locale.getDefault());
    }

}

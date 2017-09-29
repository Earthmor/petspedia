package ru.petshopedia.common.utils;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat dateFormatLong = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String formattedDate = dateFormatLong.format(date);
            jsonGenerator.writeString(formattedDate);
    }

}

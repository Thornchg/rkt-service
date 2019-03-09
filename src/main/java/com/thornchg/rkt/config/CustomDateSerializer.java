package com.thornchg.rkt.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CustomDateSerializer extends JsonSerializer {
    public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(format.format(o));
    }
}

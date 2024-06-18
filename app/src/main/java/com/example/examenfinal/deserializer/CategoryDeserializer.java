package com.example.examenfinal.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class CategoryDeserializer implements JsonDeserializer<String> {

    // Deserializar el JSON para obtener el nombre de la categoría del Pokémon
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return json.getAsJsonObject().get("name").getAsString();
    }
}
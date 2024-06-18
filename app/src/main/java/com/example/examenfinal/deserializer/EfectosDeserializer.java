package com.example.examenfinal.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class EfectosDeserializer implements JsonDeserializer<String> {

    // Deserializar el JSON para obtener los efectos de la habilidad del Pokémon

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        StringBuilder str = new StringBuilder();
        JsonArray array = json.getAsJsonArray();

        for (JsonElement element : array) {
            str.append(element.getAsJsonObject().get("short_effect").getAsString());
        }

        return str.toString();
    }
}
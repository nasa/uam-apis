package com.uss.validationtests.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class Utils {
    private static final Gson GSON = new Gson();
    public static <T> T jsonToPojo(String json, Class<T> classOfT) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, classOfT);
    }

    public static <T> String pojoToJson(T object) {
        return GSON.toJson(object);
    }

    public static <T> T jsonToPojoGson(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

}

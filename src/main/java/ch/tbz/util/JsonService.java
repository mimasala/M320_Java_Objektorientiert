package ch.tbz.util;

import ch.tbz.generic.AbstractEntity;
import com.google.gson.Gson;

public class JsonService<T extends AbstractEntity> {
    public T read(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

    public String write(T object) {
        return new Gson().toJson(object);
    }
}

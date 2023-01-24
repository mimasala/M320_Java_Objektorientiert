package ch.tbz.util;

import ch.tbz.generic.AbstractEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonService<T extends AbstractEntity> {
    public T read(String json) {
        Type type = new TypeToken<T>() {}.getType();
        return new Gson().fromJson(json, type);
    }
    public List<T> readList(String json) {
        Type listType = new TypeToken<ArrayList<T>>(){}.getType();
        return new Gson().fromJson(json, listType);
    }

    public String write(T object) {
        return new Gson().toJson(object);
    }
}

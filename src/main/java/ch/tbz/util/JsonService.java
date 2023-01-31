package ch.tbz.util;

import ch.tbz.generic.AbstractEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Json Service
 * @author mytal
 * @version 1.0.0
 */
public class JsonService {

    public <I extends AbstractEntity> String toJson(I entity) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(entity);
    }
    public <I extends AbstractEntity> String listToPrettyJson(List<I> entity) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(entity);
    }
    public <I extends AbstractEntity> I fromJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }
    public <I extends AbstractEntity> List<I> fromJsonList(String json) {
        Type listType = new TypeToken<ArrayList<I>>(){}.getType();
        return new Gson().fromJson(json, listType);
    }
}

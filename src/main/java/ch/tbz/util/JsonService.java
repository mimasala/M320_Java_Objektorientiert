package ch.tbz.util;

import ch.tbz.generic.AbstractEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonService {

    public <I extends AbstractEntity> String toJson(I entity) {
        return new Gson().toJson(entity);
    }
    public <I extends AbstractEntity> I fromJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }
    public <I extends AbstractEntity> List<I> fromJsonList(String json) {
        Type listType = new TypeToken<ArrayList<I>>(){}.getType();
        return new Gson().fromJson(json, listType);
    }
}

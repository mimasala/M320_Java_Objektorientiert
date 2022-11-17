package ch.tbz.beatmap;


import ch.tbz.api.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BeatmapService {
    ApiService apiService = new ApiService();

    public List<Beatmap> findBeatmap(String title) {
        String response = apiService.getResponse(
                String.format("https://osusearch.com/query/?title=%s&offset=0", URLEncoder.encode(title, StandardCharsets.UTF_8)));
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        response = jsonObject.get("beatmaps").toString();
        Type beatmapListType = new com.google.gson.reflect.TypeToken<List<Beatmap>>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(
                response, beatmapListType);
    }
}

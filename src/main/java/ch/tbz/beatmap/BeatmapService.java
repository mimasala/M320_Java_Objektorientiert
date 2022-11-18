package ch.tbz.beatmap;


import ch.tbz.helpers.ApiService;
import ch.tbz.log.OsuLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BeatmapService {
    private final OsuLog log = new OsuLog();
    private final ApiService apiService = new ApiService();

    public List<Beatmap> searchBeatmap(String title) {
        String response = apiService.getResponse(
                String.format("https://osusearch.com/query/?title=%s&offset=0", URLEncoder.encode(title, StandardCharsets.UTF_8)));
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        response = jsonObject.get("beatmaps").toString();
        Type beatmapListType = new com.google.gson.reflect.TypeToken<List<Beatmap>>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(
                response, beatmapListType);
    }
    public void printBeatmap(List<Beatmap> beatmaps) {
        log.info(new GsonBuilder().setPrettyPrinting().create().toJson(beatmaps));
    }
}

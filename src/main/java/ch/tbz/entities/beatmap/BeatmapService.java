package ch.tbz.entities.beatmap;


import ch.tbz.data.BeatmapDB;
import ch.tbz.entities.CrudOperations;
import ch.tbz.exception.BeatmapNotFoundException;
import ch.tbz.helpers.ApiService;
import ch.tbz.log.OsuLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static ch.tbz.Program.beatmapDB;

public class BeatmapService implements CrudOperations<Beatmap, Integer > {
    private final ApiService apiService = new ApiService();

    public List<Beatmap> searchBeatmap(String title, Charset charset) throws BeatmapNotFoundException {
        String response = apiService.getResponse(
                String.format("https://osusearch.com/query/?title=%s&offset=0", URLEncoder.encode(title, charset)));
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        response = jsonObject.get("beatmaps").toString();
        Type beatmapListType = new com.google.gson.reflect.TypeToken<List<Beatmap>>(){}.getType();
        Gson gson = new Gson();
        List<Beatmap> beatmapList = gson.fromJson(response, beatmapListType);

        if (beatmapList.isEmpty()) {
            throw new BeatmapNotFoundException("Beatmap not found: ", title);
        }
        return beatmapList;
    }

    public List<Beatmap> searchBeatmap(String title) throws BeatmapNotFoundException{
        return searchBeatmap(title, StandardCharsets.UTF_8);
    }
    public void addBeatmaps(String title) throws BeatmapNotFoundException {
        beatmapDB.addAll(searchBeatmap("title"));
    }
    public void printBeatmap(List<Beatmap> beatmaps) {
        OsuLog.info(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(beatmaps));
    }
    public Beatmap beatmapFromJsonString(String json){
        return new Gson().fromJson(json, Beatmap.class);
    }

    public void saveBeatmapFromJsonString(String json){
        save(beatmapFromJsonString(json));
    }

    public void saveAllBeatmapsFromJsonString(String jsonArray){
        Type userListType = new TypeToken<ArrayList<Beatmap>>(){}.getType();
        saveAll(new Gson().fromJson(jsonArray, userListType));
    }
    public Beatmap updateBeatmapFromJsonString(String json, Integer id){
        Beatmap beatmap = beatmapFromJsonString(json);
        throw new RuntimeException("not implemented");
    }

    @Override
    public List<Beatmap> getAll() {
        return beatmapDB;
    }

    @Override
    public Beatmap get(Integer integer) {
        return beatmapDB.get(integer);
    }

    @Override
    public void save(Beatmap beatmap) {
        beatmapDB.add(beatmap);
    }

    @Override
    public void saveAll(List<Beatmap> beatmaps) {
        beatmapDB.addAll(beatmaps);
    }

    @Override
    public void update(Integer id, Beatmap beatmap) {
        beatmapDB.set(id, beatmap);
    }

    @Override
    public void delete(Integer integer) {
        beatmapDB.remove(beatmapDB.get(integer));
    }
}

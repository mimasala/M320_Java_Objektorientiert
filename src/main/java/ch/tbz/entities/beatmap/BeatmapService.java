package ch.tbz.entities.beatmap;


import ch.tbz.entities.CrudOperations;
import ch.tbz.exception.BeatmapNotFoundException;
import ch.tbz.helpers.ApiService;
import ch.tbz.log.OsuLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

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

    private String beatmapListToPrettyJsonArray(List<Beatmap> beatmapList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(beatmapList);
    }

    public String searchBeatmap(String title){
        try {
            return beatmapListToPrettyJsonArray(searchBeatmap(title, StandardCharsets.UTF_8));
        }catch (BeatmapNotFoundException e){
            OsuLog.error(e.getMessage());
        }
        return null;
    }
    public void addBeatmaps(String title) {
        try {
            beatmapDB.addAll(searchBeatmap(title, StandardCharsets.UTF_8));
        } catch (BeatmapNotFoundException e) {
            OsuLog.error(e.getMessage());
        }
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

    public Beatmap updateBeatmapFromJsonString(String json, Integer id){
        Beatmap beatmap = beatmapFromJsonString(json);
        return beatmapDB.set(id, beatmap);
    }

    public void deleteBeatmapByTitle(String title){
        beatmapDB.removeIf(x -> x.getTitle().toLowerCase(Locale.ROOT)
                .contains(title.toLowerCase(Locale.ROOT)));
    }

    @Override
    public List<Beatmap> getAll() {
        return beatmapDB;
    }

    @Override
    public Beatmap get(Integer integer) {
        try {
            return beatmapDB.get(integer);
        }catch (IndexOutOfBoundsException e){
            OsuLog.error("Beatmap not found: " + integer);
        }
        return new Beatmap();
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

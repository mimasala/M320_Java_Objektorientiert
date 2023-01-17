package ch.tbz.entities.beatmap;


import ch.tbz.data.BeatmapDB;
import ch.tbz.entities.BaseOperations;
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
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static ch.tbz.Program.beatmapDB;

public class BeatmapService implements CrudOperations<Beatmap, Integer >, BaseOperations {
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

    public void bubbleSortBeatmaps() {
        BeatmapDB beatmaps = beatmapDB;
        boolean swapped;
        for (int i = 0; i < beatmaps.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < beatmaps.size() - i - 1; j++) {
                if (beatmaps.get(j).getTitle().compareTo(beatmaps.get(j + 1).getTitle()) > 0) {
                    // swap array[j] and array[j+1]
                    Beatmap temp = beatmaps.get(j);
                    beatmaps.set(j, beatmaps.get(j + 1));
                    beatmaps.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        beatmapDB = beatmaps;
    }

    public void bubbleSortBeatmapsDesc() {
        bubbleSortBeatmaps();
        Collections.reverse(beatmapDB);
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

    @Override
    public void sortList() {
        Collections.sort(beatmapDB);
    }
}

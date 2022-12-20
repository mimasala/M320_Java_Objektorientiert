package ch.tbz.beatmap;


import ch.tbz.exception.BeatmapNotFoundException;
import ch.tbz.helpers.ApiService;
import ch.tbz.log.OsuLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
/**
 * contains logic for beatmap
 * @author mytal, joelsow
 * @version 1.0.0
 */
public class BeatmapService {
    private final OsuLog log = new OsuLog();
    private final ApiService apiService = new ApiService();

    /**
     * @param title of the song you're searching for
     * @return the list of found beatmaps, that match the param
     * @throws BeatmapNotFoundException if no beatmap of the given title was found.
     */
    public List<Beatmap> searchBeatmap(String title) throws BeatmapNotFoundException {
        String response = apiService.getResponse(
                String.format("https://osusearch.com/query/?title=%s&offset=0", URLEncoder.encode(title, StandardCharsets.UTF_8)));
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
    public void printBeatmap(List<Beatmap> beatmaps) {
        log.info(new GsonBuilder().setPrettyPrinting().create().toJson(beatmaps));
    }
}

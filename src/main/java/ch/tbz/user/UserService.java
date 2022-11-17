package ch.tbz.user;


import ch.tbz.api.ApiService;
import ch.tbz.beatmap.Beatmap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserService {
    ApiService apiService = new ApiService();
    public boolean findUser(String name) {

        String response = apiService.getResponse(
                String.format("https://osu.ppy.sh/api/v2/users/%s/osu", URLEncoder.encode(name, StandardCharsets.UTF_8)));
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        //TODO
        return false;
    }
}

package ch.tbz;

import ch.tbz.beatmap.BeatmapService;
import ch.tbz.user.UserService;

public class Menu {
    BeatmapService beatmapService = new BeatmapService();
    UserService userService = new UserService();

    public void run(String[] args) {
        System.out.println(beatmapService.findBeatmap("kimi no shiranai monogatari"));
        System.out.println(userService.findUser("Rafis"));
    }
}

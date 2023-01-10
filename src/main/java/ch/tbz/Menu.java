package ch.tbz;

import ch.tbz.entities.beatmap.BeatmapService;
import ch.tbz.entities.user.UserService;
import ch.tbz.exception.UserNotFoundException;
import ch.tbz.helpers.InputService;


public class Menu {
    BeatmapService beatmapService = new BeatmapService();
    UserService userService = new UserService();

    public Menu run() {
        throw new RuntimeException("not implemented");
    }
}

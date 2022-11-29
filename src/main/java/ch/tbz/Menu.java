package ch.tbz;

import ch.tbz.beatmap.BeatmapService;
import ch.tbz.exception.BeatmapNotFoundException;
import ch.tbz.exception.UserNotFoundException;
import ch.tbz.log.OsuLog;
import ch.tbz.user.UserService;


public class Menu {
    BeatmapService beatmapService = new BeatmapService();
    UserService userService = new UserService();
    OsuLog log = new OsuLog();

    public void run() {
        String selection = "0";
        while (!selection.equals("3")) {
            log.debug("Welcome to osu!Search");
            log.debug("1. Search Beatmap");
            log.debug("2. User");
            log.debug("3. Exit");
            selection = InputService.getString("Enter your selection: ");
            switch (selection) {
                case "1" -> findBeatmap();
                case "2" -> {
                    log.debug("1. get all Users");
                    log.debug("2. inspect User");
                    String userSelection = InputService.getString("Enter your selection: ");
                    switch (userSelection) {
                        case "1" -> userService.printUser(userService.getUserDB());
                        case "2" -> findUser();
                        default -> log.error("Invalid selection");
                    }
                }
                case "3" -> log.debug("Goodbye!");
                default -> log.error("Invalid selection!");
            }
        }
    }
    
    void findUser(){
        try {
            String name = InputService.getString("Enter the name of the user: ");
            userService.printUser(userService.findUser(name));
        }catch (UserNotFoundException e){
            log.error(e.getMessage());
        }
    }
    void findBeatmap(){
        try {
            String title = InputService.getString("Enter the title of the beatmap: ");
            beatmapService.printBeatmap(beatmapService.searchBeatmap(title));
        }catch (BeatmapNotFoundException e){
            log.error(e.getMessage());
        }
    }
}

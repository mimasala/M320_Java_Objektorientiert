package ch.tbz;

import ch.tbz.beatmap.BeatmapService;
import ch.tbz.helpers.InputService;
import ch.tbz.user.UserService;


public class Menu {
    BeatmapService beatmapService = new BeatmapService();
    UserService userService = new UserService();

    public void run() {
        String selection = "0";
        while (!selection.equals("3")) {
            System.out.println("Welcome to osu!Search");
            System.out.println("1. Search Beatmap");
            System.out.println("2. User");
            System.out.println("3. Exit");
            selection = InputService.getString("Enter your selection: ");
            switch (selection) {
                case "1" -> {
                    String title = InputService.getString("Enter the title of the beatmap: ");
                    beatmapService.printBeatmap(beatmapService.searchBeatmap(title));
                }
                case "2" -> {
                    System.out.println("1. get all Users");
                    System.out.println("2. inspect User");
                    String userSelection = InputService.getString("Enter your selection: ");
                    switch (userSelection) {
                        case "1" -> userService.printUser(userService.getUserDB());
                        case "2" -> {
                            String name = InputService.getString("Enter the name of the user: ");
                            userService.printUser(userService.findUser(name));
                        }
                        default -> System.err.println("Invalid selection");
                    }
                }
                case "3" -> System.out.println("Goodbye!");
                default -> System.err.println("Invalid selection!");
            }
        }
    }
}

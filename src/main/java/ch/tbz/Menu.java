package ch.tbz;

import ch.tbz.entities.beatmap.BeatmapService;
import ch.tbz.entities.user.UserService;
import ch.tbz.exception.UserNotFoundException;
import ch.tbz.helpers.InputService;


public class Menu {
    BeatmapService beatmapService = new BeatmapService();
    UserService userService = new UserService();

    public Menu run() {
        String selection = "0";
        while (!selection.equals("3")) {
            System.out.println("Welcome to osu!Search");
            System.out.println("1. Search Beatmap");
            System.out.println("2. User");
            System.out.println("3. Exit");
            selection = InputService.getString("Enter your selection: ");
            switch (selection) {
                case "1" -> searchBeatmap();
                case "2" -> {
                    System.out.println("1. get all Users");
                    System.out.println("2. inspect User");
                    String userSelection = InputService.getString("Enter your selection: ");
                    switch (userSelection) {
                        case "1" -> userService.printUsers(userService.getAllUsers());
                        case "2" -> searchUser();
                        default -> System.err.println("Invalid selection");
                    }
                }
                case "3" -> System.out.println("Goodbye!");
                default -> System.err.println("Invalid selection!");
            }
        }
        return this;
    }

    void searchBeatmap(){
        try{
            String title = InputService.getString("Enter the title of the beatmap: ");
            beatmapService.printBeatmap(beatmapService.searchBeatmap(title));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    void searchUser(){
        try{
            String name = InputService.getString("Enter the name of the user: ");
            userService.printUsers(userService.getByName(name));
        } catch (UserNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}

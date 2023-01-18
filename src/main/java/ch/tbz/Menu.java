package ch.tbz;

import ch.tbz.TUI.BeatmapTUI;
import ch.tbz.TUI.UserTUI;
import ch.tbz.helpers.InputService;


public class Menu {
    BeatmapTUI beatmapTUI = new BeatmapTUI("beatmap");
    UserTUI userTUI = new UserTUI("user");

    public Menu run() {
        boolean running = true;
        System.out.println("Welcome to the osu! database!");
        do {
            System.out.println("Please select an option:");
            System.out.println("1: beatmaps");
            System.out.println("2: users");
            System.out.println("3: exit ");
            int option = InputService.getNum();
            switch (option) {
                case 1 -> beatmapTUI.startMenu();
                case 2 -> userTUI.startMenu();
                case 3 -> {
                    running = false;
                }
            }
        }while (running);
        System.out.println("Goodbye!");
        return this;
    }
}

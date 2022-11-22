package ch.tbz;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        String mainTemplate = getResourceFileAsString("main.txt");

        boolean running = true;
        do {
            System.out.println(mainTemplate);
            switch (getInput()) {
                case "1" -> user();
                case "2" -> beatmap();
                default -> System.out.println("Invalid input");
            }
            System.out.println("again? (y/n)");
            if(getInput().equals("n")){
                running = false;
            }
        }while (running);
    }
    void beatmap(){
        String beatmapTemplate = getResourceFileAsString("beatmap_options.txt");
        System.out.println(beatmapTemplate);
        switch (getInput()) {
            case "1" -> listAllBeatmaps();
            case "2" -> findInMap(getAllBeatmaps());
            default -> System.out.println("Invalid input");
        }
    }
    void user(){
        String userTemplate = getResourceFileAsString("user_options.txt");
        System.out.println(userTemplate);
        switch (getInput()) {
            case "1" -> listAllUsers();
            case "2" -> findInMap(getAllUsers());
            default -> System.out.println("Invalid input");
        }
    }

    static String getResourceFileAsString(String fileName) {
        try {
            return Resources.toString(Resources.getResource(fileName), Charsets.UTF_8);
        }catch (Exception e){
            System.out.println("could not find resource file: " + fileName);
            e.printStackTrace();
        }
        return null;
    }
    void listAllBeatmaps(){
        Jinjava jinjava = new Jinjava();
        StringBuilder sb = new StringBuilder();
        getAllBeatmaps().forEach((key,beatmap) -> sb.append(" - ").append(key).append(": ").append(beatmap).append("\n"));
        Map<String, Object> context = new HashMap<>();
        context.put("list", sb.toString());
        System.out.println(jinjava.render(getResourceFileAsString("listAll.txt"), context));
    }
    void listAllUsers(){
        Jinjava jinjava = new Jinjava();
        StringBuilder sb = new StringBuilder();
        getAllUsers().forEach((key,user) -> sb.append(" - ").append(key).append(": ").append(user).append("\n"));
        Map<String, Object> context = new HashMap<>();
        context.put("list", sb.toString());
        System.out.println(jinjava.render(getResourceFileAsString("listAll.txt"), context));
    }

    static Map<Integer,String> getAllUsers() {
        Map<Integer,String> Users = new HashMap<>();
        Users.put(1, "User 1");
        Users.put(2, "User 2");
        Users.put(3, "User 3");
        Users.put(4, "User 4");
        Users.put(5, "User 5");
        Users.put(6, "User 6");
        Users.put(7, "User 7");
        Users.put(8, "User 8");
        Users.put(9, "User 9");
        return Users;
    }
    static Map<Integer,String> getAllBeatmaps() {
        Map<Integer,String> beatmaps = new HashMap<>();
        beatmaps.put(1, "Beatmap 1");
        beatmaps.put(2, "Beatmap 2");
        beatmaps.put(3, "Beatmap 3");
        beatmaps.put(4, "Beatmap 4");
        beatmaps.put(5, "Beatmap 5");
        beatmaps.put(6, "Beatmap 6");
        beatmaps.put(7, "Beatmap 7");
        beatmaps.put(8, "Beatmap 8");
        beatmaps.put(9, "Beatmap 9");
        return beatmaps;
    }
    public String getInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    void findInMap(Map<Integer,String> map){
        System.out.println("Enter search term");
        String searchTerm = getInput();
        map.forEach((key,value) -> {
            if(value.contains(searchTerm)){
                System.out.println(key + ": " + value);
            }
        });
    }

}

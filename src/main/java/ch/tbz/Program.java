package ch.tbz;

import ch.tbz.data.BeatmapDB;
import ch.tbz.data.UserDB;
import ch.tbz.helpers.FakerService;

public class Program {
    public static UserDB userDB = new UserDB(FakerService.createUserDataBase(100));
    public static BeatmapDB beatmapDB = new BeatmapDB();
    public static void main(String[] args) {
        Menu menu = new Menu().run();
    }
}

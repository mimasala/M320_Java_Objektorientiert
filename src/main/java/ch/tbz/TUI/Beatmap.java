package ch.tbz.TUI;

public class Beatmap extends TUI {
    public Beatmap(String name) {
        super(name);
    }

    @Override
    void startMenu() {
        System.out.println(mainScreen);
    }
}

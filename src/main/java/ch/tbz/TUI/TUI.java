package ch.tbz.TUI;

import ch.tbz.helpers.InputService;

public abstract class TUI{
    public String mainScreen;

    public TUI(String name){
        this.mainScreen = InputService.getResourceAsString(name);
    }
    abstract void startMenu();
}

package ch.tbz;

import ch.tbz.gui.MainPage;
import ch.tbz.util.API;
import ch.tbz.util.PropertiesLoader;

import java.util.Properties;

public class Main {
    public static API api;
    private Properties properties;

    public Main() {
        this.properties = PropertiesLoader.loadProperties();
        api = new API(properties.getProperty("backend.url"));
    }

    public static void main(String[] args) {
        new Main();
        MainPage mainPage = new MainPage();
    }
}

package ch.tbz;

import ch.tbz.gui.MainPage;
import ch.tbz.util.API;
import ch.tbz.util.PropertiesLoader;

import java.util.Properties;

public class Main {
    private static API api;
    private Properties properties;

    public Main() {
        this.properties = PropertiesLoader.loadProperties();
        api = new API(properties.getProperty("api.url"));
    }

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
    }
}

package ch.tbz;

import ch.tbz.gui.MainPage;
import ch.tbz.util.API;
import ch.tbz.util.PropertiesLoader;

import java.util.Properties;
import java.util.UUID;

/**
 * Main
 * @author mytal
 * @version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();

    }
    public static Properties getSystemProperties() {
        return PropertiesLoader.loadProperties();
    }
}

package ch.tbz;

import ch.tbz.gui.MainPage;
import ch.tbz.util.API;
import ch.tbz.util.PropertiesLoader;

import java.util.Properties;
import java.util.UUID;


public class Main {

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
//        System.out.println(UUID.randomUUID());
    }
    public static Properties getSystemProperties() {
        return PropertiesLoader.loadProperties();
    }
}

package ch.tbz.util;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class OsuLog {
    private static final Logger logger = Logger.getLogger(OsuLog.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("application.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize file logger.", e);
        }
    }

    public static void log(Level level, String message) {
        logger.log(level, message);
    }
}

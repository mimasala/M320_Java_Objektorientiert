package ch.tbz.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OsuLog {
    public void debug(String logging) {
        System.out.println(("\u001B[34m" + logging + "\u001B[0m"));
    }
    public void error(String logging) {
        System.out.println(("\u001B[31m" + logging + "\u001B[0m"));
    }

    public void info(String logging) {
        System.out.println(("\u001B[32m" + logging + "\u001B[0m"));
    }
}

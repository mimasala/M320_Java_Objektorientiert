package ch.tbz.log;
/**
 * class to print text with colors
 * @author mytal, joelsow
 * @version 1.0.0
 */
public class OsuLog {
    /**
     * @param logging string to log
     */
    public void debug(String logging) {
        System.out.println(("\u001B[34m" + logging + "\u001B[0m"));
    }
    /**
     * @param logging string to log
     */
    public void error(String logging) {
        System.out.println(("\u001B[31m" + logging + "\u001B[0m"));
    }

    /**
     * @param logging string to log
     */
    public void info(String logging) {
        System.out.println(("\u001B[32m" + logging + "\u001B[0m"));
    }
}

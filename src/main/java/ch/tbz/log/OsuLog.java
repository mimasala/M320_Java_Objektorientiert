package ch.tbz.log;

public class OsuLog {
    public static void debug(String logging) {
        System.out.println(("\u001B[34m" + logging + "\u001B[0m"));
    }
    public static void error(String logging) {
        System.out.println(("\u001B[31m" + logging + "\u001B[0m"));
    }
    public static void info(String logging) {
        System.out.println(("\u001B[32m" + logging + "\u001B[0m"));
    }
}

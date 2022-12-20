package ch.tbz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author mytal, joelsow
 * @version 1.0.0
 */
public class InputService {
    /**
     * @param message message to be printed before reading input
     * @return the string read
     */
    public static String getString(String message) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

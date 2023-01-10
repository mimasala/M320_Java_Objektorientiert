package ch.tbz.helpers;

import ch.tbz.log.OsuLog;
import com.google.common.io.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class InputService {
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

    public static String getResourceAsString(String name){
        try{
            URL url = Resources.getResource(name);
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            OsuLog.error(e.getMessage());
        }
        return null;
    }
}

package ch.tbz.helpers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 * @author mytal, joelsow
 * @version 1.0.0
 */
public class ApiService {
    /**
     * @param url url
     * @return response json
     */
    public String getResponse(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient().send(
                            request,
                            HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

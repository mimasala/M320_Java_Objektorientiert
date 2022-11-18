package ch.tbz.helpers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
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

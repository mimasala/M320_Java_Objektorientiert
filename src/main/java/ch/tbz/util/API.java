package ch.tbz.util;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;

import java.io.IOException;

public class API {
    private final HttpRequestFactory requestFactory;
    private final String baseUrl;
    private final Gson gson;

    public API(String baseUrl) {
        HttpTransport httpTransport = new NetHttpTransport();
        this.requestFactory = httpTransport.createRequestFactory(request -> {
            request.setConnectTimeout(60000);
            request.setReadTimeout(60000);
        });
        this.baseUrl = baseUrl;
        this.gson = new Gson();
    }

    public String get(String endpoint) throws IOException {
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(baseUrl + endpoint));
        HttpResponse response = request.execute();
        // do something with the response
        return response.parseAsString();
    }

    public String post(String endpoint, Object data) throws IOException {
        String json = gson.toJson(data);
        HttpContent content = new UrlEncodedContent(json);
        HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(baseUrl + endpoint), content);
        HttpResponse response = request.execute();
        // do something with the response
        return response.parseAsString();
    }
}

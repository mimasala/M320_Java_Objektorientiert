package ch.tbz.util;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter@Setter
public class API {
    @Setter(AccessLevel.NONE)
    private final HttpRequestFactory requestFactory;
    @Setter(AccessLevel.NONE)
    private final Gson gson;
    private String baseUrl;

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
        return requestFactory.buildGetRequest(
                new GenericUrl(baseUrl + endpoint))
                .execute().parseAsString();
    }
    public String delete(String endpoint) throws IOException {
        return requestFactory.buildDeleteRequest(
                new GenericUrl(baseUrl + endpoint))
                .execute().parseAsString();
    }
    public String post(String endpoint, Object body) throws IOException {
        return requestFactory.buildPostRequest(
                new GenericUrl(baseUrl + endpoint),
                new ByteArrayContent("application/json", gson.toJson(body).getBytes()))
                .execute().parseAsString();
    }
    public String put(String endpoint, Object body) throws IOException {
        return requestFactory.buildPutRequest(
                new GenericUrl(baseUrl + endpoint),
                new ByteArrayContent("application/json", gson.toJson(body).getBytes()))
                .execute().parseAsString();
    }
}

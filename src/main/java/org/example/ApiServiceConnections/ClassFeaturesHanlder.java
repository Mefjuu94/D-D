package org.example.ApiServiceConnections;

import org.example.Main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassFeaturesHanlder {

    private final HttpClient client;

    public ClassFeaturesHanlder(HttpClient client) {
        this.client = client;
    }

    public HttpResponse<String> getClassFeatures(int index) {
        if (index > 12){
            System.out.println("index out of bounds! Index > 12");
            return null;
        }
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(ApiConnectionConstans.URL + ApiConnectionConstans.classes[index] + "/levels/1/features")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response;
            }
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

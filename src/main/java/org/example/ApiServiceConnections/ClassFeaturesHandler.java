package org.example.ApiServiceConnections;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassFeaturesHandler {

    private final HttpClient client;

    public ClassFeaturesHandler(HttpClient client) {
        this.client = client;
    }

    public HttpResponse<String> getClassFeatures(int index) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[index] + "/levels/1/features")).GET().build();
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

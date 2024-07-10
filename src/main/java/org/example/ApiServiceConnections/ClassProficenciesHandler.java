package org.example.ApiServiceConnections;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassProficenciesHandler {

    private final HttpClient client;

    public ClassProficenciesHandler(HttpClient client) {
        this.client = client;
    }

    public HttpResponse<String> getProficiencies(int index) {
        String URLProficences = "https://www.dnd5eapi.co/api/races/";
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URLProficences + ApiConnectionConstans.races[index] + "/proficiencies")).GET().build();
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

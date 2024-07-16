package org.example.ApiServiceConnections;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RaceInformationHandler {
    private final HttpClient client;

    public RaceInformationHandler(HttpClient client) {
        this.client = client;
    }

    public HttpResponse<String> getRaceInformation(int index) {
        String URLraces = "https://www.dnd5eapi.co/api/races/";
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URLraces + ApiConnectionConstants.RACES[index])).GET().build();
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

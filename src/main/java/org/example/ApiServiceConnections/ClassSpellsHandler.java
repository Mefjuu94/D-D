package org.example.ApiServiceConnections;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassSpellsHandler {

    private final HttpClient client;

    public ClassSpellsHandler(HttpClient client) {
        this.client = client;
    }

    public HttpResponse<String> getClassSpells(int index) {
        //(https://www.dnd5eapi.co/api/classes/:index/levels/:spell_level/spells
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[index] + "/levels/" + 1 + "/spells")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            if (response.statusCode() == 200) {
                return response;
            }
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

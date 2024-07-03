package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Service {

    private final String URL = "https://www.dnd5eapi.co/api/classes/";
    private final HttpClient client;

    private final String[] classes = {"barbarian", "bard", "cleric", "druid", "fighter", "monk", "paladin", "ranger", "rogue", "sorcerer", "warlock", "wizard"};

    public Service(HttpClient client) {
        this.client = client;
    }


    public HttpResponse<String> getClassInformation(int index){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URL + classes[index] + "/levels/1")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return response;
            }
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getClassInformation(String index){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URL + index + "/levels/1")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return response;
            }
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    //////////////////////////////////////////////////////////////////////////


    //    public HttpResponse<String> getClassResources(){
//
//    }
    //    public HttpResponse<String> getClassFeatures(){
//
//    }

    public HttpResponse<String> getClassSpells(String index){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URL + index + "/levels/1/spells")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return response;
            }
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getClassSpells(int index){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URL + classes[index] + "/levels/1/spells")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return response;
            }
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    /////////////////////////////////////////////////////////////////////

//    public HttpResponse<String> getProficiencies(){
//
//    }
//    public HttpResponse<String> getRaceInformation(){
//
//    }

}

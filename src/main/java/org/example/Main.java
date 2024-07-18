package org.example;

import org.example.ApiServiceConnections.*;
import org.example.Character.*;
import org.example.Character.Mappers.MapCharacterClass;
import org.example.Character.Mappers.MapFeatures;
import org.example.Character.Mappers.MapRace;
import org.example.Character.Mappers.MapSpells;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        //features zwraca ArrayList<feature>

//        ClassResourcesHandler ch = new ClassResourcesHandler(HttpClient.newHttpClient());
//        String response = ch.getClassResources(5).body();
//
//        System.out.println(response);


        ClassFeaturesHandler ch = new ClassFeaturesHandler(HttpClient.newHttpClient());
        String response = ch.getClassFeatures(5).body();
        MapFeatures mf = new MapFeatures();
       ;

        System.out.println( mf.mapClassFeatures(response));





    }
}
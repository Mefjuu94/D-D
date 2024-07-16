package org.example;

import org.example.ApiServiceConnections.ClassFeaturesHanlder;
import org.example.ApiServiceConnections.ClassResourcesHandler;
import org.example.ApiServiceConnections.ClassSpellsHandler;
import org.example.ApiServiceConnections.RaceInformationHandler;
import org.example.Character.*;
import org.example.Character.Character;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        //features zwraca ArrayList<feature>

//        ClassSpellsHandler ch = new ClassSpellsHandler(HttpClient.newHttpClient());
//        String response = ch.getClassSpells(1).body();
//        JSONMapper mapper = new JSONMapper();
//        //System.out.println(response);
//
//        RaceInformationHandler raceInformationHandler = new RaceInformationHandler(HttpClient.newHttpClient());
//
//        Race race = mapper.mapRace(raceInformationHandler.getRaceInformation(2).body());
//        ArrayList<Feature> f = mapper.mapClassFeatures(response);
//        ArrayList<Spell> spells = mapper.mapClassSpells(response);
//
//
//
//
//
//        Character character = new Character("Mefju",race,"lol nie ma",f,null,spells,race.getLanguages(),race.getProficiencies());
//
//        System.out.println(character);


        ClassResourcesHandler crh = new ClassResourcesHandler(HttpClient.newHttpClient());
        System.out.println(crh.getClassResources(1).body());

        //System.out.println(race.toString());



    }
}
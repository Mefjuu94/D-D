package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {


        Service service = new Service(HttpClient.newHttpClient());


        System.out.println(service.getClassSpells(1).body());

    }
}
package org.example;

import org.example.ApiServiceConnections.*;


import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RaceInformationHandler cfh = new RaceInformationHandler(HttpClient.newHttpClient());
        String jeden = cfh.getRaceInformation(8).body();
        //JSONMapper mapper = new JSONMapper();


//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        if (onlyDigits(input,input.length())){
//
//        }

        System.out.println(jeden);
        //System.out.println(mapper.map(jeden).toString());


    }

    public static boolean onlyDigits(String str, int n) {
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
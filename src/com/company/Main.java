package com.company;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        FileWriter outFile = new FileWriter("testfile.json");
        String test = "";
        System.out.println("Hello World");
        Scanner reader  = new Scanner (System.in);
        System.out.println("Give me ONE stock name: ");
        test = reader.nextLine();
        outFile.write(test); // write to file
        outFile.close();

        Scanner scanner = new Scanner (new FileReader ("testfile.json"));
        System.out.println("The stock you are looking for is " + test);
        System.out.println("Saved your result to JSON FILE.");

        String test2 = scanner.nextLine(); //read from file
        scanner.close();

        System.out.println("This is what I got from the file: " + test2);

        URL finnhub = new URL("https://finnhub.io/api/v1/search?q=" + test2 + "&token=c5egnaaad3ia2s68j9e0");
        URLConnection finn = finnhub.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        finn.getInputStream()));
        String inputLine;
        FileWriter jsonfile = new FileWriter ("output.json");
        while ((inputLine = in.readLine()) != null)
            jsonfile.write(inputLine);
        jsonfile.close();
        in.close();

        scanner = new Scanner (new FileReader ("output.json"));
        System.out.println(scanner.nextLine());
        scanner.close();
    }


    // c5egnaaad3ia2s68j9e0  api key for finnhub
}

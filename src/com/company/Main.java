package com.company;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Passenger passenger1 = new Passenger();

        //Prompt for passenger information
        System.out.println("Welcome to GenSpark Transportation!");
        System.out.println("May I get your name please?: ");

        Scanner sc = new Scanner(System.in);
        passenger1.setName(sc.next());

        System.out.println(String.format("Thank you %s! How old are you? ", passenger1.getName()));
        passenger1.setAge(sc.nextInt());

        System.out.println("Thank you! What is your gender? M/F ");
        passenger1.setGender(sc.next());

        System.out.println("And your phone number? in the format of ###-###-####");
        passenger1.setPhone(sc.next());

        System.out.println("And your email address please. ");
        passenger1.setEmail(sc.next());

        System.out.println("Thank you so much for that information! Here is your boarding pass! Please wait while we prepare to begin boarding!");

        //Generate boarding pass and save it
        BoardingPass bp = new BoardingPass(passenger1);

        //TODO: Generate and save the pass
        bp.generateDataFile();
        bp.readDataFile("C:\\GenSpark\\TeamProjects\\GS-BoardingPass\\src\\com\\company\\data.txt");
    }
}
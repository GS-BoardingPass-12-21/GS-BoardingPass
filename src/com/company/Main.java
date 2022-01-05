package com.company;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Passenger passenger1 = new Passenger();
        //Generate boarding pass and save it
        BoardingPass bp = new BoardingPass(passenger1);

        //Prompt for passenger information
        System.out.println("Welcome to GenSpark Transportation!");
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\s");

        System.out.println("Please Enter Your Full Name: ");
        passenger1.setName(sc.nextLine());

        System.out.println(String.format("Thank you %s! How old are you? ", passenger1.getName()));
        passenger1.setAge(Integer.parseInt(sc.nextLine()));


        System.out.println("Please Enter Your Email: ");
        passenger1.setEmail(sc.nextLine());

        System.out.println("Please Enter Your Phone Number In The Format Of ###-###-####");
        passenger1.setPhone(sc.nextLine());



//        System.out.print("Please enter the date in the format MM/DD/YYYY: ");
//        passenger1.setDob(sc.next());

        System.out.println("Please Enter Your Gender (M/F)");
        passenger1.setGender(sc.nextLine());
        System.out.println("Please Enter Your Departure Time In Format Of 24 Hour HH:00: ");
        bp.setDepartureTime(sc.nextLine());
        System.out.println("Please Enter your Origin In Format Of City, State: ");
        bp.setOrigin(sc.nextLine());
        System.out.print("Please Enter Your Destination In Format Of City, State: ");
        bp.setDestination(sc.nextLine());

        System.out.println("Thank you so much for that information! Here is your boarding pass! Please wait while we prepare to begin boarding!");



        //TODO: Generate and save the pass
        bp.generateDataFile();
        // Path For Mac
//        bp.readDataFile("/Users/rafiullahrahmati/Desktop/TeamProject/GS-BoardingPass/src/com/company/data.txt");
        // Path For Windows
        bp.readDataFile("C:\\GenSpark\\TeamProjects\\GS-BoardingPass\\src\\com\\company\\data.txt");
    }
}
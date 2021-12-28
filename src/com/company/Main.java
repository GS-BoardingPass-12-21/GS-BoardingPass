package com.company;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	getUserInfo();

    }
    public static String [] getUserInfo(){
        String[] getInput = new String[9];
        System.out.println("To process the boarding pass we need some information");
        System.out.println("Please Enter Your Full Name: ");
        getInput[0] = in.nextLine();
        System.out.println("Please Enter Your Email Address: ");
        getInput[1] = in.nextLine();
        System.out.println("Please Enter Your Phone Number: ");
        getInput[2] = in.nextLine();
        System.out.println("Please Enter Your Gender Male/Female: ");
        getInput[3] = in.nextLine();
        System.out.println("Please Enter Your Age: ");
        getInput[4] = in.nextLine();
        System.out.println("Please Enter Your Origin: ");
        getInput[5] = in.nextLine();
        System.out.println("Please Enter The Date Of Departure Date In MM-DD-YYYY Format: ");
        getInput[6] = in.nextLine();
        System.out.println("Please Enter Your Destination In Country, State, Airport City: ");
        getInput[7] = in.nextLine();
        System.out.println("Please Enter Your Departure Time In 24 Hours Format HH:MM");
        getInput[8] = in.nextLine();

        return getInput;
    }
}

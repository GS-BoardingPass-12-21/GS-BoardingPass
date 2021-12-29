package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BoardingPass {
    private String passNumber;
    private Date date;
    private String origin;
    private String destination;
    private String eta;
    private String departureTime;
    private Passenger passenger;
    private double ticketPrice;

    public BoardingPass(Passenger passenger) {
        this.passenger = passenger;
        this.ticketPrice = 50.00;
        setPassNumber(generatePassNumber());
        setEta(generateETA());
        setTicketPrice(generateTicketPrice());
        this.departureTime = "11:00 AM";
        this.date = new Date();
        this.destination = "Erie, PA";
        this.origin = "Buffalo, NY";
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String generatePassNumber(){
        return UUID.randomUUID().toString();
    }

    public int writeToFile(String path, StringBuilder data) throws IOException {
        int result = 0;
        try{
            Files.write(Paths.get(path), data.toString().getBytes());
        }
        catch(Exception ex){
            result = -1;
            System.out.println(ex);
        }

        return result;
    }

    public int readDataFile(String path) throws IOException {
        int result = 0;
        List<String> lines = new ArrayList<>();

        try{
            lines = Files.readAllLines(Paths.get(path));

            StringBuilder ticket = generateTicket(lines);

            writeToFile("C:\\GenSpark\\TeamProjects\\GS-BoardingPass\\src\\com\\company\\ticket.txt", ticket);
        }
        catch(Exception ex){
            result = -1;
            System.out.println(ex);
        }

        return result;
    }

    public StringBuilder generateTicket(List<String> ticketData){
        StringBuilder ticketSb = new StringBuilder();

        ticketSb.append("***********************************************\r\n");

        for(String ticketLine: ticketData){
            ticketSb.append(String.format("* %s            \r\n", ticketLine));
        }

        ticketSb.append("***********************************************");

        return ticketSb;
    }

    public double generateTicketPrice(){
        if(getPassenger().getAge() <= 12){
            setTicketPrice(getTicketPrice() - (getTicketPrice() * 0.5));
        }

        if(getPassenger().getAge() >= 60){
            setTicketPrice(getTicketPrice() - (getTicketPrice() * 0.6));
        }

        if(getPassenger().getGender() == "Female"){
            setTicketPrice(getTicketPrice() - (getTicketPrice() * 0.25));
        }

        return getTicketPrice();
    }

    public String generateETA(){
        return "12:00 PM";
    }

    public void generateDataFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(getPassNumber() + "\r\n");
        sb.append(getDate() + "\r\n");
        sb.append(getPassenger().getName() + "\r\n");
        sb.append(getPassenger().getAge() + "\r\n");
        sb.append(getPassenger().getGender() + "\r\n");
        sb.append(getPassenger().getEmail() + "\r\n");
        sb.append(getPassenger().getPhone() + "\r\n");
        sb.append(getOrigin() + "\r\n");
        sb.append(getDestination() + "\r\n");
        sb.append(getDepartureTime() + "\r\n");
        sb.append(getEta() + "\r\n");
        sb.append(getTicketPrice() + "\r\n");

        writeToFile("C:\\GenSpark\\TeamProjects\\GS-BoardingPass\\src\\com\\company\\data.txt", sb);
    }
}

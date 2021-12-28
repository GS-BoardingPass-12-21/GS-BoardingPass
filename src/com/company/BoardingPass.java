package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
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
        setPassNumber(generatePassNumber());
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

    public double GenerateTicketPrice(){
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
}

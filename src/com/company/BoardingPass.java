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

    public BoardingPass() {
        setPassNumber(generatePassNumber());
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

    public int writeToFile(String path) throws IOException {
        int result = 0;
        try{
            Files.write(Paths.get(path), "".getBytes());
        }
        catch(Exception ex){
            result = -1;
            System.out.println(ex);
        }

        return result;
    }
}

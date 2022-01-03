package com.company;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    Passenger testPassenger;

    @BeforeEach
    void setUp() {
        testPassenger = new Passenger("John", "john@email.com","123-456-7890", "Male", 36);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("John", testPassenger.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        testPassenger.setName("Bill");
        assertEquals("Bill", testPassenger.getName());
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        assertEquals("john@email.com", testPassenger.getEmail());
    }

    @org.junit.jupiter.api.Test
    void setEmail() {
        testPassenger.setEmail("john@email2.com");
        assertEquals("john@email2.com", testPassenger.getEmail());
    }

    @org.junit.jupiter.api.Test
    void getPhone() {
        assertEquals("123-456-7890", testPassenger.getPhone());
    }

    @org.junit.jupiter.api.Test
    void getGender() {
        assertEquals("Male", testPassenger.getGender());
    }

    @org.junit.jupiter.api.Test
    void setGender() {
        testPassenger.setGender("Female");
        assertEquals("Female", testPassenger.getGender());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(36, testPassenger.getAge());
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        testPassenger.setAge(40);
        assertEquals(40, testPassenger.getAge());
    }
}
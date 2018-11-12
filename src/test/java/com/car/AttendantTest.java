package com.car;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendantTest {
    @Test
    void shouldParkMyCarInFirstAvailableParkingLot() {
        Attendant attendant = new Attendant(new HashSet<ParkingLot>(Arrays.asList(new ParkingLot(1))));

        assertTrue(attendant.parkCar(new Car("Regular")));
    }

    @Test
    void shouldParkTheCarInAParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(new HashSet<ParkingLot>(Arrays.asList(parkingLot)));
        Car car = new Car("Regular");

        attendant.parkCar(car);

        assertTrue(parkingLot.retrieve(car));
    }

    @Test
    void shouldNotBeAbleToParkCarIfAllLotsAreFull() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Car car1 = new Car("Regular");
        Car car2 = new Car("Regular");
        Car car3 = new Car("Regular");
        Attendant attendant = new Attendant(new HashSet<ParkingLot>(Arrays.asList(parkingLot1, parkingLot2)));
        attendant.parkCar(car1);
        attendant.parkCar(car2);

        assertFalse(attendant.parkCar(car3));
    }

    @Test
    void shouldNotBeAbleToParkCarInMoreThanOneParkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Attendant attendant = new Attendant(new HashSet<ParkingLot>(Arrays.asList(parkingLot1, parkingLot2)));
        Car car = new Car("Regular");

        assertTrue(attendant.parkCar(car));
        assertTrue(parkingLot1.retrieve(car));
        assertFalse(parkingLot2.retrieve(car));
    }

    @Test
    void shouldParkTheCarInAParkingLotIfLessThen80Percent() {
        ParkingLot parkingLot = new ParkingLot(5);
        Attendant attendant = new Attendant(new HashSet<ParkingLot>(Arrays.asList(parkingLot)), 80);

        assertTrue(attendant.parkCar(new Car("Regular")));
        assertTrue(attendant.parkCar(new Car("Regular")));
        assertTrue(attendant.parkCar(new Car("Regular")));
        assertTrue(attendant.parkCar(new Car("Regular")));
        assertFalse(attendant.parkCar(new Car("Regular")));
    }
}

package com.car;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSystemIntegrationTest {

    @Test
    void shouldParkTheCarInAParkingLotIfLessThen80Percent() {
        ParkingLot parkingLot = new ParkingLot(5);
        Set<ParkingLot> lots = new HashSet<ParkingLot>(Arrays.asList(parkingLot));
        Attendant attendant = new Attendant(lots, 80);

        assertTrue(attendant.parkCar(new Car("Regular")));
        assertTrue(attendant.parkCar(new Car("Regular")));
        assertTrue(attendant.parkCar(new Car("Regular")));
        assertTrue(attendant.parkCar(new Car("Regular")));
        assertFalse(attendant.parkCar(new Car("Regular")));
    }
}

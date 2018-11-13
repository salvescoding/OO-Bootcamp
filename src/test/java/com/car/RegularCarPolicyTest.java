package com.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegularCarPolicyTest {

    private RegularCarPolicy regularCarPolicy;

    @BeforeEach
    void setUp() {
        regularCarPolicy = new RegularCarPolicy();
    }

    @Test
    void shouldReturnCorrectParkingLotWhenOnlyOneParkingLotIsPassed() {
        ParkingLot parkingLot = new ParkingLot(5);
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot));
        assertEquals(parkingLot, regularCarPolicy.applyPolicy(lots));
    }

    @Test
    void shouldReturnCorrectParkingLotWhenTwoParkingLotsArePassed() {
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingLot parkingLot100CapacityPercentage = new ParkingLot(1);
        parkingLot100CapacityPercentage.park(new Car("Regular"));
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot100CapacityPercentage, parkingLot));
        assertEquals(parkingLot, regularCarPolicy.applyPolicy(lots));
    }

    @Test
    void shouldReturnExceptionWhenNoParkingLotsAreFound() {
        ParkingLot parkingLot100CapacityPercentage = new ParkingLot(1);
        parkingLot100CapacityPercentage.park(new Car("Regular"));
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot100CapacityPercentage));
        assertThrows(NoSuchElementException.class, () -> regularCarPolicy.applyPolicy(lots));
    }
}

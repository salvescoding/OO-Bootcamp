package com.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeCarPolicyTest {

    private LargeCarPolicy largeCarPolicy;

    @BeforeEach
    void setUp() {
        largeCarPolicy = new LargeCarPolicy();
    }

    @Test
    void shouldReturnCorrectParkingLotWhenOnlyOneParkingIsPassed() {
        ParkingLot parkingLot = new ParkingLot(3);
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot));
        assertEquals(parkingLot, largeCarPolicy.applyPolicy(lots));
    }

    @Test
    void shouldReturnCorrectParkingLotWhenOnlyTwoOrMoreParkingLotsArePassed() {
        ParkingLot parkingLot = new ParkingLot(4);
        parkingLot.park(new Car("Regular"));
        ParkingLot parkingLotWithLessCars = new ParkingLot(1);
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot, parkingLotWithLessCars));
        assertEquals(parkingLotWithLessCars, largeCarPolicy.applyPolicy(lots));
    }




}

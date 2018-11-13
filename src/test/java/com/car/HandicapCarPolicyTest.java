package com.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HandicapCarPolicyTest {

    private HandicapCarPolicy handicapCarPolicy;

    @BeforeEach
    void setUp() {
        handicapCarPolicy = new HandicapCarPolicy();
    }

    @Test
    void shouldReturnCorrectParkingLotWhenOnlyOneParkingLotIsPassed() {
        ParkingLot parkingLot = new ParkingLot(5);
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot));
        assertEquals(parkingLot, handicapCarPolicy.applyPolicy(lots));
    }

    @Test
    void shouldReturnCorrectParkingLotWhenThreeParkingLotsArePassed() {
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingLot parkingLotSmall = new ParkingLot(1);
        ParkingLot parkingLot100CapacityPercentage = new ParkingLot(1);
        parkingLot100CapacityPercentage.park(new Car("Handicap"));
        Set<ParkingLot> lots = new HashSet<>(Arrays.asList(parkingLot100CapacityPercentage,parkingLotSmall, parkingLot));
        assertEquals(parkingLotSmall, handicapCarPolicy.applyPolicy(lots));
    }


}

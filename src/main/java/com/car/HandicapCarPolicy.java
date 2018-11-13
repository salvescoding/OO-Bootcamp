package com.car;

import java.util.Set;

public class HandicapCarPolicy implements CarPolicy {
    public ParkingLot applyPolicy(Set<ParkingLot> lots) {
        return lots.stream().filter(p -> p.getCapacityPercentage() < 100.0).findFirst().get();
    }
}

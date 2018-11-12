package com.car;

import java.util.Set;

public class RegularCarPolicy implements CarPolicy {
    public ParkingLot applyPolicy(Set<ParkingLot> lots) {
        return lots.stream().filter(p -> p.getCapacityPercentage() < 80.0).findFirst().get();
    }
}

package com.car;

import java.util.Comparator;
import java.util.Set;

public class LargeCarPolicy implements CarPolicy{
    public ParkingLot applyPolicy(Set<ParkingLot> lots) {
        return lots.stream().filter(p -> p.getCapacityPercentage() < 100).min(Comparator.comparing(ParkingLot::getParkedCars)).get();
}
}

package com.car;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LargeCarPolicy implements CarPolicy{
    public ParkingLot applyPolicy(Set<ParkingLot> lots) {
        return lots.stream().min(Comparator.comparing(ParkingLot::getParkedCars))
                .orElseThrow(NoSuchElementException::new);
    }
}

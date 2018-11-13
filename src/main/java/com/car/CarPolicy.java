package com.car;

import java.util.Set;

public interface CarPolicy {
    ParkingLot applyPolicy(Set<ParkingLot> setParkingLots);
}

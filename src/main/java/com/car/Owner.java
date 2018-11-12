package com.car;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Owner implements Observer {
    public static final double MINIMUM_PERCENTAGE = 20.0;
    private final Map<ParkingLot, Double> parkingLots;
    private double maxCapacityPercentage;

    public Owner(Set<ParkingLot> parkingLots) {
        this(parkingLots, 75.0);
    }

    public Owner(Set<ParkingLot> parkingLots, double maxCapacityPercentage) {
        this.maxCapacityPercentage = maxCapacityPercentage;
        this.parkingLots = new HashMap<>();
        handleParkingLots(parkingLots);
    }

    private void handleParkingLots(Set<ParkingLot> parkingLots) {
        parkingLots.forEach(lot -> {
            this.parkingLots.put(lot, lot.subscribe(this));
        });
    }

    @Override
    public void notify(ParkingLot parkingLot, double percentage)
    {
        parkingLots.put(parkingLot, percentage);
        notifyOwnerWhenParkingLotReachMinimumOrMaximum(parkingLot, percentage);
    }

    private void notifyOwnerWhenParkingLotReachMinimumOrMaximum(ParkingLot parkingLot, double percentage) {
        if (percentage > maxCapacityPercentage) {
            getParkingLotToExtend(parkingLot);
        }
        else if (percentage < MINIMUM_PERCENTAGE) {
            parkingToShutDown(parkingLot);
        }
    }

    private ParkingLot parkingToShutDown(ParkingLot parkingLot) {
        return parkingLot;
    }

    public ParkingLot getParkingLotToExtend(ParkingLot parkingLot) {
        return parkingLot;
    }


}

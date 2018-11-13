package com.car;

import java.util.*;

public class Attendant implements Observer {
    private final Map<ParkingLot, Double> parkingLots;
    private double maxCapacityPercentage;

    public Attendant(Set<ParkingLot> parkingLots) {
        this(parkingLots, 100);
    }

    public Attendant(Set<ParkingLot> parkingLots, double maxCapacityPercentage) {
        this.maxCapacityPercentage = maxCapacityPercentage;
        this.parkingLots = new HashMap<>();
        handleParkingLots(parkingLots);
    }

    private void handleParkingLots(Set<ParkingLot> parkingLots) {
        parkingLots.forEach(lot -> {
            this.parkingLots.put(lot, lot.subscribe(this));
        });
    }

    public boolean parkCar(Car car) {
        CarPolicy carPolicy = CarPolicyFactory.getPolicy(car);
        Set<ParkingLot> setParkingLots= new HashSet<>(this.parkingLots.keySet());
        try {
            ParkingLot parkingLotToPark = carPolicy.applyPolicy(setParkingLots);
            parkingLotToPark.park(car);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("No Parking Lots Available");
            return false;
        }
    }

    @Override
    public void notify(ParkingLot parkingLot, double percentage)
    {
        parkingLots.put(parkingLot, percentage);
    }
}

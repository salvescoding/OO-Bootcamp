package com.car;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        // CarPolicy carPolicy = FactoryCarPolicy.getPolicy(car);
        // ParkingLot parkingLot = carPolicy.getParking(parkingLots);
        // parkingLot.park(car);
//        return car.isLarge ? parkLargeCar(car) : parkRegularCar(car);
        return true;
    }

    private boolean parkLargeCar(Car car) {
        ParkingLot parkingLotWithLessCars = null;
        for (ParkingLot p : parkingLots.keySet()) {
            if(parkingLotWithLessCars == null){
                parkingLotWithLessCars = p;
            }else if(p.parkedCars.size() < parkingLotWithLessCars.parkedCars.size()){
                parkingLotWithLessCars = p;
            }
        }
        parkingLotWithLessCars.park(car);
        return true;
    }

    private boolean parkRegularCar(Car car) {
        for (ParkingLot p : parkingLots.keySet()) {
            Double currentCapacityPercentage = this.parkingLots.get(p);
//            if (currentCapacityPercentage < 100.0 && car.isHandicap) {
//                p.park(car);
//                return true;
//            }
//            if (currentCapacityPercentage < maxCapacityPercentage) {
//                p.park(car);
//                return true;
//            }
        }
        return false;
    }

    @Override
    public void notify(ParkingLot parkingLot, double percentage)
    {
        parkingLots.put(parkingLot, percentage);
    }
}

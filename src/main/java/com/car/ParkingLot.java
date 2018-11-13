package com.car;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    protected final Set<Car> parkedCars = new HashSet<>();
    private final Set<Observer> subscribers = new HashSet<>();
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Car car) {
        if (parkedCars.size() == this.capacity) {
            return false;
        }
        parkedCars.add(car);
        notifySubscribers(getCapacityPercentage());
        return true;
    }

    protected double getCapacityPercentage() {
        return 100 * parkedCars.size() / this.capacity;
    }

    private void notifySubscribers(double capacityPercentage) {
        subscribers.forEach(s -> s.notify(this, capacityPercentage));
    }

    public boolean retrieve(Car car) {
        return parkedCars.remove(car);
    }

    public double subscribe(Observer observer) {
        subscribers.add(observer);
        return getCapacityPercentage();
    }

    public int getParkedCars() {
        return parkedCars.size();
    }
}

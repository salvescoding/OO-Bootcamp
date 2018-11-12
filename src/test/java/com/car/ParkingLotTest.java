package com.car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("Regular");

        parkingLot.park(car);
        assertEquals(parkingLot.park(car), true);
    }

    @Test
    public void shouldNotParkACarWhenItsFull() {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car("Regular"));
        parkingLot.park(new Car("Regular"));
        parkingLot.park(new Car("Regular"));
        assertFalse(parkingLot.park(new Car("Regular")));
    }

    @Test
    void shouldRetrieveCar(){
        Car car = new Car("Regular");
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(car);

        assertEquals(parkingLot.retrieve(car), true);
    }

    @Test
    void shouldNotRetrieveNotParkedCar(){
        ParkingLot parkingLot = new ParkingLot(3);
        assertEquals(parkingLot.retrieve(new Car("Regular")), false);
    }
}

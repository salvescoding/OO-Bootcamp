package com.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ParkingSystemIntegrationTest {

    private RegularCarPolicy regularCarPolicy;
    private CarPolicyFactory carPolicyFactory;
    private Car car;
    private Attendant attendant;


    @BeforeEach
    void setUp() {
        regularCarPolicy = mock(RegularCarPolicy.class);
        carPolicyFactory = mock(CarPolicyFactory.class);
        car = mock(Car.class);
        attendant = mock(Attendant.class);
    }

    @Test
    void shouldGetPolicyWhenAttendantParkCar() {
        attendant.parkCar(car);
        verify(carPolicyFactory).getPolicy(car);
    }

}

package com.car;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CarPolicyFactoryTest {

    @Test
    void shouldReturnRegularCarPolicy() {
        Car car = new Car("Regular");
        assertThat(CarPolicyFactory.getPolicy(car), instanceOf(RegularCarPolicy.class));
    }

    @Test
    void shouldReturnHandicapCarPolicy() {
        Car car = new Car("Handicap");
        assertThat(CarPolicyFactory.getPolicy(car), instanceOf(HandicapCarPolicy.class));
    }

    @Test
    void shouldReturnLargeCarPolicy() {
        Car car = new Car("Large");
        assertThat(CarPolicyFactory.getPolicy(car), instanceOf(LargeCarPolicy.class));
    }

    @Test
    void shouldReturnNullWhenPolicyDoesNotExist() {
        Car car = new Car("ExtraLarge");
        assertNull(CarPolicyFactory.getPolicy(car));
    }
}

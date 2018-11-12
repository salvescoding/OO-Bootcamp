package com.car;

import java.util.HashMap;
import java.util.Map;

public class CarPolicyFactory {

    private static final Map<String, CarPolicy> carPolicies = new HashMap<String, CarPolicy>() {{
        put("Regular", new RegularCarPolicy());
        put("Handicap", new HandicapCarPolicy());
        put("Large", new LargeCarPolicy());
    }};


    public static CarPolicy getPolicy(Car car) {
        return carPolicies.get(car.getType());
    }
}

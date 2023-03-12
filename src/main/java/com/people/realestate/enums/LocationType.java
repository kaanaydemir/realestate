package com.people.realestate.enums;

import java.util.HashMap;
import java.util.Map;

public enum LocationType {
    CITY(0),
    DISTRICT(1),
    STREET(2);

    private final Integer value;

    LocationType(Integer i) {
        value = i;
    }

    private static final Map<Integer, LocationType> map = new HashMap<>();

    static {
        for (LocationType locationType : LocationType.values()) {
            map.put(locationType.value, locationType);
        }
    }

    public static LocationType fromValue(Integer value) {
        return map.get(value);
    }

    public int getValue() { return value; }


}

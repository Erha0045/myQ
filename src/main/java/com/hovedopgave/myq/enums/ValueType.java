package com.hovedopgave.myq.enums;

import java.util.Arrays;

public enum ValueType {
    BASIS(0, "Basis"), DERIVED(1, "Derived"), GRID(2, "Grid"),
    POLYGON_1(3, "MUNICIPALITY"),
    POLYGON_2(4, "10X10_GRID"),
    POLYGON_3(5, "20X20_GRID"),
    POLYGON_4(6, "REGION"),
    POLYGON_5(7, "DENMARK");

    private final int id;
    private final String name;

    ValueType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static boolean isPolygon(int id){
        return id >= 3;
    }

    public static String getById(int id){
        return Arrays.stream(values())
                .filter(valueType -> valueType.getId() == id)
                .map(ValueType::getName)
                .findFirst()
                .orElse("Default");
    }
}

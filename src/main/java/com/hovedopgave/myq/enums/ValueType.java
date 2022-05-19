package com.hovedopgave.myq.enums;

public enum ValueType {
    BASIS(0), DERIVED(1), GRID(2),
    POLYGON_1(3),
    POLYGON_2(4),
    POLYGON_3(5),
    POLYGON_4(6),
    POLYGON_5(7);

    private final int id;

    ValueType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

package com.hovedopgave.myq.enums;

import java.util.Arrays;

public enum Status {
    WAITING(0, "Waiting"),
    RUNNING(1, "Running"),
    COMPLETED(2, "Completed"),
    FAILED(3, "Failed");

    private final int id;
    private final String name;

    Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getById(int id) {
        return Arrays.stream(values())
                .filter(valueType -> valueType.getId() == id)
                .map(Status::getName)
                .findFirst()
                .orElse("Default");
    }
}

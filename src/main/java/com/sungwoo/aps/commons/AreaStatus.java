package com.sungwoo.aps.commons;

public enum AreaStatus {
    EMPTY(0, "Parking area is empty"),
    FULL(1, "Parking area is full");

    private final int value;
    private final String reasonPhrase;

    private AreaStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return value;
    }

    public String reasonPhrase() {
        return reasonPhrase;
    }
}

package com.sungwoo.aps.commons;

public enum CarStatus {
    MOVING(0, "Car is moving"),
    PARKING(1, "Parking complete: %s area"),
    ARRIVED(2, "Car arrived at your location");

    private final int value;
    private final String reasonPhrase;

    private CarStatus(int value, String reasonPhrase) {
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

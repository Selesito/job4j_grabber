package ru.job4j.parking;

public abstract class Auto {
    private String name;

    public Auto(String name) {
        this.name = name;
    }

    abstract int size();
}

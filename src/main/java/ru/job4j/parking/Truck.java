package ru.job4j.parking;

public class Truck extends Auto {
    private int size;

    public Truck(String name, int size) {
        super(name);
        this.size = size;

    }

    @Override
    int size() {
        return size;
    }
}

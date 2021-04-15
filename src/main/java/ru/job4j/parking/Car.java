package ru.job4j.parking;

public class Car extends Auto {

    public Car(String name) {
        super(name);
    }

    @Override
    int size() {
        return 1;
    }
}

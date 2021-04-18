package ru.job4j.parking;

public class Car extends Auto {

    public Car(String name) {
        super(name);
    }

    @Override
    int size() {
        return 1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

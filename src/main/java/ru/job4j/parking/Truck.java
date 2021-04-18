package ru.job4j.parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return size == truck.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}

package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class AutoParking implements Parking {
    private List<Car> parkCar;
    private List<Truck> parkTruck;

    public AutoParking(int sizeCar, int sizeTruck) {
        this.parkCar = new ArrayList<>(sizeCar);
        this.parkTruck = new ArrayList<>(sizeTruck);
    }

    @Override
    public boolean parkingAuto(Auto auto) {
        return false;
    }

    @Override
    public boolean removeAuto(Auto auto) {
        return false;
    }

    @Override
    public boolean accept(Auto auto) {
        return false;
    }

    @Override
    public List<Auto> getAllAuto() {
        return null;
    }
}

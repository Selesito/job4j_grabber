package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class TruckParking implements Parking {
    private List<Truck> park = new ArrayList<>();

    @Override
    public void parkingAuto(Auto auto) {

    }

    @Override
    public void removeAuto(Auto auto) {

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

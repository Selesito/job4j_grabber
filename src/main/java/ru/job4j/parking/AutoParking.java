package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class AutoParking implements Parking {
    private int sizeCar;
    private int sizeTruck;
    private List<Auto> parkCar;
    private List<Auto> parkTruck;

    public AutoParking(int sizeCar, int sizeTruck) {
        this.parkCar = new ArrayList<>(sizeCar);
        this.parkTruck = new ArrayList<>(sizeTruck);
        this.sizeCar = sizeCar;
        this.sizeTruck = sizeTruck;
    }

    @Override
    public boolean parkingAuto(Auto auto) {
        boolean result = false;
        if (auto.size() > 1) {
            if (sizeTruck != 0) {
                parkTruck.add(auto);
                sizeTruck--;
                result = true;
            } else if (sizeTruck == 0 && sizeCar >= auto.size()) {
                parkCar.add(auto);
                sizeCar -= auto.size();
                result = true;
            }
        } else if (sizeCar != 0) {
            parkCar.add(auto);
            sizeCar--;
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeAuto(Auto auto) {
        boolean result = false;
        if (parkCar.contains(auto)) {
            parkCar.remove(auto);
            sizeCar += auto.size();
            result = true;
        }
        if (parkTruck.contains(auto)) {
            parkTruck.remove(auto);
            sizeCar++;
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Auto auto) {
        if (allAuto().contains(auto)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Auto> getAllAuto() {
        return allAuto();
    }

    private List<Auto> allAuto() {
        List<Auto> all = new ArrayList<>();
        all.addAll(parkCar);
        all.addAll(parkTruck);
        return all;
    }
}

package ru.job4j.parking;

import java.util.List;

public interface Parking {
    void parkingAuto(Auto auto);

    void removeAuto(Auto auto);

    boolean accept(Auto auto);

    List<Auto> getAllAuto();
}

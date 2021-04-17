package ru.job4j.parking;

import java.util.List;

public interface Parking {
    boolean parkingAuto(Auto auto);

    boolean removeAuto(Auto auto);

    boolean accept(Auto auto);

    List<Auto> getAllAuto();
}

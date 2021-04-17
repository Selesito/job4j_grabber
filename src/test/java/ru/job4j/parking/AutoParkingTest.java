package ru.job4j.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AutoParkingTest {

    @Ignore
    @Test
    public void whenParkingAutoThenTrue() {
        Parking parking = new AutoParking(2, 1);
        Auto auto1 = new Car("Ушастый запорожец");
        Auto auto2 = new Truck("Man", 3);
        assertTrue(parking.parkingAuto(auto1));
        assertTrue(parking.parkingAuto(auto2));
    }

    @Ignore
    @Test
    public void whenParkingAutoTruckThenTrue() {
        Parking parking = new AutoParking(4, 0);
        Auto auto1 = new Car("Ушастый запорожец");
        Auto auto2 = new Truck("Man", 3);
        assertTrue(parking.parkingAuto(auto1));
        assertTrue(parking.parkingAuto(auto2));
    }

    @Ignore
    @Test
    public void whenRemoveAutoAndAcceptThenFalse() {
        Parking parking = new AutoParking(1, 1);
        Auto auto1 = new Car("Ушастый запорожец");
        Auto auto2 = new Truck("Man", 3);
        List<Auto> rsl = new ArrayList<>();
        rsl.add(auto1);
        parking.parkingAuto(auto1);
        parking.parkingAuto(auto2);
        parking.removeAuto(auto2);
        assertFalse(parking.accept(auto2));
        assertEquals(rsl, parking.getAllAuto());
    }

}
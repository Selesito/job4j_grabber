package ru.job4j.storage;

import org.junit.Test;
import ru.job4j.storage.food.Cheese;
import ru.job4j.storage.food.Meat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class WarehouseTest {

    @Test
    public void whenCheck() {
        Calendar c = Calendar.getInstance();
        Warehouse warehouse = new Warehouse(0, 25);
        Meat meat = new Meat("Мясо", new GregorianCalendar(2021, Calendar.MAY, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 8), 250.0, 0.0);
        Cheese cheese = new Cheese("Сыр", new GregorianCalendar(2021, Calendar.APRIL, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 1), 550.0, 0.0);
        assertTrue(warehouse.check(meat));
        assertFalse(warehouse.check(cheese));
    }
}
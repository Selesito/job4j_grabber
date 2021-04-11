package ru.job4j.storage;

import org.junit.Test;
import ru.job4j.storage.food.Banana;
import ru.job4j.storage.food.Cheese;
import ru.job4j.storage.food.Meat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TrashTest {

    @Test
    public void whenCheckThanTrueFalse() {
        Trash trash = new Trash(100, 0);
        Meat meat = new Meat("Мясо", new GregorianCalendar(2021, Calendar.MAY, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 8), 250.0, 0.0);
        Cheese cheese = new Cheese("Сыр", new GregorianCalendar(2021, Calendar.APRIL, 8),
                new GregorianCalendar(2021, Calendar.APRIL, 1), 550.0, 0.0);
        Banana banana = new Banana("Зеленые", new GregorianCalendar(2021, Calendar.APRIL, 5),
                new GregorianCalendar(2021, Calendar.MARCH, 10), 200.0, 0.0);
        assertFalse(trash.check(meat));
        assertTrue(trash.check(cheese));
        assertTrue(trash.check(banana));
    }

}
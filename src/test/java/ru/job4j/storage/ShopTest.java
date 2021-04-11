package ru.job4j.storage;

import org.junit.Test;
import ru.job4j.storage.food.Banana;
import ru.job4j.storage.food.Cheese;
import ru.job4j.storage.food.Meat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void whenCheckThanTrueFalse() {
        Calendar c = Calendar.getInstance();
        Shop shop = new Shop(25, 75);
        Meat meat = new Meat("Мясо", new GregorianCalendar(2021, Calendar.MAY, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 8), 250.0, 0.0);
        Cheese cheese = new Cheese("Сыр", new GregorianCalendar(2021, Calendar.APRIL, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 1), 550.0, 0.0);
        Banana banana = new Banana("Зеленые", new GregorianCalendar(2021, Calendar.APRIL, 15),
                new GregorianCalendar(2021, Calendar.MARCH, 10), 200.0, 0.0);
        assertFalse(shop.check(meat));
        assertTrue(shop.check(cheese));
        assertTrue(shop.check(banana));
    }
}
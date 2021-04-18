package ru.job4j.storage;

import org.junit.Test;
import ru.job4j.storage.food.Apple;
import ru.job4j.storage.food.Banana;
import ru.job4j.storage.food.Cheese;
import ru.job4j.storage.food.Meat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whenProductDistributorThan() {
        Warehouse warehouse = new Warehouse(0, 25);
        Shop shop = new Shop(25, 75);
        Trash trash = new Trash(100, 0);
        List<Storage> storages = Arrays.asList(warehouse, shop, trash);
        ControllQuality control = new ControllQuality(storages);
        Banana banana = new Banana("Зеленые", new GregorianCalendar(2021, Calendar.APRIL, 5),
                new GregorianCalendar(2021, Calendar.MARCH, 10), 200.0, 0.0);
        Meat meat = new Meat("Мясо", new GregorianCalendar(2021, Calendar.MAY, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 8), 250.0, 0.0);
        Cheese cheese = new Cheese("Сыр", new GregorianCalendar(2021, Calendar.APRIL, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 1), 550.0, 0.0);
        Apple apple = new Apple("Зеленые", new GregorianCalendar(2021, Calendar.APRIL, 25),
                new GregorianCalendar(2021, Calendar.MARCH, 17), 200.0, 0.0);
        List<Food> foods = Arrays.asList(banana, meat, cheese, apple);
        control.productDistributor(foods);
        assertEquals(warehouse.getFood().size(), 1);
        assertEquals(shop.getFood().size(), 2);
    }

    @Test
    public void whenResortThan() {
        Warehouse warehouse = new Warehouse(0, 25);
        Shop shop = new Shop(25, 75);
        Trash trash = new Trash(100, 0);
        List<Storage> storages = Arrays.asList(warehouse, shop, trash);
        ControllQuality control = new ControllQuality(storages);
        Banana banana = new Banana("Зеленые", new GregorianCalendar(2021, Calendar.APRIL, 5),
                new GregorianCalendar(2021, Calendar.MARCH, 10), 200.0, 0.0);
        Meat meat = new Meat("Мясо", new GregorianCalendar(2021, Calendar.MAY, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 8), 250.0, 0.0);
        Cheese cheese = new Cheese("Сыр", new GregorianCalendar(2021, Calendar.APRIL, 25),
                new GregorianCalendar(2021, Calendar.APRIL, 1), 550.0, 0.0);
        Apple apple = new Apple("Зеленые", new GregorianCalendar(2021, Calendar.APRIL, 25),
                new GregorianCalendar(2021, Calendar.MARCH, 17), 200.0, 0.0);
        List<Food> foods = Arrays.asList(banana, meat, cheese, apple);
        control.productDistributor(foods);
        cheese.setExpiryDate(new GregorianCalendar(2021, Calendar.APRIL, 17));
        apple.setExpiryDate(new GregorianCalendar(2021, Calendar.APRIL, 15));
        control.resort();
        assertEquals(warehouse.getFood().size(), 1);
        assertEquals(shop.getFood().size(), 0);
        assertEquals(trash.getFood().size(), 3);
    }
}
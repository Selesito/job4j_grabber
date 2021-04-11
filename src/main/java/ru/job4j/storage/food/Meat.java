package ru.job4j.storage.food;

import ru.job4j.storage.Food;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Meat extends Food {
    public Meat(String name, GregorianCalendar expiryDate, GregorianCalendar createdDate,
                double price, double discount) {
        super(name, expiryDate, createdDate, price, discount);
    }
}

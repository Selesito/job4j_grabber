package ru.job4j.storage.food;

import ru.job4j.storage.Food;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tomato extends Food {
    public Tomato(String name, GregorianCalendar expiryDate, GregorianCalendar createdDate,
                  double price, double discount) {
        super(name, expiryDate, createdDate, price, discount);
    }
}

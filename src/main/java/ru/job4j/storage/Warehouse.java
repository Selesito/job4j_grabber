package ru.job4j.storage;

import java.util.Date;
import java.util.GregorianCalendar;

public class Warehouse extends Storage {

    public Warehouse(double percentMin, double percentMax) {
        super(percentMin, percentMax);
    }

    @Override
    public boolean check(Food food) {
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double shelfExpired = new GregorianCalendar().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double percent = (shelfExpired * 100.0) / shelfLife;
        return percent < getPercentMax();
    }
}

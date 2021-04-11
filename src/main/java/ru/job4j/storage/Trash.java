package ru.job4j.storage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Trash extends Storage {

    public Trash(int percentMin, int percentMax) {
        super(percentMin, percentMax);
    }

    @Override
    public boolean check(Food food) {
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double shelfExpired = new GregorianCalendar().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double percent = (shelfExpired * 100.0) / shelfLife;
        return percent > getPercentMin();
    }
}

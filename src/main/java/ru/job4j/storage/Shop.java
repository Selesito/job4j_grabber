package ru.job4j.storage;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Shop extends Storage {
    public Shop(int percentMin, int percentMax) {
        super(percentMin, percentMax);
    }

    @Override
    public boolean check(Food food) {
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double shelfExpired = new GregorianCalendar().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double percent = (shelfExpired * 100.0) / shelfLife;
        if (percent > getPercentMin() && percent < getPercentMax()) {
            return true;
        } else if (percent > getPercentMax() && percent < 100) {
            food.setDiscount(0.5);
            food.setPrice(food.getPrice() * food.getDiscount());
            return true;
        }
        return false;
    }
}

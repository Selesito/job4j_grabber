package ru.job4j.storage;

public class Shop extends Storage {
    public Shop(int percentMin, int percentMax) {
        super(percentMin, percentMax);
    }

    @Override
    public boolean check(Food food) {
        double percent = calcPercent(food);
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

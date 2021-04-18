package ru.job4j.storage;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Storage {
    private double percentMax;
    private double percentMin;

    private List<Food> foods = new ArrayList<>();

    public Storage(double percentMin, double percentMax) {
        this.percentMin = percentMin;
        this.percentMax = percentMax;
    }

    public double getPercentMax() {
        return percentMax;
    }

    public void setPercentMax(double percentMax) {
        this.percentMax = percentMax;
    }

    public double getPercentMin() {
        return percentMin;
    }

    public void setPercentMin(double percentMin) {
        this.percentMin = percentMin;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

     public boolean add(Food food) {
        boolean result = check(food);
        if (result) {
            this.foods.add(food);
        }
        return result;
    }

    public double calcPercent(Food food) {
        double shelfLife = food.getExpiryDate().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        double shelfExpired = new GregorianCalendar().getTimeInMillis() - food.getCreatedDate()
                .getTimeInMillis();
        return (shelfExpired * 100.0) / shelfLife;
    }

    public abstract boolean check(Food food);

    public void clear() {
        foods.clear();
    }
}

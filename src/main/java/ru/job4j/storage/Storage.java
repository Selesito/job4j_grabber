package ru.job4j.storage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Storage {
    private double percentMax;
    private double percentMin;

    private List<Food> food = new ArrayList<>();

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

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

     void add(Food food) {
        if (check(food)) {
            this.food.add(food);
        }
    }

    public abstract boolean check(Food food);
}

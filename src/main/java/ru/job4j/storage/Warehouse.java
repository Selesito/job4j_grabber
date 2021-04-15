package ru.job4j.storage;

public class Warehouse extends Storage {

    public Warehouse(double percentMin, double percentMax) {
        super(percentMin, percentMax);
    }

    @Override
    public boolean check(Food food) {
        return calcPercent(food) < getPercentMax();
    }
}

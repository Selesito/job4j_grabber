package ru.job4j.storage;

public class Trash extends Storage {

    public Trash(int percentMin, int percentMax) {
        super(percentMin, percentMax);
    }

    @Override
    public boolean check(Food food) {
        return calcPercent(food) > getPercentMin();
    }
}

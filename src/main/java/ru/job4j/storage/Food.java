package ru.job4j.storage;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Food {
    private String name;
    private GregorianCalendar expiryDate;
    private GregorianCalendar createdDate;
    private double price;
    private double discount;

    public Food(String name, GregorianCalendar expiryDate, GregorianCalendar createdDate,
                double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createdDate = createdDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(GregorianCalendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public GregorianCalendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(GregorianCalendar createdDate) {
        this.createdDate = createdDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return price == food.price
                && discount == food.discount
                && Objects.equals(name, food.name)
                && Objects.equals(expiryDate, food.expiryDate)
                && Objects.equals(createdDate, food.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, createdDate, price, discount);
    }
}

package com.epam.restaurant.dao.entity;

public class CountedDish {
    private Dish dish;
    private int count;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountedDish{" +
                "dish=" + dish.toString() +
                ", count=" + count +
                '}';
    }
}

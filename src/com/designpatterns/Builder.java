package com.designpatterns;

import java.util.ArrayList;
import java.util.List;

// Defines an instance for creating an object but letting subclasses decide which
// class to instantiate and Allows a finer control over the construction process.

public class Builder {
    public interface Item {
        public String name();
    }

    public static class Burger implements Item {
        @Override
        public String name() {
            return "Burger";
        }
    }

    public static class Drink implements Item {
        @Override
        public String name() {
            return "Drink";
        }
    }

    public static class Meal {
        private List<Item> items = new ArrayList<>();

        public void addItem(Item item) {
            items.add(item);
        }

        public void print() {
            for (Item item : items) {
                System.out.print(item.name());
            }
        }
    }

    public static class MealBuilder {
        public Meal prepareMeal() {
            Meal meal = new Meal();
            meal.addItem(new Burger());
            meal.addItem(new Drink());
            return meal;
        }
    }

    public static void main(String[] args) {
        MealBuilder mb = new MealBuilder();
        Meal meal = mb.prepareMeal();
        meal.print();
    }
}

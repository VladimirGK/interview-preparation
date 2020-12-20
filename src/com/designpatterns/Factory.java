package com.designpatterns;

// Creates objects without exposing the instantiation logic to the client
// and Refers to the newly created object through a common interface.

public class Factory {
    public static abstract class Product {
        void print() {
            System.out.print("Product class -- ");
        }

        ;
    }

    public static class Fruit extends Product {
        @Override
        void print() {
            super.print();
            System.out.print("Fruit");
        }
    }

    public static class Vegetable extends Product {
        @Override
        void print() {
            super.print();
            System.out.print("Vegetable");
        }
    }

    public static class ProductFactory {
        public Product createProduct(String productID) {
            if (productID == "Fruit")
                return new Fruit();
            if (productID == "Vegetable")
                return new Vegetable();
            return null;
        }

    }

    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        Product first = factory.createProduct("Vegetable");
        Product second = factory.createProduct("Fruit");
        first.print();
        second.print();
    }
}

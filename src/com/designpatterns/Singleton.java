package com.designpatterns;

// Ensure that only one instance of a class is created and Provide a global access point to the object.

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null)
            return new Singleton();
        return instance;
    }
}

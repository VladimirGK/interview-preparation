package com.designpatterns;

// Specify the kinds of objects to create using a prototypical instance,
// and create new objects by copying this prototype.

public class Prototype {
    public static abstract class Shape {
        public int x;
        public int y;

        public Shape() {
        }

        public Shape(Shape rhs) {
            if (this != rhs) {
                this.x = x;
                this.y = y;
            }
        }

        public abstract Shape clone();

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Shape)) return false;
            Shape shape = (Shape) o;
            return shape.x == x && shape.y == y;
        }
    }

    public static class Circle extends Shape {
        int radius;

        public Circle() {
        }

        public Circle(Circle rhs) {
            super(rhs);
            if (rhs != null)
                this.radius = rhs.radius;
        }

        @Override
        public Shape clone() {
            return new Circle(this);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Circle) || !super.equals(o)) return false;
            Shape shape = (Shape) o;
            return radius == ((Circle) o).radius;
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.x = 2;
        circle.y = 5;
        circle.radius = 10;
        Circle clonedCircle = (Circle) circle.clone();
    }
}

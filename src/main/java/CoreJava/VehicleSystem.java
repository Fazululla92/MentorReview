package CoreJava;

import java.util.ArrayList;
import java.util.List;

public class VehicleSystem {
    interface Vehicle {
        void start();
        void stop();
    }

    static class Car implements Vehicle {
        public void start() { System.out.println("Car starts"); }
        public void stop() { System.out.println("Car stops"); }
    }

    static class Truck implements Vehicle {
        public void start() { System.out.println("Truck starts"); }
        public void stop() { System.out.println("Truck stops"); }
    }

    static class Bike implements Vehicle {
        public void start() { System.out.println("Bike starts"); }
        public void stop() { System.out.println("Bike stops"); }
    }

    static class Pizza {
        String size;
        List<String> toppings = new ArrayList<>();

        Pizza(String size) {
            this.size = size;
        }

        void addTopping(String t) {
            toppings.add(t);
        }

        void show() {
            System.out.println("Size: " + size);
            System.out.println("Toppings: " + toppings);
            System.out.println("Price: ₹" + (200 + toppings.size() * 50));
        }
    }

    public static void main(String[] args) {

        Vehicle v = new Car();
        v.start();
        v.stop();

        Pizza p = new Pizza("Medium");
        p.addTopping("Cheese");
        p.addTopping("Corn");
        p.show();
    }
}
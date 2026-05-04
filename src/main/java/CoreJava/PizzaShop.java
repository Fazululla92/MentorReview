package CoreJava;

import java.util.ArrayList;

class Base {
    String name;
    double cost;

    Base(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Topping {
    String name;
    double cost;

    Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Pizza {
    Base base;
    ArrayList<Topping> toppings = new ArrayList<>();

    Pizza(Base base) {
        this.base = base;
    }

    void addTopping(Topping topping) {
        toppings.add(topping);
    }

    double calculateCost() {
        double total = base.cost;

        for (Topping t : toppings) {
            total += t.cost;
        }

        return total;
    }
}

public class PizzaShop {
    public static void main(String[] args) {

        Base softBase = new Base("Soft Base", 5);

        Topping tomato = new Topping("Tomato", 1);
        Topping corn = new Topping("Corn", 1.5);
        Topping mushroom = new Topping("Mushroom", 2);

        Pizza pizza = new Pizza(softBase);
        pizza.addTopping(tomato);
        pizza.addTopping(corn);

        System.out.println("Total Pizza Cost: $" + pizza.calculateCost());
    }
}

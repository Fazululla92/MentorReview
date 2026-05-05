package Java8;

import java.util.*;
import java.util.function.BiFunction;

public class Task5 {

    public static void main(String[] args) {

        // 1. BiFunction to create Product from name and price
        BiFunction<String, Double, Product> productCreator =
                (name, price) -> new Product(name, price, "electronics", "Normal");

        Product p1 = productCreator.apply("Laptop", 1500.0);
        Product p2 = productCreator.apply("Phone", 900.0);

        System.out.println("1. Created Products:");
        System.out.println(p1);
        System.out.println(p2);

        // 2. BiFunction to calculate cost (Product * quantity)
        BiFunction<Product, Integer, Double> productCost =
                (product, qty) -> product.price * qty;

        Map<Product, Integer> cart = new HashMap<>();
        cart.put(p1, 2);
        cart.put(p2, 3);

        double totalCost = 0;

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            totalCost += productCost.apply(entry.getKey(), entry.getValue());
        }

        System.out.println("\n2. Cart total cost: " + totalCost);
    }
}

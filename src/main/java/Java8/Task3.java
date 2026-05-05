package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1500, "electronics", "A"),
                new Product("Phone", 900, "electronics", "B"),
                new Product("TV", 2000, "electronics", "A"),
                new Product("Shoes", 120, "fashion", "A"),
                new Product("Book", 80, "education", "C")
        );

        Function<List<Product>, Double> totalCost =
                list -> list.stream()
                        .mapToDouble(p -> p.price)
                        .sum();

        Function<List<Product>, Double> costAbove1000 =
                list -> list.stream()
                        .filter(p -> p.price > 1000)
                        .mapToDouble(p -> p.price)
                        .sum();

        Function<List<Product>, Double> electronicsCost =
                list -> list.stream()
                        .filter(p -> p.category.equals("electronics"))
                        .mapToDouble(p -> p.price)
                        .sum();

        Function<List<Product>, List<Product>> expensiveElectronics =
                list -> list.stream()
                        .filter(p -> p.price > 1000 && p.category.equals("electronics"))
                        .collect(Collectors.toList());

        System.out.println("1. Total cost: " + totalCost.apply(products));

        System.out.println("2. Cost > 1000: " + costAbove1000.apply(products));

        System.out.println("3. Electronics cost: " + electronicsCost.apply(products));

        System.out.println("4. Expensive electronics:");
        expensiveElectronics.apply(products)
                .forEach(System.out::println);
    }
}

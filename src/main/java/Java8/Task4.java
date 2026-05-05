package Java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Task4 {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laptop", 1500, "electronics", "Normal"),
                new Product("Phone", 900, "electronics", "Normal"),
                new Product("TV", 2000, "electronics", "Normal"),
                new Product("LuxuryWatch", 5000, "fashion", "Normal"),
                new Product("Book", 80, "education", "Normal")
        ));

        Consumer<Product> consolePrinter = p -> System.out.println(p);

        Consumer<Product> filePrinter = p -> {
            System.out.println("Writing to file: " + p);
        };

        String mode = "console";

        Consumer<Product> printConsumer = mode.equals("file") ? filePrinter : consolePrinter;

        System.out.println("1. Print product:");
        printConsumer.accept(products.get(0));

        Consumer<Product> premiumGradeUpdater = p -> {
            if (p.price > 1000) {
                p.grade = "Premium";
            }
        };

        products.forEach(premiumGradeUpdater);

        System.out.println("\n2. After grade update:");
        products.forEach(System.out::println);

        Consumer<Product> nameUpdater = p -> {
            if (p.price > 3000) {
                p.name = p.name + "*";
            }
        };

        products.forEach(nameUpdater);

        System.out.println("\n3. After name update:");
        products.forEach(System.out::println);

        System.out.println("\n4. Premium + '*' products:");
        products.stream()
                .filter(p -> p.grade.equals("Premium") && p.name.contains("*"))
                .forEach(System.out::println);

        Supplier<Product> randomProductSupplier = () -> {
            String[] names = {"Laptop", "Phone", "TV", "Tablet"};
            String[] categories = {"electronics", "fashion", "education"};
            Random r = new Random();

            return new Product(
                    names[r.nextInt(names.length)],
                    r.nextInt(5000),
                    categories[r.nextInt(categories.length)],
                    "Normal"
            );
        };

        System.out.println("\n5. Random Product:");
        System.out.println(randomProductSupplier.get());

        // 2. OTP supplier
        Supplier<String> otpSupplier = () -> {
            Random r = new Random();
            return String.valueOf(100000 + r.nextInt(900000));
        };

        System.out.println("\n6. OTP:");
        System.out.println(otpSupplier.get());
    }
}

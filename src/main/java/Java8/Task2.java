package Java8;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Response {
    String body;
    int statusCode;
    String responseType;

    Response(String body, int statusCode, String responseType) {
        this.body = body;
        this.statusCode = statusCode;
        this.responseType = responseType;
    }

    public String toString() {
        return body + " " + statusCode + " " + responseType;
    }
}

public class Task2 {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1500, "electronics", "A"),
                new Product("Phone", 900, "electronics", "B"),
                new Product("Shoes", 120, "fashion", "A"),
                new Product("TV", 2000, "electronics", "A"),
                new Product("Book", 80, "education", "C")
        );

        List<Response> responses = Arrays.asList(
                new Response("r1", 400, "JSON"),
                new Response("r2", 200, "XML"),
                new Response("r3", 400, "JSON"),
                new Response("r4", 500, "JSON")
        );

        Predicate<Product> priceGreater1000 = p -> p.price > 1000;
        Predicate<Product> electronics = p -> p.category.equals("electronics");
        Predicate<Product> priceGreater100 = p -> p.price > 100;
        Predicate<Product> priceLess100 = p -> p.price < 100;

        System.out.println("1. Price > 1000");
        products.stream()
                .filter(priceGreater1000)
                .forEach(System.out::println);

        System.out.println("\n2. Electronics");
        products.stream()
                .filter(electronics)
                .forEach(System.out::println);

        System.out.println("\n3. Price > 100 AND Electronics");
        products.stream()
                .filter(priceGreater100.and(electronics))
                .forEach(System.out::println);

        System.out.println("\n4. Price > 100 OR Electronics");
        products.stream()
                .filter(priceGreater100.or(electronics))
                .forEach(System.out::println);

        System.out.println("\n5. Price < 100 AND Electronics");
        products.stream()
                .filter(priceLess100.and(electronics))
                .forEach(System.out::println);

        Predicate<Response> status400 = r -> r.statusCode == 400;
        Predicate<Response> json = r -> r.responseType.equals("JSON");

        System.out.println("\n6. Status 400");
        responses.stream()
                .filter(status400)
                .forEach(System.out::println);

        System.out.println("\n7. JSON response type");
        responses.stream()
                .filter(json)
                .forEach(System.out::println);

        System.out.println("\n8. Status 400 AND JSON");
        responses.stream()
                .filter(status400.and(json))
                .forEach(System.out::println);

        System.out.println("\n9. Status 400 OR JSON");
        responses.stream()
                .filter(status400.or(json))
                .forEach(System.out::println);

        System.out.println("\n10. NOT 400 AND JSON");
        responses.stream()
                .filter(status400.negate().and(json))
                .forEach(System.out::println);
    }
}

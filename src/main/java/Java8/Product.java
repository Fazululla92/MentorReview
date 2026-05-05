package Java8;

public class Product {
    String name;
    double price;
    String category;
    String grade;

    Product(String name, double price, String category, String grade) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.grade = grade;
    }

    public String toString() {
        return name + " " + price + " " + category + " " + grade;
    }
}

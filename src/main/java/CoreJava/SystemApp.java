package CoreJava;

import java.util.*;

public class SystemApp {
    static abstract class Account {
        protected String accountNumber;
        protected double balance;

        public Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: ₹" + amount);
            } else {
                System.out.println("Insufficient balance!");
            }
        }

        public void checkBalance() {
            System.out.println("Balance: ₹" + balance);
        }
        public abstract void specialFeature();
    }
    static class SavingsAccount extends Account {
        double interestRate = 5.0;

        public SavingsAccount(String accNo, double bal) {
            super(accNo, bal);
        }

        public void addInterest() {
            double interest = balance * interestRate / 100;
            balance += interest;
            System.out.println("Interest Added: ₹" + interest);
        }

        @Override
        public void specialFeature() {
            addInterest();
        }
    }
    static class CheckingAccount extends Account {
        int transactionLimit = 3;
        int transactions = 0;

        public CheckingAccount(String accNo, double bal) {
            super(accNo, bal);
        }

        @Override
        public void withdraw(double amount) {
            if (transactions >= transactionLimit) {
                System.out.println("Transaction limit reached!");
                return;
            }
            super.withdraw(amount);
            transactions++;
        }

        @Override
        public void specialFeature() {
            System.out.println("Transactions used: " + transactions);
        }
    }

    static class Product {
        int productId;
        double price;
        int quantityOnHand;

        public Product(int id, double price, int qty) {
            this.productId = id;
            this.price = price;
            this.quantityOnHand = qty;
        }

        public double getPrice() {
            return price;
        }

        public int getProductId() {
            return productId;
        }
    }

    static class DiscountedProduct extends Product {
        double discount; // %

        public DiscountedProduct(int id, double price, int qty, double discount) {
            super(id, price, qty);
            this.discount = discount;
        }

        @Override
        public double getPrice() {
            return price - (price * discount / 100);
        }
    }

    static class ShoppingCart {
        List<Product> cart = new ArrayList<>();

        public void addProduct(Product p) {
            cart.add(p);
            System.out.println("Product added: " + p.getProductId());
        }

        public void removeProduct(int productId) {
            cart.removeIf(p -> p.getProductId() == productId);
            System.out.println("Product removed: " + productId);
        }

        public double calculateTotal() {
            double total = 0;
            for (Product p : cart) {
                total += p.getPrice();
            }
            return total;
        }

        public void showCart() {
            System.out.println("\nCart Items:");
            for (Product p : cart) {
                System.out.println("Product ID: " + p.getProductId() +
                        " | Price: ₹" + p.getPrice());
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("=== BANK SYSTEM ===");

        Account savings = new SavingsAccount("S123", 10000);
        savings.deposit(2000);
        savings.specialFeature();
        savings.checkBalance();

        Account checking = new CheckingAccount("C456", 5000);
        checking.withdraw(1000);
        checking.withdraw(1000);
        checking.withdraw(1000);
        checking.withdraw(1000); // exceeds limit
        checking.specialFeature();
        checking.checkBalance();

        System.out.println("\n=== SHOPPING CART ===");

        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product(1, 1000, 10);
        Product p2 = new DiscountedProduct(2, 2000, 5, 10);

        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.showCart();

        System.out.println("Total Amount: ₹" + cart.calculateTotal());

        cart.removeProduct(1);
        cart.showCart();
    }
}

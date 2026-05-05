package Java8;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class Task6 {

    public static void main(String[] args) {
        IntPredicate isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        System.out.println("1. Prime check:");
        System.out.println("7 is prime? " + isPrime.test(7));
        System.out.println("10 is prime? " + isPrime.test(10));

        IntConsumer squarePrinter = n -> System.out.println("Square: " + (n * n));

        System.out.println("\n2. Square of number:");
        squarePrinter.accept(5);
        squarePrinter.accept(8);

        IntSupplier randomIntSupplier = () -> new Random().nextInt(5000);

        System.out.println("\n3. Random numbers:");
        System.out.println(randomIntSupplier.getAsInt());
        System.out.println(randomIntSupplier.getAsInt());
        System.out.println(randomIntSupplier.getAsInt());
    }
}

package Java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Task8 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("1. Even numbers: " + evens);

        List<Optional<String>> namesOptional = Arrays.asList(
                Optional.of("John"),
                Optional.empty(),
                Optional.of("Jane"),
                Optional.empty()
        );

        List<String> names = namesOptional.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("2. Names: " + names);

        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT", 50000),
                new Employee("B", "HR", 40000),
                new Employee("C", "IT", 90000),
                new Employee("D", "IT", 70000)
        );

        List<String> itNames = employees.stream()
                .filter(e -> e.department.equals("IT"))
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .map(e -> e.name)
                .collect(Collectors.toList());

        System.out.println("3. IT names: " + itNames);

        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);

        long days = ChronoUnit.DAYS.between(today, newYear);

        System.out.println("4. Days to New Year: " + days);

        MathOperation multiply = (a, b) -> a * b;

        System.out.println("5. Multiply: " + multiply.operate(5, 10));

        List<Transaction> transactions = Arrays.asList(
                new Transaction(100, "USD", "COMPLETED"),
                new Transaction(200, "USD", "FAILED"),
                new Transaction(300, "INR", "COMPLETED"),
                new Transaction(400, "INR", "COMPLETED")
        );

        Map<String, Double> result = transactions.stream()
                .filter(t -> t.status.equals("COMPLETED"))
                .collect(Collectors.groupingBy(
                        t -> t.currency,
                        Collectors.summingDouble(t -> t.amount)
                ));

        System.out.println("6. Transaction sum: " + result);

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(e -> e.name))
                .collect(Collectors.toList());

        System.out.println("7. Sorted employees: " + sorted);

        long count = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("8. Parallel even count: " + count);

        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("9. FlatMap result: " + flat);
    }

    static class Employee {
        String name;
        String department;
        double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String toString() {
            return name + " " + department + " " + salary;
        }
    }

    static class Transaction {
        double amount;
        String currency;
        String status;

        Transaction(double amount, String currency, String status) {
            this.amount = amount;
            this.currency = currency;
            this.status = status;
        }
    }

    interface MathOperation {
        int operate(int a, int b);
    }
}

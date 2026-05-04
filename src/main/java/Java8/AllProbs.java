package Java8;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Collectors;

public class AllProbs {
    static class Employee {
        String name;
        int id;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    public static Optional<Integer> secondBiggest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }
    public static boolean areRotations(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
    public static void printNumbersRunnable(int n) {
        Runnable task = () -> {
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        };
        new Thread(task).start();
    }
    public static void sortNumbersReverse(List<Integer> numbers) {
        numbers.sort(Comparator.reverseOrder());
    }
    public static void sortEmployeesByName(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getName));
    }
    public static TreeSet<Integer> treeSetNumbersReverse(Set<Integer> numbers) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        set.addAll(numbers);
        return set;
    }
    public static TreeSet<Employee> treeSetEmployeesByName(Set<Employee> employees) {
        TreeSet<Employee> set = new TreeSet<>(Comparator.comparing(Employee::getName));
        set.addAll(employees);
        return set;
    }
    public static <K, V> TreeMap<K, V> treeMapDescendingKeys(Map<K, V> map, Comparator<K> comparator) {
        TreeMap<K, V> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
    public static TreeMap<Employee, String> treeMapEmployeesByNameDesc(Map<Employee, String> map) {
        TreeMap<Employee, String> treeMap = new TreeMap<>(Comparator.comparing(Employee::getName).reversed());
        treeMap.putAll(map);
        return treeMap;
    }
    public static void sortEmployeesByNameDesc(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparing(Employee::getName).reversed());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1. Palindrome 'racecar': " + isPalindrome("racecar"));
        System.out.println("2. 2nd biggest: " + secondBiggest(Arrays.asList(10, 5, 20, 20, 8)).orElse(null));
        System.out.println("3. Rotations 'abcd', 'cdab': " + areRotations("abcd", "cdab"));

        System.out.println("4. Print numbers 1 to 5 in new thread:");
        printNumbersRunnable(5);
        Thread.sleep(100); // wait for thread to finish

        List<Integer> nums = Arrays.asList(3, 1, 4, 2);
        sortNumbersReverse(nums);
        System.out.println("5. Numbers reverse sorted: " + nums);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 1),
                new Employee("Bob", 2),
                new Employee("Charlie", 3)
        );
        sortEmployeesByName(employees);
        System.out.println("6. Employees sorted by name: " + employees);

        Set<Integer> numSet = new HashSet<>(Arrays.asList(5, 3, 8, 1));
        System.out.println("7. TreeSet numbers reverse: " + treeSetNumbersReverse(numSet));

        Set<Employee> empSet = new HashSet<>(employees);
        System.out.println("8. TreeSet employees by name: " + treeSetEmployeesByName(empSet));

        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(1, "One");
        numMap.put(3, "Three");
        numMap.put(2, "Two");
        System.out.println("9. TreeMap descending keys: " + treeMapDescendingKeys(numMap, Comparator.reverseOrder()));

        Map<Employee, String> empMap = new HashMap<>();
        empMap.put(employees.get(0), "Dept A");
        empMap.put(employees.get(1), "Dept B");
        empMap.put(employees.get(2), "Dept C");
        System.out.println("10. TreeMap employees by name desc: " + treeMapEmployeesByNameDesc(empMap));

        sortEmployeesByNameDesc(employees);
        System.out.println("11. Employees sorted by name descending: " + employees);
    }
}

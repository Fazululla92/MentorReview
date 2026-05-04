package Task5;

public class Six {

    public static boolean Six(int a, int b) {
        return (a == 6 || b == 6 || (a + b) == 6 || Math.abs(a - b) == 6);
    }

    public static void main(String[] args) {
        System.out.println(Six(6, 4));  // true
        System.out.println(Six(4, 6));  // true
        System.out.println(Six(1, 5));  // true (sum is 6)
        System.out.println(Six(10, 4)); // true (difference is 6)
        System.out.println(Six(2, 3));  // false
    }
}

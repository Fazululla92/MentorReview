package CoreJava;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i));
        }

        sc.close();
    }
}

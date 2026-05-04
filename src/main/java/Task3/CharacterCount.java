package Task3;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "Fazululla";
        System.out.print("Enter a character to search: ");
        char ch = sc.next().charAt(0);
        text = text.toLowerCase();
        ch = Character.toLowerCase(ch);

        int count = 0;
        int i = 0;
        if (text.length() > 0) {
            do {
                if (text.charAt(i) == ch) {
                    count++;
                }
                i++;
            } while (i < text.length());
        }
        System.out.println("The character '" + ch + "' appears " + count + " times.");

        sc.close();
    }
}

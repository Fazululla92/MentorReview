package Task4;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.next();

        String result = "";
        int count = 1;

        for(int i = 0; i < str.length(); i++) {
            if(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result += str.charAt(i) + "" + count;
                count = 1;
            }
        }
        if(result.length() >= str.length())
            System.out.println("Output: " + str);
        else
            System.out.println("Output: " + result);

        sc.close();
    }
}

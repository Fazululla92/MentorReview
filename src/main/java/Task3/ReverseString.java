package Task3;

public class ReverseString {
    public static void main(String[] args) {
        String text = "Fazululla";
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        System.out.println("Reversed string: " + reversed);
    }
}
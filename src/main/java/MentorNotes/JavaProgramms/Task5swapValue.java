package MentorNotes.JavaProgramms;

public class Task5swapValue {
    static void main() {
        //swap a and b values
        int a = 10;
        int b = 20;
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a = "+a);
        System.out.println("b = "+b);

        //swap without third variable
        int x = 15;
        int y = 25;
        x = x+y;
        y = x-y;
        x = x-y;
        System.out.println("x = "+x);
        System.out.println("y = "+y);
    }
}

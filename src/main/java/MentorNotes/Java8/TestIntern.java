package MentorNotes.Java8;

public class TestIntern {
    static void main() {
//        with intern
        String a = "Fazul";
        String b = new String("Fazul").intern();
        System.out.println(a == b);
        System.out.println("equals with a&b: "+a.equals(b));

//        without Intern
        String x = "Fazul";
        String y = new String("Fazul");
        System.out.println(x == y);
        System.out.println("equals with x&y: "+x.equals(y));

//        It ensures that a string is stored in (or reused from) the String Constant Pool.
    }
}

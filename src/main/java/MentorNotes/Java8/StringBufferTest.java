package MentorNotes.Java8;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("Hello"); // resizable, faster, non-thread-safe
//        StringBuffer s = new StringBuffer("Hello");  // resizable, slower than SBuilder, thread-safe

        s.append(" world");
        System.out.println(s);
        s.insert(5,",");
        System.out.println(s);
        s.replace(0,5,"Hi");
        System.out.println(s);
        s.delete(0,2);
        System.out.println(s);
        s.reverse();
        System.out.println(s);
    }
}

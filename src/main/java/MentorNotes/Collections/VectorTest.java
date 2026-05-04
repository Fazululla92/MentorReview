package MentorNotes.Collections;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<String> s = new Vector<>();
        s.add("Fazul");
        s.add("sadha");
        s.add("hamza");
        s.add("Siraj");
        s.add("Fazul");
        System.out.println("check ArrayList : " + s);

        System.out.println("check ArrayList : " + s.get(0));
        s.set(0, "Fazululla");
        System.out.println("check ArrayList : " + s);

        s.remove("Fazul");
        System.out.println("check ArrayList : " + s);

        System.out.println("check ArrayList : " + s.size());

        for (String name : s) {
            System.out.println("for loop : " + name);
        }
    }
}

package MentorNotes.Collections;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    static void main() {
        List<String> s = new ArrayList<>();
        s.add("Fazul");
        s.add("sadha");
        s.add("hamza");
        s.add("Siraj");
        s.add("Fazul");
        System.out.println("check ArrayList : "+s);
        for(String name : s){
            System.out.println("for loop : "+name);
        }
    }
}

package MentorNotes.Java8;

//import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.*;

public class MaxLengthInSentence {
    static void main() {
//        String s = "I am learning stream api in java";
//        String max = Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get();
//        String min = Arrays.stream(s.split(" ")).min(Comparator.comparing(String::length)).get();
//        System.out.println(max);
//        System.out.println(min);

//        Arrays.stream(s.split(" ")).max(Comparator.comparing(String::))

        String x= "fazul";
        String y= "fazul";
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(y));
        System.out.println(x.equals(y)); //it will check the content of string
        System.out.println(x==y); // it will check object reference address of the string
        y = y+"sai";
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(y));

    }

//    @Test
    public void test(){
        System.out.println("dvf jkdfj");
    }
}

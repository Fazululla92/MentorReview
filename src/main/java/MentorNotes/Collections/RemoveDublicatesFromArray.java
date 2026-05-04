package MentorNotes.Collections;

import java.util.*;

public class RemoveDublicatesFromArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,3,4,5,5,6,4};

        Set<Integer> hs = new HashSet<>();
        for(int num : arr){
            hs.add(num);
        }
        System.out.println("duplicates removed in hs check : "+hs);

        List<Integer> al = new ArrayList<>();
        for(int num : arr){
            al.add(num);
        }
        System.out.println("duplicates allowed al check : "+al);

        List<Integer> ll = new LinkedList<>();
        for(int num : arr){
            ll.add(num);
        }
        System.out.println("duplicates allowed ll check : "+ll);
    }


}

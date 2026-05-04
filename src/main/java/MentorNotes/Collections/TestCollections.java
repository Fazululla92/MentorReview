package MentorNotes.Collections;

import java.util.*;

public class TestCollections {
    public static void main() {
        TestCollections lc = new TestCollections();
        lc.arrayListMeth();
        linkedList lll= new linkedList();
        lll.linkedListMeth();
        SetCheck sc = new SetCheck();
        sc.hasSetCheck();
        linkedHasSetCheck lhs = new linkedHasSetCheck();
        lhs.linkedHasSetMeth();


    }

    public void arrayListMeth(){
        List<String> al = new ArrayList<>();
        al.add("fazululla");
        al.add("siraj");
        al.add("sadha");
        al.add("Fazul");
        al.add("siraj");
        System.out.println(al);
        al.remove("fazululla");
        al.remove(3);
        al.add(null);
        System.out.println(al);  //faster,allow dublicates, no thread safe, resizable, less inter and delete in middle.
    }
}

class linkedList{
    public void linkedListMeth(){
        LinkedList<String> ll = new LinkedList<>();
        ll.add("fazululla");
        ll.add("siraj");
        ll.add("sadha");
        ll.add("Fazul");
        ll.add("siraj");
        System.out.println(ll);
        ll.remove("fazululla");
        ll.remove(3);
        ll.add(null);
        System.out.println(ll); //frequent insert and delete operations, double linked list, no thread safe.
    }
}

class SetCheck {
    public void hasSetCheck(){
        Set<Integer> hasSet = new HashSet<>();
        hasSet.add(10);
        hasSet.add(null);
        hasSet.add(20);
        hasSet.add(20);
        hasSet.add(10);
        System.out.println(hasSet);
        hasSet.add(null);
        hasSet.add(0);
        System.out.println(hasSet); //remove dublicates
    }
}

class linkedHasSetCheck {
    public void linkedHasSetMeth(){
        Set<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(20);
        lhs.add(10);
        lhs.add(30);
        lhs.add(30);
        lhs.add(60);
        System.out.println(lhs);
    }
}



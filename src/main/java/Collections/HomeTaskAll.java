package Collections;

import java.util.*;

public class HomeTaskAll {
    public static void main(String[] args) {

        // a) ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Mango");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("ArrayList get(1): " + arrayList.get(1));

        // b) LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.addFirst(5);
        linkedList.addLast(30);
        System.out.println("\nLinkedList: " + linkedList);
        linkedList.removeFirst();
        System.out.println("After removeFirst(): " + linkedList);

        // c) HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        System.out.println("\nHashMap: " + hashMap);
        System.out.println("Value for key 2: " + hashMap.get(2));

        // d) LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        System.out.println("\nLinkedHashMap (insertion order): " + linkedHashMap);

        // e) HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("A"); // duplicate ignored
        System.out.println("\nHashSet: " + hashSet);

        // f) LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("X");
        linkedHashSet.add("Y");
        linkedHashSet.add("X"); // duplicate ignored
        System.out.println("\nLinkedHashSet (insertion order): " + linkedHashSet);

        // g) TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(10); // duplicate ignored
        System.out.println("\nTreeSet (sorted): " + treeSet);

        // h) TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(50, "Fifty");
        treeMap.put(10, "Ten");
        treeMap.put(30, "Thirty");
        System.out.println("\nTreeMap (sorted by keys): " + treeMap);

        // Iterating TreeMap
        System.out.print("TreeMap Keys: ");
        for (int key : treeMap.keySet()) {
            System.out.print(key + " ");
        }

        System.out.println();
    }
}
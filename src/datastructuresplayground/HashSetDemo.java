package datastructuresplayground;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> h = new HashSet<>();

        // adding elements
        h.add("India");
        h.add("Australia");
        h.add("South Africa");

        // adding a duplicate element
        h.add("India");

        // displaying the HashSet
        System.out.println(h);

        // removing an item
        h.remove("Australia");
        System.out.println("Set after removing Australia: " + h);

        // iterating over set items
        System.out.println("Iterating over set:");
        Iterator<String> i = h.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }

    }


}

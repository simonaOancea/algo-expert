package datastructuresplayground;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("item one", 10);
        map.put("item two", 30);
        map.put("item three", 20);

        System.out.println("Size of map is: " + map.size());
        System.out.println("Printing elements of map: " + map);

        if (map.containsKey("item one")) {
            Integer a = map.get("item one");

            System.out.println("value for key item one is: " + a);
        }

        // remove an element
        map.remove("item one");
        System.out.println("Content of the map after removal: " + map);

        // iteration
        System.out.println("Iterating through the map:");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }

    }
}

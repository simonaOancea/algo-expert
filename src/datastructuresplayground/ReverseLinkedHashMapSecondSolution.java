package datastructuresplayground;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReverseLinkedHashMapSecondSolution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("one", "apples");
        map.put("two", "oranges");

        if (map.containsKey("aa")) {
            map.put("two", "bananas");
        } else {
            Map<String, String> newMap = new LinkedHashMap<>(map);
            map.clear();
            map.put("three", "kiwis");
            map.putAll(newMap);
        }


        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());

        }
    }

}

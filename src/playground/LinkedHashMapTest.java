package playground;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("one", "apples");
        map.put("two", "oranges");
        map.put("three", "bananas");



        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());

        }



    }
}

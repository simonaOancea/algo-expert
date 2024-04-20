package datastructuresplayground;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReverseLinkedHashMap<K, V> {
    public static <K, V> LinkedHashMap<K, V> reverse(LinkedHashMap<K, V> original) {
        List<Map.Entry<K, V>> list = new java.util.ArrayList<>(original.entrySet());
        Collections.reverse(list);
        return list.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> original = new LinkedHashMap<>();
        original.put("a", 1);
        original.put("b", 2);
        original.put("c", 3);

        LinkedHashMap<String, Integer> reversed = ReverseLinkedHashMap.reverse(original);
        System.out.println(reversed); // prints "{c=3, b=2, a=1}"

    }
}

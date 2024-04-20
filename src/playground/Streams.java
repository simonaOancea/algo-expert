package playground;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        //List<String> names = List.of("One", "Two", "Three", "One", "Five", "Two");
        //names.stream().collect(Collectors.toMap(name -> name));
        //Map<String, Integer> frequencyOfStrings = new HashMap<>();

        List<String> names = List.of("One", "Two", "Three", "One", "Five", "Two");

        // Use Java streams to count the occurrences of each element in the list

        Map<String, Long> elementCounts = names.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        for (Map.Entry<String,Long> entry : elementCounts.entrySet()) {
            System.out.println("Key is: " + entry.getKey());
            System.out.println("Value is: " + entry.getValue());
        }

        // Filter the elements that appear more than once
        List<String> duplicates = elementCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Print the elements that appear more than once
        System.out.println("Elements that appear more than once: " + duplicates);
    }

    // 1. Extract the elements that appear more than once
    // 2. Transform the set into a map that contains name as the key and number of chars as a value
    // 3. extract the sum of characters from all strings combined
}

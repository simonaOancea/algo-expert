package strings;

import java.util.HashMap;
import java.util.Map;

// O(n) time | O(1) space - where n is the length of the input string
// The constant space is because the input string has only lowercase English-alphabet letter;
// thus, our hash table will never have more than 26 character frequencies.
public class FirstNonRepeatingCharacterOptimal {
    public static void main(String[] args) {
        String str = "faadabcbbebdf";
        System.out.println(firstNonRepeatingCharacter(str));
    }

    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }

        for (int i = 0 ; i < string.length(); i++) {
            char character = string.charAt(i);
            if (characterFrequencies.get(character) == 1) {
                return i;
            }
        }

        return -1;
    }
}

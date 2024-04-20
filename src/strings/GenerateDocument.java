package strings;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    public static void main(String[] args) {
        String characters = "A";
        String document = "a";
        System.out.println(generateDocument(characters, document));
    }

    public static boolean generateDocument(String characters, String document) {
        char[] charArr = characters.toCharArray();
        char[] docArr = document.toCharArray();
        Map<String, Integer> charFrequency = new HashMap<>();
        Map<String, Integer> docFrequency = new HashMap<>();

        for (int i = 0; i < charArr.length; i ++) {
            int frequency;
            if (charFrequency.containsKey(String.valueOf(charArr[i]))) {
                frequency = charFrequency.get(String.valueOf(charArr[i]));
                charFrequency.put(String.valueOf(charArr[i]), ++frequency);
            } else {
                charFrequency.put(String.valueOf(charArr[i]), 1);
            }
        }

        for (int i = 0; i < docArr.length; i ++) {
            int frequency;
            if (docFrequency.containsKey(String.valueOf(docArr[i]))) {
                frequency = docFrequency.get(String.valueOf(docArr[i]));
                docFrequency.put(String.valueOf(docArr[i]), ++frequency);
            } else {
                docFrequency.put(String.valueOf(docArr[i]), 1);
            }
        }

        for (Map.Entry<String, Integer> docEntry : docFrequency.entrySet()) {
            String key = docEntry.getKey();
            int docFreq = docEntry.getValue();
            if (charFrequency.containsKey(key)) {
                int chrFreq = charFrequency.get(key);
                if (chrFreq < docFreq) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}

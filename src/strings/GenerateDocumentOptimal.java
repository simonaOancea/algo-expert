package strings;

// O(m * (n + m) time | O (1) space - where n is the number
// of characters and m is the length of the document
public class GenerateDocumentOptimal {
    public static void main(String[] args) {
        String characters = "Aaa";
        String document = "aa";

        System.out.println(generateDocument(characters, document));
    }

    public static boolean generateDocument(String characters, String document) {
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
            int documentFrequency = countCharacterFrequency(character, document);
            int charactersFrequency = countCharacterFrequency(character, characters);
            if (documentFrequency > charactersFrequency) {
                return false;
            }
        }

        return true;
    }

    public static int countCharacterFrequency(char character, String target) {
        int frequency = 0;
        for (int idx = 0; idx < target.length(); idx++) {
            char c = target.charAt(idx);
            if (c == character) {
                frequency += 1;
            }
        }

        return frequency;
    }
}

package strings;

//O(n^2) time | O(1) space
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "faadabcbbebdf";
        System.out.println(firstNonRepeatingCharacter(str));
    }

    public static int firstNonRepeatingCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (countCharacterFrequency(character, string) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int countCharacterFrequency(char character, String target) {
        int frequency = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == character) {
                frequency += 1;
            }
        }

        return frequency;
    }
}

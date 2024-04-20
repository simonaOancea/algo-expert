package strings;

public class CaesarCipherEncryptor {
    public static void main(String[] args) {
        String str = "xyz";
        int key = 53;

        System.out.println(caesarCypherEncryptor(str, key));
    }
    public static String caesarCypherEncryptor(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter(str.charAt(i), newKey);
        }

        return new String(newLetters);
    }

    public static char getNewLetter(char letter, int key) {
        int newLetterCode = letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }
}

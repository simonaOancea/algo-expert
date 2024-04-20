package strings;

// O(n) time | O(n) space
public class PalidromeCheck {
    public static void main(String[] args) {
    String palidrome = "abb";
    System.out.println(isPalidrome(palidrome));
    }
    public static boolean isPalidrome(String str) {
        if (str.length() == 1) {
            return true;
        } else {
           String reversedStr = "";
           char ch;
           for (int i = 0; i < str.length(); i++) {
               ch = str.charAt(i);
               reversedStr = ch + reversedStr;
           }
           if (str.equals(reversedStr)) {
               return true;
           }
        }
        return false;
    }
}

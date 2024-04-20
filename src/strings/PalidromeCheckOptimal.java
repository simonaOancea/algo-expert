package strings;
// O(n) time | O(1) space
public class PalidromeCheckOptimal {
    public static void main(String[] args) {
        String palidrome = "abba";
        System.out.println(isPalidrome(palidrome));
    }

    public static boolean isPalidrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
}

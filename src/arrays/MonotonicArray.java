package arrays;


public class MonotonicArray {
// O(n) time | O(1) space - where n is the length of the array
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(array));
    }

    public static boolean isMonotonic(int[] array) {
        boolean isDecreasing = true;
        boolean isIncreasing = true;

        if (array.length < 2) {
            return true;
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                int j = i + 1;
                if (array[i] < array[j]) {
                    isIncreasing = false;
                }
                if (array[i] > array[j]) {
                    isDecreasing = false;
                }
            }
        }

        return isDecreasing || isIncreasing;
    }


}

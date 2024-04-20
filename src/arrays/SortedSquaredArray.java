package arrays;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 8, 9};
        int[] result = sortedSquaredArray(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // O(nlogn) time | O(n) space
    public static int[] sortedSquaredArray(int[] array) {
        int[] squaredArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            squaredArray[i] = array[i] * array[i];
        }

        Arrays.sort(squaredArray);

        return squaredArray;
    }
}

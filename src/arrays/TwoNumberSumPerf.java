package arrays;

import java.util.HashSet;
import java.util.Set;

// O(n) time | O(n) space
public class TwoNumberSumPerf {

    public static void main(String[] args) {
        int[] array = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        int[] result = twoNumberSum(array, targetSum);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int number : array) {
            int potentialMatch = targetSum - number;
            if (uniqueNums.contains(potentialMatch)) {
                return new int[] {potentialMatch, number};
            } else {
                uniqueNums.add(number);
            }
        }

        return new int[0];
    }
}

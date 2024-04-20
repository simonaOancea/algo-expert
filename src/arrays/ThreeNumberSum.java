package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// O(n^2) time | O(n) space
public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;

        List<Integer[]> sums = threeNumberSum(array, targetSum);
        for(Integer[] element : sums) {
            for (int i = 0; i < element.length; i++) {
                System.out.println(element[i]);
            }
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
              int currentSum = array[i] + array[left] + array[right];
              if (currentSum == targetSum) {
                  Integer[] newTriplet = {array[i], array[left], array[right]};
                  triplets.add(newTriplet);
                  left++;
                  right--;
              } else if (currentSum < targetSum) {
                  left++;
              } else if (currentSum > targetSum) {
                  right--;
              }
            }
        }
        return triplets;
    }
}

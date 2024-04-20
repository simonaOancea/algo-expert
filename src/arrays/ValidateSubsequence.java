package arrays;

import java.util.*;

public class ValidateSubsequence {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> subsequence = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10, 12);

        System.out.println(isValidSubsequence(array, subsequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
       int arrayIndex = 0;
       int sequenceIndex = 0;

       while (arrayIndex < array.size()) {
           if (array.get(arrayIndex).equals(sequence.get(sequenceIndex))) {
               sequenceIndex++;
           }
           arrayIndex++;
       }

        return sequenceIndex == sequence.size();
    }
}

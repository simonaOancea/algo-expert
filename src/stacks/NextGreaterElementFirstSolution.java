package stacks;

import java.util.Arrays;
import java.util.Stack;

// O(n) time | O(n) space - where n is the length of the array
public class NextGreaterElementFirstSolution {

    public static void main(String[] args) {
        int[] array = {2, 5, -3, -4, 6, 7, 2};
        int[] result = nextGreatElement(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] nextGreatElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * array.length; i++) {
            int circularIdx = i % array.length;

            while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
                int top = stack.pop();
                result[top] = array[circularIdx];
            }

            stack.push(circularIdx);
        }

        return result;
    }
}

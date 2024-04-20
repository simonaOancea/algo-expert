package stacks;

import java.util.Arrays;
import java.util.Stack;

// O(n) time | O(n) space - where n is the length of the array
public class NextGreaterElementSecondSolution {

    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int idx = 2 * array.length - 1; idx >= 0; idx--) {
            int circularIdx = idx % array.length;

            while (stack.size() > 0) {
                if (stack.peek() <= array[circularIdx]) {
                    stack.pop();
                } else {
                    result[circularIdx] = stack.peek();
                    break;
                }
            }
            stack.push(array[circularIdx]);
        }

        return result;
    }
}

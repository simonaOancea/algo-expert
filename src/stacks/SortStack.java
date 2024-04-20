package stacks;

import java.util.ArrayList;
import java.util.Arrays;
// O(n^2) time | O(n) space - where n is the length of the stack
public class SortStack {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        System.out.println(sortStack(stack));
    }

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }
        int top = stack.remove(stack.size() - 1);

        sortStack(stack);
        insertInSortedOrder(stack, top);

        return stack;
    }

    public static void insertInSortedOrder(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        int top = stack.remove(stack.size() - 1);
        insertInSortedOrder(stack, value);
        stack.add(top);
    }
}

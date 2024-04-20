package stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxConstruction {
    public static void main(String[] args) {

        MinMaxStack stack = new MinMaxStack();

        System.out.println("Pushing elements to the stack: ");
        stack.push(3);
        stack.push(5);
        stack.push(2);
        for (int element : MinMaxStack.stack) {
            System.out.println(element);
        }

        System.out.println("Retrieving min-max pair elements: ");
        for (Map<String, Integer> elem : MinMaxStack.minMaxStack) {
           System.out.println(elem);
        }

        System.out.println("Peeking: ");
        System.out.println(stack.peek());

        System.out.println("Popping: ");
        System.out.println(stack.pop());
    }

    static class MinMaxStack {
        static List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        static List<Integer> stack = new ArrayList<>();

        // O(1) time | O(1) space
        public int peek() {
            return stack.get(stack.size() - 1);
        }

        // O(1) time | O(1) space
        public  int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        // O(1) time | O(1) space
        public void push(int number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax =
                        new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        // O(1) time | O(1) space
        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        // O(1) time | O(1) space
        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}

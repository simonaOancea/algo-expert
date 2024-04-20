package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// O(n) time | O(n) space - where n is the number of buildings
public class LargestRectangleUnderSkylineSecondSolution {
    public static void main(String[] args) {
        ArrayList<Integer> buildings = new ArrayList<>();
        buildings.addAll(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2));

        System.out.println(largestRectangleUnderSkyline(buildings));
    }

    public static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Stack<Integer> pillarIndices = new Stack<>();
        int maxArea = 0;

        ArrayList<Integer> extendedBuildings = new ArrayList<>(buildings);
        extendedBuildings.add(0);
        for (int idx = 0; idx < extendedBuildings.size(); idx++) {
            int height = extendedBuildings.get(idx);
            while(!pillarIndices.isEmpty()
                    && extendedBuildings.get(pillarIndices.peek()) >= height) {
                int pillarHeight = extendedBuildings.get(pillarIndices.pop());
                int width = (pillarIndices.isEmpty()) ? idx : idx - pillarIndices.peek() - 1;
                maxArea = Math.max(width * pillarHeight, maxArea);
            }
            pillarIndices.push(idx);
        }

        return maxArea;
    }
}

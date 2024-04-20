package stacks;

import java.util.ArrayList;
import java.util.Arrays;
// O(n^2) time | O(1) space - where n is the length of the input array
public class LargestRectangleUnderSkylineFirstSolution {
    public static void main(String[] args) {
        ArrayList<Integer> buildings = new ArrayList<>();
        buildings.addAll(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2));

        System.out.println(largestRectangleUnderSkyline(buildings));
    }

    public static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
       int maxArea = 0;
       for (int pillarIdx = 0; pillarIdx < buildings.size(); pillarIdx++) {
           int currentHeight = buildings.get(pillarIdx);

           int furthestLeft = pillarIdx;
           while (furthestLeft > 0
                   && buildings.get(furthestLeft - 1) >= currentHeight) {
               furthestLeft -= 1;
           }

           int furthestRight = pillarIdx;
           while (furthestRight < buildings.size() - 1
                   && buildings.get(furthestRight + 1) >= currentHeight) {
               furthestRight += 1;
           }

           int areWithCurrentBuilding = (furthestRight - furthestLeft + 1) * currentHeight;
           maxArea = Math.max(areWithCurrentBuilding, maxArea);
       }

        return maxArea;
    }


}

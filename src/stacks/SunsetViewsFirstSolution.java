package stacks;

import java.util.ArrayList;
import java.util.Collections;

// O(n) time | O(n) space - where n is the length of the input array
public class SunsetViewsFirstSolution {
    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(sunsetViews(buildings, "EAST"));
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<>();
        int startIdx = buildings.length - 1;
        int step = -1;

        if (direction.equals("WEST")) {
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        int runningMaxHeight = 0;

        while (idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];
            if (buildingHeight > runningMaxHeight) {
                buildingsWithSunsetViews.add(idx);
            }
            runningMaxHeight = Math.max(runningMaxHeight, buildingHeight);
            idx += step;
        }

        if (direction.equals("EAST")) {
            Collections.reverse(buildingsWithSunsetViews);
        }

        return buildingsWithSunsetViews;
    }
}

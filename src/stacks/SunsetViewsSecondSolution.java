package stacks;

import java.util.ArrayList;
import java.util.Collections;

// O(n) time | O(n) space - where n is the length of the input array
public class SunsetViewsSecondSolution {
    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(sunsetViews(buildings, "WEST"));
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> candidateBuildings = new ArrayList<>();
        int startIdx = buildings.length - 1;
        int step = -1;

        if (direction.equals("EAST")) {
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        while (idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];

            while (candidateBuildings.size() > 0 &&
            buildings[candidateBuildings.get(candidateBuildings.size() - 1)] <= buildingHeight) {
                candidateBuildings.remove(candidateBuildings.size() - 1);
            }

            candidateBuildings.add(idx);
            idx += step;
        }
        if (direction.equals("WEST")) {
            Collections.reverse(candidateBuildings);
        }

        return candidateBuildings;
    }
}

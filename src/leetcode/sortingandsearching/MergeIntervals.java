package leetcode.sortingandsearching;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

		MergeIntervals mergeIntervals = new MergeIntervals();
		mergeIntervals.merge(intervals);

		for (int[] interval : intervals) {
			System.out.println(Arrays.toString(interval));
		}
	}

	// Time complexity is O(nlogn) because of the sorting
	// Space complexity is O(n) because of the LinkedList
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		// we're using a linked list because we're going to be retrieving the last element often
		LinkedList<int[]> merged = new LinkedList<>();

		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}
}

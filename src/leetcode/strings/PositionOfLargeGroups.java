package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/interview/card/adobe/483/array-and-strings/2503/

public class PositionOfLargeGroups {
	public static void main(String[] args) {
		PositionOfLargeGroups sol = new PositionOfLargeGroups();

		System.out.println(sol.largeGroupPositions("abbxxxxzzy"));        // [[3,6]]
		System.out.println(sol.largeGroupPositions("abc"));               // []
		System.out.println(sol.largeGroupPositions("abcdddeeeeaabbbcd")); // [[3,5],[6,9],[12,14]]
	}

	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();
		int n = s.length();
		if (n < 3) return result;

		int start = 0; // start index of the current group
		for (int i = 1; i <= n; i++) {
			// either we've reached the end, or the group is broken
			if (i == n || s.charAt(i) != s.charAt(i - 1)) {
				int length = i - start;
				if (length >= 3) {
					List<Integer> interval = new ArrayList<>(2);
					interval.add(start);
					interval.add(i - 1);
					result.add(interval);
				}
				start = i; // begin new group
			}
		}

		return result;
	}
}

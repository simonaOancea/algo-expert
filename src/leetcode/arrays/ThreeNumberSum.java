package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeNumberSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>(); // the place where we will store our triplets
		Set<Integer> dups = new HashSet<>(); // here we will store the currently explored number
		Map<Integer, Integer> seen = new HashMap<>(); // here we will store our number with last index where we were able to find it
		for (int i = 0 ; i < nums.length; i++) {
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; ++j) {
					int complement = -nums[i] - nums[j];
					if (seen.containsKey(complement) && seen.get(complement) == i) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(triplet);
						res.add(triplet);
					}
					seen.put(nums[j], i);
				}

			}
		}
		return new ArrayList<>(res);
	}
}

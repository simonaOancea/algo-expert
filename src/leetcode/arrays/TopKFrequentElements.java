package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TopKFrequentElements {
	public static void main(String[] args) {
		TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		int[] result = topKFrequentElements.topKFrequent(nums, 2);

		for (int j : result) {
			System.out.println(j);
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		if (nums.length == 0) {
			return new int[] {0};
		}

		Map<Integer, Integer> frequencies = new HashMap<>();
		for (int num : nums) {
			frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
		}

		List<Integer> candidates = new ArrayList<>(frequencies.keySet());
		candidates.sort((num1, num2) -> frequencies.get(num2) - frequencies.get(num1));

		List<Integer> topK = candidates.subList(0, k);
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = topK.get(i);
		}

		return result;
	}
}

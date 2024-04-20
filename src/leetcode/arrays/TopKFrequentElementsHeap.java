package leetcode.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElementsHeap {
	public static void main(String[] args) {

	}

	public int[] topKFrequent(int[] nums, int k) {
		// O(1) time
		if (k == nums.length) {
			return nums;
		}

		// 1. Build hash map: character and how often it appears
		// O(N) time
		Map<Integer, Integer> count = new HashMap<>();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		// init heap 'the less frequent element first'
		Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

		// 2. Keep k top frequent elements in the heap
		// O(N log k) < O(N log N) time
		for (int n: count.keySet()) {
			heap.add(n);
			if (heap.size() > k) heap.poll();
		}

		// Build an output array
		// O(k log k) time
		int[] top = new int[k];
		for (int i = k -1; i >= 0; --i) {
			top[i] = heap.poll();
		}

		return top;
	}
}

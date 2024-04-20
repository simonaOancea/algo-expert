package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
// Time Complexity: O(N + klogN). We count the frequency of each word in O(N) time and then heapify the list of unique words in O(N) time.
// Each time we pop the top from the heap, it costs log N time as the size of the heap is O(N).
// Space Complexity: O(N), the space used to store our counter cnt and heap h.
public class TopKFrequentWordsHeap {
	class Word implements Comparable<Word> {
		private final String word;
		private final int count;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}

		@Override
		public int compareTo(Word other) {
			if (this.count == other.count) {
				return this.word.compareTo(other.word);
			}
			return other.count - this.count;
		}
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> cnt = new HashMap<>();
		for (String word : words) {
			cnt.put(word, cnt.getOrDefault(word, 0) + 1);
		}

		List<Word> candidates = new ArrayList<>();
		for (var entry : cnt.entrySet()) {
			candidates.add(new Word(entry.getKey(), entry.getValue()));
		}

		Queue<Word> heap = new PriorityQueue<>(candidates);
		List<String> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(Objects.requireNonNull(heap.poll()).word);
		}

		return res;
	}
}

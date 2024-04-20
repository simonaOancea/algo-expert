package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Input: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" comes before "love" due to a lower alphabetical order.

// Time Complexity: O(NlogN) - we count the frequency of each word in O(N) time, and then we sort the given words in O(NlogN) time.
// Space Complexity: O(N) - the space used to store frequencies in a HashMap and return a slice from a sorted list of length O(N)

public class TopKFrequentWords {
	public static void main(String[] args) {
		TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

		System.out.println(topKFrequentWords.topKFrequent(words, 2));
	}

	public List<String> topKFrequent(String[] words, int k) {
		// key: word, value: frequency
		Map<String, Integer> cnt = new HashMap<>();
		for (String word : words) {
			cnt.put(word, cnt.getOrDefault(word,0) + 1);
		}

		List<String> candidates = new ArrayList<>(cnt.keySet());
		candidates.sort((w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w1.compareTo(w2) : cnt.get(w2) - cnt.get(w1));

		return candidates.subList(0, k);
	}
}

package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

// Time: O(N × M) where N is the number of string and M the avg length of a string
//Space: O(N × M)
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix sol = new LongestCommonPrefix();
		String[] example1 = {"flower","flow","flight"};
		System.out.println(sol.longestCommonPrefix(example1));  // prints "fl"

		String[] example2 = {"dog","racecar","car"};
		System.out.println(sol.longestCommonPrefix(example2));  // prints ""

	}

	// 1. Define the TrieNode
	private static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		boolean isEndOfWord = false;
	}

	// 2. Build the Trie and insert all words
	private static class Trie {
		private final TrieNode root = new TrieNode();

		public void insert(String word) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				node = node.children.computeIfAbsent(ch, c -> new TrieNode());
			}
			node.isEndOfWord = true;
		}

		// 3. Walk down the trie as long as there's exactly one child and it's not the end of a word
		public String longestCommonPrefix() {
			StringBuilder prefix = new StringBuilder();
			TrieNode node = root;

			while (node.children.size() == 1 && !node.isEndOfWord) {
				// get the single child entry
				Map.Entry<Character, TrieNode> entry = node.children.entrySet().iterator().next();
				prefix.append(entry.getKey());
				node = entry.getValue();
			}

			return prefix.toString();
		}
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Trie trie = new Trie();
		for (String s : strs) {
			if (s.isEmpty()) {
				return ""; //edge case: empty string means no common prefix beyond ""
			}
			trie.insert(s);
		}

		return trie.longestCommonPrefix();
	}
}

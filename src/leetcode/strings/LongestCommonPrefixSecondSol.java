package leetcode.strings;
// O(N*M) time
// O(1) space
public class LongestCommonPrefixSecondSol {

	public static void main(String[] args) {
		LongestCommonPrefixSecondSol sol = new LongestCommonPrefixSecondSol();
		String[] example1 = {"flower", "flow", "flight"};
		System.out.println(sol.longestCommonPrefix(example1));

		String[] example2 = {"dog","racecar","car"};
		System.out.println(sol.longestCommonPrefix(example2));  // prints ""
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";

		// Start with the entire first string as a candidate prefix
		String prefix = strs[0];

		// Compare with each subsequent string...
		for (int i = 1; i < strs.length; i++) {
			String s = strs[i];
			// Shrink the prefix until it matches the start of s
			while (!s.startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";  // no common prefix
				}
			}
		}

		return prefix;
	}

}

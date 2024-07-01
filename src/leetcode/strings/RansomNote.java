package leetcode.strings;

public class RansomNote {

	public static void main(String[] args) {
		RansomNote ransomNote = new RansomNote();
		System.out.println(ransomNote.canFormString("aaa", "aab"));

	}

	public boolean canFormString(String s1, String s2) {
		int[] countArray = new int[26];

		for (char c : s2.toCharArray()) {
			countArray[c - 'a']++;
		}

		for (char c : s1.toCharArray()) {
			if (countArray[c - 'a'] == 0) {
				return false;
			}
			countArray[c - 'a']--;
		}

		return true;
	}
}

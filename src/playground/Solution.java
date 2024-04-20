package playground;

import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {
		String[] str = new String[] {"aab", "cac", "ac", "ba", "caa", "d", "ab"};
		Solution solution = new Solution();

		System.out.println(solution.similarPairs(str));
	}

	public int similarPairs(String[] words) {
		int count=0;
        for (int i = 0; i < words.length - 1; i++)
        {
            for (int j = i + 1; j < words.length; j++)
            {
                count+=check(words[i],words[j]);
            }
        }
        return count;
	}

	private int check(String a, String b) {
		HashSet<Character> aset = new HashSet<>();
		for (char ch : a.toCharArray()) {
			aset.add(ch);

		}
		HashSet<Character> bset = new HashSet<>();
		for (char ch : b.toCharArray()) {
			aset.add(ch);
		}

		return aset.equals(bset) ? 1 : 0;
	}
}

package test.leetcode.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.strings.LongestCommonPrefixSecondSol;

public class LongestCommonPrefixSecondSolTest {

	@Test
	public void testLongestCommonPrefix() {
		String[] input = {"crown", "crowded", "crowbar"};
		LongestCommonPrefixSecondSol testee = new LongestCommonPrefixSecondSol();

		String result = testee.longestCommonPrefix(input);

		assertEquals("crow", result);
	}

	@Test
	public void testLongestCommonPrefixNoPrefix() {
		String[] input = {"make", "shake", "maybe"};
		LongestCommonPrefixSecondSol testee = new LongestCommonPrefixSecondSol();

		String result = testee.longestCommonPrefix(input);

		assertEquals("", result);
	}
}

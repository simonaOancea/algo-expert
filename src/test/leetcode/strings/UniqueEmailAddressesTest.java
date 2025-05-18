package test.leetcode.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.strings.UniqueEmailAddresses;

public class UniqueEmailAddressesTest {

	@Test
	public void testUniqueEmailAddresses() {
		UniqueEmailAddresses testee = new UniqueEmailAddresses();
		String[] input = {
				"a@leetcode.com",
				"b@leetcode.com",
				"c@leetcode.com"
		};

		int actual = testee.numUniqueEmails(input);
		int expected = 3;

		assertEquals("Expected " + expected + " unique email addresses, but got " + actual, expected, actual);
	}
}

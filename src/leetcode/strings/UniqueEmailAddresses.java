package leetcode.strings;


import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/unique-email-addresses/description/

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 */

// T: (N*M)
// O: (N*M)
public class UniqueEmailAddresses {

	public static void main(String[] args) {
		UniqueEmailAddresses sol = new UniqueEmailAddresses();
		String[] emails = new String[3];
		emails[0] = "test.email+alex@leetcode.com";
		emails[1] = "test.e.mail+bob.cathy@leetcode.com";
		emails[2] = "testemail+david@lee.tcode.com";

		System.out.println(sol.numUniqueEmails(emails));

	}

	public int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmailAddresses = new HashSet<>();

		if (emails.length == 0) {
			return 0;
		}

		for (String email : emails) {
			uniqueEmailAddresses.add(normalizeEmail(email));
		}

		return uniqueEmailAddresses.size();
	}

	private String normalizeEmail(String email) {
		String[] parts = email.split("@");
		String local = parts[0];
		String domain = parts[1];

		if (local.contains("+")) {
			local = local.substring(0, local.indexOf('+'));
		}

		local = local.replace(".", "");

		return local + "@" + domain;
	}
}

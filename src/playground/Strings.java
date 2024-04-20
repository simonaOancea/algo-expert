package playground;

import java.util.HashSet;
import java.util.Set;

/*
I: aab, cac, ac, ba, caa, d, ab
O:
aab -> 3 [aab, ba, ab]
cac -> 3 [cac, ac, caa]
d -> 1 [d]

// ["ab", "ba"]; ["ab, "ab"]

Fiind data secventa I de stringuri alcatuita din litere [a-z], sa se scrie un program in Java/Scala/pseudocod care afiseaza outputul O, unde un rand din output reprezinta numarul de apartii al stringurilor alcatuite din aceleasi litere.
Cuvintele "aab" si "ba" sunt "la fel" dupa cum ele sunt compuse din literele "a" si "b".
 */
public class Strings {
	public static void main(String[] args) {
		String[] str = new String[] {"aab", "cac", "ac", "ba", "caa", "d", "ab"};
		String s1 = "ab";
		String s2 = "ba";

		Strings strings = new Strings();
		//strings.compare(s1, s2);
	}

	public void count(String[] str) {
		if (str.length == 1) {
			System.out.println(str[0] + " -> 1 [" + str[0] + "]");
		}

		StringBuilder result = new StringBuilder();

	}

	public boolean isIdenticalString(String s1, String s2) {
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		boolean isIdentical = false;

		Set<Character> uniqueCharsS1 = new HashSet<>();
		Set<Character> uniqueCharsS2 = new HashSet<>();

		for (char c : s1Arr) {
			uniqueCharsS1.add(c);
		}

		for (char c : s2Arr) {
			uniqueCharsS2.add(c);
		}

		if (uniqueCharsS1.equals(uniqueCharsS2)) {
			isIdentical = true;
			return isIdentical;
		}
		return isIdentical;
	}
}

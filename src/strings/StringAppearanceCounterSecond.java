package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAppearanceCounterSecond {

	public static Map<String, List<String>> getSameLetterStrings(String[] strings) {
		Map<String, List<String>> appearanceMap = new HashMap<>();

		for (String str : strings) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);

			if (!appearanceMap.containsKey(sortedStr)) {
				appearanceMap.put(sortedStr, new ArrayList<>());
			}
			appearanceMap.get(sortedStr).add(str);
		}

		return appearanceMap;
	}

	public static void printSameLetterStrings(Map<String, List<String>> appearanceMap) {
		for (Map.Entry<String, List<String>> entry : appearanceMap.entrySet()) {
			List<String> strings = entry.getValue();
			System.out.print(entry.getKey() + " -> " + strings.size() + " [");
			for (int i = 0; i < strings.size(); i++) {
				System.out.print(strings.get(i));
				if (i < strings.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		String[] strings = {"aab", "cac", "ac", "ba", "caa", "d", "ab"};
		Map<String, List<String>> appearanceMap = getSameLetterStrings(strings);
		printSameLetterStrings(appearanceMap);
	}
}

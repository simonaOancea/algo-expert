package strings;

import java.util.*;

// O(n * m) time | O(n * m) space - where n is the number of words and
// m is the length of the longest word
public class Semordnilap {
    public static void main(String[] args) {
        String one = "dog";
        String two = "god";
        String[] words = new String[]{one, two};

        ArrayList<ArrayList<String>> result = semordnilap(words);

        for (ArrayList<String> array : result) {
            System.out.println(array.get(0));
            System.out.println(array.get(1));
        }
    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> semordinlapPairs = new ArrayList<ArrayList<String>>();

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (wordSet.contains(reverse) && !reverse.equals(word)) {
                ArrayList<String> semordnilapPair = new ArrayList<>();
                semordnilapPair.add(word);
                semordnilapPair.add(reverse);
                semordinlapPairs.add(semordnilapPair);
                wordSet.remove(word);
                wordSet.remove(reverse);
            }
        }

        return semordinlapPairs;
    }

}

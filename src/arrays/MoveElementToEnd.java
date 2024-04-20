package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n) time | O(1) space - where n is the length of the array
public class MoveElementToEnd {
    public static void main(String[] args) {
        int toMove = 2;
        List<Integer> input = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        List<Integer> result = moveElementToEnd(input, toMove);

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove) j--;
            if (array.get(i) == toMove) swap(i, j, array);
            i++;
        }
        return array;
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}

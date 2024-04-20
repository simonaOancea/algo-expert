package arrays;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        int[] result = twoNumberSum(array, targetSum);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum
                        && array[i] != array[j]) {
                    return new int[] {array[i], array[j]};
                }
            }
        }

        return new int[0];
    }


}

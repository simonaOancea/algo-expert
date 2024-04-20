package arrays;


public class SortedSquaredArrayPerf {

    public static void main(String[] args) {
        int[] array = {-7, -3, 1, 4};
        int[] result = sortedSquaredArray(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //O(n) time | O(n) space
    public static int[] sortedSquaredArray(int[] array) {
        int[] sortedSquares = new int[array.length];
        int minIndex = 0;
        int maxIndex = array.length - 1;

        for (int index = array.length - 1; index >= 0; index --) {
            int smallerValue = array[minIndex];
            int largerValue = array[maxIndex];

            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                sortedSquares[index] = smallerValue * smallerValue;
                minIndex++;
            } else {
                sortedSquares[index] = largerValue * largerValue;
                maxIndex--;
            }
        }
        return sortedSquares;
    }
}

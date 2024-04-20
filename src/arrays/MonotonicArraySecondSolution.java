package arrays;

public class MonotonicArraySecondSolution {
    // O(n) time | O(1) space - where n is the length of the array
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(array));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length <= 2) return true;

        var direction = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (direction == 0) {
                direction = array[i] - array[i - 1];
                continue;
            }
            if (breakDirection(direction, array[i - 1], array[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean breakDirection(int direction, int previous, int current) {
        var difference = current - previous;
        if (direction > 0) return difference < 0;
        return difference > 0;
    }
}

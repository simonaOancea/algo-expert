package arrays;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(nonConstructibleChange(coins));
    }

    public static int nonConstructibleChange(int[] coins) {
        if (coins.length == 0) {
            return 1;
        }

        int minAmountOfChange = 0;

        Arrays.sort(coins);

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > minAmountOfChange + 1) {
                break;
            } else {
                minAmountOfChange += coins[i];
            }
        }
        return minAmountOfChange + 1;
    }

}

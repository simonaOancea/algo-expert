package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveIslands {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        int[][] result = removeIslands(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    // O(wh) time | O(wh) space - where w and h are the width and height on the input matrix
    public static int[][] removeIslands(int[][] matrix) {
        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            onesConnectedToBorder[i][matrix[0].length - 1] = false;
        }

        // Find all the 1s that are not islands
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                boolean rowIsBorder = row == 0 || row == matrix.length - 1;
                boolean colIsBorder = col == 0 || col == matrix[row].length - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder) {
                    continue;
                }

                if (matrix[row][col] != 1) {
                   continue;
                }

                findOnesConnectedToBorder(matrix, row, col, onesConnectedToBorder);
            }
        }

        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {
                if (onesConnectedToBorder[row][col]) {
                    continue;
                }
                matrix[row][col] = 0;
            }
        }

        return matrix;
    }

    public static void findOnesConnectedToBorder(
            int[][] matrix, int startRow, int startCol, boolean[][] onesConnectedToBorder) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {startRow, startCol});

        while (!stack.isEmpty()) {
            int[] currentPosition = stack.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            boolean alreadyVisited = onesConnectedToBorder[currentRow][currentCol];
            if (alreadyVisited) {
                continue;
            }
            onesConnectedToBorder[currentRow][currentCol] = true;

            int[][] neighbors = getNeighbors(matrix, currentRow, currentCol);
            for (int[] neighbor : neighbors) {
                int row = neighbor[0];
                int col = neighbor[1];

                if (matrix[row][col] != 1) {
                    continue;
                }

                stack.push(neighbor);
            }

        }
    }

    public static int[][] getNeighbors(int[][] matrix, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[row].length;
        ArrayList<int[]> temp = new ArrayList<>();

        if (row - 1 >= 0) {
            temp.add(new int[] {row - 1, col}); // UP
        }

        if (row + 1 < numRows) {
            temp.add(new int[] {row + 1, col}); // DOWN
        }

        if (col - 1 >= 0) {
            temp.add(new int[] {row, col - 1}); // LEFT
        }

        if (col + 1 < numCols) {
            temp.add(new int[] {row, col + 1}); // RIGHT
        }

        int[][] neighbors = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            neighbors[i] = temp.get(i);
        }

        return neighbors;
    }
}

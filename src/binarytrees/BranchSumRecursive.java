package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSumRecursive {
    public static void main(String[] args) {
        BinaryTree one = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree ten = new BinaryTree(10);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = eight;
        four.right = nine;
        five.left = ten;
        three.left = six;
        three.right = seven;

        List<Integer> result = branchSums(one);
        for(int res : result) {
            System.out.println(res);
        }
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    //O(n) time | O (n) space where n is the number of nodes in the Binary Tree
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null) return;
        int newRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }
}

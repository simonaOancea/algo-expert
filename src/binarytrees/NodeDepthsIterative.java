package binarytrees;

import java.util.ArrayList;
import java.util.List;

// O(n) time | O(h) space - where n is the number of nodes in
// the Binary Tree and h is the height of the Binary Tree
public class NodeDepthsIterative {
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

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;

        System.out.println(nodeDepths(one));
    }

    public static int nodeDepths(BinaryTree root) {
        int sumOfDepths = 0;
        List<Level> stack = new ArrayList<>();
        stack.add(new Level(root, 0));

        while (stack.size() > 0) {
            Level top = stack.remove(stack.size() - 1);
            BinaryTree node = top.root;
            int depth = top.depth;
            if (node == null) continue;
            sumOfDepths += depth;
            stack.add(new Level(node.left, depth + 1));
            stack.add(new Level(node.right, depth +1));
        }

        return sumOfDepths;
    }

    static class Level {
        public BinaryTree root;
        int depth;

        public Level(BinaryTree root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}

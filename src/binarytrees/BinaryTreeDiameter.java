package binarytrees;
// Average case: when the tree is balanced
// O(n) time | O(h) space - where n is the number of nodes
// in the Binary Tree and h is the height of the Binary Tree
public class BinaryTreeDiameter {

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

        one.left = three;
        one.right = two;
        three.left = seven;
        three.right = four;
        seven.left = eight;
        eight.left = nine;
        four.right = five;
        five.right = six;

        System.out.println(binaryTreeDiameter(one));
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }

    public static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0,0);
        }
        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);

        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

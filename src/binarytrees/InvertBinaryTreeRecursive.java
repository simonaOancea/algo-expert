package binarytrees;

// O(n) time | O(d) space where d is the depth of the binary tree
public class InvertBinaryTreeRecursive {
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

        invertBinaryTree(one);

        System.out.println(one.left.value);
        System.out.println(one.right.value);

        System.out.println(one.left.left.value);
        System.out.println(one.right.right.value);
    }

    public static void invertBinaryTree(BinaryTree tree) {
       if (tree == null) {
           return;
       }
       swapLeftAndRight(tree);
       invertBinaryTree(tree.right);
       invertBinaryTree(tree.left);
    }

    private static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
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

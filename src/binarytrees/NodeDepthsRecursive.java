package binarytrees;

// O(n) time | O(h) space - where n is the number of nodes in
// the Binary Tree and h is the height of the Binary Tree
public class NodeDepthsRecursive {
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
        return nodeDepthsHelper(root, 0);
    }

    public static int nodeDepthsHelper(BinaryTree root, int depth) {
        if (root == null) return 0;
        return depth + nodeDepthsHelper(root.left, depth + 1) + nodeDepthsHelper(root.right, depth + 1);
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

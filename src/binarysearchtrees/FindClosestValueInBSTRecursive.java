package binarysearchtrees;

// Each BST node has an integer value, a left child node, and a right child node.
// A node is said to be a valid BST node if and only if it satisfies the BST property:
// its value is strictly greater than the values of every node to its left;
// its value is less than or equal to the values of every node to its right;
// and its children nodes are either valid BST nodes themselves or None / null.

// Space & time complexity:
// O(log (n)) time in avg case | O(n) space in avg case
// O(h) time avg case | O(n) space worst case
public class FindClosestValueInBSTRecursive {

    public static void main(String[] args) {
        BST one = new BST(10);
        BST two = new BST(5);
        BST three = new BST(15);
        BST four = new BST(2);
        BST five = new BST(5);
        BST six = new BST(1);
        BST seven = new BST(13);
        BST eight = new BST(22);
        BST nine = new BST(14);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = six;
        three.left = seven;
        three.right = eight;
        seven.right = nine;

        System.out.println(findClosestValueInBst(one, 12));

    }

    public static int findClosestValueInBst(BST tree, int target) {
        int closest = tree.value;
        return findClosestValueInBstHelper(tree, target, closest);
    }

    public static int findClosestValueInBstHelper(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        }
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value && tree.left != null) {
            return findClosestValueInBstHelper(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBstHelper(tree.right, target, closest);
        } else {
            return closest;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

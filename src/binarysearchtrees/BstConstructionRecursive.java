package binarysearchtrees;

public class BstConstructionRecursive {
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

        System.out.println(one.contains(13));
        System.out.println(one.insert(11).value);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // Average: O(log(n)) time | O(log(n)) space
        // Worst: O(n) time | O(n) space
        public BST insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (value > this.value) {
                    if (right == null) {
                        right = new BST(value);
                    } else {
                        right.insert(value);
                    }
                }
            }
            return this;
        }

        // Average: O(log(n)) time | O(log(n)) space
        // Worst: O(n) time | O(n) space
        public  boolean contains(int value) {
            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            } else {
                // value is equal to current node value
                return true;
            }
        }

        public BST remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {

                }
            }
            return this;
        }

        public  int getMinValue() {
            if (left == null) {
                return this.value;
            } else {
                return left.getMinValue();
            }
        }
    }


}

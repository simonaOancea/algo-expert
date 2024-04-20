package leetcode.binarytree;

// Time complexity: we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
// Space complexity: in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur NNN times (the height of the tree), therefore the storage to keep the call stack would be O(N).
// But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
public class MaximumDepthOfBinaryTreeRecursive {
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		one.left = two;
		one.right = seven;
		two.left = three;
		two.right = four;
		four.left = five;
		four.right = six;

		MaximumDepthOfBinaryTreeRecursive maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTreeRecursive();
		System.out.println(maximumDepthOfBinaryTree.maxDepth(one));
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {
		}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
		}
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = maxDepth(root.left);
			int rightDepth = maxDepth(root.right);

			return Math.max(leftDepth, rightDepth) + 1;
		}
	}
}

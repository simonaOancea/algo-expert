package leetcode.binarytree;

import java.util.LinkedList;
// Time complexity: O(N)
// Space complexity: O(log(N))
public class MaximumDepthOfBinaryTreeIterative {
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

		MaximumDepthOfBinaryTreeIterative maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTreeIterative();
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
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> depths = new LinkedList<>();
		if (root == null) return 0;

		stack.add(root);
		depths.add(1);

		int depth = 0;
		int currentDepth = 0;

		while (!stack.isEmpty()) {
			root = stack.pollLast();
			currentDepth = depths.pollLast();
			if (root != null) {
				depth = Math.max(depth, currentDepth);
				stack.add(root.left);
				stack.add(root.right);
				depths.add(currentDepth + 1);
				depths.add(currentDepth + 1);
			}
		}

		return depth;
	}
}

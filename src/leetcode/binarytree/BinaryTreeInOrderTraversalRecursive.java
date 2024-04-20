package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(N)
// Space Complexity: O(N) (the worst case of space required is O(N) and in the average case it's O(log(N)))
public class BinaryTreeInOrderTraversalRecursive {
	// Depth First Search

	public static void main(String[] args) {
		TreeNode third = new TreeNode(3, null, null);
		TreeNode second = new TreeNode(2, third, null );
		TreeNode root = new TreeNode(1, null , second);

		BinaryTreeInOrderTraversalRecursive binaryTreeInOrderTraversal = new BinaryTreeInOrderTraversalRecursive();
		binaryTreeInOrderTraversal.inorderTraversal(root).forEach(System.out::println);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this. val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			helper(root.left, res);
			res.add(root.val);
			helper(root.right, res);
		}
	}
}

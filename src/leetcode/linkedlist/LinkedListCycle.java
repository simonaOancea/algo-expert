package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;
// Time complexity: O(n) - we visit each of the n elements in the list at most once. Adding a node to the hash table costs only O(1) time.
// Space complexity: O(n) - the space depends on the number of elements added to the hash table, which contains at most n elements.
public class LinkedListCycle {
	public static void main(String[] args) {
		LinkedListCycle linkedListCycle = new LinkedListCycle();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head;

		System.out.println(linkedListCycle.hasCycle(head));
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		Set<ListNode> nodesSeen = new HashSet<>();
		ListNode current = head;
		while (current != null) {
			if (nodesSeen.contains(current)) {
				return true;
			}
			nodesSeen.add(current);
			current = current.next;
		}
		return false;
	}
}

package leetcode.design;

import java.util.HashMap;
import java.util.Map;

/*
Time complexity: O(1) for both get and put operations

For get:
- Check if a key is in a hash map. This costs O(1).
- Get a node associated with a key. This costs O(1).
- Call remove and add. Both methods cost O(1).

For put:
- Check if a key is in a hash map. This costs O(1).
- If it is, we get a node associated with a key and call remove. Both cost O(1).
- Create a new node and insert it into the hash map. This costs O(1).
- Call add. This method costs O(1).
- If the capacity is exceeded, we call remove and delete from the hash map. Both operations cost O(1).

Space complexity: O(capacity)
- We use extra space for the hash map and for our linked list. Both cannot exceed a size of capacity.
 */

public class LRUCache {
	int capacity;
	Map<Integer, ListNode> dic;
	ListNode head;
	ListNode tail;

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		dic = new HashMap<>();
		head = new ListNode(-1, -1);
		tail = new ListNode(-1, -1);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!dic.containsKey(key)) {
			return - 1;
		}

		ListNode node = dic.get(key);
		remove(node);
		add(node);
		return node.val;
	}

	public void put(int key, int value) {
		if (dic.containsKey(key)) {
			ListNode oldNode = dic.get(key);
			remove(oldNode);
		}

		ListNode node = new ListNode(key, value);
		dic.put(key, node);
		add(node);

		if (dic.size() > capacity) {
			ListNode nodeToDelete = head.next;
			remove(nodeToDelete);
			dic.remove(nodeToDelete.key);
		}
	}

	public void add(ListNode node) {
	 ListNode previousEnd = tail.prev;
	 previousEnd.next = node;
	 node.prev = previousEnd;
	 node.next = tail;
	 tail.prev = node;
	}

	public void remove(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public static class ListNode {
		int key;
		int val;
		ListNode next;
		ListNode prev;

		public ListNode (int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}

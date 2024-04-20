package leetcode.linkedlist;

import leetcode.linkedlist.utils.ListNode;

public class AddTwoNumbers {
	//Input: l1 = [2,4,3], l2 = [5,6,4]
	//Output: [7,0,8]
	//Explanation: 342 + 465 = 807.
	// Time Complexity: O(max(m, n)) where m is the number of elements in l1 and n is the number of elements in l2
	// Space Complexity: O(1)
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode tempHead = new ListNode(0);
		ListNode current = tempHead;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int x = (l1 != null) ? l1.val :0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}

		return tempHead.next;
	}
}

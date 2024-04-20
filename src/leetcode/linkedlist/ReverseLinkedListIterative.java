package leetcode.linkedlist;

public class ReverseLinkedListIterative {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ReverseLinkedListIterative reverseLinkedListIterative = new ReverseLinkedListIterative();
		ListNode reversedList = reverseLinkedListIterative.reverseList(head);

		while (reversedList.next != null) {
			System.out.println(reversedList.val);
			reversedList = reversedList.next;
		}
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {
		}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
}

package linkedlists;

public class RemoveKthNodeFromEndSecondSolution {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(0);
        LinkedList linkedListTwo = new LinkedList(1);
        LinkedList linkedListThree = new LinkedList(2);
        LinkedList linkedListFour = new LinkedList(3);
        LinkedList linkedListFive = new LinkedList(4);
        LinkedList linkedListSix = new LinkedList(5);
        LinkedList linkedListSeven = new LinkedList(6);

        linkedListOne.next = linkedListTwo;
        linkedListTwo.next = linkedListThree;
        linkedListThree.next = linkedListFour;
        linkedListFour.next = linkedListFive;
        linkedListFive.next = linkedListSix;
        linkedListSix.next = linkedListSeven;
        linkedListSeven.next = null;

        removeKthNodeFromEnd(linkedListOne, 7);
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int counter = 1;
        LinkedList first = head;
        LinkedList second = head;

        while (counter <= k) {
            second = second.next;
            counter++;
        }

        if (second == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

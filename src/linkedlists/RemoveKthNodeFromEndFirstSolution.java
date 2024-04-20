package linkedlists;

public class RemoveKthNodeFromEndFirstSolution {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(0);
        LinkedList linkedListTwo = new LinkedList(1);
        LinkedList linkedListThree = new LinkedList(2);
        LinkedList linkedListFour = new LinkedList(3);
        LinkedList linkedListFive = new LinkedList(4);
        LinkedList linkedListSix = new LinkedList(5);
        LinkedList linkedListSeven = new LinkedList(6);
        LinkedList linkedListEight = new LinkedList(7);
        LinkedList linkedListNine = new LinkedList(8);
        LinkedList linkedListTen = new LinkedList(9);

        linkedListOne.next = linkedListTwo;
        linkedListTwo.next = linkedListThree;
        linkedListThree.next = linkedListFour;
        linkedListFour.next = linkedListFive;
        linkedListFive.next = linkedListSix;
        linkedListSix.next = linkedListSeven;
        linkedListSeven.next = linkedListEight;
        linkedListEight.next = linkedListNine;
        linkedListNine.next = linkedListTen;
        linkedListTen.next = null;

        removeKthNodeFromEnd(linkedListOne, 4);
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int length = 1;
        LinkedList temp = head;
        int indexToRemove = 0;

        // calculate the total length
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        indexToRemove = length - k - 1;

        if (indexToRemove == 0) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        temp = head;
        for (int i = 0; i < indexToRemove - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        // listing the new LinkedList
        LinkedList node = head;
        for (int i = 1; i < length - 1; i++) {
            System.out.println("Current node is: " + node.value);
            node = node.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

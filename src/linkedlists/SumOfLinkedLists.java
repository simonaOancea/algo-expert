package linkedlists;

public class SumOfLinkedLists {

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
        LinkedList linkedListTwo = new LinkedList(4);
        LinkedList linkedListThree = new LinkedList(7);
        LinkedList linkedListFour = new LinkedList(1);

        linkedListOne.next = linkedListTwo;
        linkedListOne.next.next = linkedListThree;
        linkedListOne.next.next.next = linkedListFour;

        LinkedList linkedListFive = new LinkedList(9);
        LinkedList linkedListSix = new LinkedList(4);
        LinkedList linkedListSeven = new LinkedList(5);

        linkedListFive.next = linkedListSix;
        linkedListFive.next.next = linkedListSeven;

        LinkedList result = sumOfLinkedLists(linkedListOne, linkedListFive);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = (nodeOne != null) ? nodeOne.value : 0;
            int valueTwo = (nodeTwo != null) ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10;
            nodeOne = (nodeOne != null) ? nodeOne.next : null;
            nodeTwo = (nodeTwo != null) ? nodeTwo.next : null;

        }

        return newLinkedListHeadPointer.next;
    }


}

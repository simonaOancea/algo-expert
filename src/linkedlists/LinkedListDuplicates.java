package linkedlists;

public class LinkedListDuplicates {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(1);
        LinkedList linkedListTwo = new LinkedList(1);
        LinkedList linkedListThree = new LinkedList(3);
        LinkedList linkedListFour = new LinkedList(4);
        LinkedList linkedListFive = new LinkedList(4);
        LinkedList linkedListSix = new LinkedList(4);

        linkedListOne.next = linkedListTwo;
        linkedListOne.next.next = linkedListThree;
        linkedListOne.next.next.next = linkedListFour;
        linkedListOne.next.next.next.next = linkedListFive;
        linkedListOne.next.next.next.next.next = linkedListSix;
        linkedListOne.next.next.next.next.next.next = null;

        LinkedListDuplicates linkedListDuplicates = new LinkedListDuplicates();

        LinkedList resultList = linkedListDuplicates.removeDuplicatesFromLinkedList(linkedListOne);

       System.out.println("Result list is: ");
        while (resultList.next != null) {
            System.out.println(resultList.value);
            resultList = resultList.next;

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

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList temp = linkedList;
        while (temp.next != null) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return linkedList;
    }
}

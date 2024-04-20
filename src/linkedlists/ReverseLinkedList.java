package linkedlists;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        LinkedList secondNode = new LinkedList(1);
        LinkedList thirdNode = new LinkedList(2);
        LinkedList fourthNode = new LinkedList(3);
        LinkedList fifthNode = new LinkedList(4);
        LinkedList sixthNode = new LinkedList(5);

        head.next = secondNode;
        head.next.next = thirdNode;
        head.next.next.next = fourthNode;
        head.next.next.next.next = fifthNode;
        head.next.next.next.next.next = sixthNode;

        LinkedList result = reverseLinkedList(head);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previousNode = null;
        LinkedList currentNode = head;

        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

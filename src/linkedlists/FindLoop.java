package linkedlists;

public class FindLoop {
    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        LinkedList second = new LinkedList(1);
        LinkedList third = new LinkedList(2);
        LinkedList fourth = new LinkedList(3);
        LinkedList fifth = new LinkedList(4);
        LinkedList sixth = new LinkedList(5);
        LinkedList seventh = new LinkedList(6);
        LinkedList eight = new LinkedList(7);
        LinkedList nineth = new LinkedList(8);
        LinkedList tenth = new LinkedList(9);

        head.next = second;
        head.next.next = third;
        head.next.next.next = fourth;
        head.next.next.next.next = fifth;
        head.next.next.next.next.next = sixth;
        head.next.next.next.next.next.next = seventh;
        head.next.next.next.next.next.next.next = eight;
        head.next.next.next.next.next.next.next.next = nineth;
        head.next.next.next.next.next.next.next.next.next = tenth;
        head.next.next.next.next.next.next.next.next.next.next = fifth;

        System.out.println(findLoop(head).value);
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head.next;
        LinkedList second = head.next.next;
        while (first != second) {
            first = first.next;
            second = second.next.next;
        }
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

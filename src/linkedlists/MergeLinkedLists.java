package linkedlists;

public class MergeLinkedLists {
    public static void main(String[] args) {
        LinkedList headOne = new LinkedList(2);
        LinkedList headOneNext = new LinkedList(6);
        LinkedList headOneNextNext = new LinkedList(7);
        LinkedList headOneNextNextNext = new LinkedList(8);

        headOne.next = headOneNext;
        headOne.next.next = headOneNextNext;
        headOne.next.next.next = headOneNextNextNext;

        LinkedList headTwo = new LinkedList(1);
        LinkedList headTwoNext = new LinkedList(3);
        LinkedList headTwoNextNext = new LinkedList(4);
        LinkedList headTwoNextNextNext = new LinkedList(5);
        LinkedList headTwoNextNextNextNext = new LinkedList(9);
        LinkedList headTwoNextNextNextNextNext = new LinkedList(10);

        headTwo.next = headTwoNext;
        headTwo.next.next = headTwoNextNext;
        headTwo.next.next.next = headTwoNextNextNext;
        headTwo.next.next.next.next = headTwoNextNextNextNext;
        headTwo.next.next.next.next.next = headTwoNextNextNextNextNext;

        LinkedList result = mergeLinkedList(headOne, headTwo);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedList(LinkedList headOne, LinkedList headTwo) {
        LinkedList p1 = headOne;
        LinkedList p1Prev = null;
        LinkedList p2 = headTwo;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p1Prev = p1;
                p1 = p1.next;
            } else {
                if (p1Prev != null) p1Prev.next = p2;
                p1Prev = p2;
                p2 = p2.next;
                p1Prev.next = p1;
            }
        }
        if (p1 == null) p1Prev.next = p2;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }
}

package datastructuresplayground;

public class QueueImplementation {
    // first-in-first-out
    Node first;
    Node last;

    public void enqueue(int item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public Object dequeue() {
        if (first != null) {
            Object item = first.data;
            first = first.next;
            return item;
        }

        return null;
    }

    static class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}

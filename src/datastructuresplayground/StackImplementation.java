package datastructuresplayground;

public class StackImplementation {
    Node top;

    // peek(), pop(), push()

    public Object peek() {
        return top.data;
    }

    public Object pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    public void push(int item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }
    }
}

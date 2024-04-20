package linkedlists;

public class LinkedListConstruction {
    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);

        Node nodeFour = new Node(0);
        Node nodeFive = new Node(5);

        nodeOne.prev = null;
        nodeOne.next = nodeTwo;

        nodeTwo.prev = nodeOne;
        nodeTwo.next = nodeThree;

        nodeThree.prev = nodeTwo;
        nodeThree.next = null;

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.head = nodeOne;
        doublyLinkedList.tail = nodeThree;

        doublyLinkedList.setHead(nodeFour);
        doublyLinkedList.setTail(nodeFive);

        doublyLinkedList.insertBefore(nodeThree, nodeOne);

       System.out.println("Head is: " + doublyLinkedList.head.value);
       System.out.println("Next is: " + doublyLinkedList.head.next.value);
       System.out.println("Next is: " + doublyLinkedList.head.next.next.value);
       System.out.println("Next is: " + doublyLinkedList.head.next.next.next.value);
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        // O(1) time | O(1) space
        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        // O(1) time | O(1) space
        public void setTail(Node node) {
           if (tail == null) {
               setHead(node);
               return;
           }
           insertAfter(tail, node);
        }

        // O(1) time | O(1) space
        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        // O(1) time | O(1) space
        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        // O(p) time | O(1) space
        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node node = head;
            int currentPosition = 1;
            while (node != null && currentPosition++ != position) node = node.next;
            if (node != null) {
                insertBefore(node, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }
        }

        // O(n) time | O(1) space
        public void removeNodesWithValue(int value) {
            Node node = head;
            while (node != null) {
                Node nodeToRemove = node;
                node = node.next;
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
            }
        }

        // O(1) time | O(1) space
        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            removeNodeBindings(node);
        }

        // O(n) time | O(1) space
        public boolean containsNodeWithValue(int value) {
            Node node = head;
            while (node != null && node.value != value) {
                node = node.next;
            }

            return node != null;
        }

        public void removeNodeBindings(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

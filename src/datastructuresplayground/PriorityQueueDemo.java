package datastructuresplayground;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        // add method
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        // iterating through a priority queue: converting the queue to an array and traversing using for loop
        // or using an inbuilt iterator
        Iterator<String> iterator = pq.iterator();
        System.out.println("Iterating through the priority queue:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

        for(String element : pq) {
            System.out.println(element);
        }

        /*Iterator<String> it = pq.iterator();
        while( it.hasNext()) {
            it.next()
        }*/

        // since Queue follows the First In First Out principle, we can access only the head of the queue.
        // to access the elements from a priority queue, we can use the peek() method
        String element = pq.peek();
        System.out.println("Accessed Element: " + element);

        // remove method - if there are multiple such objects, then the first occurrence of the object is removed.
        // Apart from that, the poll() method is also used to remove the head and return it.
        pq.remove("Geeks");

        System.out.println("After Remove: " + pq);
        System.out.println("Poll Method: " + pq.poll());
        System.out.println("Final Priority Queue: " + pq);
    }
}

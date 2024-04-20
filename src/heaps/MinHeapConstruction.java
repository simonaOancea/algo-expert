package heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // O(n) time | O(1) space
        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return new ArrayList<>();
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // when we're sifting down we need to compare both child nodes
            int childOneIdx = (currentIdx * 2) + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = (currentIdx * 2) + 2 <= endIdx ? (currentIdx * 2) + 2 : -1;
                int idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap) {
            // first we want to get the parent index of our current node
            int parentIdx = (currentIdx - 1) / 2;
            // while our current node is smaller than its parent node
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                // update the current idx
                currentIdx = parentIdx;
                // recalculate the parent idx
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            // swap the first and last value
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(valueToRemove);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i,temp);
        }
    }
}

package sorting;

// Time Complexity: O(n^2)
// The best case time complexity is O(n) when the input array is already sorted,
// but this is generally not the case for most inputs.
// The space complexity for Bubble Sort is O(1), because only a single additional memory space is required i.e. for temp variable.

public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		bs.bubbleSort(arr);
		System.out.println("Sorted array");
		for (int i=0; i<arr.length; ++i) System.out.print(arr[i] + " ");

	}

	public void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

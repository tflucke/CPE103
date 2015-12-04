/**
 * Sorting algorithms implementation
 * 
 * Project 5
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/12/01
 * 
 */
public class Sorts {
	 /**
	  * Sorts the list of size elements contained in arr using the selection sort algorithm.
	  * Iterates through the list to check for the smallest item
	  * Swap one at a time "Shrinking List"
	  */
	 public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size)

	 {
		 for (int i = 0; i < size; i++)
		 {
			 int minIndex = i; // Keeps track of the index of the minimum variable
			 for(int j = i + 1; j < size; j++)
			 {
				 if(arr[minIndex].compareTo(arr[j]) > 0)
				 {
					 minIndex = j;
				 }
			 }
			 
			swap(arr, i, minIndex);
	 	 }
	 }
	 /**
	  * private method to swap two items in an array
	  */
	 private static <T extends Comparable<? super T>> void swap(T[] arr, int index1, int index2)
	 {
		 T tmp = arr[index1]; // holds the value of the swapped item
		 arr[index1] = arr[index2];
		 arr[index2] = tmp;
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the bubble sort algorithm.
	  * Swaps elements as the algorithm is iterating through the list
	  */
	 public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size)
	 {
		 boolean done; // Boolean indicating that the list is sorted and no more iterations are needed
		 do
		 {
			 done = true;
			 for(int i = 0; i < size-1; i++)
			 {
				 if(arr[i].compareTo(arr[i + 1]) > 0)
				 {
					 swap(arr, i, i + 1);
					 done = false;
				 }
			 }
		 }
		 while (!done);
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the insertion sort algorithm.
	  * Builds the final sorted array (or list) one item at a time.
	  */
	 public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size)
	 {
		 for(int i = 1; i < size; i++)
		 {
			 T tmp = arr[i]; // temp array to hold the checked item
			 int j = i; // index of value to be swapped
			 while (j > 0 && arr[j-1].compareTo(tmp) > 0)
			 {
				 arr[j] = arr[j - 1];
				 j--;
			 }
			 arr[j] = tmp;
		 }
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the merge sort algorithm.
	  * Divides the list into the smallest unit then merges the lists together into one sorted array
	  */
	 public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size)
	 {
		 mergeSort(arr, 0, size - 1);
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the merge sort algorithm.
	  * Divides the list into the smallest unit then merges the lists together into one sorted array
	  */
	 private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last)
	 {
		 int middle = (first + last) / 2; // finds the middle index of the list in order to split it
		 if(first < last)
		 {
			 mergeSort(arr, first, middle);
			 mergeSort(arr, middle + 1, last);
			 mergeSortedHalves(arr, first, middle, last);
		 }
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the merge sort algorithm.
	  * Private method used to merge two lists back into a sorted array
	  */
	 private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right)
	 {
		 @SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable[right - left + 1]; // tmp array to contain the merged halves of the original array
		 int index1 = left; // index of the left side of the array
		 int index2 = middle + 1; // index of the right side of the array
		 int index = 0; // index for the tmp array
		 
		 while(index1 <= middle && index2 <= right)
		 {
			 if(arr[index1].compareTo(arr[index2]) < 0)
			 {
				 tmp[index] = arr[index1];
				 index1 ++;
			 }
			 else
			 {
				 tmp[index] = arr[index2];
				 index2++;
			 }
			 index++;
		 }

		while(index1 <= middle)
		{
			tmp[index] = arr[index1];
			index1++;
			index++;
		}
		while(index2 <= right)
		{
			tmp[index] = arr[index2];
			index2++;
			index++;
		}
		for (int i = 0; i < tmp.length; i++)
		{
			arr[i+left] = tmp[i];
		}
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the quick sort algorithm.
	  * Median-of-three pivot and rearrangement of the three elements (as done in class).
	  */
	 public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size)
	 {
		 quickSort(arr, 0, size - 1);
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the quick sort algorithm.
	  * Median-of-three pivot and rearrangement of the three elements (as done in class).
	  * Divides a large array into smaller sub-arrays, recursively sorting them
	  */
	 private static <T extends Comparable<? super T>> void quickSort(T[] arr, int first, int last)
	 {
		 if (first < last)
		 {
			 setPivotToEnd(arr, first, last);
			 int pivotIndex = splitList(arr, first, last); // finds the index of the pivot
			 quickSort(arr, first, pivotIndex - 1);
			 quickSort(arr, pivotIndex + 1, last);
		 }
		 
	 }
	 
	 /**
	  * Sorts the list of size elements contained in arr using the quick sort algorithm.
	  * Puts the pivot at the end of the list
	  */
	 private static <T extends Comparable<? super T>> void setPivotToEnd(T[] arr, int left, int right)
	 {
		 int middle = (right + left) / 2;
		 if(arr[middle].compareTo(arr[left]) < 0)
		 {
			 swap(arr, left, middle);
		 }
		 if(arr[right].compareTo(arr[left]) < 0)
		 {
			 swap(arr, left, right);
		 }
		 if(arr[middle].compareTo(arr[right]) < 0)
		 {
			 swap(arr, right, middle);
		 }
	 }
	 
	 /**
	  * Sorts the list into the left side, right side, and pivot (in that order)
	  */
	 private static <T extends Comparable<? super T>> int splitList(T[] arr, int left, int right)
	 {
		 int indexLeft = left; //start index of the left half of the array
		 int indexRight = right - 1; // start index of the right half of the array
		 
		 T pivot = arr[right]; // pivot 
		 
		 while(indexRight >= indexLeft)
		 {
			 while(arr[indexLeft].compareTo(pivot) < 0)
			 {
				 indexLeft++;
			 }
			 while(indexRight >= indexLeft && arr[indexRight].compareTo(pivot) > 0)
			 {
				 indexRight--;
			 }
			 if(indexRight >= indexLeft)
			 {
				 swap(arr, indexLeft, indexRight);
				 indexLeft++;
				 indexRight--;
			 }
		 }
		 swap(arr, indexLeft, right);
		 return indexLeft;
	 }
}

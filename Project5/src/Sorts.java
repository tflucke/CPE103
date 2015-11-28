
public class Sorts {
	 public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size)
	 //Sorts the list of size elements contained in arr using the selection sort algorithm.
	 //Swap one at a time "Shrinking LIst"
	 {
		 for (int i = 0; i < size; i++)
		 {
			 int minIndex = i;
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
	 
	 private static <T extends Comparable<? super T>> void swap(T[] arr, int index1, int index2)
	 {
		 T tmp = arr[index1];
		 arr[index1] = arr[index2];
		 arr[index2] = tmp;
	 }
	 
	 public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size)
	 //Sorts the list of size elements contained in arr using the bubble sort algorithm.
	 // Swap as you go
	 {
		 boolean done;
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
	 public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size)
	 //Sorts the list of size elements contained in arr using the insertion sort algorithm.
	 {
		 for(int i = 1; i < size; i++)
		 {
			 T tmp = arr[i];
			 int j = i;
			 while (j > 0 && arr[j-1].compareTo(tmp) > 0)
			 {
				 arr[j] = arr[j - 1];
				 j--;
			 }
			 arr[j] = tmp;
		 }
	 }
	 public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size)
	 //Sorts the list of size elements contained in arr using the merge sort algorithm.
	 {
		 mergeSort(arr, 0, size - 1);
	 }
	 
	 private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last)
	 {
		 int middle = (first + last) / 2;
		 if(first < last)
		 {
			 mergeSort(arr, first, middle);
			 mergeSort(arr, middle + 1, last);
			 mergeSortedHalves(arr, first, middle, last);
		 }
	 }
	 
	 private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right)
	 {
		 @SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable[right - left + 1];
		 int index1 = left;
		 int index2 = middle + 1;
		 int index = 0;
		 
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
	 
	 public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size)
	 //Sorts the list of size elements contained in arr using the quick sort algorithm with
	 //median-of-three pivot and rearrangement of the three elements (as done in class).
	 {
		 quickSort(arr, 0, size - 1);
	 }
	 
	 private static <T extends Comparable<? super T>> void quickSort(T[] arr, int first, int last)
	 {
		 if (first < last)
		 {
			 setPivotToEnd(arr, first, last);
			 int pivotIndex = splitList(arr, first, last);
			 quickSort(arr, first, pivotIndex - 1);
			 quickSort(arr, pivotIndex + 1, last);
		 }
		 
	 }
	 
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
	 
	 private static <T extends Comparable<? super T>> int splitList(T[] arr, int left, int right)
	 {
		 int indexLeft = left;
		 int indexRight = right - 1;
		 
		 T pivot = arr[right];
		 
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

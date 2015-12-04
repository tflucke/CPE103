/**
 * Prints out sort times on a pre-sorted list
 * 
 * Project 5
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/12/01
 * 
 */
public class SortTimes1 {

	public static void main(String[] args)
	{
		Integer[] baseListSelect = new Integer[80000], baseListBubble = new Integer[80000], baseListInsert = new Integer[80000], baseListMerge = new Integer[80000], baseListQuick = new Integer[80000];
		System.out.println("TEST1: presorted list");
		for (int N = 5000; N <= 80000; N *= 2)
		{
			for (int i = 0; i < N; i++)
			{
				baseListSelect[i] = i;
				baseListBubble[i] = i;
				baseListInsert[i] = i;
				baseListMerge[i] = i;
				baseListQuick[i] = i;
			}
			long start = System.currentTimeMillis(); // start time for selection sort
			Sorts.selectionSort(baseListSelect, N);
			long selectSortTime = System.currentTimeMillis() - start; // stores final sort time
			start = System.currentTimeMillis(); // start time for bubble sort
			Sorts.bubbleSort(baseListBubble, N);
			long bubbleSortTime = System.currentTimeMillis() - start; // stores final sort time
			start = System.currentTimeMillis(); // start time for insertion sort
			Sorts.insertionSort(baseListInsert, N);
			long insertSortTime = System.currentTimeMillis() - start; // stores final sort time
			start = System.currentTimeMillis(); // start time for merge sort
			Sorts.mergeSort(baseListMerge, N);
			long mergeSortTime = System.currentTimeMillis() - start; // stores final sort time
			start = System.currentTimeMillis(); // start time for quick sort
			Sorts.quickSort(baseListQuick, N);
			long quickSortTime = System.currentTimeMillis() - start; // stores final sort time
			System.out.println(String.format("N=%d: T_ss=%d, T_bs=%d, T_is=%d, T_ms=%d, T_qs=%d",
					N, selectSortTime, bubbleSortTime, insertSortTime, mergeSortTime, quickSortTime));
		}
		System.out.println("End TEST1");
	}

}

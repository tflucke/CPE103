import java.util.Arrays;

public class SortTimes3 {

	public static void main(String[] args)
	{
		Integer[] baseListSelect = new Integer[80000], baseListBubble = new Integer[80000], baseListInsert = new Integer[80000], baseListMerge = new Integer[80000], baseListQuick = new Integer[80000];
		System.out.println("TEST3: unsorted list");
		for (int N = 5000; N <= 80000; N *= 2)
		{
			for (int x = 1; x <= 3; x++)
			{
				for (int i = 0; i < N; i++)
				{
					int num = (int) (Math.random()*N);
					baseListSelect[i] = num;
					baseListBubble[i] = num;
					baseListInsert[i] = num;
					baseListMerge[i] = num;
					baseListQuick[i] = num;
				}
				long start = System.currentTimeMillis();
				Sorts.selectionSort(baseListSelect, N);
				long selectSortTime = System.currentTimeMillis() - start;
				start = System.currentTimeMillis();
				Sorts.bubbleSort(baseListBubble, N);
				long bubbleSortTime = System.currentTimeMillis() - start;
				start = System.currentTimeMillis();
				Sorts.insertionSort(baseListInsert, N);
				long insertSortTime = System.currentTimeMillis() - start;
				start = System.currentTimeMillis();
				Sorts.mergeSort(baseListMerge, N);
				long mergeSortTime = System.currentTimeMillis() - start;
				start = System.currentTimeMillis();
				Sorts.quickSort(baseListQuick, N);
				long quickSortTime = System.currentTimeMillis() - start;
				System.out.println(String.format("N=%d: T_ss=%d, T_bs=%d, T_is=%d, T_ms=%d, T_qs=%d",
						N, selectSortTime, bubbleSortTime, insertSortTime, mergeSortTime, quickSortTime));
			}
			System.out.println();
		}
		System.out.println("End TEST3");
	}

}

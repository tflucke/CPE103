import java.util.Scanner;


public class TreeTest
{
	public static void main(String... args)
	{
		Integer[] arr = new Integer[20];
		int size = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Waddup boosh. I herd you like giving me a tree to input. (:");
		while (size != arr.length && in.hasNextInt())
		{
			arr[size++] = in.nextInt();
		}
		in.close();
		if (size == 0)
		{
			System.out.println("The tree is empty.");
		}
		else
		{
			System.out.println(TreeWork.isHeap(arr, size)? "Is Heap":"Is Not Heap");
			System.out.println();
			TreeWork.printTree(arr, size);
		}
	}
}

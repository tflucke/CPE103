
public class TreeWork
{
	private static int leftChild(int index)
	{
		return 2*index+1;
	}
	private static int rightChild(int index)
	{
		return 2*index+2;
	}
	
	public static<T extends Comparable<? super T>> boolean isHeap(T[] tree, int size)
	{
		return isHeap(tree, 0, size);
	}
	
	private static<T extends Comparable<? super T>> boolean isHeap(T[] tree, int start, int size)
	{
		if (leftChild(start) >= size)
		{
			return true;
		}
		else if (tree[leftChild(start)].compareTo(tree[start]) < 0)
		{
			return false;
		}
		else if (!isHeap(tree, leftChild(start), size))
		{
			return false;
		}
		
		else if (rightChild(start) >= size)
		{
			return true;
		}
		else if (tree[rightChild(start)].compareTo(tree[start]) < 0)
		{
			return false;
		}
		else if (!isHeap(tree, rightChild(start), size))
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}
	
	public static<T> void printTree(T[] tree, int size)
	{
		for (int i = 0; i < size; i++)
		{
			if (i != 0 && (Math.log(i + 1)/Math.log(2)) % 1 == 0)
			{
				System.out.println();
			}
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}
}

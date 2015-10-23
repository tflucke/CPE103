/**
 * Binary minimum heap implementation using the Comparable interface.
 * 
 * Project 2
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/21
 * 
 * @see Comparable
 */

public class BinHeap<T extends Comparable<? super T>>
{
	/**
	 * An exception to be thrown when an invalid operation is invoked while the heap is empty.
	 * Basically a carbon-copy of RuntimeException
	 * 
	 * Project 2
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/10/21
	 */
	@SuppressWarnings("serial")
	public static class MyException extends RuntimeException
	{
		/**
		 * Default constructor which just calls the super constructor.
		 */
		public MyException()
		{
			super();
		}

		/**
		 * Constructor which just passes a string argument to the super constructor.
		 */
		public MyException(String msg)
		{
			super(msg);
		}
	}
	
	/**
	 * The array which holds the elements in the heap in the left-to-right, top-to-bottom order.
	 */
	private T[] array;
	
	/**
	 * Number of valid elements in the heap.
	 */
	private int count;

	/**
	 * Creates a new heap with a default size of 100.
	 */
	@SuppressWarnings("unchecked")
	public BinHeap()
	{
		array = (T[]) new Comparable[100];
		count = 0;
	}

	/**
	 * Creates a new heap with a given size.
	 * 
	 * @param maxSize The size of the heap.
	 */
	@SuppressWarnings("unchecked")
	public BinHeap(int maxSize)
	{
		array = (T[]) new Comparable[maxSize];
		count = 0;
	}

	/**
	 * Inserts a new item into the heap.
	 * @param item The item to be inserted.
	 */
	public void insert(T item)
	{
		if(count >= array.length)
		{
			resizeArray();
		}
		
		bubbleUp(count++, item);
	}
	
	/**
	 * Resizes the array to twice it's original size.
	 * Used when the heap is filled and an element needs to be added.
	 */
	private void resizeArray()
	{
		@SuppressWarnings("unchecked")
		//The new array of double the length of the original
		T[] newArray = (T[]) new Comparable[2*array.length];
		for(int x = 0; x < count; x++)
		{
			newArray[x] = array[x];
		}
		array = newArray;
	}
	
	/**
	 * Checks if the parent is larger than the given index, and swaps the two if necessary.
	 * Used to correct issues with smaller elements being in the bottom of the heap after an insert.
	 * @param index The index of the element which to (maybe) move up.
	 * @param value The value which to move up the heap
	 */
	private void bubbleUp(int index, T value)
	{
		//The index of this node's parent
		int parentIndex = (index - 1) / 2;
		if(count != 1 && value.compareTo(array[parentIndex]) < 0)
		{
			array[index] = array[parentIndex];
			bubbleUp(parentIndex, value);
		}
		else
		{
			array[index] = value;
		}
	}
	
	/**
	 * Deletes the element from the top of the heap (also the minimum element)
	 * @return The deleted element
	 * @throws MyException If the heap is empty
	 */
	public T deleteMin()
	{
		if (count == 0)
		{
			throw new MyException();
		}
		else
		{
			//Temporarily store the return value
			T res = array[0];
			bubbleDown(0, array[--count]);
			return res;
		}
	}

	/**
	 * Checks if the children are smaller than the given index, and swaps the two if necessary.
	 * Used to correct issues with larger elements being in the top of the heap after a delete.
	 * @param index The index of the element which to (maybe) move down.
	 * @param value The value which to move down the heap
	 */
	private void bubbleDown(int index, T value)
	{
		//The child to be moved down to.  -1 if the element has no children which are smaller than it.
		int hole = newHole(index, value);
		if (hole == -1)
		{
			array[index] = value;
		}
		else
		{
			array[index] = array[hole];
			bubbleDown(hole, value);
		}
	}
	
	/**
	 * Checks which of the two child nodes should be swap with the parent (if any).
	 * Used after a delete.
	 * @param parent The element whose children to check
	 * @param value The value which will be considered for the parent spot.
	 * @return Either the index of the appropriate child, or -1 if the parent is in a good situation.
	 */
	private int newHole(int parent, T value)
	{
		//The indexes of the left and right children.
		int leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
		
		if (leftChild < count)
		{
			if (array[leftChild].compareTo(value) < 0 &&
				(rightChild >= count || array[leftChild].compareTo(array[rightChild]) < 0)
			   )
			{
				return leftChild;
			}
			else if (rightChild < count && array[rightChild].compareTo(value) < 0)
			{
				return rightChild;
			}
		}
		return -1;
	}
	
	/**
	 * Checks whether or not there are any elements in the heap.
	 * @return true if there are no elements in the heap.  false otherwise.
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	 /**
	  * Returns the number of elements in the heap.
	  * @return Number of elements in the heap.
	  */
	public int size()
	{
		return count;
	}
	
	/**
	 * Creates a string representation of the heap as a space seperated list.
	 */
	@Override
	public String toString()
	{
		if(!isEmpty())
		{
			//Stores the result until it's ready to be returned.
			String printArray = new String();
			for(int i = 0; i < count-1; i ++)
			{
				printArray += array[i] + " ";
			}
			return printArray + array[count - 1];
		}
		return "";
	}
}

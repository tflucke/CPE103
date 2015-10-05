
public class AQueue <T>
{
	private T[] arr;
	private int front;
	private int end;
	private int count;
	
	public static class MyException extends RuntimeException
	{
		private static final long serialVersionUID = -244806549310243756L;
		public MyException()
		{
			super();
		}
		public MyException(String message)
		{
			super(message);
		}
	}
	
	public AQueue(int arrSize)
	{
		arr = (T[]) new Object[arrSize];
		front = 0;
		end = -1;
		count = 0;
	}
	
	public boolean isEmpty()
	{
		return (count < 1);
	}
	
	public void enqueue(T item)
	{
		if(count == arr.length)
		{
			T[] tmpArr = (T[]) new Object[arr.length * 2];
			for (int i = 0; i < count; i++)
			{
				tmpArr[i] = arr[(front + i) % arr.length];
				
			}
			arr = tmpArr;
			front = 0;
			end = count - 1;
		}
		end++;
		arr[end] = item;
		count ++;
	}
	
	public T dequeue()
	{
		if (isEmpty())
		{
			throw new MyException();
		}
		T tmp = arr[front];
		arr[front] = null;
		front = (front + 1) % arr.length;
		return tmp;
	}
	
	public void printArray()
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
	}
	
	
	
	
	
	
}

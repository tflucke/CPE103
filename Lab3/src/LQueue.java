
public class LQueue<T>
{
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
	
	private Node front, end;
	
	public LQueue()
	{
		front = end = null;
	}
	
	public void enqueue(T item)
	{
		Node newEnd = new Node(item);
		if (isEmpty())
		{
			front = newEnd;
		}
		else
		{
			end.next = newEnd;	
		}
		end = newEnd;
	}
	
	public T dequeue()
	{
		if (isEmpty())
		{
			throw new MyException();
		}
		try
		{
			return front.item;
		}
		finally
		{
			front = front.next;
		}
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	private class Node
	{
		public T item;
		public Node next;
		
		public Node(T item)
		{
			this.item = item;
			this.next = null;
		}
	}
}

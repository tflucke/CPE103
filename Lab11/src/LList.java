import java.util.Iterator;

public class LList<T> implements Iterable<T> {
	
	private Node head;
	
	private class Node
	{
		public T elm;
		public Node next;
	}
	
	private class Iter implements Iterator<T>
	{
		private Node next;
		
		{
			next = head;
		}
		
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			try
			{
				return next.elm;
			}
			finally
			{
				next = next.next;
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	{
		head = null;
	}
	
	public Iterator<T> iterator()
	{
		return new Iter();
	}
	
	public void add(T item)
	{
		//Handle empty list
		Node cur = head;
		while (cur.next != null)
		{
			cur = cur.next;
		}
		cur.next = new Node();
		cur.next.elm = item;
	}
}

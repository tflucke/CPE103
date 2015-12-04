import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class MyHashTable<T>
{
	private LinkedList<T>[] elements;
	
	@SuppressWarnings("unchecked")
	public MyHashTable(int size)
	{
		elements = (LinkedList<T>[]) new LinkedList[size];
		for (int i = 0; i < size; i++)
		{
			elements[i] =  new LinkedList<T>();
		}
	}
	
	private int hash(T input)
	{
		return input.hashCode() % elements.length;
	}
	
	public void insert(T elm)
	{
		elements[hash(elm)].addFirst(elm);
	}
	
	public void delete(T elm)
	{
		elements[hash(elm)].remove(elm);
	}
	
	public boolean find(T elm)
	{
		return elements[hash(elm)].contains(elm);
	}
	
	public boolean isEmpty()
	{
		for (LinkedList<T> list : elements)
		{
			if (list.size() > 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public void print()
	{
		int i = 0;
		for (LinkedList<T> list : elements)
		{
			System.out.print(i++ + ": ");
			for (T elm : list)
			{
				System.out.print(elm+" ");
			}
			System.out.println();
		}
	}

	public void makeEmpty()
	{
		for (int i = 0; i < elements.length; i++)
		{
			elements[i].clear();
		}
	}

	public int size()
	{
		int sum = 0;
		for (LinkedList<T> list : elements)
		{
			sum += list.size();
		}
		return sum;
	}
	
	private class Iter implements Iterator<T>
	{
		private int i, j;
		
		public Iter()
		{
			j = 0;
			i = 0;
			while (i < elements.length && elements[i].isEmpty())
			{
				i++;
			}
		}
		
		@Override
		public boolean hasNext()
		{
			return i < elements.length;
		}

		@Override
		public T next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			T result = elements[i].get(j++);
			if (j >= elements[i].size())
			{
				j = 0;
				do
				{
					i++;
				}
				while (i < elements.length && elements[i].isEmpty());
			}
			return result;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<T> iterator()
	{
		return new Iter();
	}
}

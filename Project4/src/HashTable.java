import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable
{
	private class HashEntry
	{
		public Object elm;
		public boolean active;
		
		public HashEntry(Object elm)
		{
			this.elm = elm;
			active = true;
		}
	}
	
	private HashEntry[] table;
	private int size;
	
	public HashTable(int tableCapacity)
	{
		table = new HashEntry[nextPrime(2*tableCapacity)];
		size = 0;
	}
	
	private static boolean isPrime(int num)
	{
		if (num % 2 == 0)
		{
			return false;
		}
		for (int i = 3; i*i <= num; i += 2)
		{
			if (num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	private static int nextPrime(int num)
	{
		if (num % 2 == 0)
		{
			num++;
		}
		while (!isPrime(num))
		{
			num += 2;
		}
		return num;
	}
	
	private static boolean isActive(HashEntry entry)
	{
		return entry != null && entry.active;
	}
	
	private class Iter implements Iterator<Object>
	{
		private int cursor;
		
		public Iter()
		{
			cursor = -1;
			findNextElm();
		}

		private void findNextElm()
		{
			cursor++;
			while (cursor < table.length && isActive(table[cursor]))
			{
				cursor++;
			}
		}
		
		@Override
		public boolean hasNext() {
			return cursor < table.length;
		}

		@Override
		public Object next() {
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			Object tmp = table[cursor];
			findNextElm();
			return tmp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public void insert(Object item)
	{
		int index = findNextIndex(item);
		if (table[index] == null)
		{
			table[index] = new HashEntry(item);
			size++;
		}
		else
		{
			table[index].active = true;
		}
		if (size >= table.length / 2)
		{
			rehash();
		}
	}
	
	private int hash(Object obj)
	{
		return Math.abs(obj.hashCode()) % table.length;
	}
	
	private int findNextIndex(Object obj)
	{
		int hash = hash(obj);
		int i = 0;
		while (table[hash + i*i] != null && !table[hash + i*i].elm.equals(obj))
		{
			i++;
		}
		return hash+i*i;
	}
	
	private void rehash()
	{
		HashEntry[] tmp = table;
		table = new HashEntry[nextPrime(table.length*2)];
		for (HashEntry he : tmp)
		{
			if (isActive(he))
			{
				insert(he.elm);
			}
		}
	}
	
	public void delete(Object item)
	{
		int index = findNextIndex(item);
		if (table[index] != null)
		{
			table[index].active = false;
		}
	}
	
	public Object find(Object item)
	{
		int index = findNextIndex(item);
		if (isActive(table[index]))
		{
			return table[index];
		}
		return null;
	}
	
	public int elementCount()
	{
		int count = 0;
		for (HashEntry he : table)
		{
			if (isActive(he))
			{
				count++;
			}
		}
		return count;
	}
	
	public boolean isEmpty()
	{
		for (HashEntry he : table)
		{
			if (isActive(he))
			{
				return false;
			}
		}
		return true;
	}
	
	public void makeEmpty()
	{
		table = new HashEntry[table.length];
	}
	
	public void printTable()
	{
		for (int i = 0; i < table.length; i++)
		{
			System.out.print("["+i+"] ");
			if (table[i] == null)
			{
				System.out.print("empty");
			}
			else
			{
				System.out.print(table[i].elm);
				System.out.print(", ");
				System.out.print(table[i].active? "active":"inactive");
			}
			System.out.println();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Iterator iterator()
	{
		return new Iter();
	}
}

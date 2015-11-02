import java.util.LinkedList;


public class HashTableSC<T>
{
	private LinkedList<T>[] elements;
	
	@SuppressWarnings("unchecked")
	public HashTableSC(int size)
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
}

/**
 * Hashtable implementation
 * Contains Iterator
 * 
 * Project 2
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/11/11
 * 
 * @see Comparable
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable
{
	/**
	 * A private class used by Hashtable
	 * Creates HashEntries to be used in the hashtable consisting of an element (type Object) and a boolean active
	 * 
	 * Project 4
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/10/21
	 */
	private class HashEntry
	{
		public Object elm; // element stored in the hashEntry
		public boolean active; // boolean stating whether or not the entry can be used (used for "deleting" an entry)
		
		/**
		 * Constructor creating a new hash entry of Object type
		 */
		public HashEntry(Object elm)
		{
			this.elm = elm;
			active = true;
		}
	}
	
	private HashEntry[] table; // Creates the table array in which the hash entries will be held
	private int size; // parameter for the number of elements inside the hashtable
	
	/**
	 * Constructor creating a new hash table
	 * Length of the array: next prime number after doubling the capacity
	 */
	public HashTable(int tableCapacity)
	{
		table = new HashEntry[nextPrime(2*tableCapacity)];
		size = 0;
	}
	

	/**
	 * Method returning whether or not the parameter (num) is prime
	 * @param num
	 * @return true if the input is prime, false otherwise
	 */
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
	/**
	 * Method for finding the next prime number specified in the parameter (num)
	 * @param num
	 * @return the next prime integer
	 */
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
	
	/**
	 * Method returning whether or not a hashEntry is active
	 * @param entry
	 * @return true if the hashEntry is active, false if it is not
	 */
	private static boolean isActive(HashEntry entry)
	{
		return entry != null && entry.active;
	}
	
	/**
	 * A private class used by Hashtable
	 * Visits each number in the order of its hash
	 * 
	 * Project 4
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/10/21
	 */
	private class Iter implements Iterator<Object>
	{
		private int cursor; // cursor: points to current location on the hashTable
		
		/**
		 * Constructor creating an iterator
		 * cursor starts at -1
		 */
		public Iter()
		{
			cursor = -1;
			findNextElm();
		}

		/**
		 * function moving the cursor onto the next element
		 */
		private void findNextElm()
		{
			cursor++;
			while (cursor < table.length && !isActive(table[cursor]))
			{
				cursor++;
			}
		}
		
		/**
		 * Returning a boolean stating whether or not there is a next node
		 */
		@Override
		public boolean hasNext() {
			return cursor < table.length;
		}

		/**
		 * Returns the next element in the in-level traversal
		 */
		@Override
		public Object next() {
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			Object tmp = table[cursor].elm; //temp variable holding the value of the cursor
			findNextElm();
			return tmp;
		}

		/**
		 * throws an UnsupportedOperationException; is not meant to be used in the class
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * Method inserting an element of type Object in the hashTable
	 * resizes the hashtable if it the size of the hashTable is greater than half of the hashTable
	 * @param item
	 */
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
	
	/**
	 * Returns the unique identifier for the object
	 * @param obj
	 * @return the index of the array where the element will be stored (hash)
	 */
	private int hash(Object obj)
	{
		return Math.abs(obj.hashCode()) % table.length;
	}
	
	/**
	 * finds the next available index for the object to be stored if the first spot is already taken
	 * @param obj
	 * @return the next index where the object will be stored
	 */
	private int findNextIndex(Object obj)
	{
		int hash = hash(obj);
		int i = 0;
		int index = hash;
		while (table[index] != null && !table[index].elm.equals(obj))
		{
			i++;
			index = (hash + i*i) % table.length;
		}
		return index;
	}
	
	/**
	 * Creates a new hashtable twice the size of the old hashTable
	 * Moves all the old elements into the new hashTable
	 */
	private void rehash()
	{
		HashEntry[] tmp = table; //creates temporary table twice the size of the old one
		table = new HashEntry[nextPrime(table.length*2)];
		for (HashEntry he : tmp)
		{
			if (isActive(he))
			{
				insert(he.elm);
			}
		}
	}
	
	/**
	 * Method "deleting" the specified element in the hashTable
	 * To "delete": makes the element inactive by changing the active instance variable to "false"
	 * @param item
	 */
	public void delete(Object item)
	{
		int index = findNextIndex(item);
		if (table[index] != null)
		{
			table[index].active = false;
		}
	}
	
	/**
	 * Method to find the specified item in the hashTable
	 * 
	 * @param item
	 * @return the index at which the item is located, returns null if the item is not located in the hashTable
	 */
	public Object find(Object item)
	{
		int index = findNextIndex(item);
		if (isActive(table[index]))
		{
			return table[index].elm;
		}
		return null;
	}
	
	/**
	 * Counts the number of entries in the hashtable
	 * @return an integer for the amount of items in a hashTable
	 */
	public int elementCount()
	{
		int count = 0; // integer counting the amount of items in an object
		for (HashEntry he : table)
		{
			if (isActive(he))
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Method seeing whether or not the hashTable is empty
	 * @return true if the hashTable is empty, false if it is not
	 */
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
	
	/**
	 * Empties the hashTable of all elements
	 */
	public void makeEmpty()
	{
		table = new HashEntry[table.length];
	}
	
	/**
	 * Prints out the hashtable in the following format:
	 * [0]: xxx, active
 	 *[1]: empty
   	 *[2]: yyy, inactive
	 */
	public void printTable()
	{
		for (int i = 0; i < table.length; i++)
		{
			System.out.print("["+i+"]: ");
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

	/**
	 * Constructor creating a new iterator
	 * @return a new Iterator
	 */
	@SuppressWarnings("rawtypes")
	public Iterator iterator()
	{
		return new Iter();
	}
}

/**
 * Linked list implementation of a stack.
 * 
 * Project 1
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/07
 */

import java.util.EmptyStackException;
public class MyStack<T>
{
	/**
	 * A single node containing an item in the list and a reference to the next node.
	 */
	private class Node
	{
		public T elm; // contains the data in the node
		
		public Node next; // contains the location of the next linked node
	}
	
	private Node first; // contains the first node in the linked list
	
	/**
	 * Initializes an instance of MyStack
	 */
	public MyStack()
	{
		first = null;
	}
	
	/**
	 * Places an item at the front of the stack.
	 * @param item The item to be placed on the stack.
	 */
	public void push(T item)
	{
		Node newFirst = new Node(); // creates a new node
		newFirst.elm = item; 
		newFirst.next = first; 
		first = newFirst; 
	}

	/**
	 * Removes an item from the front of the stack.
	 * @return The item removed from the stack.
	 */
	public T pop()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		T val = first.elm; // stores object to be returned
		first = first.next;
		return val;
	}
	
	/**
	 * Returns the value at the front of the stack.
	 * @return The item at the front of the stack.
	 */
	public T peek()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return first.elm;
	}
	
	/**
	 * Checks if there are any items left on the stack.
	 * @return true if there are no items on the stack, false otherwise.
	 */
	public boolean isEmpty()
	{
		return first == null;
	}
}

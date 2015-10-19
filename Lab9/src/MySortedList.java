import org.omg.CORBA.Current;


public class MySortedList
{
	private Node head;
	
	private class Node
	{
		public int element;
		public Node next;
		
		public Node(int element)
		{
			this.element = element;
			this.next = null;
		}
	
	}
		
	public MySortedList()
	{
		this.head = null;
	}
	
	public void add(int newElm)
	{
		if (head == null)
		{
			head = new Node(newElm);
		}
		
		else if(head.element > newElm)
		{
			Node tmp = new Node(newElm);
			tmp.next = head;
			head = tmp;
		}
		
		else
		{
			Node current = new Node(newElm);
			Node tmpHead = head;
			
			while ( tmpHead.next.element < current.element)
			{
				tmpHead = tmpHead.next;
			}
			
			current.next = tmpHead.next;
			tmpHead.next = current;
		}
	}
	
	
	public void delete(int elm)
	{
		if (head == null)
		{
			//DO NOTHING
		}
		else
		{
			//Set tmp variable head, iterate w/while until tmp.next == null
			//Stop when tmp.elem = elm
			//
		}
	}
	
	public int max()
	{
		Node tmpHead = head;
		
		while (tmpHead.next != null)
		{
			tmpHead = tmpHead.next;
		}
		
		return tmpHead.element;
	}
	
	public int min()
	{
		return head.element;
	}
	
	public void print()
	{
		Node tmpHead = head;
		while (tmpHead.next != null)
		{
			System.out.print(tmpHead.element + " " );
			tmpHead = tmpHead.next;
		}
		System.out.println();
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}
}

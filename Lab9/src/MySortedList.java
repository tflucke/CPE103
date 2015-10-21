
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
			
			while (tmpHead.next != null && tmpHead.next.element < current.element)
			{
				tmpHead = tmpHead.next;
			}
			
			current.next = tmpHead.next;
			tmpHead.next = current;
		}
	}
	
	
	public void delete(int elm)
	{
		if (head != null)
		{
			if (head.element == elm)
			{
				head = head.next;
			}
			else
			{
				Node tmp =  head;
				while(tmp.next != null && tmp.next.element <= elm)
				{
					if (tmp.next.element == elm)
					{
						tmp.next = tmp.next.next;
						return;
					}
					tmp = tmp.next;
				}
			}	
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
		while (tmpHead != null)
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

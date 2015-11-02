
public class MyList {
	
	private class Node{
		public int element;
		public Node next;
	}
	//instance variables
	public Node head;
	//constructor
	public MyList(){
		head = null;
	}
	//methods
	public void add(int elm){
		Node newNode = new Node();
		newNode.element = elm;
		newNode.next = head;
		head = newNode;
	}
	public boolean find(int elm){
		return find(elm, head);
	}
	private boolean find(int elm, Node next){
		if (next == null) return false;
		if (next.element == elm) return true;
		return find(elm, next.next);
	}
	public void print(){
		print(head);
	}
	private void print(Node next){
		if (next != null){
			print(next.next);
			System.out.print(next.element + " ");
		}
	}
	public int sum(){
		return sum(head);
	}
	private int sum(Node next){
		if (next == null) return 0;
		return sum(next.next) + next.element;
	}
}

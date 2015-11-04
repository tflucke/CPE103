/**
 * Binary Search Tree using the Comparable interface.
 * Contains classes BSTNode, PreIter, InIter, LevelIter
 * 
 * Project 3
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/11/1
 * 
 * @see Comparable
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST <T extends Comparable <? super T>>
{
	/**
	 * A private class used by BST
	 * Creates Nodes to be used in the tree consisting of a left child (type BSTNode), a right child (type BSTNode), and an element type T
	 * 
	 * Project 3
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/11/2
	 */
	
	private class BSTNode
	{
		/**
		 * Contains the element in this node of the tree
		 */
		private T element;
		
		/**
		 * The link to the left subtree
		 */
		private BSTNode leftChild;
		
		/**
		 * The link to the right subtree
		 */
		private BSTNode rightChild;

		/**
		 * Creates a node with the given element as the value
		 * 
		 * @param element The node's value
		 */
		private BSTNode(T element)
		{
			this.element = element;
		}
	}
	/**
	 * The BSTNode containing the beginning of the tree. 
	 */
	private BSTNode root;
	
	/**
	 * A private class used by BST
	 * Creates a stack that organizes the BST by preorder traversal
	 * 
	 * Project 3
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/11/2
	 */
	
	private class PreIter implements Iterator<T>
	{
		/**
		 * The stack that contains the elements in the tree 
		 */
		public MyStack<BSTNode> stk;
		
		/**
		 * Constructor creating the stack out of the BST, pushes the root onto the tree
		 */
		public PreIter()
		{
			stk = new MyStack<BSTNode>();
			if (root != null)
			{
				stk.push(root);
			}
		}
		
		/**
		 * Method returning a boolean stating whether or not there is a next element
		 */
		@Override
		public boolean hasNext()
		{	
			return (!stk.isEmpty());
		}
		
		/**
		 * Method returns the next element in the preorder traversal
		 */
		@Override
		public T next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			
			/*
			 * Temporary variable holding the value of the popped node
			 */
			BSTNode tmp = stk.pop();
			if (tmp.rightChild != null)
			{
				stk.push(tmp.rightChild);
			}
			if (tmp.leftChild != null)
			{
				stk.push(tmp.leftChild);
			}
			
			return tmp.element;
		}
	}
	
	/**
	 * A private class used by BST
	 * Creates a stack that organizes the BST by infix traversal
	 * 
	 * Project 3
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/11/2
	 */
	
	private class InIter implements Iterator<T>
	{
		/**
		 * The stack that contains the elements in the tree 
		 */
		public MyStack<BSTNode> stk;
		
		/**
		 * Constructor creating the stack out of the BST, pushes the root onto the tree
		 */
		public InIter()
		{
			stk = new MyStack<BSTNode>();
			BSTNode chkNode = root;
			while (chkNode != null)
			{
				stk.push(chkNode);
				chkNode = chkNode.leftChild;
			}
		}
		
		/**
		 * Method returning a boolean stating whether or not there is a next node
		 */
		@Override
		public boolean hasNext()
		{
			return(!stk.isEmpty());
		}
		
		/**
		 * Method returns the next element in the infix traversal
		 */
		@Override
		public T next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			/*
			 * Temporary variable holding the value of the popped node
			 */
			BSTNode tmp = stk.pop();
			/*
			 * Current left most node of the right subtree to be added to the stack
			 */
			BSTNode chkNode = tmp.rightChild;
			while(chkNode != null)
			{
				stk.push(chkNode);
				chkNode = chkNode.leftChild;
			}
			return tmp.element;
		}
		
	}
	
	/**
	 * A private class used by BST
	 * Creates a queue that organizes the BST by level
	 * 
	 * Project 3
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/11/2
	 */
	private class LevelIter implements Iterator<T>
	{
		/**
		 * The queue that contains the elements in the tree 
		 */
		private LQueue<BSTNode> queue;
		
		/**
		 * Constructor creating the queue out of the BST, pushes the root onto the tree
		 */
		public LevelIter()
		{
			queue = new LQueue<BSTNode>();
			if(root != null)
			{
				queue.enqueue(root);
			}
		}

		/**
		 * Returning a boolean stating whether or not there is a next node
		 */
		@Override
		public boolean hasNext() 
		{
			return !queue.isEmpty();
		}

		/**
		 * Returns the next element in the in-level traversal
		 */
		@Override
		public T next() 
		{
			/*
			 * Temporary variable holding the value of the dequeued node
			 */
			BSTNode tmp = queue.dequeue();
			if(tmp.leftChild != null)
			{
				queue.enqueue(tmp.leftChild);
			}
			if(tmp.rightChild != null)
			{
				queue.enqueue(tmp.rightChild);
			}
			return tmp.element;
		}
	}

	/**
	 * An exception to be thrown when an invalid operation is invoked while the heap is empty.
	 * Basically a carbon-copy of RuntimeException
	 * 
	 * Project 3
	 * 
	 * @author Thomas Flucke tflucke
	 * @author Lara Luu ljluu
	 * 
	 * @since 2015/11/2
	 */
	@SuppressWarnings("serial")
	public static class MyException extends RuntimeException
	{
		/**
		 * Default constructor which just calls the super constructor.
		 */
		public MyException()
		{
			super();
		}

		/**
		 * Constructor which just passes a string argument to the super constructor.
		 */
		public MyException(String msg)
		{
			super(msg);
		}
	}
	
	/**
	 * Constructor initializes an empty binary search tree
	 */
	public BST()
	{
		root = null;
	}
	
	/**
	 * Method to insert a T element into the BST
	 */
	public void insert(T item)
	{
		root = insertHelper(root, item);
	}
	
	/**
	 * returns BSTNode after adding the new member in the correct location
	 */
	private BSTNode insertHelper(BSTNode chkNode, T item)
	{
		if (chkNode == null)
		{
			return new BSTNode(item);
		}
		if(item.compareTo(chkNode.element) < 0)
		{
			chkNode.leftChild = insertHelper(chkNode.leftChild, item);
		}
		else
		{
			chkNode.rightChild = insertHelper(chkNode.rightChild, item);
		}
		return chkNode;
	}
	
	/**
	 * Finds the element specified in the BST and deletes it
	 */
	public void delete(T item)
	{
		root = deleteFindHelper(root, item);
	}
	
	/**
	 * locates the element to be deleted, runs deleteNode to delete the node
	 */
	private BSTNode deleteFindHelper(BSTNode chkNode, T item)
	{
		if(chkNode == null)
		{
			return null;
		}
		else if(chkNode.element.compareTo(item) == 0)
		{
			return deleteNode(chkNode);
			
		}
		else if(item.compareTo(chkNode.element) < 0)
		{
			chkNode.leftChild = deleteFindHelper(chkNode.leftChild, item);
		}
		else
		{
			chkNode.rightChild = deleteFindHelper(chkNode.rightChild, item);
		}
		return chkNode;
	}
	
	/**
	 * returns a node after circulating through the BST to delete the found element
	 */
	private BSTNode deleteNode(BSTNode deleteNode)
	{
		//Node has no children
		if (deleteNode.leftChild == null && deleteNode.rightChild == null)
		{
			return null;
		}
		//Node has one child
		if(deleteNode.leftChild != null && deleteNode.rightChild == null)
		{
			return deleteNode.leftChild;
		}
		else if( deleteNode.rightChild != null && deleteNode.leftChild == null)
		{
			return deleteNode.rightChild;
		}
		//Node has two children
		else
		{
			BSTNode chkNode = deleteNode.rightChild;
			while (chkNode.leftChild != null)
			{
				chkNode = chkNode.leftChild;
			}
			deleteNode.element = chkNode.element;
			deleteNode(chkNode);
			return deleteNode;
		}

	}
	
	/**
	 * Returns a boolean stating whether or not an item is found in the BST
	 */
	public boolean find(T item)
	{
		return findHelper(root, item);
	}
	
	/**
	 * Recurses through BST in order to search for the item to be found
	 */
	private boolean findHelper(BSTNode chkNode, T item)
	{
		if (chkNode == null)
		{
			return false;
		}
		else if (chkNode.element.compareTo(item) == 0)
		{
			return true;
		}
		else if (item.compareTo(chkNode.element) < 0)
		{
			return findHelper(chkNode.leftChild, item);
		}
		else
		{
			return findHelper(chkNode.rightChild, item);
		}
		
	}
	
	/**
	 * returns a boolean stating whether or not the tree is empty
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * deletes the old BST, creating a new one in its place
	 */
	public void makeEmpty()
	{
		root = null;
	}
	
	/**
	 * returns the number of elements in the tree
	 */
	public int size()
	{
		return sizeHelper(root);
		
	}
	
	/**
	 * recurses through the tree to count the number of elements in it
	 */
	private int sizeHelper(BSTNode chkNode)
	{
		if (chkNode == null)
		{
			return 0;
		}
		else
		{
			return 1 + sizeHelper(chkNode.leftChild) + sizeHelper(chkNode.rightChild);
		}
	}
	
	/**
	 * returns the smallest element in the tree
	 */
	public T findMinimum()
	{
		if(root == null)
		{
			throw new MyException();
		}
		/*
		 * holds the min node in the tree
		 */
		BSTNode chkNode = root;
		while(chkNode.leftChild != null)
		{
			chkNode = chkNode.leftChild;
		}
		return chkNode.element;
	}
	
	/**
	 * returns the largest element in the tree
	 */
	public T findMaximum()
	{
		if (root == null)
		{
			throw new MyException();
		}
		/*
		 * holds the max node in the tree
		 */
		BSTNode chkNode = root;
		while(chkNode.rightChild != null)
		{
			chkNode = chkNode.rightChild;
		}
		return chkNode.element;
	}
	
	/**
	 * Constructor creating a preOrder stack
	 */
	public Iterator<T> iteratorPre()
	{
		return new PreIter();
	}
	
	/**
	 * Constructor creating a infixOrder stack
	 */
	public Iterator<T> iteratorIn()
	{
		return new InIter();
	}
	
	/**
	 * Constructor creating a levelOrder stack
	 */
	public Iterator<T> iteratorLevel()
	{
		return new LevelIter();
	}

	/**
	 * Method printing out all the elements in the tree
	 */
	public void printTree()
	{
		printHelper(root, "");
	}
	
	/**
	 * Recursive method creating the formatting for and printing the tree
	 */
	private void printHelper(BSTNode chkNode, String indent)
	{
		if (chkNode != null)
		{
			System.out.println(indent + chkNode.element);
			indent += "    ";
			printHelper(chkNode.leftChild, indent);
			printHelper(chkNode.rightChild, indent);
		}
	}
	
	/**
	 * Method creating a single-line string out of the binary tree
	 */
	@Override
	public String toString()
	{
		return stringHelper(root);
	}
	
	/**
	 * Recursive method helping to form the string with proper formatting 
	 */
	private String stringHelper(BSTNode chkNode)
	{
		if (chkNode == null)
		{
			return "";
		}
		String left = stringHelper(chkNode.leftChild);
		String right = stringHelper(chkNode.rightChild);
		return (chkNode.element + (left.length() > 0? " "+left:"") + (right.length() > 0? " "+right:"") );
	}
}

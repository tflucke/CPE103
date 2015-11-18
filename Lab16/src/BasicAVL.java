public class BasicAVL 
{
	private class AVLNode
	{
		int element;
		int height;
		
		AVLNode leftChild;
		AVLNode rightChild;
	
		public AVLNode(int element)
		{
			this.element = element;
			this.height = 0;
		}
	}
	
	private AVLNode root;
	
	public BasicAVL()
	{
		root = null;
	}
	
	public void insert(int item)
	{
		root = insert(root, item);
	}
	
	private AVLNode insert(AVLNode root, int item)
	{
		if(root == null)
		{
			return new AVLNode(item);
		}
		else if(item < root.element)
		{
			root.leftChild = insert(root.leftChild, item);
			if(root.leftChild.height >= height(root.rightChild) + 2)
			{
				if(item < root.leftChild.element)
				{
					root = rotateWithLeft(root);
				}
				else
				{
					root = doubleRightLeft(root);
				}
			}
		
		}
		else
		{
			root.rightChild = insert(root.rightChild, item);
			if(root.rightChild.height >= height(root.leftChild) + 2)
			{
				if(item < root.rightChild.element)
				{
					root = doubleLeftRight(root);
				}
				else
				{
					root = rotateWithRight(root);
				}
			}
		}
		root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
		return root;
	}
	
	private AVLNode rotateWithRight(AVLNode oldRoot)
	{
		AVLNode newRoot = oldRoot.rightChild;
		oldRoot.rightChild = newRoot.leftChild;
		newRoot.leftChild = oldRoot;
		oldRoot.height = 1 + Math.max(height(oldRoot.leftChild), height(oldRoot.rightChild));
		newRoot.height = 1 + Math.max(height(newRoot.rightChild), newRoot.leftChild.height);
		return newRoot;
	}
	
	private AVLNode rotateWithLeft(AVLNode oldRoot)
	{
		AVLNode newRoot = oldRoot.leftChild;
		oldRoot.leftChild = newRoot.rightChild;
		newRoot.rightChild = oldRoot;
		oldRoot.height = 1 + Math.max(height(oldRoot.leftChild), height(oldRoot.rightChild));
		newRoot.height = 1 + Math.max(height(newRoot.leftChild), newRoot.rightChild.height);
		return newRoot;
	}
	
	private AVLNode doubleLeftRight(AVLNode oldRoot)
	{
		oldRoot.leftChild = rotateWithRight(oldRoot.leftChild);
		return rotateWithLeft(oldRoot);
	}
	
	private AVLNode doubleRightLeft(AVLNode oldRoot)
	{
		oldRoot.rightChild = rotateWithLeft(oldRoot.rightChild);
		return rotateWithRight(oldRoot);
	}
	private int height(AVLNode node)
	{
		return node == null? -1:node.height;
	}
	
	public void print()
	{
		printHelper(root, "");
	}
	
	private void printHelper(AVLNode chkNode, String indent)
	{
		if (chkNode != null)
		{
			System.out.println(indent + chkNode.element);
			indent += "    ";
			printHelper(chkNode.leftChild, indent);
			printHelper(chkNode.rightChild, indent);
		}
	}
}

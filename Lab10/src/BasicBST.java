
public class BasicBST 
{
	
	private class BSTNode
	{
		public int element;
		public BSTNode left;
		public BSTNode right;
		
		public BSTNode(int element)
		{
			this.element = element;
			this.left = null;
			this.right = null;
		}
	}
	
	private BSTNode root;
	
	public BasicBST()
	{
		root = null;
	}
	
	
	
	public void insert(int insert)
	{
		if(root == null)
		{
			root = new BSTNode(insert);
		}
		else
		{
			insertHelper(insert, root);
		}
	}
	
	private BSTNode insertHelper(int insert, BSTNode chkNode)
	{
		if (chkNode == null)
		{
			return new BSTNode(insert);
		}
		else if(insert < chkNode.element)
		{
			chkNode.left = insertHelper(insert, chkNode.left);
		}
		else
		{
			chkNode.right = insertHelper(insert, chkNode.right);
		}
		return chkNode;
	}
	
	public int countOdds()
	{
		return countHelper(root);
	}
	
	private int countHelper(BSTNode chkNode)
	{
		if (chkNode == null)
		{
			return 0;
		}
		else if(chkNode.element %2 == 1)
		{
			return 1 + countHelper(chkNode.left)+ countHelper(chkNode.right); 
		}
		else
		{
			return countHelper(chkNode.left)+ countHelper(chkNode.right);
		}
	}
	
	public int height()
	{
		return heightHelper(root);
	}
	
	private int heightHelper(BSTNode chkNode)
	{
		if(chkNode == null)
		{
			return -1;
		}
		else
		{
			return 1 + Math.max(heightHelper(chkNode.left), heightHelper(chkNode.right));
		}
	}
	
	public int countLeaves()
	{
		return leavesHelper(root);
	}
	
	private int leavesHelper(BSTNode chkNode)
	{
		if(chkNode == null)
		{
			return 0;
		}
		else if (chkNode.left == null && chkNode.right == null)
		{
			return 1;
		}
		else
		{
			return leavesHelper(chkNode.left) + leavesHelper(chkNode.right);
		}
	}

	public int countOneChildParents()
	{
		return oneChildHelper(root);
	}
	
	private int oneChildHelper(BSTNode chkNode)
	{
		if(chkNode == null)
		{
			return 0;
		}
		else if (chkNode.left == null ^ chkNode.right == null)
		{
			return 1;
		}
		else
		{
			return oneChildHelper(chkNode.left) + oneChildHelper(chkNode.right);
		}
	}
}

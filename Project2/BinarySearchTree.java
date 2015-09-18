/**
 * Ankit Gandhi
 * CS 146B
 */

public class BinarySearchTree
{
	private BinaryNode root;
	
	// Construct the tree
	public BinarySearchTree() 
	{
		root = null;
	}
	
	// The tree root
	public BinaryNode getRoot()
    {
        return root;
    }
	
	// Make the tree logically empty
	public void makeEmpty()
    {
        root = null;
    }
	
	// Test if the tree is logically empty
	public boolean isEmpty()
    {
        return root == null;
    }
	
	// insert an value to the tree
	public void insert(int value) 
	{
		root = insert(value, root);
	}

	private BinaryNode insert(int value, BinaryNode root) 
	{
		if (root == null)
		{
			return new BinaryNode(value, null, null);
		}
		
		int compareResult = value.compareTo(root.getData());
		
		if (compareResult < 0)
		{
			root.setLeft(insert(value, root.getLeft()));
		}
		else if (compareResult > 0)
		{
			root.setRight(insert(value, root.getRight()));
		}
		else
		{
			; // Duplicate; do nothing
		}
		
		return root;
	}
	 
	// Find the smallest value in the tree
	public int findMin()
	{
		if (!isEmpty()) {
			BinaryNode traverse = root;
			while (true) {
				if (traverse.left == null)
					break;
				else
					traverse = traverse.left;
			}
			return traverse.data;
		} else {
			return null;
		}
	}

	// Find the largest value in the tree
	public int findMax()
	{
		if (!isEmpty()) {
			BinaryNode traverse = root;
			while (true) {
				if (traverse.right == null)
					break;
				else
					traverse = traverse.right;
			}
			return traverse.data;
		} else {
			return null;
		}
	}

	// Determines the height of the tree
	int getHeight()
	{
		if (root == null)
			return -1;

		if (root.height != null)
			return root.height;
		else {	
			root.height = max(getHeight(root.left),
							  getHeight(root.right)) + 1;
			return root.height;
		}
	}
	
    // recursive method that removes a value from the tree
	public void remove(int value) 
	{
        root = remove(value, root);
    }

    private BinaryNode remove(int value, BinaryNode root) 
    {
        if(root == null) 
        {
            return root;
        }
        
        int compareResult = value.compareTo(root.getData());
        
        if(compareResult < 0) 
        {
            root.setLeft(remove(value, root.getLeft()));
        } 
        else if(compareResult > 0) 
        {
            root.setRight(remove(value, root.getRight()));
        }
        else if(root.getLeft() != null && root.getRight() != null)
        {
            root.setData(findMin(root.getRight()).getData());
            root.setRight(remove(root.getData(), root.getRight()));
        }
        else
        {
            root = root.getLeft() != null ? root.getLeft() : root.getRight();
        }
        
		return root;
    }
}

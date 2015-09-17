/**
 * Ankit Gandhi
 * CS 146B
 */

public class BinarySearchTree<T extends Comparable<T>> 
{
	private BinaryNode<T> node;
	
	// Construct the tree
	public BinarySearchTree() 
	{
		node = null;
	}
	
	// The tree root
	public BinaryNode<T> getRoot()
    {
        return node;
    }
	
	// Make the tree logically empty
	public void makeEmpty()
    {
        node = null;
    }
	
	// Test if the tree is logically empty
	public boolean isEmpty()
    {
        return node == null;
    }
	
	// insert an value to the tree
	public void insert(T value) 
	{
		node = insert(value, node);
	}
	private BinaryNode<T> insert(T value, BinaryNode<T> node) 
	{
		if (node == null)
		{
			return new BinaryNode<T>(value, null, null);
		}
		
		int compareResult = value.compareTo(node.getData());
		
		if (compareResult < 0)
		{
			node.setLeft(insert(value, node.getLeft()));
		}
		else if (compareResult > 0)
		{
			node.setRight(insert(value, node.getRight()));
		}
		else
		{
			; // Duplicate; do nothing
		}
		
		return node;
	}
	 
	// Find the smallest value in the tree
	public T findMin()
	{
		if(isEmpty( ))
		{
			return null;
		}
		return findMin(node).getData();
	}
	private BinaryNode<T> findMin(BinaryNode<T> node) 
	{		
        if(node == null) 
        {
            return null;
        } 
        else if(node.getLeft() == null)
        {
            return node;
        } 
        else 
        {
            return findMin(node.getLeft());
        }
	}

	// Find the largest value in the tree
	public T findMax()
	{
		 if(isEmpty())
		 {
			 return null;
		 }
		 return findMax(node).getData();
	}
	private BinaryNode<T> findMax(BinaryNode<T> node)
	{
        if(node == null)
        {
        	while( node.getRight() != null )
        	{
        		 node = node.getRight();
        	}
        }		
        return node;
	}
	
    // recursive method that removes a value from the tree
	public void remove(T value) 
	{
        node = remove(value, node);
    }
    private BinaryNode<T> remove(T value, BinaryNode<T> node) 
    {
        if(node == null) 
        {
            return node;
        }
        
        int compareResult = value.compareTo(node.getData());
        
        if(compareResult < 0) 
        {
            node.setLeft(remove(value, node.getLeft()));
        } 
        else if(compareResult > 0) 
        {
            node.setRight(remove(value, node.getRight()));
        }
        else if(node.getLeft() != null && node.getRight() != null)
        {
            node.setData(findMin(node.getRight()).getData());
            node.setRight(remove(node.getData(), node.getRight()));
        }
        else
        {
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
        }
        
		return node;
    }

    private int height(BinaryNode node)
    {
		if (node == null)
			return -1;

		if (root.height != null)
			return root.height;
		else {
			root.height = max(height(node.left).
							  height(node.right)) + 1;
			return root.height;
		}
	}
}

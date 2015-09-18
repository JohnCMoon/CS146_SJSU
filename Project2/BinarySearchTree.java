/**
 * Ankit Gandhi
 * CS 146B
 */

<<<<<<< HEAD
public class BinarySearchTree<T extends Comparable<T>> 
{
	private BinaryNode<T> node;
=======
public class BinarySearchTree
{
	private BinaryNode root;
>>>>>>> a83d61fc3211ab47bebe01de64438b1878d2e5d1
	
	// Construct the tree
	public BinarySearchTree() 
	{
<<<<<<< HEAD
		node = null;
	}
	
	// The tree root
	public BinaryNode<T> getRoot()
    {
        return node;
=======
		root = null;
	}
	
	// The tree root
	public BinaryNode getRoot()
    {
        return root;
>>>>>>> a83d61fc3211ab47bebe01de64438b1878d2e5d1
    }
	
	// Make the tree logically empty
	public void makeEmpty()
    {
<<<<<<< HEAD
        node = null;
=======
        root = null;
>>>>>>> a83d61fc3211ab47bebe01de64438b1878d2e5d1
    }
	
	// Test if the tree is logically empty
	public boolean isEmpty()
    {
<<<<<<< HEAD
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
=======
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
>>>>>>> a83d61fc3211ab47bebe01de64438b1878d2e5d1
		}
		else
		{
			; // Duplicate; do nothing
		}
		
<<<<<<< HEAD
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
=======
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
>>>>>>> a83d61fc3211ab47bebe01de64438b1878d2e5d1
}

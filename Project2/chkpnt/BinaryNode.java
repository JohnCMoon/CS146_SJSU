/*
 *
 *	File: BinaryNode.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *			 John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Implements the binary node class for use in BST and AVL trees.
 *
 */

public final class BinaryNode<T>
{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private int height = 0;

	/* Constructors */	
	public BinaryNode(T newData, BinaryNode<T> leftNode, BinaryNode<T> rightNode, int newHeight) 
	{
		data = newData;
		left = leftNode;
		right = rightNode;
		height = newHeight;
	}
	
	public BinaryNode(T data)
    {
        this(data, null, null, 0);
    }

	/* Getters and setters */
	public T getData() 
	{
		return data;
	}

	public void setData(T theData) 
	{
		data = theData;
	}

	public BinaryNode<T> getLeft() 
	{
		return left;
	}

	public void setLeft(BinaryNode<T> leftNode) 
	{
		left = leftNode;
	}

	public BinaryNode<T> getRight() 
	{
		return right;
	}

	public void setRight(BinaryNode<T> rightNode)
	{
		right = rightNode;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int theHeight) 
	{
		 height = theHeight;
	}
}

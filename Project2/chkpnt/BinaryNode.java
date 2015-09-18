/**
 * Ankit Gandhi
 * CS 146B
 */

public final class BinaryNode<T>
{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private int height = 0;
	
	public BinaryNode(T theData, BinaryNode<T> leftNode, BinaryNode<T> rightNode, int theHeight) 
	{
		data = theData;
		left = leftNode;
		right = rightNode;
		height = theHeight;
	}
	
	public BinaryNode(T data)
    {
        this(data, null, null, 0);
    }

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
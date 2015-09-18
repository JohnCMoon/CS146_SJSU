/**
 * Ankit Gandhi
 * CS 146B
 */

public final class BinaryNode<T>
{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T theData, BinaryNode<T> leftNode, BinaryNode<T> rightNode) 
	{
		data = theData;
		left = leftNode;
		right = rightNode;
	}
	
	public BinaryNode(T data)
    {
        this(data, null, null);
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
}

<<<<<<< HEAD
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
=======
public class BinaryNode
{
	private int data;
	private int height;
	private BinaryNode left;
	private BinaryNode right;

	public BinaryNode(int newData, BinaryNode newLeft, BinaryNode newRight)
	{
		data = newData;
		left = newLeft;
		right = newRight;
	}	
	
	public BinaryNode(int data)
	{
		this(data, null, null);
	}

	public int getData()
	{
		return data;
	}

	public int getHeight()
	{
		return height;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setData(int value)
	{
		data = value;
	}
	
	public void setHeight(int newHeight)
	{
		height = newHeight;
	}
	
	public void setLeft(BinaryNode node) {
		left = node;
	}	

	public void setRight(BinaryNode node) {
		right = node;
	}
}
>>>>>>> a83d61fc3211ab47bebe01de64438b1878d2e5d1

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

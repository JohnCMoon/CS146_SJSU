public class ListNode
{
	private DataCount<String> data;
	private ListNode next;

	ListNode()
	{
		data = null;
		next = null;
	}

	ListNode(String newData)
	{
		data = new DataCount<String>(newData, 1);
		next = null;
	}
	
	public void incQty()
	{
		data.count = data.count + 1;
	}

	public DataCount<String> getData()
	{
		return data;
	}

	public int getQty()
	{
		return data.count;
	}

	public ListNode getNext()
	{
		return next;
	}

	public void setData(String newData)
	{
		data.data = newData;
	}

	public void setNext(ListNode newNext)
	{
		next = newNext;
	}
}

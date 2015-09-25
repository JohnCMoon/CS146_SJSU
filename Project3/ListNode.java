public class ListNode<T>
{
	private T data;
	private int qty;
	private ListNode next;

	ListNode()
	{
		data = null;
		qty = 0;
		next = null;
	}

	ListNode(T newData)
	{
		data = newData;
		qty = 1;
		next = null;
	}

	public void incQty()
	{
		qty = qty + 1;
	}

	public T getData()
	{
		return data;
	}

	public int getQty()
	{
		return qty;
	}

	public ListNode getNext()
	{
		return next;
	}

	public void setData(T newData)
	{
		data = newData;
	}

	public void setNext(ListNode newNext)
	{
		next = newNext;
	}
}

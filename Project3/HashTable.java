/**
 * TODO Replace this comment with your own.
 * 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable implements DataCounter<String>
{
	int capacity;
	ListNode[] table;

	HashTable(int newCap)
	{
		capacity = newCap;
		table = new ListNode[capacity];	
		for (int i = 0; i < capacity; i++)
			table[i] = new ListNode<String>();
	}

    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        return null;
    }

    /** {@inheritDoc} */
    public int getCap() {
        return capacity;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
		int index = hashCode(data);
		ListNode traverse = table[index];
		while (true) {
			if (traverse != null) {
				if (traverse.getData() == data) {
					traverse.incQty();
					break;
				} else {
					if (traverse.getNext() == null) {
						ListNode newNode = new ListNode(data);
						traverse.setNext(newNode);
						break;
					} else {
						traverse = traverse.getNext();
					}
				}
			} else {
				ListNode newNode = new ListNode(data);
				traverse = newNode;
				break;
			}
		}
	}

	/* Returns index based on modded sum of string's ascii values */
	public int hashCode(String data)
	{
		int length = data.length();
		int sum = 0;
		for (int i = 1; i < length; i++) {
			char ch = data.charAt(i);
			sum = sum + (int)ch;
		}
		return sum % getCap();
	}
}

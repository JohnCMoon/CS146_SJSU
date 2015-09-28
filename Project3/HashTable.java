/**
 * TODO Replace this comment with your own.
 * 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable
{
	int capacity;
	ListNode[] table;

	HashTable(int newCap)
	{
		capacity = newCap;
		table = new ListNode[capacity];	
		for (int i = 0; i < capacity; i++)
			table[i] = new ListNode();
	}

    public int getCap() {
        return capacity;
    }

    /* Increments the qty of given data. If data does not exist, creates data. */
    public void incCount(String data) {
		int index = hashCode(data);
		System.out.println("Index " + index);
		ListNode traverse = table[index];
		while (true) {
			if (traverse.getData() != null) {
				if (traverse.getData().data == data) {
					System.out.println("Node qty incremented...");
					traverse.incQty();
					break;
				} else {
					if (traverse.getNext() == null) {
						ListNode newNode = new ListNode(data);
						traverse.setNext(newNode);
						System.out.println("New node added 1...");
						break;
					} else {
						traverse = traverse.getNext();
					}
				}
			} else {
				ListNode newNode = new ListNode(data);
				traverse = newNode;
				System.out.println("New node added 2...");
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

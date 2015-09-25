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
	int size;
	ListNode[] table;

	HashTable(int newSize)
	{
		size = newSize;
		table = new ListNode[size];	
		for (int i = 0; i < size; i++)
			table[i] = new ListNode<String>();
	}

    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        // TODO Auto-generated method stub
        return null;
    }

    /** {@inheritDoc} */
    public int getSize() {
        return size;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
        // TODO Auto-generated method stub

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
		return sum % getSize();
	}
}

/* Implements the HashCounter using Strings */

class HashCounter implements DataCounter<String>
{
	/* Creates hash table with large prime number */
	HashTable hashTable = new HashTable(4999);

	/* Increments the qty of given data. If data does not exist, creates data. */
	public void incCount(String data)
	{
		hashTable.incCount(data);	
	}	

	public int getSize()
	{
		int sum = 0;
		for (int i = 0; i < hashTable.getCap(); i++) {
			ListNode traverse = hashTable.table[i];
			while (traverse.getData() != null) {
				sum = sum + 1;
				traverse = traverse.getNext();
			}
		}
		return sum;
	}

	public DataCount<String>[] getCounts()
	{
		int size = getSize();
		DataCount[] arr = new DataCount[size];
		int j = 0;
		for (int i = 0; i < hashTable.getCap(); i++) {
			ListNode traverse = hashTable.table[i];
			while (traverse.getData() != null) {
				arr[j] = traverse.getData();
				j = j + 1;
				traverse = traverse.getNext();
			}
		}
		return arr;
	}

}

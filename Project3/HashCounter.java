/* Implements the HashCounter using Strings */

class HashCounter implements DataCounter<String>
{
	HashTable table = new HashTable();

	public void incCount(String data)
	{
		table.incCount(data);		
	}	

	public int getSize()
	{
		int sum = 0;
		for (int i = 0; i < HashTable.getSize(); i++) {
			Node traverse = HashTable.table[i];
			while (traverse != null) {
				sum = sum + 1;
				traverse = traverse.next;
			}
		}
		return sum;
	}

	public DataCount<String>[] getCounts()
	{
		int size = getSize();
		DataCount<String>[] arr = new DataCount<String>[size];
		int j = 0;
		for (int i = 0; i < HastTable.getSize(); i++) {
			Node traverse = HashTable.table[i];
			while (traverse != null) {
				arr[j] = traverse.getData();
				j = j + 1;
				traverse = traverse.next;
			}
		}
		return arr;
	}

}

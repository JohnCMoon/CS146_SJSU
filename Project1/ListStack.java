import java.util.EmptyStackException;

public class ListStack implements DStack {

	public class LinkedList {

		private Node first = null;

		public void insFirst(double data) {
			Node newNode = new Node(data);
			newNode.next = first;
			first = newNode;
		}

		public Node delFirst() {
			Node tmp = first;
			first = first.next;
			return tmp;
		}

		public boolean isEmpty() {
			return (first == null);
		}
	}

	LinkedList list = new LinkedList();

	public void push(double data) {
		list.insFirst(data);
	}

	public double pop() {
		if (!list.isEmpty()) {
			Node tmp = list.delFirst();
			return tmp.data;
		} else {
			throw new EmptyStackException();
		}
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public double peek() {
		if (!list.isEmpty()) {
			return list.first.data;
		} else {
			throw new EmptyStackException();
		}
	}
}

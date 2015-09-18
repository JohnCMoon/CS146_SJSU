/**
 * Ankit Gandhi 
 * CS 146B
 */

public class BinarySearchTree<T extends Comparable<T>> {
	private BinaryNode<T> node;

	// Construct the tree
	public BinarySearchTree() {
		node = null;
	}

	// The tree root
	public BinaryNode<T> getRoot() {
		return node;
	}

	// Make the tree logically empty
	public void makeEmpty() {
		node = null;
	}

	// Test if the tree is logically empty
	public boolean isEmpty() {
		return node == null;
	}

	// find an item in a subtree
	public boolean contains(T value) {
		return contains(value, node);
	}
	private boolean contains(T value, BinaryNode<T> node) {
		if (node == null) {
			return false;
		}

		int compareResult = value.compareTo(node.getData());

		if (compareResult < 0) {
			return contains(value, node.getLeft());
		} else if (compareResult > 0) {
			return contains(value, node.getRight());
		} else {
			return true; // Match
		}
	}

	// insert an value to the tree
	public void insert(T value) {
		System.out.println("Inserting " + value);
		node = insert(value, node);
	}
	protected BinaryNode<T> insert(T value, BinaryNode<T> node) {
		if (node == null) {
			return new BinaryNode<T>(value, null, null, 0);
		}

		int compareResult = value.compareTo(node.getData());

		if (compareResult < 0) {
			node.setLeft(insert(value, node.getLeft()));
		} else if (compareResult > 0) {
			node.setRight(insert(value, node.getRight()));
		} else {
			; // Duplicate; do nothing
		}

		return node;
	}

	// Find the smallest value in the tree
	public T findMin() {
		if (isEmpty()) {
			return null;
		}
		return findMin(node).getData();
	}
	private BinaryNode<T> findMin(BinaryNode<T> node) {
		if (node == null) {
			return null;
		} else if (node.getLeft() == null) {
			return node;
		} else {
			return findMin(node.getLeft());
		}
	}

	// Find the largest value in the tree
	public T findMax() {
		if (isEmpty()) {
			return null;
		}
		return findMax(node).getData();
	}
	private BinaryNode<T> findMax(BinaryNode<T> node) {
		if (node == null) {
			while (node.getRight() != null) {
				node = node.getRight();
			}
		}
		return node;
	}

	// Determines the height of the tree
	public int height() {
		return (height(node));
	}
	protected int height(BinaryNode<T> node) {
		if (node == null) {
			return -1;
		}
		
		int left = height(node.getLeft());
		int right = height(node.getRight());
		int total = Math.max(left, right) + 1;

		return total;
	}

	// recursive method that removes a value from the tree
	public void remove(T value) {
		node = remove(value, node);
	}
	protected BinaryNode<T> remove(T value, BinaryNode<T> node) {
		if (node == null) {
			return node;
		}

		int compareResult = value.compareTo(node.getData());

		if (compareResult < 0) {
			node.setLeft(remove(value, node.getLeft()));
		} else if (compareResult > 0) {
			node.setRight(remove(value, node.getRight()));
		} else if (node.getLeft() != null && node.getRight() != null) {
			node.setData(findMin(node.getRight()).getData());
			node.setRight(remove(node.getData(), node.getRight()));
		} else {
			node = node.getLeft() != null ? node.getLeft() : node.getRight();
		}

		return node;
	}
}

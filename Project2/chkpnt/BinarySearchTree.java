/*
 *
 *	File: BinarySearchTree.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *			 John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Implements the binary search tree class.
 *
 */

public class BinarySearchTree<T extends Comparable<T>>
{
	
	private BinaryNode<T> root;

	/* Contructor */
	public BinarySearchTree()
	{
		root = null;
	}

	public BinaryNode<T> getRoot()
	{
		return root;
	}

	public void makeEmpty()
	{
		root = null;
	}

	public boolean isEmpty()
	{
		return root == null;
	}

	// find an item in a subtree
	public boolean contains(T value)
	{
		return contains(value, root);
	}
	private boolean contains(T value, BinaryNode<T> root)
	{
		if (root == null) {
			return false;
		}

		int compareResult = value.compareTo(root.getData());

		if (compareResult < 0) {
			return contains(value, root.getLeft());
		} else if (compareResult > 0) {
			return contains(value, root.getRight());
		} else {
			return true; // Match
		}
	}

	// insert an value to the tree
	public void insert(T value)
	{
		System.out.println("Inserting " + value);
		root = insert(value, root);
	}
	protected BinaryNode<T> insert(T value, BinaryNode<T> root)
	{
		if (root == null) {
			return new BinaryNode<T>(value, null, null, 0);
		}

		int compareResult = value.compareTo(root.getData());

		if (compareResult < 0) {
			root.setLeft(insert(value, root.getLeft()));
		} else if (compareResult > 0) {
			root.setRight(insert(value, root.getRight()));
		} else {
			; // Duplicate; do nothing
		}

		return root;
	}

	// Find the smallest value in the tree
	public T findMin()
	{
		if (isEmpty()) {
			return null;
		}
		return findMin(root).getData();
	}
	private BinaryNode<T> findMin(BinaryNode<T> root)
	{
		if (root == null) {
			return null;
		} else if (root.getLeft() == null) {
			return root;
		} else {
			return findMin(root.getLeft());
		}
	}

	// Find the largest value in the tree
	public T findMax()
	{
		if (isEmpty()) {
			return null;
		}
		return findMax(root).getData();
	}
	private BinaryNode<T> findMax(BinaryNode<T> root)
	{
		if (root == null) {
			while (root.getRight() != null) {
				root = root.getRight();
			}
		}
		return root;
	}

	// Determines the height of the tree
	public int height()
	{
		return (height(root));
	}
	protected int height(BinaryNode<T> root)
	{
		if (root == null) {
			return -1;
		}
		
		int left = height(root.getLeft());
		int right = height(root.getRight());
		int total = Math.max(left, right) + 1;

		return total;
	}

	// recursive method that removes a value from the tree
	public void remove(T value)
	{
		root = remove(value, root);
	}
	protected BinaryNode<T> remove(T value, BinaryNode<T> root)
	{
		if (root == null) {
			return root;
		}

		int compareResult = value.compareTo(root.getData());

		if (compareResult < 0) {
			root.setLeft(remove(value, root.getLeft()));
		} else if (compareResult > 0) {
			root.setRight(remove(value, root.getRight()));
		} else if (root.getLeft() != null && root.getRight() != null) {
			root.setData(findMin(root.getRight()).getData());
			root.setRight(remove(root.getData(), root.getRight()));
		} else {
			root = root.getLeft() != null ? root.getLeft() : root.getRight();
		}

		return root;
	}
}


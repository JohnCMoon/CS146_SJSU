/*
 *
 *	File: BinarySearchTree.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *	         John Moon <johncarlmoon@gmail.com>
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

	/* Returns node if value is found in the tree, null if not */
	public BinaryNode<T> contains(T value)
	{
		return contains(value, root);
	}
	private BinaryNode<T> contains(T value, BinaryNode<T> root)
	{
		if (root == null) {
			return null;
		}

		int compareResult = value.compareTo(root.getData());

		if (compareResult < 0) {
			return contains(value, root.getLeft()); // Value is less than, look in left subtree
		} else if (compareResult > 0) {
			return contains(value, root.getRight()); // Value is greater than, look in right subtree
		} else {
			return root; // Found a match, return that node
		}
	}

	/* Inserts the value into the tree, maintaining BST conditions */
	public void insert(T value)
	{
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
			; // Duplicate - do nothing
		}

		return root;
	}

	/* Returns the smallest value in the tree */
	public T findMin()
	{
		return findMin(root);
	}	
	private T findMin(BinaryNode<T> root)
	{
		if (isEmpty()) {
			return null;
		} else {
			BinaryNode<T> traverse = root;
			while (true) {
				if (traverse.getLeft() == null)
					break;
				else
					traverse = traverse.getLeft();
			}
			return traverse.getData();
		}
	}

	/* Returns the largest value in the tree */
	public T findMax()
	{
		return findMax(root);
	}
	private T findMax(BinaryNode<T> root)
	{
		if (isEmpty()) {
			return null;
		} else {
			BinaryNode<T> traverse = root;
			while (true) {
				if (traverse.getRight() == null)
					break;
				else
					traverse = traverse.getRight();
			}
			return traverse.getData();
		}
	}

	/* Returns the height of the tree */
	public int height()
	{
		return (height(root));
	}
	protected int height(BinaryNode<T> root)
	{
		if (root == null)
			return -1;
		
		return Math.max(height(root.getLeft()),
						height(root.getRight())) + 1;
	}

	/* Removes given value from the tree */
	public void remove(T value)
	{
		root = remove(value, root);
	}
	protected BinaryNode<T> remove(T value, BinaryNode<T> root)
	{
		if (root == null) {
			return null;
		}

		int compareResult = value.compareTo(root.getData());

		if (compareResult < 0) {
			root.setLeft(remove(value, root.getLeft()));
		} else if (compareResult > 0) {
			root.setRight(remove(value, root.getRight()));
		} else if (root.getLeft() != null && root.getRight() != null) {
			root.setData(findMin(root.getRight()));
			root.setRight(remove(root.getData(), root.getRight()));
		} else {
			root = root.getLeft() != null ? root.getLeft() : root.getRight();
		}

		return root;
	}
}


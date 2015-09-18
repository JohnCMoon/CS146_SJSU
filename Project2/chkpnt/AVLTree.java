public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	protected BinaryNode<T> insert(T data, BinaryNode<T> node) {
		return balance(super.insert(data, node));
	}

	protected BinaryNode<T> remove(T data, BinaryNode<T> node) {
		return balance(super.remove(data, node));
	}

	private BinaryNode<T> balance(BinaryNode<T> node) {
		if (node == null) {
			return node;
		}

		if (super.height(node.getLeft()) - super.height(node.getRight()) > 1) {
			if (super.height(node.getLeft().getLeft()) >= super.height(node.getLeft().getRight())) {
				node = singleRightRotation(node); // Outside left-left
			} else {
				node = doubleLeftRightRotation(node); // Inside left-right
			}
		} else if (super.height(node.getRight()) - super.height(node.getLeft()) > 1) {
			if (super.height(node.getRight().getRight()) >= super.height(node.getRight().getLeft())) {
				node = singleLeftRotation(node); // Outside right-right
			} else {
				node = doubleRightLeftRotation(node); // Inside right-left
			}
		}
		return node;
	}

	private BinaryNode<T> singleRightRotation(BinaryNode<T> k2) {
		System.out.println("Single Right Rotation Applied");
		BinaryNode<T> k1 = k2.getLeft();
		k2.setLeft(k1.getRight());
		k1.setRight(k2);
		k2.setHeight(Math.max(super.height(k2.getLeft()), super.height(k2.getRight())) + 1);
		k1.setHeight(Math.max(super.height(k1.getLeft()), k2.getHeight()) + 1);

		return k1;
	}

	private BinaryNode<T> singleLeftRotation(BinaryNode<T> k1) {
		System.out.println("Single Left Rotation Applied");
		BinaryNode<T> k2 = k1.getRight();
		k1.setRight(k2.getLeft());
		k2.setLeft(k1);
		k1.setHeight(Math.max(super.height(k1.getLeft()), super.height(k1.getRight())) + 1);
		k2.setHeight(Math.max(super.height(k2.getRight()), k1.getHeight()) + 1);

		return k2;
	}

	private BinaryNode<T> doubleLeftRightRotation(BinaryNode<T> k3) {
		System.out.println("Double Left Right Rotation Applied");
		k3.setLeft(singleLeftRotation(k3.getLeft()));
		return singleRightRotation(k3);
	}

	private BinaryNode<T> doubleRightLeftRotation(BinaryNode<T> k1) {
		System.out.println("Double Right Left Rotation Applied");
		k1.setRight(singleRightRotation(k1.getRight()));
		return singleLeftRotation(k1);
	}

	private int checkBalance(BinaryNode<T> node) throws Exception {
		if (node == null)
			return -1;

		if (node != null) {
			int leftHeight = checkBalance(node.getLeft());
			int rightHeight = checkBalance(node.getRight());

			if ((Math.abs(super.height(node.getLeft()) - super.height(node.getRight()))) > 1
					|| (super.height(node.getLeft()) != leftHeight) || (super.height(node.getRight()) != rightHeight)) {
				throw new Exception("Unbalanced trees.");
			}
		}
		return super.height(node);
	}
}

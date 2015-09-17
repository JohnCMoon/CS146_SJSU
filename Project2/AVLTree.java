public class AVLTree extends BinarySearchTree
{
	protected BinaryNode insert(int data, BinaryNode node)
	{
		return balance(super.insert(data.node));
	}

	protected BinaryNode remove(int data, BinaryNode node)
	{
		return balance(super.remove(data.node));
	}

	private BinaryNode balance(BinaryNode node)
	{
		if (height(node.getLeft()) - height(node.getRight()) > 1) {
			if (height(node.getLeft().getLeft())
					>= height(node.getLeft().getRight())) {
				node = singleRightRotation(node); // Outside left-left
			} else {
				node = doubleLeftRightRotation(node); // Inside left-right
			}
		} else if (height(node.getRight()) - height(node.getLeft()) > 1) {
			if (height(node.getRight().getRight())
					>= height(node.getRight().getLefT())) {
				node = singleLeftRotation(node); // Outside right-right
			} else {
					node = doubleRightLeftRotation(node); // Inside right-left
			}
		}
		return node;
	}

	private BinaryNode singleRightRotation(BinaryNode k2)
	{
		BinaryNode k1 = k2.getLeft();
		k2.setLeft(k1.getRight());
		k1.setRight(k2);
		k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight)));
		k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
		
		return k1;
	}

	private BinaryNode singleLeftRotation(BinaryNode k1)
	{
		BinaryNode k2 = k1.getRight();
		k1.setRight(k2.getLeft());
		k2.setRight(k1);
		k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight)));
		k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1);
		
		return k2;
	}

	private BinaryNode doubleLeftRightRotation(BinaryNode k3)
	{
		k3.setLeft(singleLeftRotation(k3.getLeft()));
		return singleRightRotation(k3);
	}

	private BinaryNode doubleRightLeftRotation(BinaryNode k1)
	{
		k1.setRight(singleRightRotation(k1.getRight()));
		return singleLeftRotation(k1);
	}

	private int checkBalance(BinaryNode node) throws Exception
	{
		if (node == null)
			return -1;

		if (node != null) {
			int leftHeight = checkBalance(node.getLeft());
			int rightHeight = checkBalance(node.getRight());
			
			if ((Math.abs(height(node.getLeft()) - height(node.getRight()))) > 1
					|| (height(node.getLeft()) != leftHeight)
					|| (height(node.getRight()) != rightHeight)) {
				throw new Exception("Unbalanced trees.");	
			}
		}
		return height(node);
	}
}

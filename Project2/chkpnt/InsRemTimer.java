/*
 *
 *	File: TreeTimer.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *	         John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Program to test the efficiency of the different tree types.
 *
 */

import java.util.Random;

public class TreeTimer
{
    public static void main(String[] args)
    {
		int iterations = Integer.parseInt(args[0]); // Number of tree entries is first arg
	
		/* Starting BST test */
		System.out.println("Beginning BST test with " + iterations + " iterations...");
		long startTime = System.currentTimeMillis();	
		BSTTest(iterations);
		long endTime = System.currentTimeMillis();
		final long BSTTimeDif = endTime - startTime;
		System.out.println("BST exec time: " + BSTTimeDif + " ms");

		/* Starting AVL test */
		System.out.println("Beginning AVL test with " + iterations + " iterations...");	
		startTime = System.currentTimeMillis();
		AVLTest(iterations);
		endTime = System.currentTimeMillis();
		final long AVLTimeDif = endTime - startTime;
		System.out.println("AVL exec time: " + AVLTimeDif + " ms");
	}

	public static void BSTTest(int iterations)
	{ 
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Random rand = new Random();

		for (int i = 0; i < iterations; i++)
            bst.insert(rand.nextInt(Integer.MAX_VALUE));  
        
        while(!bst.isEmpty()) 
            bst.remove(bst.getRoot().getData());
    }

	public static void AVLTest(int iterations)
	{
        AVLTree<Integer> avl = new AVLTree<>();

        Random rand = new Random();

        for(int i = 0; i < iterations; i++)
            avl.insert(rand.nextInt(Integer.MAX_VALUE));
        
        while(!avl.isEmpty()) 
            avl.remove(avl.getRoot().getData());
    }
}

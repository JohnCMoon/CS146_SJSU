/*
 *
 *	File: SearchTimer.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *	         John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Program to test searching for random keys in the tree.
 *
 */

import java.util.Random;

public class SearchTimer
{
    public static void main(String[] args)
    {
		int iterations = Integer.parseInt(args[0]); // Number of things to insert and search for
	
		/* Starting BST test */
		System.out.println("Beginning BST test with " + iterations + " integers...");
		BSTTest(iterations);

		/* Starting AVL test */
		System.out.println("Beginning AVL test with " + iterations + " integers...");	
		AVLTest(iterations);
	}

	public static void BSTTest(int iterations)
	{ 
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Random rand = new Random();

		for (int i = 0; i < iterations; i++)
            bst.insert(rand.nextInt(Integer.MAX_VALUE));  
        
		long startTime = System.currentTimeMillis();	
		int found = 0;
		int notFound = 0;
        for (int i = 0; i < iterations; i++) {
			if (bst.contains(rand.nextInt(Integer.MAX_VALUE)) != null)
				found = found + 1;
			else
				notFound = notFound + 1;
		}	

		long endTime = System.currentTimeMillis();
		final long BSTTimeDif = endTime - startTime;

		System.out.println("Found " + found + " values in BST");
		System.out.println("Did not find " + notFound + " values in BST");
		System.out.println("Search took " + BSTTimeDif + " ms");
    }

	public static void AVLTest(int iterations)
	{
        AVLTree<Integer> avl = new AVLTree<>();

        Random rand = new Random();

        for(int i = 0; i < iterations; i++)
            avl.insert(rand.nextInt(Integer.MAX_VALUE));
        
		long startTime = System.currentTimeMillis();
		int found = 0;
		int notFound = 0;
        for (int i = 0; i < iterations; i++) {
			if (avl.contains(rand.nextInt(Integer.MAX_VALUE)) != null)
				found = found + 1;
			else
				notFound = notFound + 1;
		}

		long endTime = System.currentTimeMillis();
		final long AVLTimeDif = endTime - startTime;

		System.out.println("Found " + found + " values in AVL tree");
		System.out.println("Did not find " + notFound + " values in AVL tree");
		System.out.println("Search took " + AVLTimeDif + " ms");
    }
}

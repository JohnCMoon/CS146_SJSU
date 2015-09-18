/*
 *
 *	File: MixTimer.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *	         John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Program to perform some random mixture of insertions and searches
 *           on the BST and AVL trees in hopes of finding some ratio where
 *           the AVL tree has better performance than a BST.
 *
 */

import java.util.Random;

public class MixTimer
{
    public static void main(String[] args)
    {
		int insertions = Integer.parseInt(args[0]); // First arg is number of insertions
		int searches = Integer.parseInt(args[1]);   // Second arg is number of searches
	
		/* Starting BST test */
		System.out.println("Beginning BST test with " + insertions + " integers...");
		BSTTest(insertions, searches);

		/* Starting AVL test */
		System.out.println("Beginning AVL test with " + insertions + " integers...");	
		AVLTest(insertions, searches);
	}

	public static void BSTTest(int insertions, int searches)
	{ 
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Random rand = new Random();

		long startInsert = System.currentTimeMillis();
		for (int i = 0; i < insertions; i++)
            bst.insert(rand.nextInt(Integer.MAX_VALUE));  
		long endInsert = System.currentTimeMillis();
		final long insertTimeDif = endInsert - startInsert;
		System.out.println("Insertion took " + insertTimeDif + " ms");
        
		long startSearch = System.currentTimeMillis();	
		int found = 0;
		int notFound = 0;
        for (int i = 0; i < searches; i++) {
			if (bst.contains(rand.nextInt(Integer.MAX_VALUE)) != null)
				found = found + 1;
			else
				notFound = notFound + 1;
		}
		long endSearch = System.currentTimeMillis();
		final long searchTimeDif = endSearch - startSearch;

		System.out.println("Found " + found + " values in BST");
		System.out.println("Did not find " + notFound + " values in BST");
		System.out.println("Search took " + searchTimeDif + " ms");
    }

	public static void AVLTest(int insertions, int searches)
	{
        AVLTree<Integer> avl = new AVLTree<>();

        Random rand = new Random();

		long startInsert = System.currentTimeMillis();
        for(int i = 0; i < insertions; i++)
            avl.insert(rand.nextInt(Integer.MAX_VALUE));
		long endInsert = System.currentTimeMillis();
		final long insertTimeDif = endInsert - startInsert;
		System.out.println("Insertion took " + insertTimeDif + " ms");	

		long startSearch = System.currentTimeMillis();
		int found = 0;
		int notFound = 0;
        for (int i = 0; i < searches; i++) {
			if (avl.contains(rand.nextInt(Integer.MAX_VALUE)) != null)
				found = found + 1;
			else
				notFound = notFound + 1;
		}
		long endSearch = System.currentTimeMillis();
		final long searchTimeDif = endSearch - startSearch;

		System.out.println("Found " + found + " values in AVL tree");
		System.out.println("Did not find " + notFound + " values in AVL tree");
		System.out.println("Search took " + searchTimeDif + " ms");
    }
}

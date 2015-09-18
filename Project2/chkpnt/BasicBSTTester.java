/*
 *
 *	File: BasicBSTTester.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *	         John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Generates a random BST, then deletes all nodes. Prints tree
 *	         after every insertion and deletion.
 *
 */

import java.util.Random;

public class BasicBSTTester
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		/* Min and max per assignment parameters */
        int min = 10;
        int max = 99;

        Random rand = new Random();

        while(bst.height() < 5) // Max height of 5, per assignment parameters
        {
			int tmp = rand.nextInt(max - min) + min;
			System.out.println("\nInserting " + tmp);
            bst.insert(tmp);
            new TreePrinter(bst).print("BST post-insertion:");
        }        
        
        while(!bst.isEmpty()) // Delete root until tree is gone
        {                	
            bst.remove(bst.getRoot().getData());
            new TreePrinter(bst).print("BST post-removal:");
        }      
    }
}

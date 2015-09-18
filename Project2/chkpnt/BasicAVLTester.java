/*
 *
 *	File: BasicAVLTester.java
 *
 *	Authors: Ankit Gandhi <csgandhiankit@gmail.com>
 *	         John Moon <johncarlmoon@gmail.com>
 *
 *	Purpose: Generates a random BST, then deletes all nodes. Prints tree
 *	         after every insertion and deletion.
 *
 */

import java.util.Random;

public class BasicAVLTester
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> avl = new BinarySearchTree<>();

		/* Min and max per assignment parameters */
        int min = 10;
        int max = 99;

        Random rand = new Random();

		for (int i = 0; i < 35; i++) {
			int tmp = rand.nextInt(max - min) + min;
			System.out.println("\nInserting " + tmp);
            avl.insert(tmp);
            new TreePrinter(avl).print("AVL post-insertion:");
        }        
        
        while(!avl.isEmpty()) // Delete root until tree is gone
        {                	
            avl.remove(avl.getRoot().getData());
            new TreePrinter(avl).print("AVL post-removal:");
        }      
    }
}

import java.util.Random;

public class PerformanceTester
{
    public static void main(String[] args)
    {
		BSTTest();
		AVLTest();
	}

	public static void BSTTest()
	{
        
		BinarySearchTree<Integer> BST = new BinarySearchTree<>();

        Random rand = new Random();

        int i;
		for (i = 0, i < 1000000, i++)
            bst.insert(rand);  
        
        while(!bst.isEmpty()) 
            bst.remove(bst.getRoot().getData());
    }
}


public class AVLTester
{
    public static void main(String[] args)
    {
        AVLTree<Integer> avl = new AVLTree<>();

        int min = 10;
        int max = 99;

        Random rand = new Random();

        for(int i = 0; i < 35; i++)
        {
            avl.insert(rand.nextInt(max - min) + min);
            new TreePrinter(avl).print("AVL Insert: ");
        }
        
        while(!avl.isEmpty()) 
        {
            avl.remove(avl.getRoot().getData());
            new TreePrinter(avl).print("AVL Remove: ");
        }
    }

}

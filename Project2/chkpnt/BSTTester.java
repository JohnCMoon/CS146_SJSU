import java.util.Random;

public class BSTTester
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int min = 10;
        int max = 99;

        Random rand = new Random();

        while(bst.height() < 5)
        {
            bst.insert(rand.nextInt(max - min) + min);  
            new TreePrinter(bst).print("BST Insert: " + bst.height());
        }        
        
        while(!bst.isEmpty()) 
        {                	
            bst.remove(bst.getRoot().getData());
            new TreePrinter(bst).print("BST Remove: " + bst.height());
        }      
    }
}
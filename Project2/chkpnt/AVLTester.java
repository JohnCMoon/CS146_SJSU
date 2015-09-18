import java.util.Random;


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

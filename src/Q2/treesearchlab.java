package Q2;

import DataStructures.binarySearchTree;

public class treesearchlab {
    public static void main(String[] args) {
        // Test bread and depth
        var bt = new binarySearchTree<Integer>();

        var rand = new java.util.Random(42);
        for (int i = 0; i < 100; i++) {
            bt.insert(rand.nextInt(100));
        }
        System.out.println("BFS: ");
        bt.bread();

        System.out.println("\nDFS: ");
        bt.depthfs();

    }
}

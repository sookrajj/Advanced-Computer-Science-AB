package Q2;

import DataStructures.binarySearchTree;

public class bigtree {
    public static void main(String[] args) {
        var bt = new binarySearchTree<Integer>();
        for (int i = 0; i < 50; i++) {
            Integer n = (int) Math.round(Math.random() * 100);
            bt.insert(n);
            System.out.print(n + " ");
        }
//        bt.insert(5);
//        bt.insert(2);
//        bt.insert(8);
//        bt.insert(3);
//        bt.insert(7);
//        bt.insert(4);
//        bt.insert(6);
//        bt.insert(1);
//        bt.insert(9);
        System.out.println();
        bt.nlr(bt.root); // 5, 2, 1, 3, 4, 8, 6, 7, 9
        System.out.println();
        bt.printInOrder(); // 1, 2, 3, 4, 5, 6, 7, 8, 9
        bt.lrn(bt.root); // 1, 4, 3, 2, 6, 7, 9, 8, 5
        System.out.println();
        System.out.println("total of all numbers: " + bt.total(bt.root));
        System.out.println("Is 32 in the list? " + bt.find(32));
        System.out.println("Height: " + bt.height());
        System.out.println("Width: " + bt.width());
        bt.invert();
        bt.printInOrder();
        System.out.println("Average: " + bt.ave());
        System.out.println("Remove close to average " + bt.removeclose((int)bt.ave()));
        bt.printInOrder();
    }
}

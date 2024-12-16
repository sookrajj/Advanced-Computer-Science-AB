package Q2;

import DataStructures.binarySearchTree;

import java.util.*;

public class bigtree {
    public static void main(String[] args) {
        var bt = new binarySearchTree<Integer>();
        var ran = new Random();
        ran.setSeed(1);
        for (int i = 0; i < 50; i++) {
            Integer n = ran.nextInt(100);
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

        bt.printInOrder();
        bt.lrn(bt.root); // 1, 4, 3, 2, 6, 7, 9, 8, 5
        System.out.println();
        System.out.println("total of all numbers: " + bt.total(bt.root));
        System.out.println("Is 32 in the list? " + bt.find(32));
        System.out.println("Height: " + bt.height());
        System.out.println("Width: " + bt.width());
        System.out.println("Average: " + bt.ave());
        System.out.println("Remove close to average " + bt.findclose((int)bt.ave()));
        bt.delete(bt.findclose((int) bt.ave()));
        bt.printInOrder();
        bt.invert();
        bt.printInOrder();
        bt.bread();
        bt.depthfs();
    }
}
//85 88 47 13 54 4 34 6 78 48 69 73 17 63 62 34 92 62 96 89 76 32 10 99 74 59 98 53 37 2 5 54 0 6 63 55 89 20 75 34 15 60 77 37 77 92 20 88 0 57
//85 47 13 4 2 0 6 5 10 34 17 15 32 20 37 54 48 53 78 69 63 62 59 55 57 60 73 76 74 75 77 88 92 89 96 99 98
//0 2 4 5 6 10 13 15 17 20 32 34 37 47 48 53 54 55 57 59 60 62 63 69 73 74 75 76 77 78 85 88 89 92 96 98 99
//0 2 4 5 6 10 13 15 17 20 32 34 37 47 48 53 54 55 57 59 60 62 63 69 73 74 75 76 77 78 85 88 89 92 96 98 99
//0 2 5 10 6 4 15 20 32 17 37 34 13 53 48 57 55 60 59 62 63 75 74 77 76 73 69 78 54 47 89 98 99 96 92 88 85
//total of all numbers: 1922
//Is 32 in the list? false
//Height: 10
//Width: 8
//Average: 51.945945945945944
//Remove close to average 53
//0 2 4 5 6 10 13 15 17 20 32 34 37 47 48 54 55 57 59 60 62 63 69 73 74 75 76 77 78 85 88 89 92 96 98 99
//99 98 96 92 89 88 85 78 77 76 75 74 73 69 63 62 60 59 57 55 54 48 47 37 34 32 20 17 15 13 10 6 5 4 2 0
//85 88 47 92 54 13 96 89 78 48 34 4 99 69 37 17 6 2 98 73 63 32 15 10 5 0 76 62 20 77 74 59 75 60 55 57
//85 88 92 96 99 98 89 47 54 78 69 73 76 77 74 75 63 62 59 60 55 57 48 13 34 37 17 32 20 15 4 6 10 5 2 0
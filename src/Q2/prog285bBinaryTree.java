package Q2;

import DataStructures.binarySearchTree;
import Q1.prog285b.Cl285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog285bBinaryTree {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog285b.dat"));
            var tree = new binarySearchTree<Cl285b>();

            System.out.println("Id\tCode\tSales\tCommission");
            while (input.hasNext()) {
                var id = input.nextInt();
                var code = input.nextInt();
                var sales = input.nextDouble();

                var fred = new Cl285b(id, code, sales);
                tree.insert(fred);
            }
            input.close();

            tree.printInOrder();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

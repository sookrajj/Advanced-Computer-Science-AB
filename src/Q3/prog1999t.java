package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import DataStructures.Set;
import DataStructures.Dictionary;
import DataStructures.LinkedList;
import DataStructures.binarySearchTree;
import DataStructures.CircularLinkedList;

record Fish(String name, int cost) implements Comparable<Fish>{
    @Override
    public int compareTo(Fish o) {
        return this.cost - o.cost;
    }
}

record Eel(String firstName, String LastName, int[][] food, LinkedList<String> fishEaten, CircularLinkedList<Fish> fish) implements Comparable<Eel> {
    public String getName() {return firstName + " " + LastName;}
    public int compareTo(Eel eel) {return this.fishEaten.size() - eel.fishEaten.size();}
}

record Bunny(String name, int SoldTo, Set<String> customers, Dictionary<Integer, String> hats, binarySearchTree<Integer> numbers) implements Comparable<Bunny> {
    public int compareTo(Bunny o) {return this.hats.size() - o.hats.size();}
}

public class prog1999t {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog1999.txt"));

            int eelcnt = input.nextInt();
            var eels = new Eel[eelcnt];
            for (int i = 0; i < eelcnt; i++) {
                var fn = input.next();
                var ln = input.next();
                var grid = new int[3][5];
                for (int l = 0; l < grid.length; l++) {
                    grid[l][0] = input.nextInt();
                    grid[l][1] = input.nextInt();
                    grid[l][2] = input.nextInt();
                    grid[l][3] = input.nextInt();
                    grid[l][4] = input.nextInt();
                }
                var fishname = new LinkedList<String>();
                var line = input.nextLine();
                var spl = line.split(" ");
                for (int l = 0; l < spl.length; l++) {
                    if (!spl[l].equals("-1")) {
                        fishname.add(spl[l]);
                    }
                }

                var fish = new CircularLinkedList<Fish>();

                eels[i] = new Eel(fn, ln, grid, fishname, fish);

            }
            var bunnies = new CircularLinkedList<Bunny>();
            while (input.hasNextLine()) {
                var name = input.next();
                var sold = input.nextInt();
                Set<String> set = new Set<>();
                while (!input.hasNextInt()) {
                    set.insert(input.next());
                }
                var numhats = input.nextInt();
                var dict = new Dictionary<Integer, String>();
                for (int i = 0; i < numhats; i++) {
                    dict.insert(input.nextInt(), input.next());
                }
                var bt = new binarySearchTree<Integer>();
                var rand = new Random(1);
                for (int i = 0; i < 100; i++) bt.insert(rand.nextInt(1, 100000));
                bunnies.add(new Bunny(name, sold, set, dict, bt));
            }
            input.close();
            /* Which eel ate the most fish?
            How much did it cost to feed all of the eels on the 2nd Tuesday?
            If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed?
            If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3?
            What is the name of the longest fish that each eel has eaten, and which eel ate the longest fish?
            Did any of the eels eat a fish of the same name?
            What day was the most expensive day to feed the eels? Monday, Tuesday, …
            **/
            var most = eels[0];
            var cost = 0.0;

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

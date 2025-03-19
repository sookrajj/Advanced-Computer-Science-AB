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

record Fish(String name, double cost) implements Comparable<Fish>{
    @Override
    public int compareTo(Fish o) {
        return (int) (this.cost - o.cost);
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
                var iter = fishname.iterator();
                while (iter.hasNext()) {
                    var name = iter.next();
                    var cost = Math.random() * name.length();
                    fish.add(new Fish(name, cost));
                }
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
            var mosteel = 0;
            var mostcount = 0;
            var cost = 0;
            var eelcost = eels[0];
            var eelcosts = 0;
            var mostcost = 0;
            var weeks = new int[3];
            var week = 0;
            var mostweek = new Eel[3];
            for (int i = 0; i < eels.length; i++) {
                var eel = eels[i];
                var food = eel.food();
                for (int l = 0; l < food.length; l++) {
                    if (l == 1) {
                        cost += food[l][1] * 2;
                    }
                    for(int temp : food[l]) mostcount += temp;
                    for (int p = 0; p < food[l].length; p++) {
                        var mult = p%5 + 1;
                        mostcost += mult * food[l][p];
                        week += mostcost;
                    }
                    if (i > 0) {
                        if (week > weeks[l]) {
                            weeks[l] = week;
                            mostweek[l] = eel;
                        }
                    } else {
                        weeks[l] = week;
                        mostweek[l] = eel;
                    }
                }

                if (mostcost > eelcosts) {
                    eelcost = eel;
                    eelcosts = mostcost;
                }
                if (mosteel < mostcount) {
                    most = eel;
                    mosteel = mostcount;
                }
            }
            System.out.println("1) " + most.getName());
            System.out.println("2) $" + cost);
            System.out.println("3) " + eelcost.getName());
            System.out.println("4) Week 1: " + mostweek[0].getName() + " Week 2: " + mostweek[1].getName() + " Week 3: " + mostweek[2].getName());
            var eellong = "";
            var eeeeeel = eels[0];
            var eellongo = "";
            var longestnames = new String[eels.length];
            for (int l = 0; l < eels.length; l++) {
                var eel = eels[l];
                var fish = eel.fishEaten();
                for (int i = 0; i < fish.size(); i++) {
                    if (eellong.length() < fish.get(i).length()) {
                        eellong = fish.get(i);
                    }
                }
                longestnames[l] = eellong;
                if (eellong.length() > eellongo.length()) {
                    eellongo = eellong;
                    eeeeeel = eel;
                }
                eellong = "";
            }
            System.out.print("5) ");
            for (int i = 0; i < longestnames.length; i++) System.out.print(longestnames[i] + " ");
            System.out.println(" Eel that at longest fish name: " + eeeeeel.getName());

            var eatsame = false;
            var mostday = "Monday";
            var mostdaycost = 0.0;


        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

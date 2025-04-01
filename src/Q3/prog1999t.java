package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
            /*
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
            var mostdaycost = new int[5];
            for (int i = 0; i < eels.length; i++) {
                for (int p = eels.length-1; p < eels.length; p++) {
                    for (int u = 0; u < eels[p].fishEaten().size(); u++) {
                        if (eels[i].fishEaten().contains(eels[p].fishEaten().get(u))) eatsame = true;
                    }
                }
                for (int[] wee : eels[i].food()) {
                    for (int l = 0 ; l < wee.length; l++) {
                        mostdaycost[l] += wee[l] * (l+1);
                    }
                }
            }
            System.out.println("6) " + eatsame);
            var great = mostdaycost[0];
            great = Math.max(mostdaycost[1], great);
            great = Math.max(mostdaycost[2], great);
            great = Math.max(mostdaycost[3], great);
            great = Math.max(mostdaycost[4], great);
            System.out.println("7) " + (great == mostdaycost[0] ? "Monday" : great == mostdaycost[1] ? "Tuesday" : great == mostdaycost[2] ? "Wednesday" : great == mostdaycost[3] ? "Thursday" : "Friday"));
            System.out.println();


            var feetuni = new ArrayList<String>();
            var tot = 0;
            var numhats = 0;
            var hat = 1;
            var numletbun = bunnies.get(0);
            var numlet = 0;
            var longhat = "";
            var longhatbun = bunnies.get(0);
            var bunfewhat = bunnies.get(0);
            for (int i = 0; i < bunnies.size(); i++) {
                var bun = bunnies.get(i);
                var feet = bun.customers();
                var iter = feet.iterator();
                while (iter.hasNext()) {
                    var f = iter.next();
                    if (!feetuni.contains(f)) feetuni.add(f);
                }
                var tree = bun.numbers();
                tot += tree.getRoot() + tree.findclose(0);
                var hats = bun.hats();
                numhats += hats.size();
                var lets = 0;
                for (int l = 0 ; l < hats.size(); l++) {
                    lets += hats.get(hat).length();
                    if (longhat.length() < hats.get(hat).length()) {
                        longhat = hats.get(hat);
                        longhatbun = bun;
                    }
                    hat++;

                }
                if (numlet < lets) {
                    numletbun = bun;
                }
                if (bunfewhat.hats().size() > hats.size()) bunfewhat = bun;
            }
            System.out.print("1) ");
            for (int i = 0; i < feetuni.size(); i++) System.out.print(feetuni.get(i) + " ");
            System.out.println();
            System.out.println("2) " + tot);
            System.out.println("3) " + numhats);
            System.out.println("4) " + numletbun.name());
            System.out.println("5) " + longhatbun.name());
            System.out.println("6) Bunny getting taken out back " + bunfewhat.name());
            for (int i = 0; i < bunnies.size(); i++) {
                if (bunnies.get(i).equals(bunfewhat)) {
                    bunnies.remove(i);
                }
            }

            /*
            The first bunny just purchased a magic hat with a number of 100 which polymorphs and the last bunny bought a magic hat with a number of 101 which shrinks.
            The second bunny lost his second magic hat.
            Fred is not allowed to be a customer of any bunny any more.  Delete Fred from the set of purchasers from all of the bunnies.
            How many of the bunnies has Pill been a customer?
             */
            for (int i = 0; i < bunnies.size(); i++) {
                bunnies.get(i).customers().insert("Jill");
                if (i % 2 == 0) bunnies.get(i).customers().insert("Pill");
            }



        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

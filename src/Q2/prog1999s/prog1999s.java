package Q2.prog1999s;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import DataStructures.*;

public class prog1999s {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prog1999s.txt"));
            var bt = new binarySearchTree<recipe>();
            var lines = new ArrayList<String>();
            while (input.hasNext()) {
                lines.add(input.nextLine());
            }
            input.close();

            var num = Integer.parseInt(lines.remove(0));
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                var split = line.split(" ");
                var rec = split[0];
                var i1 = split[1].split(":")[0];
                var i1q = Integer.parseInt(split[1].split(":")[1]);
                var i2 = split[2].split(":")[0];
                var i2q = Integer.parseInt(split[2].split(":")[1]);
                var i3 = split[3].split(":")[0];
                var i3q = Integer.parseInt(split[3].split(":")[1]);
                bt.insert(new recipe(rec, i1, i2, i3, i1q, i2q, i3q));
            }

            num = Integer.parseInt(lines.remove(0));
            dynamicArray<inventory> ib = new dynamicArray<>();
//            inventory[] ib = new inventory[num];
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                var inv = new inventory(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
                ib.add(inv);
            }

            num = Integer.parseInt(lines.remove(0));
            var sm = new DoublyLinkedList<shipment>();
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                sm.add(new shipment(line));
            }

            for (int i = 0; i < sm.getSize(); i++) {
                var ship = sm.get(i);
                var ing = ship.getShips();
                var nu = ship.getNumshi();
                for (int y = 0; y < ing.length; y++) {
                    var l = ing[y];
                    var added = false;
                    for (int p = 0; p < ib.size(); p++) {
                        if (l.equals(ib.get(p).getItem())) {
                            ib.get(p).setNum(nu[y] + ib.get(p).getNum());
                            added = true;
                        }
                    }
                    if (!added) {
                        ib.add(new inventory(l, nu[y]));
                    }
                }
            }

            num = Integer.parseInt(lines.remove(0));
            Queue<inventory> om = new Queue<>();
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                var inv = new inventory(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
                om.enqueue(inv);
            }
            num = om.size();
            for (int i = 0; i < num; i++) {
                var ord = om.dequeue();
                var name = ord.getItem();
                var n = ord.getNum();
                var b = bt.bread();
                while (!b.isEmpty()) {
                    var or = b.dequeue();
                    if (or.getData().getRec().compareTo(name) == 0) {
                        var i1 = or.getData().getI1();
                        var i2 = or.getData().getI2();
                        var i3 = or.getData().getI3();
                        var i1q = or.getData().getI1q();
                        var i2q = or.getData().getI2q();
                        var i3q = or.getData().getI3q();
                        for (int p = 0; p < ib.size(); p++) {
                            if (ib.get(p).getItem().equals(i1)) {
                                ib.get(p).setNum(ib.get(p).getNum()-i1q * n);
                            }
                            if (ib.get(p).getItem().equals(i2)) {
                                ib.get(p).setNum(ib.get(p).getNum()-i2q * n);
                            }
                            if (ib.get(p).getItem().equals(i3)) {
                                ib.get(p).setNum(ib.get(p).getNum()-i3q * n);
                            }
                        }
                    }
                }
            }
            System.out.println("Final Inventory:");
            for (int i = 0; i < ib.size(); i++) {
                System.out.println(ib.get(i).getItem() + " " + ib.get(i).getNum() + "     ");
            }
            System.out.println();

            num = Integer.parseInt(lines.remove(0));
            Dequeue<String> fm = new Dequeue<>();
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                if (line.split(" ")[0].equals("ADD_FRONT")) {
                    fm.enqueueFront(line.split(" ")[1]);
                }
                if (line.split(" ")[0].equals("ADD_BACK")) {
                    fm.enqueueRear(line.split(" ")[1]);
                }
                if (line.equals("REMOVE_FRONT")) {
                    fm.dequeueFront();
                }
                if (line.equals("REMOVE_BACK")) {
                    fm.dequeueRear();
                }
            }
            System.out.println("Featured Meals");
            while (!fm.isEmpty()) {
                var f = fm.dequeue();
                System.out.println(f);
            }


            num = Integer.parseInt(lines.remove(0));
            Stack<String> rv = new Stack<>();
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                if (line.split(" ")[0].equals("VIEW")) {
                    rv.push(line.split(" ")[1]);
                }
            }
            System.out.println();
            System.out.println("Top of Recently Viewed");
            System.out.println(rv.peak());

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//Final Inventory:
//Pasta 6
//Sauce 2
//Cheese 1
//Quinoa 2
//Chickpeas 2
//Herbs 4
//Spinach 3
//Lemons 4
//Tortillas 4
//Beans 4
//Salsa 2
//
//Featured Meals
//VeganBowl
//SpicyTacos
//
//Top of Recently Viewed
//GrilledSalmon
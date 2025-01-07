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

            for (int i = 0; i < ib.size(); i++) {
                System.out.print(ib.get(i).getItem() + " " + ib.get(i).getNum() + "     ");
            }


            num = Integer.parseInt(lines.remove(0));
            Queue<inventory> om = new Queue<>();
            for (int i = 0; i < num; i++) {
                var line = lines.remove(0);
                var inv = new inventory(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
                om.enqueue(inv);
            }

            for (int i = 0; i < om.size(); i++) {
                var ord = om.dequeue();
                var name = ord.getItem();
                var n = ord.getNum();
                var b = bt.bread();
                while (!b.isEmpty()) {
                    var or = b.dequeue();
                    if (or.getData().getRec().compareTo(name) == 0) {
                        var i1 = or.getData().getI1q();
                        var i2 = or.getData().getI2q();
                        var i3 = or.getData().getI3q();
                    }
                }
            }


        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

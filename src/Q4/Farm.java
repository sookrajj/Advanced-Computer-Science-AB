package Q4;

import DataStructures.CircularLinkedList;
import DataStructures.Dictionary;
import DataStructures.Queue;
import DataStructures.Stack;
import Q4.prog1999w.*;

import java.util.*;

public class Farm {
    public static class cornCob implements Comparable<cornCob> {
        private int cobs;
        public cornCob(int cobs) {
            this.cobs = cobs;
        }
        public int compareTo(cornCob corn) {return Integer.compare(this.cobs, corn.cobs);}
    }
    public static class hayBale implements Comparable<hayBale> {
        private int hay;
        public hayBale(int hay) {
            this.hay = hay;
        }
        public int compareTo(hayBale bale) {return Integer.compare(this.hay, bale.hay);}
    }

    private Random rand;
    private double milkPrice;
    private int beans;
    private int oats;
    private int[][] riders;
    private Stack<cornCob> cornCobs;
    private Queue<hayBale> hayBales;
    private Dictionary<Integer, Cow> cows;
    private Set<Turkey> turks;
    private CircularLinkedList<Horse> hors;
    private Pig[] pens;


    public Farm() {
        cornCobs = new Stack<>();
        hayBales = new Queue<>();
        cows = new Dictionary<>();
        turks = new HashSet<>();
        hors = new CircularLinkedList<>();
        pens = new Pig[500];
    }

    public void addCow(Cow cow) {
        cows.insert(cows.size(), cow);
    }
    public void addTurkey(Turkey turk) {
        turks.add(turk);
    }
    public void addHorse(Horse hor) {
        hors.add(hor);
    }
    public void addPig(Pig pig) {
        for (int i = 0; i < pens.length; i++) if (pens[i] == null) {pens[i] = pig; break;}
    }
    public void stockCorn() {
        //TODO
    }
    public void stockHay() {
        //TODO
    }
    public void addCorn() {
        //TODO
    }
    public void addHay() {
        //TODO
    }
    public void removeCorn() {
        //TODO
    }
    public void removeHay() {
        //TODO
    }
    public int getCorn() {
        var stack = new Stack<cornCob>();
        var corn = 0;
        while (!cornCobs.isEmpty()) {
            var c = cornCobs.pop();
            corn += c.cobs;
            stack.push(c);
        }
        while (!stack.isEmpty()) cornCobs.push(stack.pop());
        return corn;
    }
    public int getHay() {return 0;}
    public int getBeans() {return beans;}
    public int getOats() {return oats;}
    public double getMilkPrice() {return milkPrice;}
    public int getNumHorseRiders() {
        int rider = 0;
        for (int[]r : riders) {
            for (int p : r) {
                rider += p;
            }
        }
        return rider;
    }
    public double getCost() {
        var tot = 0.0;
        for (int i = 0; i < cows.size(); i++) {
            tot += cows.get(i).getCost();
        }
        var arr = (Turkey[]) turks.toArray();
        for (int i = 0; i < arr.length; i++) {
            tot += arr[i].getCost();
        }
        for (int i = 0; i < hors.size(); i++) {
            tot += hors.get(i).getCost();
        }
        for (int i = 0; i < pens.length; i++) {
            tot += pens[i].getCost();
        }

        return tot;
    }
    public double getIncome() {
        var tot = 0.0;
        for (int i = 0; i < cows.size(); i++) {
            tot += cows.get(i).getIncome();
        }
        var arr = (Turkey[]) turks.toArray();
        for (int i = 0; i < arr.length; i++) {
            tot += arr[i].getIncome();
        }
        for (int i = 0; i < hors.size(); i++) {
            tot += hors.get(i).getIncome();
        }
        for (int i = 0; i < pens.length; i++) {
            tot += pens[i].getIncome();
        }

        return tot;
    }
    public double getProfit() {
        var tot = 0.0;
        for (int i = 0; i < cows.size(); i++) {
            tot += cows.get(i).getProfit();
        }
        var arr = (Turkey[]) turks.toArray();
        for (int i = 0; i < arr.length; i++) {
            tot += arr[i].getProfit();
        }
        for (int i = 0; i < hors.size(); i++) {
            tot += hors.get(i).getProfit();
        }
        for (int i = 0; i < pens.length; i++) {
            tot += pens[i].getProfit();
        }

        return tot;
    }
    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < cows.size(); i++ ) {
            animals.add(cows.get(i));
        }
        animals.addAll(List.of((Turkey[]) turks.toArray()));

        for (int i = 0; i < hors.size(); i++ ) {
            animals.add(hors.get(i));
        }
        animals.addAll(Arrays.asList(pens));
        return animals;
    }
    public int compareTo(Farm farm) {
        return Double.compare(this.getIncome(), farm.getIncome());
    }
}

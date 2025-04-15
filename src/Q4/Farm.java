package Q4;

import DataStructures.CircularLinkedList;
import DataStructures.Dictionary;
import DataStructures.Queue;
import DataStructures.Stack;
import Q4.prog1999w.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
        cows.insert(cow.getId(), cow);
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
    public int getCorn() {return 0;}
    public int getHay() {return 0;}
    public int getBeans() {return beans;}
    public int getOats() {return oats;}
    public double getMilkPrice() {return milkPrice;}
    public int getNumHorseRiders() {
        int riders = 0;
        for (int i = 0; i < hors.size(); i++) {
            hors.get(i);
        }
        return 0;
    }
    public double getCost() {return 0.0;}
    public double getIncome() {return 0.0;}
    public double getProfit() {return 0.0;}
    public ArrayList getAllAnimals() {
        return null;
    }
    public int compareTo(Farm farm) {
        return Double.compare(this.getIncome(), farm.getIncome());
    }
}

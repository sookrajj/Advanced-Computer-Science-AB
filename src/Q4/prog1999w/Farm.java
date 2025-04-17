package Q4.prog1999w;

import DataStructures.CircularLinkedList;
import DataStructures.Dictionary;
import DataStructures.Queue;
import DataStructures.Stack;

import java.util.*;

public class Farm implements Comparable<Farm> {
    static class cornCob implements Comparable<cornCob> {
        private int cobs;
        public cornCob(int cobs) {
            this.cobs = cobs;
        }
        public int compareTo(cornCob corn) {return Integer.compare(this.cobs, corn.cobs);}
    }
    static class hayBale implements Comparable<hayBale> {
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
        cornCobs.push(new cornCob(rand.nextInt(10000, 15000)));
        hayBales = new Queue<>();
        hayBales.enqueue(new hayBale(rand.nextInt(2000, 3000)));
        cows = new Dictionary<>();
        turks = new HashSet<>();
        hors = new CircularLinkedList<>();
        pens = new Pig[500];
        beans = rand.nextInt(750, 1000);
        oats = rand.nextInt(1750, 2500);
        var numCows = rand.nextInt(12, 15);
        var numTurks = rand.nextInt(10, 20);
        var numHors = rand.nextInt(8, 10);
        var numPigs = rand.nextInt(12, 20);
        milkPrice = rand.nextDouble(.20, .24);

        for (int i = 0; i < numCows; i++) {
            var id = rand.nextInt(1000, 9999);
            var weight = rand.nextInt(1000, 1500);
            var eatc = rand.nextInt(5, 8);
            var eath = rand.nextInt(1, 3);
            var eatb = rand.nextInt(2, 5);
            var eato = rand.nextInt(1, 4);
            var milk = rand.nextInt(20, 100);
            cows.insert(id, new Cow(id, weight, eatc, eath, eatb, eato, milk, milkPrice));
        }
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
    public int stockCorn() {
        return cornCobs.peak().cobs;
    }
    public int stockHay() {
        return hayBales.peek().hay;
    }
    public void addCorn() {
        cornCobs.push(new cornCob(rand.nextInt(1000, 1250)));
    }
    public void addHay() {
        hayBales.enqueue(new hayBale(rand.nextInt(75, 100)));
    }
    public void removeCorn() {
        cornCobs.pop();
    }
    public void removeHay() {
        hayBales.dequeue();
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
    public int getHay() {
        var queue = new Queue<hayBale>();
        var hay = 0;
        while (!hayBales.isEmpty()) {
            var h = hayBales.dequeue();
            hay += h.hay;
            queue.enqueue(h);
        }
        while (!queue.isEmpty()) hayBales.enqueue(queue.dequeue());
        return hay;
    }
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

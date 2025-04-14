package Q4;

import DataStructures.CircularLinkedList;
import DataStructures.Dictionary;
import DataStructures.Queue;
import DataStructures.Stack;
import Q4.prog1999w.*;

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


}

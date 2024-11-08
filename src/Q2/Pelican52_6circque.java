package Q2;

import DataStructures.CircularDequeue;
import DataStructures.Circularqueue;

public class Pelican52_6circque {
    public static void main(String[] args) {
        var c1 = new CircularDequeue<Integer>(50);
        for (int lcv = 0; lcv < c1.getCap(); lcv++) {
            c1.enqueue(lcv);
        }
        var c2 = new CircularDequeue<Integer>(50);
        c1.enqueue(60);
        for (int lcv = 0; lcv < c1.getCap(); lcv++) {
            var value = c1.dequeue();
            System.out.print(value + " ");
            c2.enqueue(value);
        }
        System.out.println();
        for (int l = 0; l < c1.getCap(); l++) {
            c1.enqueue(c2.dequeue());
        }
        for (int l = 0; l < 40; l++) {
            var value = c1.dequeue();
            c1.enqueue(value);
        }
        for (int lcv = 0; lcv < c1.getCap(); lcv++) {
            System.out.print(c1.dequeue() + " ");
        }
    }
}
//No more can be added
//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49
//40 41 42 43 44 45 46 47 48 49 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39
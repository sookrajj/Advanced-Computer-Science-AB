package Q4;
import DataStructures.PriorityQueue;
public class Peli555 {
    public static void main(String[] args) {
        var prio = new PriorityQueue<Integer>();

        for (int i = 0; i < 50; i++) {
            prio.enqueue(i);
        }
        prio.print();
    }
}
//49
//48 47
//46 45 44 43
//42 41 40 39 38 37 36 35
//34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19
//18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
package Q2;

import DataStructures.Dequeue;

import java.sql.SQLOutput;

public class DequeueLab {
    public static void main(String[] args) {
        var deque = new Dequeue<Integer>();
        for (int i = 0; i < 10; i++) {
            deque.enqueueFront(i);
        }
        for (int i = 10; i < 20; i++) {
            deque.enqueueRear(i);
        }
        // 9 8 7 6 5 4 3 2 1 0 10 11 12 13 14 15 16 17 18 19

        System.out.println(deque.size());
        System.out.println(deque.peekFront()); // 9
        System.out.println(deque.peekRear()); // 19
        System.out.println(deque.dequeueFront());
        System.out.println(deque.dequeueRear());
        System.out.println(deque.size());

        var ran = new java.util.Random(42);
        for (int i = 0; i < 50; i++) {
            deque.enqueueFront(ran.nextInt(50));
        }
        for (int i = 0; i < 48; i++) {
            deque.dequeueFront();
        }
        System.out.println("New size: " + deque.size());
        System.out.println(deque.peekFront());
        System.out.println(deque.peekRear());
    }
}
//20
//9
//19
//9
//19
//18
//New size: 20
//13
//18
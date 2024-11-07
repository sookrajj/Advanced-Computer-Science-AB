package Q1;

import DataStructures.QueueStack;
import DataStructures.Stack;

public class queuestacktest {
    public static void main(String[] args) {
        QueueStack<Integer> hi = new QueueStack<>();
        Stack<Integer> h = new Stack<>();
        for (int i = 0; i < 20; i++) {
            hi.push(i);
            h.push(i);
        }
//        System.out.println(hi.peek() + " che");
//        System.out.println(h.peak() + " che");
        for (int i = 0; i < 14; i++) {
            System.out.println(hi.pop() + " hi");
            System.out.println(h.pop() + " h");
        }
    }
}

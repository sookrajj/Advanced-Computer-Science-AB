package Q1;

import DataStructures.QueueStack;
import DataStructures.Stack;

public class queuestacktest {
    public static void main(String[] args) {
        QueueStack<Integer> hi = new QueueStack<>();
        Stack<Integer> h = new Stack<>();
        hi.push(1);
        hi.push(2);
        h.push(1);
        h.push(2);
        System.out.println(hi.pop());
        System.out.println(h.pop());
    }
}

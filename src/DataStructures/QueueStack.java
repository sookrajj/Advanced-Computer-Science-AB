package DataStructures;

import java.util.ArrayList;

public class QueueStack<T extends Comparable<T>> {
    private Queue<T> stack;

    public QueueStack() {stack = new Queue<T>();}

    public void push(T element) {stack.enqueue(element);}
    public T pop() {
        var temp = new ArrayList<T>();
        while (!stack.isEmpty()) {
            temp.add(stack.dequeue());
        }
        var ret = temp.remove(temp.size()-1);
        for (int lcv =0; lcv < temp.size(); lcv++) {
            stack.enqueue(temp.remove(lcv));
            lcv--;
        }
        return ret;
    }
    public T peek() {
        var temp = new ArrayList<T>();
        while (!stack.isEmpty()) {
            temp.add(stack.dequeue());
            System.out.println("hi");
        }
        System.out.println(temp.size()-1);
        var ret = temp.remove(temp.size()-1);
        for (int lcv = temp.size()-1; lcv > 0; lcv--) {
            stack.enqueue(temp.remove(lcv));
        }
        stack.enqueue(ret);
        return ret;
    }
//    public int size() {return stack.size();}
    public boolean isEmpty() {return stack.isEmpty();}
}

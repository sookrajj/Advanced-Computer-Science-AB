package DataStructures;

public class QueueStack<T extends Comparable<T>> {
    private Queue<T> stack;

    public QueueStack() {stack = new Queue<T>();}

    public void push(T element) {stack.enqueue(element);}
    public T pop() {
        var temp = new Queue<T>();
        while (!stack.isEmpty()) temp.enqueue(stack.dequeue());
        var ret = temp.dequeue();
        while (!temp.isEmpty()) stack.enqueue(temp.dequeue());
        return ret;
    }
    public T peek() {
        var temp = new Queue<T>();
        while (!stack.isEmpty()) temp.enqueue(stack.dequeue());
        var ret = temp.dequeue();
        while (!temp.isEmpty()) stack.enqueue(temp.dequeue());
        stack.enqueue(ret);
        return ret;
    }
//    public int size() {return stack.size();}
    public boolean isEmpty() {return stack.isEmpty();}
}

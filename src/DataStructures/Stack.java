package DataStructures;


@SuppressWarnings("unchecked")
public class Stack<T extends Comparable<T>>{
    private T[] stack;
    private int size;
    private int capacity;

    public Stack() {
        size = 0;
        capacity = 1;
        stack = (T[]) new Comparable[capacity];
    }

    public void push(T element) {
        if (size == capacity) resize(2 * capacity);
        stack[size++] = element;
    }
    public T pop() {
        T element = stack[--size];
        if (size == capacity/4) resize(capacity/2);
        return element;
    }

    public T peak() {return stack[size-1];}

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {return size == 0;}

    public void resize(int newcap) {
        if (newcap < 1) newcap = 1;
        T[] newStack = (T[]) new Comparable[newcap];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
        capacity = newcap;
    }
}

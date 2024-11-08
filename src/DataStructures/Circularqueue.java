package DataStructures;

@SuppressWarnings({"unchecked"})
public class Circularqueue<T extends Comparable<T>> {
    protected T[] buffer;
    protected int head;
    protected int tail;
    protected int size;
    protected final int capacity;

    public Circularqueue(int cap) {
        buffer = (T[]) new Comparable[cap];
        capacity = cap;
    }

    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("No more can be added");
            return;
        }
        buffer[tail] = element;
        tail = (tail+1) % capacity;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("No more can be deleted");
            return null;
        }
        var value = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Nothing here");
            return null;
        }
        return buffer[head];
    }

    public boolean isFull() {return size == capacity;}
    public boolean isEmpty() {return size == 0;}
}

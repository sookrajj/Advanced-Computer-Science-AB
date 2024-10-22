package DataStructures;

@SuppressWarnings("unchecked")
public class Queue<T extends Comparable<T>>{
    //protected means "private except to child classes"
    protected T[] queue;
    protected int front;
    protected int rear;
    protected int size;
    protected int capacity;

    public Queue() {
        size = 0;
        capacity = 1;
        queue = (T[]) new Comparable[capacity];
        front = size;
        rear = size;
    }

    public void enqueue(T element) {
        if(size == capacity) resize(2*capacity);
        queue[rear] = element;
        rear = (rear +1) % capacity;
        size++;
    }

    public T dequeue() {
        var element = queue[front];
        front = (front + 1)%capacity;
        size--;
        if (size == capacity/4) resize((capacity/2));
        return element;
    }
    public T peek() {return queue[front];}
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    protected void resize(int newcap) {
        if (newcap < 1) newcap = 1;
        T[] newqueue = (T[]) new Comparable[newcap];
        for (int i = 0; i < size; i++) {
            newqueue[i] = queue[(front + i) % capacity];
        }
        queue = newqueue;
        capacity = newcap;
        front = 0;
        rear = size;
    }
}

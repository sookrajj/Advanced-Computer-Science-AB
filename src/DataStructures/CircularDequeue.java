package DataStructures;

public class CircularDequeue<T extends Comparable<T>> extends Circularqueue<T> {


    public CircularDequeue(int cap) {
        super(cap);
    }

    public void enqueueFront(T element) {
        if (size == capacity) {
            System.out.println("No more can be added");
            return;
        }
        head = (head-1 +capacity) % capacity;
        buffer[head] = element;
        size++;
    }
    public void enqueueRear(T element) {super.enqueue(element);}
    public T dequeueFront() { return super.dequeue();}
    public T dequeueRear() {
        if (size == 0) {
            System.out.println("No more can be deleted");
            return null;
        }
        tail = (tail - 1 +capacity) % capacity;
        T element = buffer[tail];
        size--;
        return element;
    }

    public T peekFront() {return buffer[tail]; }
    public T peekRear() {return buffer[(tail-1 + capacity)%capacity];}

    public int getCap() {return capacity;}
}

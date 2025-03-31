package DataStructures;

public class PriorityQueue <T extends Comparable<T>>{
    private final heap<T> heap;

    public PriorityQueue() {heap = new heap<>();}
    public PriorityQueue(boolean min) {heap = new heap<>(min);}

    public void enqueue(T element) {heap.insert(element);}
    public T dequeue() {return heap.deleteMin();}
    public T peek() {return heap.peak();}
    public int size() {return heap.size();}
    public boolean isEmpty() {return heap.isEmpty();}

    public boolean contains(T element) {
        return getIndex(element) != -1;
    }

    public int getIndex(T element) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.hep[i].equals(element)) return i;
        }
        return -1;
    }

    public void remove(T element) {
        int index = -1;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.hep[i].equals(element)) { index = i; break;}
        }
        if (index != -1) {
            T lastElement = heap.deleteMin();
            if (index < heap.size()) {
                heap.hep[index] = lastElement;
                heap.sink(index);
                heap.swim(index);
            }
        }
    }

    public void changePriority(T element, T newPriority) {
        int index = getIndex(element);
        if (index != -1) {
            heap.hep[index] = newPriority;
            if (heap.compare(newPriority, element) > 0) {
                heap.sink(index);
            } else {
                heap.swim(index);
            }
        }
    }

}

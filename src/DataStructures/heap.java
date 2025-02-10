package DataStructures;

@SuppressWarnings({"unchecked"})
public class heap<T extends Comparable<T>> {
    public static final int DEFAULT_CAP = 16;
    T[] hep;
    private int size;
    private int cap;
    private final boolean min;

    public heap() {
        this(DEFAULT_CAP);
    }
    public heap(int capacity) {this(capacity, false);}
    public heap(boolean min) {this(DEFAULT_CAP, min);}
    public heap(int capacity, boolean min) {
        this.cap = capacity;
        this.min = min;
        size = 0;
        hep = (T[]) new Comparable[capacity];
    }

    public void insert(T element) {
        if (size == cap) resize(2 * cap);
        hep[size++] = element;
        swim(size - 1);
    }
    /**extracts the minimum */
    public T deleteMin() {
        if (size == 0) {return null;}
        T element = hep[0];
        hep[0] = hep[--size];
        hep[size] = null;
        sink(0);
        if (size > 0 && size <= cap/4) resize(cap/2);
        return element;
    }

    public T peak() {return size == 0 ? null : hep[0];}
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    int compare(T a, T b) {return min ? b.compareTo(a) : a.compareTo(b);}
    private void swap(int i, int j) {
        var temp = hep[i];
        hep[i] = hep[j];
        hep[j] = temp;
    }

    private void resize(int newcap) {
        T[] newhep = (T[]) new Comparable[newcap];
        System.arraycopy(hep, 0, newhep, 0, size);
        hep = newhep;
        cap = newcap;
    }

    void swim(int k) {
        while (k > 0 && compare(hep[k], hep[(k-1)/2]) > 0) {
            swap(k, (k-1) / 2);
            k = (k-1) / 2;
        }
    }

    void sink(int k) {
        while (2 * k + 1 < size) {
            int j = 2*k +1;
            if (j+1 < size && compare(hep[j], hep[j+1]) < 0) {
                j++;
            }
            if (compare(hep[k], hep[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
}

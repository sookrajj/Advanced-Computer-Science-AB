package DataStructures;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> { // implements List<T>
    private class Node implements Comparable<Node> {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }

        public int compareTo(Node o) {return data.compareTo(o.data);}
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(T element) {
        var newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    public boolean add(T element, int pos) {
        var newNode = new Node(element);
        pos--;
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && pos >= 0) {
                current = current.next;
                pos--;
            }
            var temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
        size++;
        return true;
    }

    public T remove(int index) {
        T old;
        if (index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            old = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int lcv = 0; lcv < index-1; lcv++) {
                current = current.next;
            }
            old = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return old;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public T set(int index, T element) {
        T old;
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        old = current.data;
        current.data = element;
        return old;
    }

    public void print() {
        for (Node current = head; current != null; current = current.next) System.out.print(current.data + " ");
        System.out.println();
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}
    public T getFirst() {return head.data;}
    public T getLast() {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
    public T getByIndex(int pos) {
        var current = head;
        pos--;
        while (current.next != null && pos >= 0) {
            current = current.next;
            pos--;
        }
        return current.data;
    }
    public void removeFirst() {head = head.next;}
    public void removeLast() {
        var current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    public int countLessthan(T target) {
        var current = head;
        int cnt = 0;
        while (current.next != null) {
            if (current.data.compareTo(target) < 0) cnt++;
            current = current.next;
        }
        if (current.data.compareTo(target) < 0) cnt++;
        return cnt;
    }
    public void removeIndex(int pos) {
        var current = head;
        pos--;
        while (current.next.next != null && pos >= 0) {
            current = current.next;
            pos--;
        }
        current.next = current.next.next;
    }
    public boolean contains(T n) {
        var current = head;
        while (current.next != null) {
            if (current.data.compareTo(n) < 0) return true;
            current = current.next;
        }
        if (current.data.compareTo(n) < 0) return true;
        return false;
    }
    public LinkedList<T> getReverse() {
        var newlist = new LinkedList<T>();
        while (head.next != null) {
            newlist.add(head.data);
            head = head.next;
        }
        newlist.add(head.data);
        return newlist;
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private LinkedList.Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                var node = current;
                current = current.next;

                return (T) node.data;

            }
        };
    }
//    public double avg()
//    public int min()
//    public int max()
//    public int indexOfMax()
//    public int lastIndexOfMax()
    public void sort() {
        var newlist = new LinkedList<T>();
        var pos = 0;
        while (head != null) {
            var  current= newlist.head;
            while (current.data.compareTo(head.data) < 0) {
                pos++;
            }
            newlist.add(head.data, pos);
            if (head == null) {break;}
            else {
                head = head.next;
            }
        }
        head = newlist.head;
    }
//    public int lose58()
//    public int getEvenCount()
//    public void removeOdds()
    public void clear() {head = null;}

}

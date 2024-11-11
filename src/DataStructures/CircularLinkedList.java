package DataStructures;

import java.util.*;

public class CircularLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class node implements Comparable<node> {
        T data;
        node next;

        node(T data) {
            this.data = data;
            next = null;
        }

        @Override
        public int compareTo(node o) {
            return data.compareTo(o.data);
        }
    }
    private node head;
    private int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        var nod = new node(data);
        if (head == null) {
            head = nod;
            head.next = head;
        } else {
            node current = head;
            while (current.next != head) current = current.next;
            current.next = nod;
            nod.next = head;
        }
        size++;
    }

    public void addSpot(T element, int spot) {
        if (spot < 0 || spot >= size) {
            throw new IndexOutOfBoundsException();
        }
        var nod = new node(element);
        if (head == null) {
            head = nod;
            head.next = head;
        } else {
            node current = head;
            while (current.next != head && spot > 0) {
                current = current.next;
                spot--;
            }
            var temp = current.next;
            current.next = nod;
            nod.next = temp;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        node current = head;
        if (index == 0) {
            while (current.next != head) current = current.next;
            current.next = head.next;
            head = head.next;
        } else {
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.data = element;
    }

    public void print() {
        var current = head;
        do{
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private node current = head;
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                var temp = current.data;
                current = current.next;
                index++;
                return temp;
            }
        };
    }


    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
}

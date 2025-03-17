package DataStructures;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T>{
    private class Node implements Comparable<Node> {
        T data;
        Node prev;
        Node next;

        public Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }

        public int compareTo(Node o) {return data.compareTo(o.data);}
    }
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null; tail = null; size = 0;
    }

    public void add(T element) {
        var temp = new Node(element);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    public void addFront(T element) {
        var temp = new Node(element);
        if (head != null) {
            head.prev = temp;
            temp.next = head;
        }
        head = temp;
        size++;
    }

    public void addSorted(T element) {
        var temp = new Node(element);
        if (head == null) {
            head = temp;
        } else if (size ==1) {
            head.next = temp;
            temp.prev= head;
            tail = temp;
        } else{
            var current = head;
            Node pre = null;
            boolean added = false;
            if (temp.compareTo(current) <= 0) {
                current.prev = temp;
                temp.next = current;
                head = temp;
                added = true;
            }
            while (current.next != null && !added) {
                current = current.next;
                pre = current.prev;
                if (temp.compareTo(pre) >= 0 && temp.compareTo(current) <= 0) {
                    pre.next = temp;
                    current.prev = temp;
                    temp.next = current;
                    temp.prev = pre;
                    added = true;
                    break;
                }
            }
            if (!added && tail != null) {
                temp.prev = tail;
                tail.next = temp;
                tail = temp;
            }
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            var current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            var pre = current.prev;
            var ne = current.next;
            pre.next = pre.next.next;
            ne.prev = ne.prev.prev;
        }
    }

    public void remove(T element) {
        if (element.equals("")) {
            throw new IndexOutOfBoundsException();
        } else if (tail.data.equals(element)) {
            var current = tail.prev;
            current.next = null;
            tail = current;
        } else {
            var current = head;
            while (current.next.next != null) {
                if (current.next.data.equals(element)) {
                    var ne = current.next.next;
                    ne.prev = current;
                    current.next = ne;
                    break;
                }
                current = current.next;
            }
            if (head.data.equals(element)) {
                current = head.next;
                current.prev = null;
                head = current;
            }
        }
    }

    public T get(int index) {
        if (index < 0 && index > size) {throw new IndexOutOfBoundsException();}
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 && index > size) {throw new IndexOutOfBoundsException();}
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.data = element;
    }

    public void print() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }

    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}

    public void printReverse() {
        for (Node current = tail; current != null; current = current.prev) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }

    public void removeItem(T data) {
        var current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                current.prev = current.next;
                return;
            }
            current = current.next;
        }

    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;

                return data;

            }
        };
    }

    public T pop() {
        var iter = iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        var current = head;
        while (current.next != null) current = current.next;
        current.prev = null;
        System.out.println(current.data);
        size--;
        return current.data;
    }

}

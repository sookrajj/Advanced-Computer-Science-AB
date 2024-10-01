package DataStructures;

import java.util.Iterator;

public class intLinkedList implements Iterable<Integer>{
    private class Node {
        int data;
        Node next; //pointer to next node

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public intLinkedList() {head = null;}

    public void addFront(int data) {
        var newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        var newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void printList() {
        if (head == null) {return;}
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public int getCount() {
        if (head == null) {
            return -1;
        }
        int nums = 1;
        var current = head;
        while (current != null) {
            nums++;
            current = current.next;
        }
        return nums;
    }
    public boolean add(int num, int spot) {
        if (head == null) {return false;}
        var current = head;
        while (current != null && num != 0) {
            current = current.next;
            num--;
        }
        return false;
    }
    public boolean isEmpty() {return false;}
    public boolean isThere(int n) {return false;}
    public int getFirst() {return -1;}
    public int getLast() {return -1;}
    public int getSpot(int spot) {return -1;}
    public void removeFirst() {}
    public void removeLast() {}
    public int countLess10() {return -1;}
    public void removeSpot(int num) {}
    public void clear() {}
    public boolean checkForNum(int n) {return false;}
    public int getNum(int pos) {return -1;} //(-1 if illegal position)
//    public stuff getReverse() {
//
//        return null;
//    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int data = current.data;
                current = current.next;

                return data;

            }
        };
    }
    public double avg() {
        return -1;
    }
    public int min() {return -1;}
    public int max() {return -1;}
    public int findSlotMaxFirst() {return -1;}    //first occurrence
    public int findSlotMaxLast()  {return -1;}   //last occurrence
    public void sort() {}
    public int lose58() {return -1;}
    public int getEvenCount() {return -1;}
    public void killOdds() {}

}

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
        while (current.next != null) {
            nums++;
            current = current.next;
        }
        return nums;
    }
    public boolean add(int num, int spot) {
        if (head == null) {return false;}
        var current = head;
        var count = 2;
        while (current.next != null && count != spot) {
            current = current.next;
            count++;
        }
        var next = current.next;
        if (current.next != null) {
            Node node = new Node(num);
            current.next = node;
            node.next = next;
            return true;
        }
        return false;
    }
    public boolean isEmpty() {return head != null;}
    public boolean isThere(int n) {
        var current = head;
        while (current.next != null) {
            if (current.data == n) return true;
            current = current.next;
        }
        return false;
    }
    public int getFirst() {return head.data;}
    public int getLast() {
        if (head == null) {return -1;}
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
    private Node getLastpri() {
        if (head == null) {return null;}
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    public int getSpot(int pos) {
        if (head == null) {return -1;}
        var current = head;
        if (current.data == pos) return current.data;
        while (current.next != null) {
            current = current.next;
            if (current.data == pos) return current.data;
        }
        return -1;
    }
    public void removeFirst() {
        head = head.next;
    }
    public void removeLast() {
        if (head == null) {return;}
        var current = head;
//        while (current != null) {
//            current = current.next;
//        }
//        var oneback = head;
//        while (oneback.next != current) {
//            oneback = oneback.next;
//        }
//        oneback.next = null;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    public int countLess10() {
        if (head == null) {return -1;}
        var num = 0;
        var current = head;
        if (current.data < 10) num++;
        while (current.next != null) {
            current = current.next;
            if (current.data < 10) num++;
        }
        return num;
    }
    public void removeSpot(int num) {
        if (head == null) {return;}

        var current = head;
        if (current.next == null) {

            return;
        }
        num--;
        while (current.next.next != null && num != 0) {
            current = current.next;
            num--;
        }
        if (current == head) {head = head.next;}
        if (current.next.next == null) current.next = null;
        else {
            current.next = current.next.next;
        }

    }
    public void clear() {
        head = null;
    }
    public boolean checkForNum(int n) {
        if (head == null) {return false;}
        var current = head;
        if (current.data == n) return true;
        while (current.next != null) {
            current = current.next;
            if (current.data == n) return true;
        }
        return false;
    }
    public intLinkedList getReverse() {
        var newlist = new intLinkedList();
        newlist.addLast(getLast());
        removeLast();
        while (head.next != null) {
            newlist.addLast(getLast());
            removeLast();
        }
        newlist.addLast(getLast());
        head = newlist.head;
        return newlist;
    }
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
        if (head == null) {return 0;}
        var current = head;
        var total = current.data;
        var nums = 1;
        while (current.next != null) {
            current = current.next;
            total += current.data;
            nums++;
        }
        return (double) total/ (double) nums;
    }
    public int min() {
        if (head == null) {return -1;}
        var current = head;
        var min = current.data;
        while (current.next != null) {
            current = current.next;
            if (current.data < min) min = current.data;
        }
        return min;
    }
    public int max() {
        if (head == null) {return -1;}
        var current = head;
        var max = current.data;
        while (current.next != null) {
            current = current.next;
            if (current.data > max) max = current.data;
        }
        return max;
    }
    public int findSpotMaxFirst() {
        if (head == null) {return -1;}
        var current = head;
        var max = max();
        var index = 0;
        if (current.data == max) {
            index = 1;
            return index;
        }
        index++;
        while (current.next != null) {
            current = current.next;
            index++;
            if (current.data == max) return index;
        }
        return -1;
    }
    public int findSpotMaxLast()  {
        if (head == null) {return -1;}
        var current = head;
        var max = max();
        var index = 1;
        var last = -1;
        if (current.data == max) last = index;
        while (current.next != null) {
            current = current.next;
            index++;
            if (current.data == max) last = index;
        }
        return last;
    }
    public void sort() {
        if (head == null) {return;}
        var current = head;
        var min = min();
        var index = getSpot(min);
        var newList = getNode(index);
        head = newList;
        removeSpot(index);
        var nums = getCount();
        for (int lcv = 0; lcv < nums; lcv++) {
            min = min();
            index = getSpot(min);
            newList.next = getNode(index);
            removeSpot(index);
        }
    }
    public int lose58() {
        System.out.println("ley");
        if (head == null) {return -1;}
        var current = head;
        var num = 0;
        System.out.println(num);
        while (head == current) {
            System.out.println("ley");
            if (current.data == 58) {
                current = current.next;
                head = current;
                num++;
            } else {
                current = current.next;
                break;
            }
        }
        System.out.println(current.data + " " + current.next);
        System.out.println("ley");
        System.out.print("hi ");
        while (current.next != null) {
            System.out.println("ley");
            current = current.next;
            if (current.data == 58) {
                current.next = current.next.next;
                num++;
            }
            System.out.print("hi ");
        }
        num = 0;
        return num;
    }
    public int getEvenCount() {
        if (head == null) {return -1;}
        var current = head;
        var num = 0;
        if (current.data % 2 == 0) num++;
        while (current.next != null) {
            current = current.next;
            if (current.data % 2 == 0) num++;
        }
        return num;
    }
    public void killOdds() {
        if (head == null) {return;}
        var current = head;
        var num = 0;
        while (head == current) {
            if (current.data % 2 == 1) {
                current = current.next;
                head = current;
            }
        }
        while (current.next != null) {
            current = current.next;
            if (current.data % 2 == 1) {
                current.next = current.next.next;
            }
        }
    }
    public Node getNode(int spot) {
        if (head == null) {return null;}
        var current = head;
        spot--;
        while (current != null && spot != 0) {
            current = current.next;
            spot--;
        }
        return current;
    }
}

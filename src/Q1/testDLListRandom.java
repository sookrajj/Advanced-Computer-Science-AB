package Q1;
import DataStructures.DoublyLinkedList;

public class testDLListRandom {
    public static void main(String[] args) {
        var list = new DoublyLinkedList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.addSorted((int) (Math.random() * 100));
        }
        list.print();
        list.printReverse();
    }
}

package Q1;
import DataStructures.intLinkedList;

public class BigLinkedList {
    public static void main(String[] args) {
        var list = new intLinkedList();
        for (int lcv = 0; lcv < 200; lcv++) {
            list.addFront((int) (Math.random()*100 + 1));
        }
        var iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        list.addLast(58);
        System.out.println(list.getCount());
        list.add(68, 58);
        System.out.println("Is list empty: " + list.isEmpty());
        for (Node node : list) {
            System.out.print(node.data + " ");
        }
        System.out.println();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getSlot(74));
    }
}

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
        System.out.println(list.getCount());
    }
}

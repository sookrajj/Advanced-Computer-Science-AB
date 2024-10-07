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
        System.out.println(list.add(58, 58));
        System.out.println("Is list empty: " + list.isEmpty());
        list.printList();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getSpot(58));
        list.removeFirst();
        list.removeLast();
        System.out.println(list.getLast());
        System.out.println("The amount of numbers less than 10 is " + list.countLess10());
        list.printList();
        list.removeSpot(58);
        list.clear();
        System.out.println(list.checkForNum(58));
        for (int lcv = 0; lcv < 200; lcv++) {
            list.addFront((int) (Math.random()*100 + 1));
        }
        list.printList();
        list = list.getReverse();
        list.printList();
        System.out.print("The average is: " + Math.round(list.avg() * 100)/100);
        System.out.println();
        System.out.println(list.min());
        System.out.println(list.max());
        System.out.println(list.findSpotMaxFirst());
        System.out.println(list.findSpotMaxLast());
        list.sort();
        list.printList();
        var num = list.lose58();
        System.out.println("ley");
        System.out.println("The amount of 58s lost: " + num);
        System.out.println("ley");
        System.out.println("The amount of 2s: " + list.getEvenCount());
        list.killOdds();
        list.printList();
    }
}

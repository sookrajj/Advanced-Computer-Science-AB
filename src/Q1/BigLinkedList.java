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
        System.out.println(list.add(101, 58));
        System.out.println(list.getSpot(list.findSpotMaxFirst()));
        System.out.println("Is list empty: " + list.isEmpty());
        list.printList();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getSpot(58));
        System.out.println(list.getSpot(57));
        System.out.println(list.getSpot(59));
        System.out.println(list.getSpot(60));
        System.out.println(list.getSpot(56));
        list.removeFirst();
        list.removeLast();
        System.out.println("The amount of numbers less than 10 is " + list.countLess10());
        list.printList();
        list.removeSpot(58);
        list.clear();
        System.out.println(list.checkForNum(58));
        for (int lcv = 0; lcv < 200; lcv++) {
            list.addFront((int) (Math.random()*100 + 1));
        }
        System.out.println("hi");
        list = list.getReverse();
        System.out.println("hi");
        System.out.printf("The average is: %.2f" + list.avg());
        System.out.println("hi");
        System.out.println(list.min());
        System.out.println(list.max());
        System.out.println(list.findSpotMaxFirst());
        System.out.println(list.findSpotMaxLast());
        list.sort();
        var num = list.lose58();
        System.out.println("The amount of 58s lost: " + num);
        System.out.println("The amount of 58s lost: " + list.getEvenCount());
        list.killOdds();
        list.printList();
    }
}

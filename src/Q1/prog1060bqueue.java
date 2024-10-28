package Q1;

import java.util.*;


public class prog1060bqueue {
    public static void main(String[] args) {
        Queue<Integer> que = new PriorityQueue<>();
        var scanner = new Scanner(System.in);
        var let = "";
        do {
            System.out.print("Enter task A)dd, D)elete, E)xit ");
            let = scanner.next();
            if (!let.equalsIgnoreCase("E")) {
                System.out.print("Enter Number ");
                Integer num = scanner.nextInt();
                if (let.equalsIgnoreCase("A")) {
                    que.add(num);
                    System.out.println("This is the List: ");
                    for (Integer n : que) {
                        System.out.print(n + " ");
                    }
                    System.out.println();
                } else {
                    if (num.equals(que.peek())) {
                        que.remove();
                    } else {
                        que.remove(num);
                    }
                    System.out.println("This is the List: ");
                    for (Integer n : que) {
                        System.out.print(n + " ");
                    }
                    System.out.println();
                }
            }
        } while (!let.equalsIgnoreCase("E"));
        System.out.println("This is the Ending List: ");
        for (Integer n : que) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
//Enter task A)dd, D)elete, E)xit A
//Enter Number 10
//This is the List:
//10
//Enter task A)dd, D)elete, E)xit A
//Enter Number 15
//This is the List:
//10 15
//Enter task A)dd, D)elete, E)xit A
//Enter Number 2
//This is the List:
//2 15 10
//Enter task A)dd, D)elete, E)xit D
//Enter Number 10
//This is the List:
//2 15
//Enter task A)dd, D)elete, E)xit D
//Enter Number 2
//This is the List:
//15
//Enter task A)dd, D)elete, E)xit D
//Enter Number 15
//This is the List:
//
//Enter task A)dd, D)elete, E)xit A
//Enter Number 7
//This is the List:
//7
//Enter task A)dd, D)elete, E)xit D
//Enter Number 8
//This is the List:
//7
//Enter task A)dd, D)elete, E)xit A
//Enter Number 12
//This is the List:
//7 12
//Enter task A)dd, D)elete, E)xit D
//Enter Number 12
//This is the List:
//7
//Enter task A)dd, D)elete, E)xit E
//This is the Ending List:
//7
package Q1;
import java.util.*;
public class LP521 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter you first name: ");
        String f = input.nextLine();
        System.out.print("Enter you last name: ");
        String l = input.nextLine();

        if (l.substring(0, 1).compareTo("I") <= 0) {
            System.out.println(f + " " + l + " is assigned to group 1");
        } else if (l.substring(0, 1).compareTo("S") <= 0) {
            System.out.println(f + " " + l + " is assigned to group 2");
        } else {
            System.out.println(f + " " + l + " is assigned to group 3");
        }
    }
}
//Enter you first name: Jonah
//Enter you last name: Sookraj
//Jonah Sookraj is assigned to group 2
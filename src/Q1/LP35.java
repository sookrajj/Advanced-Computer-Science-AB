package Q1;
import java.util.*;
public class LP35 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter the change in cents: ");
        double cents = input.nextDouble();
        int q = (int) Math.round(cents/(0.25));
        cents = cents%(0.25);
        int d = (int) Math.round(cents/(0.1));
        cents = cents%(0.1);
        int n = (int) Math.round(cents/(0.05));
        cents = cents%(0.05);
        int p = (int) Math.round(cents/(0.01));
        cents = cents%(0.01);
        System.out.println("The minimum number of coins is: ");
        System.out.println("Quarters: " + q);
        System.out.println("Dimes: " + d);
        System.out.println("Nickels: " + n);
        System.out.println("Pennies: " + p);
    }
}
//Enter the change in cents:
//2.12
//The minimum number of coins is:
//Quarters: 8
//Dimes: 1
//Nickels: 0
//Pennies: 2
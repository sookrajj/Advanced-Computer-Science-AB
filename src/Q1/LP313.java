package Q1;
import java.util.*;
public class LP313 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter the principal: ");
        double prin = input.nextDouble();
        System.out.print("Enter the number of years: ");
        int year = input.nextInt();
        System.out.print("Enter the interest rate: ");
        double rate = input.nextDouble();

        System.out.printf("The value after the term is: $%.2f", (prin * (1+year*rate)));
    }
}
//Enter the principal: 5000
//Enter the number of years: 5
//Enter the interest rate: .06
//The value after the term is: $6500.00
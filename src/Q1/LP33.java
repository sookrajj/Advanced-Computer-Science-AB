package Q1;
import java.util.*;
public class LP33 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter rent costs: ");
        double rent = input.nextDouble();
        System.out.print("Enter tuition cost: ");
        rent += input.nextDouble();
        System.out.print("Enter book costs: ");
        rent += input.nextDouble();
        System.out.print("Enter transportation costs: ");
        rent += input.nextDouble();
        System.out.print("Enter food costs: ");
        rent += input.nextDouble();
        System.out.print("Scholarship offset: ");
        rent -= input.nextDouble();
        System.out.print("Money that your parents give: ");
        rent -= input.nextDouble();
        System.out.print("Money from job: ");
        rent -= input.nextDouble();


        if (rent > 0) {
            System.out.printf("You owe $%.2f", rent);
        } else {
            rent = rent * -1;
            System.out.printf("You have $%.2f", rent);
        }
    }
}
//    Enter rent costs: 120.5
//        Enter tuition cost: 78.05
//        Enter book costs: 40
//        Enter transportation costs: 0
//        Enter food costs: 230.76
//        Scholarship offset: 0
//        Money that your parents give: 4
//        Money from job: 0
//        You owe $465.31
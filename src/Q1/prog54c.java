package Q1;
import java.util.*;

public class prog54c {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter Radius: ");
        double rad = input.nextDouble();

        double area = Math.PI * Math.pow(rad, 2);
        double cir = 2 * Math.PI * rad;

        System.out.printf("Area = %.3f\n", area);
        System.out.printf("Circumference = %.3f\n", cir);
    }
}
//Enter Radius: 3.712
//Area = 43.288
//Circumference = 23.323
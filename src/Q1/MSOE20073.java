package Q1;
import java.util.*;
public class MSOE20073 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter length c: ");
        double c = input.nextDouble();
        System.out.print("Enter angle A: ");
        double A = input.nextDouble();
        System.out.print("Enter angle B: ");
        double B = input.nextDouble();
        System.out.print("Enter angle C: ");
        double C = input.nextDouble();
        if (A+B+C <= 181 && A+B+C >= 179) {
            double r = c * Math.sin(Math.toRadians(A/ 2)) * Math.sin(Math.toRadians(B/ 2)) * (1 / Math.cos(Math.toRadians(C/ 2)));
            System.out.printf("The radius of the circle in the triangle is: %.2f", r);
        } else {
            System.out.println("Your angles are not for a triangle");
        }
    }
}
//Enter length c: 10
//Enter angle A: 60
//Enter angle B: 60
//Enter angle C: 60
//The radius of the circle in the triangle is: 2.89
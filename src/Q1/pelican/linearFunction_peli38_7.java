package Q1.pelican;
import java.io.*;
import java.util.Scanner;

public class linearFunction_peli38_7 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("What is the slope of your line? ");
        var slope = input.nextDouble();

        System.out.print("What is the y-intercept of your line? ");
        var yIntc = input.nextDouble();

        var line = new LinearFunction(slope, yIntc);
        System.out.println("\nSlope of this line is: " + line.getSlope());
        System.out.println("Y-intercept of this line is: " + line.getY());

        System.out.println("Root of this lne is: " + line.getRoot());

        System.out.print("\nWhat is an x value for which you wish to solve for y? ");
        double x = input.nextDouble();
        System.out.println("The Y value corresponding to x= " + x + " is " + line.getYvalue(x));

        System.out.print("\nWhat is a y value for which you wish to solve for x? ");
        double y = input.nextDouble();
        System.out.println("The X value corresponding to y= " + y + " is " + line.getXvalue(y));
    }
}

//What is the slope of your line? -3
//What is the y-intercept of your line? 2.5
//
//Slope of this line is: -3.0
//Y-intercept of this line is: 2.5
//Root of this lne is: 0.8333333333333334
//
//What is an x value for which you wish to solve for y? -4.61
//The Y value corresponding to x= -4.61 is 16.330000000000002
//
//What is a y value for which you wish to solve for x? 5.0
//The X value corresponding to y= 5.0 is -0.8333333333333334
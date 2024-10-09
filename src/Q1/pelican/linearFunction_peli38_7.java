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

    }
}


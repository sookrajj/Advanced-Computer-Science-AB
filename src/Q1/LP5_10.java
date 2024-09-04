package Q1;
import java.util.*;

public static void main(Strings[] args) {
  var input = new Scanner(System.in);
  System.out.print("Enter a number: "); 
  int num = input.nextInt();
  System.out.print("/nEnter a second number: ");
  int snum = input.nextInt();

  int lcv = 1;
  int high = 1;
  while (lcv < num) {
    lcv++;
    if (num % lcv == 0 && snum % lcv == 0) {high = lcv;}
  }
  System.out.println("/nThe GCD is " + high);
}

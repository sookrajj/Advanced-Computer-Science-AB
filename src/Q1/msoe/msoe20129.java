package Q1.msoe;
import java.util.*;

public class msoe20129 {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    System.out.print("numeral: ");
    var line = input.nextLine();
    var num = 0;
    for (int lcv = 0; lcv < line.length(); lcv++) {
        var let = line.substring(lcv, lcv+1);
        if (let.equalsIgnoreCase("M")) {
          num += 1000;
        } else if (let.equalsIgnoreCase("D")) {
          num += 500;
        } else if (let.equalsIgnoreCase("C")) {
          if (lcv+1 != line.length()) {
            if (line.substring(lcv+1, lcv+2).equalsIgnoreCase("D")) {
              num += 400;
              lcv++;
            } else if (line.substring(lcv+1, lcv+2).equalsIgnoreCase("M")) {
              num += 900;
              lcv++;
            } else {
              num += 100;
            }
          }else {
            num += 100;
          }
        } else if (let.equalsIgnoreCase("L")) {
          num+= 50;
        } else if (let.equalsIgnoreCase("X")) {
          if (lcv+1 != line.length()) {
            if (line.substring(lcv+1, lcv+2).equalsIgnoreCase("L")) {
              num += 40;
              lcv++;
            } else if (line.substring(lcv+1, lcv+2).equalsIgnoreCase("C")) {
              num += 90;
              lcv++;
            } else {
              num += 10;
            }
          }else {
            num += 10;
          }
        } else if (let.equalsIgnoreCase("V")) {
          num += 5;
        } else if (let.equalsIgnoreCase("I")) {
          if (lcv+1 != line.length()) {
            if (line.substring(lcv+1, lcv+2).equalsIgnoreCase("V")) {
              num += 4;
              lcv++;
            } else if (line.substring(lcv+1, lcv+2).equalsIgnoreCase("X")) {
              num += 9;
              lcv++;
            } else {
              num += 1;
            }
          }else {
            num += 1;
          }
        }
        
    }
    System.out.println("Decimal Value: " + num);
  }
}
//numeral: XLVII
//Decimal Value: 47
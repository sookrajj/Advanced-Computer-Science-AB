package Q1;

public class LP59 {
    public static void main(String[] args) {
  System.out.println("x^1   x^2   x^3   x^4   x^5");
  for (int lcv = 1; lcv <= 6; lcv++) {
    System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n", lcv, (int) Math.pow(lcv, 2), (int) Math.pow(lcv, 3), (int) Math.pow(lcv, 4), (int) Math.pow(lcv, 5));
  }
}
}
//x^1   x^2   x^3   x^4   x^5
//1		1		1		1		1
//2		4		8		16		32
//3		9		27		81		243
//4		16		64		256		1024
//5		25		125		625		3125
//6		36		216		1296		7776
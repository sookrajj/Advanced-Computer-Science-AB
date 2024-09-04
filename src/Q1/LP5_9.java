package Q1;

public static void main(Strings[] args) {
  System.out.println("x^1   x^2   x^3   x^4   x^5");
  for (int lcv = 1; lcv <= 6; lcv++) {
    System.out.println(lcv + "   " + Math.pow(lcv, 2) + "   " + Math.pow(lcv, 3) + "   " + Math.pow(lcv, 4) + "   " + Math.pow(lcv, 5));
  }
}

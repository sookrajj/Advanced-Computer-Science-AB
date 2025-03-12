package Q3;

public class runnerscore {
    private double mynum1;
    private double mynum2;
    private double mynum3;
    private double mynum4;
    private double mynum5;
    private double mynum6;
    private double mynum7;
    private double mynum8;
    private double myave;
    private int cnt = 0;

    public runnerscore(double num1, double num2, double num3,double num4, double num5, double num6, double num7, double num8) {
        mynum1 = num1;
        mynum2 = num2;
        mynum3 = num3;
        mynum4 = num4;
        mynum5 = num5;
        mynum6 = num6;
        mynum7 = num7;
        mynum8 = num8;
        myave = 8;
        cnt ++;
    }

    public void calc() {
        myave = (mynum1 + mynum2 + mynum3+ mynum4 + mynum5 + mynum6 + mynum7 + mynum8) / myave;
    }

    public String toString() {
        return "" + mynum1 + " " + mynum2 + " " +
                mynum3 + " " + mynum4 + " " + mynum5 + " " + mynum6 + " "
                + mynum7 + " " +mynum8 + " =" + myave + "\n";
    }

}

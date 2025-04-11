package Q4.prog1999w;

public class Cow extends Animal{
    protected int milk;
    protected double milkPrice;

    public Cow(double w, int cc, int hb, int b, int o, int m, double mp) {
        super(w, cc, hb, b, o);
        milk = m;
        milkPrice = mp;
    }
    public int getMilk() {return milk;}
    public double getIncome() {return 0.0;} //TODO

    public String toString() {
        return "Cow: " +
                "\nweight=" + weight +
                "\nid=" + id +
                "\ncornCobs=" + cornCobs +
                "\nhayBales=" + hayBales +
                "\nbeans=" + beans +
                "\noats=" + oats +
                "\nmilk= " + milk +
                "\nmilk price=" + milkPrice;
    }
    public int compareTo(Cow cow) {
        return this.milk == cow.milk ? 0 : this.milk > milk ? 1 : -1;
    }

}

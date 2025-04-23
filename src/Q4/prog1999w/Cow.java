package Q4.prog1999w;

public class Cow extends Animal implements Comparable<Cow> {
    protected int milk;
    protected double milkPrice;

    public Cow(int id, double w, int cc, int hb, int b, int o, int m, double mp) {
        super(id, w, cc, hb, b, o);
        milk = m;
        milkPrice = mp;
    }
    public int getMilk() {return milk;}
    public double getIncome() {return milk * milkPrice;}

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
    public int compareTo(Cow cow) {return Double.compare(this.getIncome(), cow.getIncome());}

}

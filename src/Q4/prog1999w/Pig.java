package Q4.prog1999w;

public class Pig extends Animal {
    protected double value;

    public Pig(double w, int cc, int hb, int b, int o, int v) {
        super(w, cc, hb, b, o);
        this.value = v;
    }

    public double getValue() {
        return value;
    }
    public double getIncome() {
        return value * weight;
    }
    public String toString() {
        return "Pig: " +
                "\nweight=" + weight +
                "\nid=" + id +
                "\ncornCobs=" + cornCobs +
                "\nhayBales=" + hayBales +
                "\nbeans=" + beans +
                "\noats=" + oats +
                "\nvalue= " + value;
    }
    public int compareTo(Pig pig) {return Double.compare(this.getIncome(), pig.getIncome());}
}

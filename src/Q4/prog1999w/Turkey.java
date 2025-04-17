package Q4.prog1999w;

public class Turkey extends Animal{
    protected double value;

    public Turkey(int id, double w, int cc, int hb, int b, int o, int v) {
        super(id, w, cc, hb, b, o);
        this.value = v;
    }

    public double getValue() {
        return value;
    }
    public double getIncome() {
        return value * weight;
    }
    public String toString() {
        return "Turkey: " +
                "\nId= " + id +
                "\nweight=" + weight +
                "\nid=" + id +
                "\ncornCobs=" + cornCobs +
                "\nhayBales=" + hayBales +
                "\nbeans=" + beans +
                "\noats=" + oats +
                "\nvalue= " + value;
    }
    public int compareTo(Turkey turkey) {return Double.compare(this.getIncome(), turkey.getIncome());}
}
